package com.feximin.notificationspanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.but_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotManager.getInstance(MainActivity.this).publish(new DownloadNot(MainActivity.this, "http://www.iteye.com/upload/logo/user/953008/15a7e852-ed61-3ef9-a042-7e92be65547b.jpg?1395728549"));
            }
        });
    }
}
