package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class simple2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String a;
                Intent y = getIntent();
                a = y.getStringExtra("P");
                Intent t = new Intent(simple2.this,result.class);
                t.putExtra("H",a);
                startActivity(t);
                finish();
            }
        },2000);
    }
}