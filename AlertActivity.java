package com.example.watcher_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class AlertActivity extends AppCompatActivity {

    Button notifyBtn;

    public String Name;
    public String Group;
    public String AlertTitle;
    public String AlertText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        notifyBtn = findViewById(R.id.notify_btn);

        Name = getIntent().getStringExtra("Name");
        Group = getIntent().getStringExtra("Group");

        AlertTitle = Group + ": Emergency group alert!!";
        AlertText = Name + " has pushed the alert button!";

        if  (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Alerts", "Alerts", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(AlertActivity.this, "Alerts");
                builder.setContentTitle(AlertTitle);
                builder.setContentText(AlertText);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(AlertActivity.this);
                managerCompat.notify(1, builder.build());
            }
        });
    }
}