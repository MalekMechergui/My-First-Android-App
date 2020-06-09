package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class WeeklyMustDo extends AppCompatActivity {

    private Button monday;
    private Button tuesday;
    private Button wednesday;
    private Button thursday;
    private Button friday;
    private Button saturday;
    private Button sunday;
    private ImageButton menu;
    private TextView tester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_must_do);
        this.monday = (Button) findViewById(R.id.button6);
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Monday.class);
                startActivity(day);
                onPause();
            }
        });
        this.tuesday = (Button) findViewById(R.id.button8);
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Tuesday.class);
                startActivity(day);
                onPause();
            }
        });
        this.wednesday = (Button) findViewById(R.id.button9);
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Wednesday.class);
                startActivity(day);
                onPause();
            }
        });
        this.thursday = (Button) findViewById(R.id.button10);
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Thursday.class);
                startActivity(day);
                onPause();
            }
        });
        this.friday = (Button) findViewById(R.id.button11);
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Friday.class);
                startActivity(day);
                onPause();
            }
        });
        this.saturday = (Button) findViewById(R.id.button12);
        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Saturday.class);
                startActivity(day);
                onPause();
            }
        });
        this.sunday = (Button) findViewById(R.id.button13);
        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Sunday.class);
                startActivity(day);
                onPause();
            }
        });

        this.menu = (ImageButton) findViewById(R.id.menu2);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(day);
                onPause();
            }
        });



    }
}
