package com.example.hauskonnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LaucherScreen extends AppCompatActivity {
    Animation topAnim,bottomAnim;
    ImageView img;
    TextView tl;
    private static int SPLASH_VARIABLE=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_laucher_screen);

        img=findViewById(R.id.imageView);
        tl=findViewById(R.id.textView);

        topAnim= AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        img.setAnimation(topAnim);
        tl.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(LaucherScreen.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_VARIABLE);


    }
}