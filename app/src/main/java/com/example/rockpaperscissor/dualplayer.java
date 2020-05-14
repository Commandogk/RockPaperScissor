package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dualplayer extends AppCompatActivity {
    EditText play1,play2,to;
    MediaPlayer pl;
    Button st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dualplayer);
        play1 = findViewById(R.id.player1);
        play2 = findViewById(R.id.player2);
        to = findViewById(R.id.abc);
        st = findViewById(R.id.begin);
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play1.getText().toString().isEmpty()||play2.getText().toString().isEmpty()||to.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter the details",Toast.LENGTH_SHORT).show();
                }
                else if(play1.getText().toString().equals(play2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Enter different player names",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(dualplayer.this,game1.class);
                    String player_1, player_2, noofrounds;
                    player_1 = play1.getText().toString();
                    player_2 = play2.getText().toString();
                    noofrounds = to.getText().toString();
                    intent.putExtra("A", player_1);
                    intent.putExtra("B", player_2);
                    intent.putExtra("C", noofrounds);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
