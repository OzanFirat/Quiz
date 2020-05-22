package com.example.quiz;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        Toast.makeText(LvlOverview.this, "Data updated"+questionList.get(0).getLvlDone(), Toast.LENGTH_LONG).show();
        int questionCountTotal = questionList.size();
        int counter = 0, doneCounter=0;
        ArrayList<Button> buttons = new ArrayList<Button>();

        while (counter<questionCountTotal){

            if(questionList.get(counter).getLvlDone().equalsIgnoreCase("yes")){

                doneCounter++;

            }
            counter++;

        }

        if(doneCounter<=20){
            counter=0;
        }

      //  Toast.makeText(LvlOverview.this, "Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_overview);


        lvl1 = (Button) findViewById(R.id.buttonlvl1);
        lvl1.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl1.setClickable(true);
            //lvl1.setBackgroundColor(@ColorInt);
        } else {
            lvl1.setClickable(false);
        }
        counter++;
       // Toast.makeText(LvlOverview.this, "Second Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        lvl2 = (Button) findViewById(R.id.buttonlvl2);
        lvl2.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl2.setClickable(true);
        }  else {
        lvl2.setClickable(false);
    }
        counter++;

        lvl3 = (Button) findViewById(R.id.buttonlvl3);
        lvl3.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl3.setClickable(true);
        } else {
            lvl3.setClickable(false);
        }
        counter++;

        lvl4 = (Button) findViewById(R.id.buttonlvl4);
        lvl4.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl4.setClickable(true);

        } else {
            lvl4.setClickable(false);
        }
        counter++;

        lvl5 = (Button) findViewById(R.id.buttonlvl5);
        lvl5.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl5.setClickable(true);
        } else {
            lvl5.setClickable(false);
        }
        counter++;

        lvl6 = (Button) findViewById(R.id.buttonlvl6);
        lvl6.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl6.setClickable(true);
        }else {
            lvl6.setClickable(false);
        }
        counter++;

        lvl7 = (Button) findViewById(R.id.buttonlvl7);
        lvl7.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl7.setClickable(true);
        }else {
            lvl7.setClickable(false);
        }
        counter++;

        lvl8 = (Button) findViewById(R.id.buttonlvl8);
        lvl8.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl8.setClickable(true);
        }else {
            lvl8.setClickable(false);
        }
        counter++;

        lvl9 = (Button) findViewById(R.id.buttonlvl9);
        lvl9.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl9.setClickable(true);
        } else {
            lvl9.setClickable(false);
        }
        counter++;

        lvl10 = (Button) findViewById(R.id.buttonlvl10);
        lvl10.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl10.setClickable(true);
        } else {
            lvl10.setClickable(false);
        }
        counter++;

        lvl11 = (Button) findViewById(R.id.buttonlvl11);
        lvl11.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl11.setClickable(true);
        } else {
            lvl11.setClickable(false);
        }
        counter++;

        lvl12 = (Button) findViewById(R.id.buttonlvl12);
        lvl12.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl12.setClickable(true);
        } else {
            lvl12.setClickable(false);
        }
        counter++;

        lvl13 = (Button) findViewById(R.id.buttonlvl13);
        lvl13.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl13.setClickable(true);
        } else {
            lvl13.setClickable(false);
        }
        counter++;

        lvl14 = (Button) findViewById(R.id.buttonlvl14);
        lvl14.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl14.setClickable(true);
        } else {
            lvl14.setClickable(false);
        }
        counter++;

        lvl15 = (Button) findViewById(R.id.buttonlvl15);
        lvl15.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl15.setClickable(true);
        } else {
            lvl15.setClickable(false);
        }
        counter++;

        lvl16 = (Button) findViewById(R.id.buttonlvl16);
        lvl16.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl16.setClickable(true);
        } else {
            lvl16.setClickable(false);
        }
        counter++;

        lvl17 = (Button) findViewById(R.id.buttonlvl17);
        lvl17.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl17.setClickable(true);
        } else {
            lvl17.setClickable(false);
        }
        counter++;

        lvl18 = (Button) findViewById(R.id.buttonlvl18);
        lvl18.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl18.setClickable(true);
        } else {
            lvl18.setClickable(false);
        }
        counter++;

        lvl19 = (Button) findViewById(R.id.buttonlvl19);
        lvl19.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl19.setClickable(true);
        } else {
            lvl19.setClickable(false);
        }
        counter++;

        lvl20 = (Button) findViewById(R.id.buttonlvl20);
        lvl20.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl20.setClickable(true);
        } else {
            lvl20.setClickable(false);
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

            case R.id.buttonlvl2:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl3:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl4:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl5:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl6:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl7:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl8:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl9:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl10:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl11:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl12:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl13:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl14:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl15:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl16:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl17:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl18:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl19:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl20:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;



        }


    }
}
