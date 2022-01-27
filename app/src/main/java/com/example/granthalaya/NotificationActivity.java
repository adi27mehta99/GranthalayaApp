package com.example.granthalaya;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NotificationActivity extends AppCompatActivity {

public static final String id = App.CHANNEL_ID;
    private static final String CHANNEL_ID = "channel";
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);
        notificationManager = NotificationManagerCompat.from(this);
      //  editTextTitle = findViewById(R.id.edit_text_title);
    //    editTextMessage = findViewById(R.id.edit_text_message);
     //   Button notification = findViewById(R.id.send_notification);

       // String title = editTextTitle.getText().toString();
        //String message = editTextMessage.getText().toString();
        /*notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String title = editTextTitle.getText().toString();
                //String message = editTextMessage.getText().toString();
                Notification notification = new NotificationCompat.Builder(NotificationActivity.this,id)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setSmallIcon(R.drawable.ic_notifications)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();
                notificationManager.notify(1, notification);
            }
        });*/

        Intent intent = new Intent(this, SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Remainder to return Your Book")
                .setContentInfo("random info testing")
                .setContentText("Return To kill a mockingbird Today itself")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());



        /*NotificationCompat.Builder build = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);*/

    }

}
