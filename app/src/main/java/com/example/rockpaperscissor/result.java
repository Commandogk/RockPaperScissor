package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class result extends AppCompatActivity {
     TextView win,result;
     String F;
     RelativeLayout layout;
     MediaPlayer p,l,m;
     Animation A;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        win = findViewById(R.id.win);
        result = findViewById(R.id.b);
        Intent t = getIntent();
        p = MediaPlayer.create(result.this,R.raw.lost);
        l = MediaPlayer.create(result.this,R.raw.vicotry);
        p.setVolume(50,50);
        l.setVolume(50,50);
        layout = findViewById(R.id.layout);
        F = t.getStringExtra("H");
        A = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);

        if(F.equals("You Lost")){
            win.setText("System is the winner!!");
            p.start();
            win.setTextColor(Color.parseColor("#1D1B1B"));
            layout.setBackgroundColor(Color.parseColor("#EC4849"));
            result.setTextColor(Color.parseColor("#1D1B1B"));
        }
        else if(F.equals("draw")){

            win.setText("Draw!!");
            layout.setBackgroundColor(Color.parseColor("#1D1B1B"));
        }
        else
        {   l.start();
            win.setText("The Winner is "+ F);
            win.setTextColor(Color.parseColor("#1D1B1B"));
            layout.setBackgroundColor(Color.parseColor("#32CD32"));
            result.setTextColor(Color.parseColor("#1D1B1B"));


        }
        win.startAnimation(A);


        Handler a = new Handler();

              a.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      Intent r = new Intent(result.this,MainActivity.class);
                      startActivity(r);
                  }
              },5000);



    }
}
