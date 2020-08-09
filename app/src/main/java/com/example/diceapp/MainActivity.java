package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int [] diceImages={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6,};

        final MediaPlayer mp=MediaPlayer.create(this,R.raw.dice_sound);

        final ImageView diceImage1=findViewById(R.id.imgDice1);
        final ImageView diceImage2=findViewById(R.id.imgDice2);

        Button btn=findViewById(R.id.btnRoll);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomObj=new Random();
                int randomNum=randomObj.nextInt(6);
                diceImage1.setImageResource(diceImages[randomNum]);

                randomNum=randomObj.nextInt(6);
                diceImage2.setImageResource(diceImages[randomNum]);
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage2);
                mp.start();
            }
        });
    }
}