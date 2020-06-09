package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

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

public class Sunday extends AppCompatActivity  implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText itemET;
    private Button btn;
    private ListView itemsList;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunday);

        itemET = findViewById(R.id.item_edit_text_sunday);
        btn = findViewById(R.id.add_btn_sunday);
        itemsList = findViewById(R.id.items_list_sunday);

        try {
            items = FileHelperSunday.readData(this);
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
            case R.id.add_btn_sunday:
                String itemEntered =itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");
                FileHelperSunday.writeData(items, this);
                Toast.makeText(this, "Must do added", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        FileHelperSunday.writeData(items, this);
        Toast.makeText(this, "Congrats you've finished a task, keep going!", Toast.LENGTH_SHORT).show();
    }

}
