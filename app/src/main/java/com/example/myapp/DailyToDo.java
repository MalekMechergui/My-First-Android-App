package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class DailyToDo extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
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
        setContentView(R.layout.activity_daily_to_do);

        this.button1 = (Button) findViewById(R.id.button19);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyMustDo.class);
                startActivity(day);
                onPause();
            }
        });

        this.button2 = (Button) findViewById(R.id.button20);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyCalls.class);
                startActivity(day);
                onPause();
            }
        });

        this.button3 = (Button) findViewById(R.id.button21);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyPlaces.class);
                startActivity(day);
                onPause();
            }
        });

        itemET = findViewById(R.id.item_edit_text_todo);
        btn = findViewById(R.id.add_btn_todo);
        itemsList = findViewById(R.id.items_list_todo);

        try {
            items = FileHelperToDo.readData(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        itemsList.setAdapter(adapter);
        btn.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn_todo:
            String itemEntered =itemET.getText().toString();
            adapter.add(itemEntered);
            itemET.setText("");
            FileHelperToDo.writeData(items, this);
            Toast.makeText(this, "To do added", Toast.LENGTH_SHORT).show();
            break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        FileHelperToDo.writeData(items, this);
        Toast.makeText(this, "Congrats you've finished a task, keep going!", Toast.LENGTH_SHORT).show();
    }
}