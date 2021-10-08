package com.example.gueesthenumber;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        getSupportActionBar().hide();//hide launch bar
        Thread thread = new Thread(new Runnable() {//this code is totaly for splash screen delay
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);//connect splash and main activity
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}