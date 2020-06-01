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

public class lvlOverview6 extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String SHARED_PREFS = "keyHighscore";
    Button lvl58, lvl56, lvl57, lvl59, lvl60, lvl61, lvl62, lvl63, lvl64, lvl65, lvl66;
    private List<Question> questionList;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_overview6);
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

        counter=55;

        //  Toast.makeText(LvlOverview.this, "Data updated"+doneCounter, Toast.LENGTH_LONG).show();



        lvl56 = (Button) findViewById(R.id.buttonlvl56);
        lvl56.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl56.setClickable(true);
            //lvl1.setBackgroundColor(@ColorInt);
            //  lvl1.setBackgroundColor(-65536);
            lvl56.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl56,doneCounter,counter);
        }
        counter++;
        // Toast.makeText(LvlOverview.this, "Second Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        lvl57 = (Button) findViewById(R.id.buttonlvl57);
        lvl57.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl57.setClickable(true);
            //  lvl2.setBackgroundColor(-65536);
            lvl57.setBackground(getDrawable(R.drawable.sparta_helm));
        }  else {
            levelIsDone(lvl57,doneCounter,counter);
        }
        counter++;

        lvl58 = (Button) findViewById(R.id.buttonlvl58);
        lvl58.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl58.setClickable(true);
            lvl58.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl58,doneCounter,counter);
        }
        counter++;

        lvl59 = (Button) findViewById(R.id.buttonlvl59);
        lvl59.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl59.setClickable(true);
            lvl59.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl59,doneCounter,counter);
        }
        counter++;

        lvl60 = (Button) findViewById(R.id.buttonlvl60);
        lvl60.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl60.setClickable(true);
            lvl60.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl60,doneCounter,counter);
        }
        counter++;

        lvl61 = (Button) findViewById(R.id.buttonlvl61);
        lvl61.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl61.setClickable(true);
            //lvl6.setBackgroundColor(-65536);
            lvl61.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl61,doneCounter,counter);
        }
        counter++;

        lvl62 = (Button) findViewById(R.id.buttonlvl62);
        lvl62.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl62.setClickable(true);
            lvl62.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl62,doneCounter,counter);
        }
        counter++;

        lvl63 = (Button) findViewById(R.id.buttonlvl63);
        lvl63.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl63.setClickable(true);
            lvl63.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl63,doneCounter,counter);
        }
        counter++;

        lvl64 = (Button) findViewById(R.id.buttonlvl64);
        lvl64.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl64.setClickable(true);
            lvl64.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl64,doneCounter,counter);
        }
        counter++;

        lvl65 = (Button) findViewById(R.id.buttonlvl65);
        lvl65.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl65.setClickable(true);
            lvl65.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl65,doneCounter,counter);
        }
        counter++;

        lvl66 = (Button) findViewById(R.id.buttonlvl66);
        lvl66.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()) {
            lvl66.setClickable(true);
            lvl66.setBackground(getDrawable(R.drawable.sparta_helm));
        }  else {
            levelIsDone(lvl66,doneCounter,counter);
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
            case R.id.buttonlvl56:
                Intent intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl57:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl58:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl59:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl60:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl61:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl62:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl63:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl64:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl65:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl66:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;






        }


    }
}
