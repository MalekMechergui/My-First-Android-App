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

public class Pasta extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText itemET;
    private Button btn;
    private ListView itemsList;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private ImageButton button_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);

        this.button_retour = (ImageButton) findViewById(R.id.Retour);

        button_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Grocery.class);
                startActivity(day);
                onStop();
            }
        });


        itemET = findViewById(R.id.item_edit_text_pasta);
        btn = findViewById(R.id.add_btn_pasta);
        itemsList = findViewById(R.id.items_list_pasta);

        try {
            items = FileHelperPasta.readData(this);
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
            case R.id.add_btn_pasta:
                String itemEntered =itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");
                FileHelperPasta.writeData(items, this);
                Toast.makeText(this, "Pasta/Rice product added", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        FileHelperPasta.writeData(items, this);
        Toast.makeText(this, "Keep your grocery shopping!", Toast.LENGTH_SHORT).show();
    }
}
