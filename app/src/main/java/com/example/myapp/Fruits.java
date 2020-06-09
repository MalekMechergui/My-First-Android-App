package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class Fruits extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText itemET;
    private Button btn;
    private ListView itemsList;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private ImageButton button5;
    private ImageButton button6;
    private ImageButton button7;
    private ImageButton button8;
    private ImageButton button_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);


        this.button1 = (ImageButton) findViewById(R.id.imageButton59);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Vegetables.class);
                startActivity(day);
                isDestroyed();
            }
        });

        this.button2 = (ImageButton) findViewById(R.id.imageButton60);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Dairy.class);
                startActivity(day);
                isDestroyed();
            }
        });

        this.button3 = (ImageButton) findViewById(R.id.imageButton61);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), FishMeat.class);
                startActivity(day);
                isDestroyed();
            }
        });

        this.button4 = (ImageButton) findViewById(R.id.imageButton62);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Pasta.class);
                startActivity(day);
                isDestroyed();
            }
        });

        this.button5 = (ImageButton) findViewById(R.id.imageButton63);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Snacks.class);
                startActivity(day);
                isDestroyed();
            }
        });

        this.button6 = (ImageButton) findViewById(R.id.imageButton64);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Paper.class);
                startActivity(day);
                isDestroyed();
            }
        });

        this.button7 = (ImageButton) findViewById(R.id.imageButton65);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Toilet.class);
                startActivity(day);
                isDestroyed();
            }
        });

        this.button8 = (ImageButton) findViewById(R.id.imageButton66);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), More.class);
                startActivity(day);
                isDestroyed();
            }
        });

        this.button_retour = (ImageButton) findViewById(R.id.Retour);

        button_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Grocery.class);
                startActivity(day);
                isDestroyed();
            }
        });


        itemET = findViewById(R.id.item_edit_text_fruits);
        btn = findViewById(R.id.add_btn_fruits);
        itemsList = findViewById(R.id.items_list_fruits);

        try {
            items = FileHelperFruits.readData(this);
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
            case R.id.add_btn_fruits:
                String itemEntered =itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");
                FileHelperFruits.writeData(items, this);
                Toast.makeText(this, "Fruit added", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        FileHelperFruits.writeData(items, this);
        Toast.makeText(this, "Continue your grocery shopping!", Toast.LENGTH_SHORT).show();
    }
}
