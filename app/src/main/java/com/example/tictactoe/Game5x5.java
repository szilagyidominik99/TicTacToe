package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Game5x5 extends AppCompatActivity implements View.OnClickListener{

    CheckIsWinnerState checkIsWinnerState = new CheckIsWinnerState();
    MediaPlayer mediaPlayer;

    private ImageButton[] imgBtns = new ImageButton[25];
    private int size = 5;
    private ImageButton[] haveToBlinking = new ImageButton[4];
    private int[][] buttonsValue = {{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
    private int counter = -1, start = 0, xWin = 0,oWin = 0, draw = 0, clicks= 0;
    private boolean step = true, whoIsStart = true, isDraw = false;
    private String[] blinkingButtonId;
    private Drawable value;
    private Button againBtn;
    private TextView numberOfDraw;
    private TextView numberOfX;
    private TextView numberOfO;

    public void EndOfGame(){
        for(int i = 0; i < imgBtns.length; i++){
            imgBtns[i].setEnabled(false);
        }
    }

    public void Blinking(ImageButton [] haveToBlinking){
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(150);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        for(int i = 0; i < haveToBlinking.length; i++){
            haveToBlinking[i].startAnimation(anim);
        }
    }

    public void stopBlinking(ImageButton[] haveToBlinking){
        for(int i = 0; i < haveToBlinking.length; i++){
            haveToBlinking[i].clearAnimation();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5x5);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer.start();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                counter++;
                String buttonIdName = "btn_" + i + "_" + j;
                int buttonId = getResources().getIdentifier(buttonIdName,"id",getPackageName());
                imgBtns[counter] = (ImageButton) findViewById(buttonId);
                imgBtns[counter].setOnClickListener(this);
            }
        }

        value = imgBtns[0].getBackground();

        againBtn = findViewById(R.id.againButton);
        againBtn.setVisibility(View.GONE);

        numberOfDraw = findViewById(R.id.drawTextView);
        numberOfO = findViewById(R.id.oTextView);
        numberOfX = findViewById(R.id.xTextView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer.start();
    }

    @Override
    public void onClick(View v) {
        clicks++;
        int row = -1;
        int column = -1;

        if(start == 0){
            whoIsStart = step;
            start++;
        }
        String[] idName = v.getResources().getResourceName(v.getId()).split("/");
        row = Integer.parseInt(idName[1].split("_")[1]);
        column = Integer.parseInt(idName[1].split("_")[2]);

        if(step){
            v.setBackgroundResource(R.drawable.x);
            buttonsValue[row][column] = 1;

        }else {
            v.setBackgroundResource(R.drawable.o);
            buttonsValue[row][column] = 2;
        }
        v.setEnabled(false);

        if(checkIsWinnerState.isWinnerState(row,column,buttonsValue, step, size)){
            EndOfGame();

            if(step){
                xWin++;
                numberOfX.setText(xWin+"");
            }
            else{
                oWin++;
                numberOfO.setText(oWin+"");
            }
            if(whoIsStart == step){
                step = !step;
            }

            againBtn.setVisibility(View.VISIBLE);
            blinkingButtonId = checkIsWinnerState.getWinnerImageButtonId();
            for(int i = 0; i<blinkingButtonId.length; i++){
                int x = getResources().getIdentifier(blinkingButtonId[i],"id",getPackageName());
                haveToBlinking[i] = findViewById(x);
            }
            Blinking(haveToBlinking);
            isDraw = false;
        }
        else if(clicks == 25){
            draw++;
            numberOfDraw.setText(draw+"");
            againBtn.setVisibility(View.VISIBLE);
            step = !step;
            isDraw = true;
        }
        else {
            step = !step;
        }
    }

    public void clickedBack(View view) {
        mediaPlayer.stop();
        finish();
    }

    public void clickedExit(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public void clickedAgain(View view) {
        for(int i = 0; i < imgBtns.length; i++){
            imgBtns[i].setBackground(value);
            imgBtns[i].setEnabled(true);
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                buttonsValue[i][j] = 0;
            }
        }

        againBtn.setVisibility(View.GONE);
        if(isDraw == false)
            stopBlinking(haveToBlinking);

        start = 0;
        clicks = 0;
    }
}
