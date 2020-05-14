package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class singleplayer extends AppCompatActivity {
    EditText pl1,t;

    Button s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        pl1 =  findViewById(R.id.play1);
        t = findViewById(R.id.ab);
        s = findViewById(R.id.begi);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pl1.getText().toString().isEmpty()||t.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter Details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent b =   new Intent(singleplayer.this, game2.class);
                    String play_1,  norounds;
                    play_1 = pl1.getText().toString();
                    norounds = t.getText().toString();
                    b.putExtra("AB", play_1);
                    b.putExtra("CD", norounds);
                    startActivity(b);
                    finish();
                }
            }
        });
    }
}
