package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Grocery extends AppCompatActivity {
   private ImageButton imbutt1;
   private ImageButton imbutt2;
   private ImageButton imbutt3;
   private ImageButton imbutt4;
   private ImageButton imbutt5;
   private ImageButton imbutt6;
   private ImageButton imbutt7;
   private ImageButton imbutt8;
   private ImageButton imbutt9;
   private ImageButton menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        this.imbutt1 = (ImageButton) findViewById(R.id.imageButton4);
        imbutt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Fruits.class);
                startActivity(day);
                onPause();
            }
        });

        this.imbutt2 = (ImageButton) findViewById(R.id.imageButton5);
        imbutt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Vegetables.class);
                startActivity(day);
                onPause();
            }
        });

        this.imbutt3 = (ImageButton) findViewById(R.id.imageButton6);
        imbutt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Dairy.class);
                startActivity(day);
                onPause();
            }
        });

        this.imbutt4 = (ImageButton) findViewById(R.id.imageButton7);
        imbutt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), FishMeat.class);
                startActivity(day);
                onPause();
            }
        });

        this.imbutt5 = (ImageButton) findViewById(R.id.imageButton8);
        imbutt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Pasta.class);
                startActivity(day);
                onPause();
            }
        });

        this.imbutt6 = (ImageButton) findViewById(R.id.imageButton9);
        imbutt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Snacks.class);
                startActivity(day);
                onPause();
            }
        });

        this.imbutt7 = (ImageButton) findViewById(R.id.imageButton10);
        imbutt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Paper.class);
                startActivity(day);
                onPause();
            }
        });

        this.imbutt8 = (ImageButton) findViewById(R.id.imageButton11);
        imbutt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), Toilet.class);
                startActivity(day);
                onPause();
            }
        });

        this.imbutt9 = (ImageButton) findViewById(R.id.imageButton12);
        imbutt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), More.class);
                startActivity(day);
                onPause();
            }
        });

        this.menu = (ImageButton) findViewById(R.id.menu);
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
