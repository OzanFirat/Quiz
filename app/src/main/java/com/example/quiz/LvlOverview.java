package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class LvlOverview extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String SHARED_PREFS = "keyHighscore";
    Button lvl1, lvl2, lvl3, lvl4, lvl5, lvl6, lvl7, lvl8, lvl9, lvl10, lvl11, lvl12, lvl13, lvl14, lvl15, lvl16, lvl17, lvl18, lvl19, lvl20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_overview);

        lvl1 = (Button) findViewById(R.id.buttonlvl1);
        lvl1.setOnClickListener(this);

        lvl2 = (Button) findViewById(R.id.buttonlvl2);
        lvl2.setOnClickListener(this);

        lvl3 = (Button) findViewById(R.id.buttonlvl3);
        lvl3.setOnClickListener(this);

        lvl4 = (Button) findViewById(R.id.buttonlvl4);
        lvl4.setOnClickListener(this);

        lvl5 = (Button) findViewById(R.id.buttonlvl5);
        lvl5.setOnClickListener(this);

        lvl6 = (Button) findViewById(R.id.buttonlvl6);
        lvl6.setOnClickListener(this);

        lvl7 = (Button) findViewById(R.id.buttonlvl7);
        lvl7.setOnClickListener(this);

        lvl8 = (Button) findViewById(R.id.buttonlvl8);
        lvl8.setOnClickListener(this);

        lvl9 = (Button) findViewById(R.id.buttonlvl9);
        lvl9.setOnClickListener(this);

        lvl10 = (Button) findViewById(R.id.buttonlvl10);
        lvl10.setOnClickListener(this);

        lvl11 = (Button) findViewById(R.id.buttonlvl11);
        lvl11.setOnClickListener(this);

        lvl12 = (Button) findViewById(R.id.buttonlvl12);
        lvl12.setOnClickListener(this);

        lvl13 = (Button) findViewById(R.id.buttonlvl13);
        lvl13.setOnClickListener(this);

        lvl14 = (Button) findViewById(R.id.buttonlvl14);
        lvl14.setOnClickListener(this);

        lvl15 = (Button) findViewById(R.id.buttonlvl15);
        lvl15.setOnClickListener(this);

        lvl16 = (Button) findViewById(R.id.buttonlvl16);
        lvl16.setOnClickListener(this);

        lvl17 = (Button) findViewById(R.id.buttonlvl17);
        lvl17.setOnClickListener(this);

        lvl18 = (Button) findViewById(R.id.buttonlvl18);
        lvl18.setOnClickListener(this);

        lvl19 = (Button) findViewById(R.id.buttonlvl19);
        lvl19.setOnClickListener(this);

        lvl20 = (Button) findViewById(R.id.buttonlvl20);
        lvl20.setOnClickListener(this);

        QuizDBHelper dbHelper = new QuizDBHelper(this);
        List<Question> questionList = dbHelper.getAllQuestions();
        int questionCountTotal = questionList.size();
        int counter = 0;
        while (counter<=questionCountTotal){
            if(questionList.get(counter).getLvlDone()=="yes"){
                String currentLvl= "lvl"+counter;

            }
        }






    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonlvl1:
                Intent intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }
}
