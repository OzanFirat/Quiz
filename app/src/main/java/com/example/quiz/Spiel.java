package com.example.quiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    private int score, questionCountTotal;
    private boolean answered;

    private static final long COUNTDOWN_IN_MILLIS = 60000;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private TextView textViewCountDown;


    private QuizDBHelper dbHelper;



    private TextView textVFrage;

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



        //textColorDefaultRb = btnAnswer.getTextColors();

       textColorDefaultCd = textViewCountDown.getTextColors();

       dbHelper = new QuizDBHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);



        showNextQuestion();




        btnAnswer.setOnClickListener(this);
        btnAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);



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

    private boolean antwortAuswerten (String btnText){
        boolean frage = false;
        countDownTimer.cancel();
        Fragen fragenC = new Fragen();
       ArrayList fragen = fragenC.getFragen();
       String[] speicher = (String[]) fragen.get(aktuelleFrage);
       if (speicher[1].equals(btnText)){
           frage=true;
       }
        return frage;
    }

    private void setTheScore(boolean winORLoss){
        if (winORLoss==true){
            dbHelper.addRating(level, ratingStar);
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
    level=1;
    currentQuestion = questionList.get(level);
    textVFrage.setText(currentQuestion.getQuestion());
    btnAnswer.setText(currentQuestion.getOpt1());
        btnAnswer1.setText(currentQuestion.getOpt2());
        btnAnswer2.setText(currentQuestion.getOpt3());
        btnAnswer3.setText(currentQuestion.getOpt4());



        rightAnswer=currentQuestion.getAnswerNr();

        timeLeftInMillis = COUNTDOWN_IN_MILLIS;

        startCountDown();





    }

    private void endGame() {
        ratingStar=0;
        Intent intent = new Intent(this, End2.class);
        startActivity(intent);
        this.finish();
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

        if (timeLeftInMillis>=40000){
            ratingStar=3;
        }
        if (timeLeftInMillis<40000){
            ratingStar=2;
        }
        if (timeLeftInMillis<20000){
            ratingStar=1;
        }


        if (timeLeftInMillis < 10000){
            textViewCountDown.setTextColor(Color.RED);

        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }

    }
}
