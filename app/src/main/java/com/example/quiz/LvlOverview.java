package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class LvlOverview extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String SHARED_PREFS = "keyHighscore";
    Button lvl1, lvl2, lvl3, lvl4, lvl5, lvl6, lvl7, lvl8, lvl9, lvl10, lvl11, lvl12, lvl13, lvl14, lvl15, lvl16, lvl17, lvl18, lvl19, lvl20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        QuizDBHelper dbHelper = new QuizDBHelper(this);
        List<Question> questionList = dbHelper.getAllQuestions();
        int questionCountTotal = questionList.size();
        int counter = 0, doneCounter=0;
        ArrayList<Button> buttons = new ArrayList<Button>();

        while (counter<questionCountTotal){

            if(questionList.get(counter).getLvlDone().equalsIgnoreCase("yes")){

                doneCounter++;

            }
            counter++;

        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_overview);


        lvl1 = (Button) findViewById(R.id.buttonlvl1);
        lvl1.setOnClickListener(this);
        if(doneCounter+1>=questionList.get(0).getLevelNr()){
            lvl1.setClickable(true);
        } else {
            lvl1.setClickable(false);
        }

        lvl2 = (Button) findViewById(R.id.buttonlvl2);
        lvl2.setOnClickListener(this);
        if(doneCounter+1>=questionList.get(1).getLevelNr()){
            lvl2.setClickable(true);
        }

        lvl3 = (Button) findViewById(R.id.buttonlvl3);
        lvl3.setOnClickListener(this);
        if(doneCounter+1>=questionList.get(2).getLevelNr()){
            lvl3.setClickable(true);
        }

        lvl4 = (Button) findViewById(R.id.buttonlvl4);
        lvl4.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(3).getLevelNr()){
            lvl4.setClickable(true);
        }

        lvl5 = (Button) findViewById(R.id.buttonlvl5);
        lvl5.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(4).getLevelNr()){
            lvl5.setClickable(true);
        }
/*
        lvl6 = (Button) findViewById(R.id.buttonlvl6);
        lvl6.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(5).getLevelNr()){
            lvl6.setClickable(true);
        }

        lvl7 = (Button) findViewById(R.id.buttonlvl7);
        lvl7.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(6).getLevelNr()){
            lvl7.setClickable(true);
        }

        lvl8 = (Button) findViewById(R.id.buttonlvl8);
        lvl8.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(7).getLevelNr()){
            lvl8.setClickable(true);
        }

        lvl9 = (Button) findViewById(R.id.buttonlvl9);
        lvl9.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(8).getLevelNr()){
            lvl1.setClickable(true);
        }

        lvl10 = (Button) findViewById(R.id.buttonlvl10);
        lvl10.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(9).getLevelNr()){
            lvl1.setClickable(true);
        }

        lvl11 = (Button) findViewById(R.id.buttonlvl11);
        lvl11.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(10).getLevelNr()){
            lvl11.setClickable(true);
        }

        lvl12 = (Button) findViewById(R.id.buttonlvl12);
        lvl12.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(11).getLevelNr()){
            lvl12.setClickable(true);
        }

        lvl13 = (Button) findViewById(R.id.buttonlvl13);
        lvl13.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(12).getLevelNr()){
            lvl11.setClickable(true);
        }

        lvl14 = (Button) findViewById(R.id.buttonlvl14);
        lvl14.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(13).getLevelNr()){
            lvl11.setClickable(true);
        }

        lvl15 = (Button) findViewById(R.id.buttonlvl15);
        lvl15.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(14).getLevelNr()){
            lvl11.setClickable(true);
        }

        lvl16 = (Button) findViewById(R.id.buttonlvl16);
        lvl16.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(15).getLevelNr()){
            lvl11.setClickable(true);
        }

        lvl17 = (Button) findViewById(R.id.buttonlvl17);
        lvl17.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(16).getLevelNr()){
            lvl11.setClickable(true);
        }

        lvl18 = (Button) findViewById(R.id.buttonlvl18);
        lvl18.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(17).getLevelNr()){
            lvl11.setClickable(true);
        }

        lvl19 = (Button) findViewById(R.id.buttonlvl19);
        lvl19.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(18).getLevelNr()){
            lvl11.setClickable(true);
        }

        lvl20 = (Button) findViewById(R.id.buttonlvl20);
        lvl20.setOnClickListener(this);
        if(doneCounter+1<=questionList.get(19).getLevelNr()){
            lvl11.setClickable(true);
        }




 */







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
