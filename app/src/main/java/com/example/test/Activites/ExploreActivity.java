package com.example.test.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.test.R;

import java.util.Calendar;

public class ExploreActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        initViews();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Explore");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,MainActivity.class));
            }
        });

        //gd evening or gd morning
        Calendar now = Calendar.getInstance();
        if(now.get(Calendar.AM_PM) == Calendar.AM){
            date.setText("Good Morning");
        }else{
            date.setText("Good Evening");
        }

    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        date = (TextView) findViewById(R.id.datedetect);

    }

    public void setMessage(View view) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", "");
        smsIntent.putExtra("sms_body"," ");
        startActivity(smsIntent);
    }

    public void phoneCall(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    public void setTimer(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "")
                .putExtra(AlarmClock.EXTRA_LENGTH, 60)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showNews(View view) {
        Toast.makeText(this, "in implementation ...", Toast.LENGTH_SHORT).show();
    }

    public void addEvent(View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, "new ")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "egypt")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 10)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 10);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void addReminder(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "new alarm")
                .putExtra(AlarmClock.EXTRA_HOUR, 10)
                .putExtra(AlarmClock.EXTRA_MINUTES, 10);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


}
