package com.example.hauskonnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class About extends AppCompatActivity {
    private ImageView har,ahm,sar,uts,kev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        har=findViewById(R.id.hardeep);
        ahm=findViewById(R.id.ahmed);
        sar=findViewById(R.id.sarthakk);
        uts=findViewById(R.id.utsav);
        kev=findViewById(R.id.kev);

        har.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl( "https://www.linkedin.com/in/hardeep-patel/");
            }
        });
        ahm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl( "https://www.linkedin.com/in/ahmed-mulla-548872204/");
            }
        });
        sar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl( "https://www.linkedin.com/in/sarthak-kapaliya-2723bb202//");
            }
        });
        uts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl( "https://www.linkedin.com/in/utsav-mehta-4253b0200/");
            }
        });
        kev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl( "https://www.linkedin.com/in/kevin-patel45/");
            }
        });

    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}