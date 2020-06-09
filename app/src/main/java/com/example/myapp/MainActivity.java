package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //le bouton d'alarme
        Button button = (Button) findViewById(R.id.Alarm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragement();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

        //Display the exact date
        Calendar calendar = Calendar.getInstance();
        String currenmonth = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textdate3 = findViewById(R.id.date);
        textdate3.setText(currenmonth);

        //Daily To do list
        this.button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day = new Intent(getApplicationContext(), MainActivityDay.class);
                startActivity(day);
                onPause();
            }
        });

        //weekly to do list
        this.button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent week = new Intent(getApplicationContext(), WeeklyMustDo.class);
                startActivity(week);
                onPause();

            }
        });

        //Grocery Shopping List
        this.button3 = (Button) findViewById(R.id.button7);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent week = new Intent(getApplicationContext(), Grocery.class);
                startActivity(week);
                onPause();
            }
        });
    }


    @Override


    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        startAlarm(c);

    }
    private void startAlarm(Calendar c){
        AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }
}
