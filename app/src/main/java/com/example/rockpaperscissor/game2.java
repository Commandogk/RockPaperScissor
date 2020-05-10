package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game2 extends AppCompatActivity {
    String da,dc,winner;
    Integer dtotal,ptd1=0,ptd2=0,xd=0,yd=0,id=0,dcheckId=-1;
    ImageView b,n,m;
    RadioGroup dchoices;
    Button dreset,dsubmit;
    static int Delay = 2000;
    MediaPlayer j,o;
    Animation a;
    TextView Td1,Td2,Td3;
    boolean turn = true;
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        b=findViewById(R.id.dq);
        n=findViewById(R.id.dw);
        m=findViewById(R.id.de);
        dchoices = findViewById(R.id.rd);
        dreset = findViewById(R.id.dbtr);
        dsubmit = findViewById(R.id.dbts);
        Td1 = findViewById(R.id.ptd1);
        Td2 = findViewById(R.id.ptd2);
        Td3 = findViewById(R.id.dround);
        Intent b=getIntent();
        da=b.getStringExtra("AB");
        dc=b.getStringExtra("CD");
        dtotal= Integer.parseInt(dc);
        Td1.setText("Player 1:"+ yd);
        Td2.setText("Player 2:"+ id);
        Td3.setText("Round:"+xd+"/"+dtotal);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        j = MediaPlayer.create(game2.this,R.raw.out);
        j.setVolume(50,50);
        o = MediaPlayer.create(game2.this,R.raw.lost1);
        o.setVolume(50,50);

        dsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 dcheckId = dchoices.getCheckedRadioButtonId();
                if (dcheckId == -1) {
                    Toast.makeText(getApplicationContext(), "select a option", Toast.LENGTH_SHORT);
                } else {
                    win(findradiobutton(dcheckId));

                }



            }

            private void win(boolean turn) {
                if(xd<=dtotal&&xd!=0)
                {

                        if(((ptd1==2)&&(ptd2==1))||((ptd1==1)&&(ptd2==3))||((ptd1==3)&&(ptd2==2))){
                            yd++;
                            j.start();
                        }
                        else if(((ptd1==1)&&(ptd2==2))||((ptd2==1)&&(ptd1==3))||((ptd1==2)&&(ptd2==3)))
                        {   id++;
                        o.start();

                        }
                        else{

                        }
                     Td1.setText("Player 1:"+ yd);
                    Td2.setText("Player 2:"+ id);
                    Td3.setText("Round:"+xd +"/" + dtotal);
                   if(xd==dtotal){
                       if(yd>id){
                           winner=da;
                       }
                       else if (id>yd){
                           winner="You Lost";
                       }
                       else
                           winner="draw";
                       new Handler().postDelayed(new Runnable() {
                           @Override
                           public void run() {

                                   Intent y = new Intent(game2.this,simple2.class);
                                   y.putExtra("P",winner);
                                   startActivity(y);

                           }
                       },Delay);


                   }

                }

            }
        });

        dreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dchoices.clearCheck();
                xd=0;yd=0;id=0; Td1.setText("Player 1:"+ yd);
                Td2.setText("Player 2:"+ id);
                Td3.setText("Round:"+xd +"/" + dtotal);


            }
        });
    }
    private boolean findradiobutton(int dcheckId) {
        switch (dcheckId) {
            case R.id.gk1: {
                    ptd1 = 1;
                    Toast.makeText(getApplicationContext(),"round over",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.gk2: {
                    ptd1 = 2;
                    Toast.makeText(getApplicationContext(),"round over",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.gk3: {
                    ptd1 = 3;
                    Toast.makeText(getApplicationContext(),"round over",Toast.LENGTH_SHORT).show();
                break;
            }
        }
        vibrator.vibrate(300);
        xd++;

        Random rand = new Random();
        ptd2 = rand.nextInt(3) +1;
        a = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        if(ptd2==1)
        {
            b.startAnimation(a);
        }
        else if(ptd2==2)
        {
            n.startAnimation(a);
        }
        else if(ptd2==3)
        {
            m.startAnimation(a);
        }
        else{}
        dchoices.clearCheck();
        return turn;


    }


}
