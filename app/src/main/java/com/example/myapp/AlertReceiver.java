package com.example.myapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notif = new NotificationHelper(context);
        NotificationCompat.Builder nb = notif.getChannelNotification();
        notif.getManager().notify(1,nb.build());

    }
}
