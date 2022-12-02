package com.example.pixel_effect_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.pixel_effect_app.R;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Animation animation = AnimationUtils.loadAnimation(home.this, R.anim.layout);
        findViewById(R.id.textView).setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(home.this, Start_Activity.class);
                startActivity(homeIntent);
                finish();

            }
        }, 3000);
    }
}