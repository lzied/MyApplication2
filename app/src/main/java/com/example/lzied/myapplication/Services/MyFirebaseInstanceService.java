package com.example.lzied.myapplication.Services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.lzied.myapplication.MainActivity;
import com.example.lzied.myapplication.R;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Random;

/**
 * Created By Lahiani Zied on 12/11/2018.
 **/
public class MyFirebaseInstanceService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d("TOKENFIREBASE", s);
    }
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if(remoteMessage.getData().isEmpty())
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        else
            showNotification(remoteMessage.getData());
    }

    private void showNotification(Map<String,String> data) {
        String n=data.get("title").toString();
        String p=data.get("body").toString();

        String CHANEL_ID="com.example.lzied.myapplication";
        NotificationManager nm= (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel=new NotificationChannel(CHANEL_ID,"Notification",NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("apptest");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
            nm.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder nc=new NotificationCompat.Builder(this,CHANEL_ID);
        Intent notifyIntent=new Intent(Intent.ACTION_VIEW,Uri.parse(p));
        notifyIntent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK));
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,notifyIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        nc.setContentIntent(pendingIntent);
        nc.setAutoCancel(true);

        nc.setSmallIcon(R.drawable.ic_stat_name);
        nc.setWhen(System.currentTimeMillis());
        nc.setContentTitle(n);
        //nc.setContentText(p);
        nm.notify(new Random().nextInt(),nc.build());


    }


    public void showNotification(String n,String p)
    {       String CHANEL_ID="com.example.lzied.myapplication";
        NotificationManager nm= (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel=new NotificationChannel(CHANEL_ID,"Notification",NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("apptest");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
            nm.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder nc=new NotificationCompat.Builder(this,CHANEL_ID);
        Intent notifyIntent=new Intent(Intent.ACTION_VIEW,Uri.parse(p));
        notifyIntent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK));
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,notifyIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        nc.setContentIntent(pendingIntent);
        nc.setAutoCancel(true);

        nc.setSmallIcon(R.drawable.ic_stat_name);
        nc.setWhen(System.currentTimeMillis());
        nc.setContentTitle(n);
        //nc.setContentText(p);
        nm.notify(new Random().nextInt(),nc.build());
    }



}
