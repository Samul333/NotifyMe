package com.huske.sharedexample;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Welcome_page extends AppCompatActivity {
    private static int Splash_time_out = 4000;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        ImageView loading = (ImageView)findViewById(R.id.imageView4);
        animationDrawable = (AnimationDrawable)loading.getDrawable();
        animationDrawable.start();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {


                Intent homeIntent = new Intent(Welcome_page.this,MainActivity.class);

                startActivity(homeIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();


            }
        },Splash_time_out);
    }
}
