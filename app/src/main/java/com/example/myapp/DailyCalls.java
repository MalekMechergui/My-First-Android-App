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

public class DailyCalls extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
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
        setContentView(R.layout.activity_daily_calls);

        this.button1 = (Button) findViewById(R.id.button22);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyMustDo.class);
                startActivity(day);
                onPause();
            }
        });

        this.button2 = (Button) findViewById(R.id.button23);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyToDo.class);
                startActivity(day);
                onPause();
            }
        });

        this.button3 = (Button) findViewById(R.id.button24);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyPlaces.class);
                startActivity(day);
                onPause();
            }
        });


        itemET = findViewById(R.id.item_edit_text_calls);
        btn = findViewById(R.id.add_btn_calls);
        itemsList = findViewById(R.id.items_list_calls);

        try {
            items = FileHelperCalls.readData(this);
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
            case R.id.add_btn_calls:
                String itemEntered =itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");
                FileHelperCalls.writeData(items, this);
                Toast.makeText(this, "Call to make added", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        FileHelperCalls.writeData(items, this);
        Toast.makeText(this, "Congrats!", Toast.LENGTH_SHORT).show();
    }
}
