package com.example.quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class lvlOverview8 extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String SHARED_PREFS = "keyHighscore";
    Button lvl78, lvl79, lvl80, lvl81, lvl82, lvl83, lvl84, lvl85, lvl86, lvl87, lvl88;
    private List<Question> questionList;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

   super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lvl_overview8);
    QuizDBHelper dbHelper = new QuizDBHelper(this);
    questionList = dbHelper.getAllQuestions();

    //Toast.makeText(LvlOverview.this, "Data updated"+questionList.get(0).getLvlDone(), Toast.LENGTH_LONG).show();
    int questionCountTotal = questionList.size();
    int counter = 0, doneCounter=0;
    ArrayList<Button> buttons = new ArrayList<Button>();

        while (counter<questionList.size()){

        if(questionList.get(counter).getLvlDone().equalsIgnoreCase("yes")){

            doneCounter++;

        }
        counter++;

    }

    counter=77;

    //  Toast.makeText(LvlOverview.this, "Data updated"+doneCounter, Toast.LENGTH_LONG).show();



    lvl78 = (Button) findViewById(R.id.buttonlvl78);
        lvl78.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl78.setClickable(true);
        //lvl1.setBackgroundColor(@ColorInt);
        //  lvl1.setBackgroundColor(-65536);
            lvl78.setBackground(getDrawable(R.drawable.sparta_helm));
    } else {
        levelIsDone(lvl78,doneCounter,counter);
    }
    counter++;
    // Toast.makeText(LvlOverview.this, "Second Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        lvl79= (Button) findViewById(R.id.buttonlvl79);
        lvl79.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl79.setClickable(true);
        //  lvl2.setBackgroundColor(-65536);
            lvl79.setBackground(getDrawable(R.drawable.sparta_helm));
    }  else {
        levelIsDone(lvl79,doneCounter,counter);
    }
    counter++;

        lvl80 = (Button) findViewById(R.id.buttonlvl80);
        lvl80.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl80.setClickable(true);
            lvl80.setBackground(getDrawable(R.drawable.sparta_helm));
    } else {
        levelIsDone(lvl80,doneCounter,counter);
    }
    counter++;

        lvl81 = (Button) findViewById(R.id.buttonlvl81);
        lvl81.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl81.setClickable(true);
            lvl81.setBackground(getDrawable(R.drawable.sparta_helm));
    } else {
        levelIsDone(lvl81,doneCounter,counter);
    }
    counter++;

        lvl82 = (Button) findViewById(R.id.buttonlvl82);
        lvl82.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl82.setClickable(true);
            lvl82.setBackground(getDrawable(R.drawable.sparta_helm));
    } else {
        levelIsDone(lvl82,doneCounter,counter);
    }
    counter++;

        lvl83 = (Button) findViewById(R.id.buttonlvl83);
        lvl83.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl83.setClickable(true);
        //lvl6.setBackgroundColor(-65536);
            lvl83.setBackground(getDrawable(R.drawable.sparta_helm));
    }else {
        levelIsDone(lvl83,doneCounter,counter);
    }
    counter++;

    lvl84 = (Button) findViewById(R.id.buttonlvl84);
        lvl84.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl84.setClickable(true);
            lvl84.setBackground(getDrawable(R.drawable.sparta_helm));
    }else {
        levelIsDone(lvl84,doneCounter,counter);
    }
    counter++;

    lvl85 = (Button) findViewById(R.id.buttonlvl85);
        lvl85.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl85.setClickable(true);
            lvl85.setBackground(getDrawable(R.drawable.sparta_helm));
    }else {
        levelIsDone(lvl85,doneCounter,counter);
    }
    counter++;

    lvl86 = (Button) findViewById(R.id.buttonlvl86);
        lvl86.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl86.setClickable(true);
            lvl86.setBackground(getDrawable(R.drawable.sparta_helm));
    } else {
        levelIsDone(lvl86,doneCounter,counter);
    }
    counter++;

        lvl87 = (Button) findViewById(R.id.buttonlvl87);
        lvl87.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl87.setClickable(true);
            lvl87.setBackground(getDrawable(R.drawable.sparta_helm));
    } else {
        levelIsDone(lvl87,doneCounter,counter);
    }
    counter++;

        lvl88 = (Button) findViewById(R.id.buttonlvl88);
        lvl88.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()) {
            lvl88.setClickable(true);
            lvl88.setBackground(getDrawable(R.drawable.sparta_helm));
    }  else {
        levelIsDone(lvl88,doneCounter,counter);
    }
    counter++;


}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void levelIsDone(Button lvlXY, int doneCounter, int counter) {
        lvlXY.setClickable(false);
        if(questionList.get(counter).getLevelNr()<=doneCounter){
            if(questionList.get(counter).getRatingStars()==3){
                lvlXY.setBackground(getDrawable(R.drawable.sieges_banner_drei_sterne));
            }
            if(questionList.get(counter).getRatingStars()==2){
                lvlXY.setBackground(getDrawable(R.drawable.sieges_banner_zwei_sterne));
            }
            if(questionList.get(counter).getRatingStars()==1){
                lvlXY.setBackground(getDrawable(R.drawable.sieges_banner_ein_stern));
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonlvl78:
                Intent intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl79:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl80:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl81:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl82:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl83:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl84:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl85:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl86:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl87:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl88:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;


        }
    }


}