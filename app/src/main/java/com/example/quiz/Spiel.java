package com.example.quiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


@SuppressWarnings("ALL")
public class Spiel extends AppCompatActivity implements View.OnClickListener {
    private Button btnAnswer,btnAnswer1,btnAnswer2,btnAnswer3;
    private List<Question> questionList;
    private ColorStateList textColorDefaultRb;
    private Question currentQuestion;

    private int score, questionCountTotal, amountOfFails;
    private boolean answered;

    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private TextView textViewCountDown, textVFrage, imgView;


    private QuizDBHelper dbHelper;





    int aktuelleFrage = 0, level = 0, ratingStar;
    boolean win;
    int rightAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel);


        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        btnAnswer1 = (Button) findViewById(R.id.btnAnswer1);
        btnAnswer2 = (Button) findViewById(R.id.btnAnswer2);
        btnAnswer3 = (Button) findViewById(R.id.btnAnswer3);

        textVFrage = (TextView)  findViewById(R.id.textVFrage);
        textViewCountDown = (TextView) findViewById(R.id.txtVTimer);
    imgView=(TextView) findViewById(R.id.imageView);



        //textColorDefaultRb = btnAnswer.getTextColors();

       textColorDefaultCd = textViewCountDown.getTextColors();

       dbHelper = new QuizDBHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
       // Collections.shuffle(questionList);



        showNextQuestion();




        btnAnswer.setOnClickListener(this);
        btnAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);

        Toast.makeText(Spiel.this, "Game activity new loaded", Toast.LENGTH_LONG).show();

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAnswer:
               if (rightAnswer==1){
                   win=true;
                   setTheScore(win);

               } else {
                    win=false;
                    setTheScore(win);
               }

                break;
            case R.id.btnAnswer1:

                if (rightAnswer==2){
                    win=true;
                    setTheScore(win);
                } else {
                    win=false;
                    setTheScore(win);
                }
                    break;
            case R.id.btnAnswer2:
                if (rightAnswer==3){
                    win=true;
                    setTheScore(win);
                } else {
                    win=false;
                    setTheScore(win);
                }
                break;
            case R.id.btnAnswer3:

                if (rightAnswer==4){
                    win=true;
                    setTheScore(win);
                } else {
                    win=false;
                    setTheScore(win);
                }
                break;
        }
    }


    private void setTheScore(boolean winORLoss){
        if (winORLoss==true){
           String oldRating = ""+currentQuestion.getRatingStars();
           String actualLvlStatus="yes", oldLvlStatus = "no";
           level = currentQuestion.getLevelNr();
           boolean update = dbHelper.addRating(level, ratingStar, oldRating, actualLvlStatus, oldLvlStatus);

           if(update==true){
               Toast.makeText(Spiel.this, "Data updated"+ratingStar, Toast.LENGTH_LONG).show();

           } else {
               Toast.makeText(Spiel.this, "Data is not updated", Toast.LENGTH_LONG).show();
           }
            countDownTimer.cancel();
            Intent intent = new Intent(this, End.class);
            startActivity(intent);
            this.finish();
        } else {
            ratingStar=0;

            Intent intent = new Intent(this, End2.class);
            startActivity(intent);
            this.finish();

        }

    }

    private void showNextQuestion(){
        /*
        btnAnswer.setTextColor(textColorDefaultRb);
        btnAnswer1.setTextColor(textColorDefaultRb);
        btnAnswer2.setTextColor(textColorDefaultRb);
        btnAnswer3.setTextColor(textColorDefaultRb);

         */

        int counter=0, doneCounter=0;
        while (counter<questionCountTotal){

            if(questionList.get(counter).getLvlDone().equalsIgnoreCase("yes")){

                doneCounter++;

            }
            counter++;

        }
    level=doneCounter;
    currentQuestion = questionList.get(level);
    textVFrage.setText(currentQuestion.getQuestion());
    btnAnswer.setText(currentQuestion.getOpt1());
        btnAnswer1.setText(currentQuestion.getOpt2());
        btnAnswer2.setText(currentQuestion.getOpt3());
        btnAnswer3.setText(currentQuestion.getOpt4());

        if(level==1){
            amountOfFails=currentQuestion.getAmountOfFailures();
        } else{
            int previousQuestion = currentQuestion.getLevelNr()-1;
            amountOfFails=questionList.get(previousQuestion).getAmountOfFailures();

            dbHelper.updateAmountOfFailure(currentQuestion.getLevelNr(), currentQuestion.getAmountOfFailures()+"", amountOfFails+"");
            currentQuestion.setAmountOfFailures(amountOfFails);
        }



        rightAnswer=currentQuestion.getAnswerNr();

        timeLeftInMillis = COUNTDOWN_IN_MILLIS;

        startCountDown();





    }

    private void endGame() {
        countDownTimer.cancel();
        ratingStar=0;
        amountOfFails++;
        dbHelper.updateAmountOfFailure(currentQuestion.getLevelNr(), currentQuestion.getAmountOfFailures()+"", amountOfFails+"");
        if(amountOfFails==3){
            Intent intent = new Intent(this, End2.class);
            startActivity(intent);
            this.finish();
            dbHelper.alterTable();
        } else {
            Intent intent = new Intent(this, End2.class);
            startActivity(intent);
            this.finish();
        }

    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();


            }


        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int)(timeLeftInMillis / 1000) / 60;
        int seconds = (int)(timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);
        if (timeLeftInMillis==0){
            endGame();
        }

        if (timeLeftInMillis>=20000){
            ratingStar=3;
        }
        if (timeLeftInMillis<20000){
            ratingStar=2;
        }
        if (timeLeftInMillis<10000){
            ratingStar=1;
        }


        if (timeLeftInMillis < 10000){
            textViewCountDown.setTextColor(Color.RED);

        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }

    }
}
