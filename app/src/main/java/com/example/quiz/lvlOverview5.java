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

public class lvlOverview5 extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String SHARED_PREFS = "keyHighscore";
    Button lvl45, lvl46, lvl47, lvl55, lvl48, lvl49, lvl50, lvl51, lvl52, lvl53, lvl54;
    private List<Question> questionList;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_overview5);
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

        counter=11;

        //  Toast.makeText(LvlOverview.this, "Data updated"+doneCounter, Toast.LENGTH_LONG).show();



        lvl45 = (Button) findViewById(R.id.buttonlvl45);
        lvl45.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl45.setClickable(true);
            //lvl1.setBackgroundColor(@ColorInt);
            //  lvl1.setBackgroundColor(-65536);
            lvl45.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl45,doneCounter,counter);
        }
        counter++;
        // Toast.makeText(LvlOverview.this, "Second Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        lvl46 = (Button) findViewById(R.id.buttonlvl46);
        lvl46.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl46.setClickable(true);
            //  lvl2.setBackgroundColor(-65536);
            lvl46.setBackground(getDrawable(R.drawable.sparta_helm));
        }  else {
            levelIsDone(lvl46,doneCounter,counter);
        }
        counter++;

        lvl47 = (Button) findViewById(R.id.buttonlvl47);
        lvl47.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl47.setClickable(true);
            lvl47.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl47,doneCounter,counter);
        }
        counter++;

        lvl48 = (Button) findViewById(R.id.buttonlvl48);
        lvl48.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl48.setClickable(true);
            lvl48.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl48,doneCounter,counter);
        }
        counter++;

        lvl49 = (Button) findViewById(R.id.buttonlvl49);
        lvl49.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl49.setClickable(true);
            lvl49.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl49,doneCounter,counter);
        }
        counter++;

        lvl50 = (Button) findViewById(R.id.buttonlvl50);
        lvl50.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl50.setClickable(true);
            //lvl6.setBackgroundColor(-65536);
            lvl50.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl50,doneCounter,counter);
        }
        counter++;

        lvl51 = (Button) findViewById(R.id.buttonlvl51);
        lvl51.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl51.setClickable(true);
            lvl51.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl51,doneCounter,counter);
        }
        counter++;

        lvl52 = (Button) findViewById(R.id.buttonlvl52);
        lvl52.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl52.setClickable(true);
            lvl52.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl52,doneCounter,counter);
        }
        counter++;

        lvl53 = (Button) findViewById(R.id.buttonlvl53);
        lvl53.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl53.setClickable(true);
            lvl53.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl53,doneCounter,counter);
        }
        counter++;

        lvl54 = (Button) findViewById(R.id.buttonlvl54);
        lvl54.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl54.setClickable(true);
            lvl54.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl54,doneCounter,counter);
        }
        counter++;

        lvl55 = (Button) findViewById(R.id.buttonlvl55);
        lvl55.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()) {
            lvl55.setClickable(true);
            lvl55.setBackground(getDrawable(R.drawable.sparta_helm));
        }  else {
            levelIsDone(lvl55,doneCounter,counter);
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
            case R.id.buttonlvl45:
                Intent intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl46:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl47:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl48:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl49:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl50:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl51:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl52:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl53:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl54:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl55:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;






        }


    }
}
