package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityDay extends AppCompatActivity {
    private Button button;
    private Button button4;
    private Button button3;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_day);

        this.button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyMustDo.class);
                startActivity(day);
                onPause();
            }
        });
        this.button4 = (Button) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent week = new Intent(getApplicationContext(), DailyToDo.class);
                startActivity(week);
                onPause();

            }
        });
        this.button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyCalls.class);
                startActivity(day);
                onPause();
            }
        });
        this.button5 = (Button) findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), DailyPlaces.class);
                startActivity(day);
                onPause();
            }
        });

    }
}
