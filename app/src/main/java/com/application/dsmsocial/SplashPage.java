package com.application.dsmsocial;

import android.os.CountDownTimer;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashPage extends AppCompatActivity {

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);

        timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                closeScreen();
            }
        }.start();
    }

    private void closeScreen()
    {
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
        finish();
    }
}