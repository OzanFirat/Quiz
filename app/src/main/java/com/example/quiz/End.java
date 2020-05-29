package com.example.quiz;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class End extends Activity implements View.OnClickListener {

    private Button btnStartMenu, btnNextLvl;
    private RatingBar rtBar;
    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    private int erreichtePunkte;
    private final String KEY = "speicherPreferences";
    private QuizDBHelper dbHelper;


    private TextView test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ende);

        this.btnStartMenu = (Button) findViewById(R.id.btnmainMenu);
        btnStartMenu.setOnClickListener(this);

        this.btnNextLvl = (Button) findViewById(R.id.btnNextLvl);
        btnNextLvl.setOnClickListener(this);


        this.rtBar = (RatingBar) findViewById(R.id.ratingBarEnd);


        QuizDBHelper dbHelper = new QuizDBHelper(this);
        List<Question>  questionList = dbHelper.getAllQuestions();


        int counter = 0, doneCounter = 0;
        while (counter < questionList.size()) {

            if (questionList.get(counter).getLvlDone().equalsIgnoreCase("yes")) {

                doneCounter++;

            }

            counter++;  }

        doneCounter=doneCounter-1;

            this.test = (TextView) findViewById(R.id.txtScore);
            // test.setText(questionList.get(level).getRatingStars());
            //test.setText(questionList.get(doneCounter).getRatingStars() + " " + questionList.get(doneCounter).getQuestion()+questionList.get(doneCounter).getLvlDone());

            // rtBar.setRating(questionList.get(level).getRatingStars());
            rtBar.setNumStars(3);
            float num = questionList.get(doneCounter).getRatingStars();
            rtBar.setRating(num);
            rtBar.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });


            // this.preferences = this.getSharedPreferences("highscore", MODE_PRIVATE);
            //  preferencesEditor = preferences.edit();

            // Bundle extras = getIntent().getExtras();
        }

        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.btnmainMenu:
                    Intent intent = new Intent(this, gameOverview.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.btnNextLvl:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

            }
        }
    }

