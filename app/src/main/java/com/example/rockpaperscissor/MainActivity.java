package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button single,dual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        single=findViewById(R.id.single);
        dual=findViewById(R.id.dual);
        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent X = new Intent(MainActivity.this,singleplayer.class);
                startActivity(X);
                finish();
            }
        });
        dual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent V = new Intent(MainActivity.this,dualplayer.class);
                startActivity(V);
                finish();
            }
        });

    }
}
