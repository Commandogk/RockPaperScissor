package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game1 extends AppCompatActivity {
   String A,B,C,winnner;
   Integer total,pt1=0,pt2=0,x=0,y=0,turn=2,i=0;
    RadioGroup choices;
    Button reset,submit;
    TextView T1,T2,T3;
    Vibrator vibrator ;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int display_mode = getResources().getConfiguration().orientation;
        setContentView(R.layout.activity_game1);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        choices = findViewById(R.id.r);
        reset = findViewById(R.id.btr);
        submit = findViewById(R.id.bts);
        T1 = findViewById(R.id.pt1);
        T2 = findViewById(R.id.pt2);
        T3 = findViewById(R.id.round);
        Intent intent=getIntent();
        A=intent.getStringExtra("A");
        B=intent.getStringExtra("B");
        C=intent.getStringExtra("C");


       total = Integer.parseInt(C);
        T1.setText("Player 1:"+ y);
        T2.setText("Player 2:"+ i);
        T3.setText("Round:"+x +"/" + total);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkId = choices.getCheckedRadioButtonId();
                if (checkId == -1) {
                    Toast.makeText(getApplicationContext(), "select a option", Toast.LENGTH_SHORT);
                } else {
                    win(findradiobutton(checkId));

                }



            }

            private void win(int turn) {

                if(x<=total&&x!=0)
                {
                    if(turn%2==0){
                        if(((pt1==2)&&(pt2==1))||((pt1==1)&&(pt2==3))||((pt1==3)&&(pt2==2))){
                            y++;

                        }
                        else if(((pt1==1)&&(pt2==2))||((pt2==1)&&(pt1==3))||((pt1==2)&&(pt2==3)))
                        {   i++;

                        }
                        else{

                        }

                    }
                    T1.setText("Player 1:"+ y);
                    T2.setText("Player 2:"+ i);
                    T3.setText("Round:"+x +"/" + total);
                    if(x==total)
                    {
                        if(y>i){
                            winnner=A;
                        }
                        else if (i>y){
                            winnner=B;
                        }
                        else
                           winnner="draw";
                        x=0;y=0;i=0;
                        T1.setText("Player 1:"+ y);
                        T2.setText("Player 2:"+ i);
                        T3.setText("Round:"+x +"/" + total);
                        Intent y = new Intent(game1.this,simple2.class);
                        y.putExtra("P",winnner);
                        startActivity(y);
                    }

                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                choices.clearCheck();
                x=0;y=0;i=0;
                T1.setText("Player 1:"+ y);
                T2.setText("Player 2:"+ i);
                T3.setText("Round:"+x +"/" + total);
            }
        });
    }
    private int findradiobutton(int checkId) {
        switch (checkId) {
            case R.id.stone: {
                if (turn%2==0)
                { pt1 = 1;
                    vibrator.vibrate(50);
                    Toast.makeText(getApplicationContext(),"next player choice",Toast.LENGTH_SHORT).show();
                }
                else{
                    pt2 = 1;
                    x++;
                    vibrator.vibrate(500);
                    Toast.makeText(getApplicationContext(),"round over",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.paper: {
                if (turn%2==0) {
                    pt1 = 2;
                    vibrator.vibrate(50);
                    Toast.makeText(getApplicationContext(),"next player choice",Toast.LENGTH_SHORT).show();

                }
                else{
                    pt2 = 2;
                    vibrator.vibrate(500);
                    x++;

                    Toast.makeText(getApplicationContext(),"round over",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.scissor: {
                if (turn%2==0) {
                    pt1 = 3;
                    vibrator.vibrate(50);
                    Toast.makeText(getApplicationContext(),"next player choice",Toast.LENGTH_SHORT).show();
                }
                else{
                    pt2 = 3;
                    x++;
                    vibrator.vibrate(500);
                    Toast.makeText(getApplicationContext(),"round over",Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
        turn++;
        choices.clearCheck();
        return turn;


    }


}