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

public class lvlOverview4 extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String SHARED_PREFS = "keyHighscore";
    Button lvl34, lvl35, lvl36, lvl37, lvl38, lvl39, lvl40, lvl41, lvl42, lvl43, lvl44;
    private  List<Question> questionList;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_overview4);
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

        counter=33;

        //  Toast.makeText(LvlOverview.this, "Data updated"+doneCounter, Toast.LENGTH_LONG).show();



        lvl34 = (Button) findViewById(R.id.buttonlvl34);
        lvl34.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl34.setClickable(true);
            //lvl1.setBackgroundColor(@ColorInt);
            //  lvl1.setBackgroundColor(-65536);
            lvl34.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl34,doneCounter,counter);
        }
        counter++;
        // Toast.makeText(LvlOverview.this, "Second Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        lvl35 = (Button) findViewById(R.id.buttonlvl35);
        lvl35.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl35.setClickable(true);
            //  lvl2.setBackgroundColor(-65536);
            lvl35.setBackground(getDrawable(R.drawable.sparta_helm));
        }  else {
            levelIsDone(lvl35,doneCounter,counter);
        }
        counter++;

        lvl36 = (Button) findViewById(R.id.buttonlvl36);
        lvl36.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl36.setClickable(true);
            lvl36.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl36,doneCounter,counter);
        }
        counter++;

        lvl37 = (Button) findViewById(R.id.buttonlvl37);
        lvl37.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl37.setClickable(true);
            lvl37.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl37,doneCounter,counter);
        }
        counter++;

        lvl38 = (Button) findViewById(R.id.buttonlvl38);
        lvl38.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl38.setClickable(true);
            lvl38.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl38,doneCounter,counter);
        }
        counter++;

        lvl39 = (Button) findViewById(R.id.buttonlvl39);
        lvl39.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl39.setClickable(true);
            //lvl6.setBackgroundColor(-65536);
            lvl39.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl39,doneCounter,counter);
        }
        counter++;

        lvl40 = (Button) findViewById(R.id.buttonlvl40);
        lvl40.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl40.setClickable(true);
            lvl40.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl40,doneCounter,counter);
        }
        counter++;

        lvl41 = (Button) findViewById(R.id.buttonlvl41);
        lvl41.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl41.setClickable(true);
            lvl41.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl41,doneCounter,counter);
        }
        counter++;

        lvl42 = (Button) findViewById(R.id.buttonlvl42);
        lvl42.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl42.setClickable(true);
            lvl42.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl42,doneCounter,counter);
        }
        counter++;

        lvl43 = (Button) findViewById(R.id.buttonlvl43);
        lvl43.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl43.setClickable(true);
            lvl43.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl43,doneCounter,counter);
        }
        counter++;

        lvl44 = (Button) findViewById(R.id.buttonlvl44);
        lvl44.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()) {
            lvl44.setClickable(true);
            lvl44.setBackground(getDrawable(R.drawable.sparta_helm));
        }  else {
                levelIsDone(lvl44,doneCounter,counter);
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
        switch (v.getId()){
            case R.id.buttonlvl34:
                Intent intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl35:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl36:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl37:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl38:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl39:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl40:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl41:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl42:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl43:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl44:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;






        }


    }
}
