package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static android.widget.Toast.*;

public class DailyMustDo extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText itemET;
    private Button btn;
    private ListView itemsList;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_must_do);

        this.button1 = (Button) findViewById(R.id.button16);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyToDo.class);
                startActivity(day);
                onPause();
            }
        });

        this.button2 = (Button) findViewById(R.id.button17);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyCalls.class);
                startActivity(day);
                onPause();
            }
        });

        this.button3 = (Button) findViewById(R.id.button18);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyPlaces.class);
                startActivity(day);
                onPause();
            }
        });




        itemET = findViewById(R.id.item_edit_text_must);
        btn = findViewById(R.id.add_btn_must);
        itemsList = findViewById(R.id.items_list_must);

        Calendar c = Calendar.getInstance();
        int week_day = c.get(Calendar.DAY_OF_WEEK);

        if (week_day==7){
            try {
                items = FileHelperSaturday.readData(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (week_day==1){
            try {
                items = FileHelperSunday.readData(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (week_day==2){
            try {
                items = FileHelperMonday.readData(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (week_day==3){
            try {
                items = FileHelperTuesday.readData(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (week_day==4){
            try {
                items = FileHelperWenesday.readData(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (week_day==5){
            try {
                items = FileHelperThursday.readData(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (week_day==6){
            try {
                items = FileHelperFriday.readData(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        itemsList.setAdapter(adapter);
        btn.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn_must:
                String itemEntered = itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");
                Calendar c = Calendar.getInstance();
                int week_day = c.get(Calendar.DAY_OF_WEEK);

                if (week_day==7){FileHelperSaturday.writeData(items, this);}
                else if (week_day==1){FileHelperSunday.writeData(items, this);}
                else if (week_day==2){FileHelperMonday.writeData(items, this);}
                else if (week_day==3){FileHelperTuesday.writeData(items, this);}
                else if (week_day==4){FileHelperWenesday.writeData(items, this);}
                else if (week_day==5){FileHelperThursday.writeData(items, this);}
                else if (week_day==6){FileHelperFriday.writeData(items, this);}

                Toast.makeText(this, "Must do added", LENGTH_SHORT).show();
                break;
        }

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        items.remove(position);
        adapter.notifyDataSetChanged();
        Calendar c = Calendar.getInstance();
        int week_day = c.get(Calendar.DAY_OF_WEEK);

        if (week_day==7){FileHelperSaturday.writeData(items, this);}
        else if (week_day==1){FileHelperSunday.writeData(items, this);}
        else if (week_day==2){FileHelperMonday.writeData(items, this);}
        else if (week_day==3){FileHelperTuesday.writeData(items, this);}
        else if (week_day==4){FileHelperWenesday.writeData(items, this);}
        else if (week_day==5){FileHelperThursday.writeData(items, this);}
        else if (week_day==6){FileHelperFriday.writeData(items, this);}

        Toast.makeText(this, "Congrats, you've finished a task, keep going!", LENGTH_SHORT).show();

    }


}

