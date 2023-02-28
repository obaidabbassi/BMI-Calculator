package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        LottieAnimationView animationView = findViewById(R.id.animation_view);
        animationView.setAnimation(R.raw.doc);
        animationView.playAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {




                Intent inext = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(inext);
                finish();
            }
        },3000);


    }




    }
