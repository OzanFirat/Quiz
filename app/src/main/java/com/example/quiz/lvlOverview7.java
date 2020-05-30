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

public class lvlOverview7 extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String SHARED_PREFS = "keyHighscore";
    Button lvl67, lvl68, lvl69, lvl70, lvl71, lvl72, lvl73, lvl74, lvl75, lvl76, lvl77;
    private List<Question> questionList;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_overview7);
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



        lvl67 = (Button) findViewById(R.id.buttonlvl67);
        lvl67.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl67.setClickable(true);
            //lvl1.setBackgroundColor(@ColorInt);
            //  lvl1.setBackgroundColor(-65536);
            lvl67.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl67,doneCounter,counter);
        }
        counter++;
        // Toast.makeText(LvlOverview.this, "Second Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        lvl68= (Button) findViewById(R.id.buttonlvl68);
        lvl68.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl68.setClickable(true);
            //  lvl2.setBackgroundColor(-65536);
            lvl68.setBackground(getDrawable(R.drawable.sparta_helm));
        }  else {
            levelIsDone(lvl68,doneCounter,counter);
        }
        counter++;

        lvl69 = (Button) findViewById(R.id.buttonlvl69);
        lvl69.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl69.setClickable(true);
            lvl69.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl69,doneCounter,counter);
        }
        counter++;

        lvl70 = (Button) findViewById(R.id.buttonlvl70);
        lvl70.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl70.setClickable(true);
            lvl70.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl70,doneCounter,counter);
        }
        counter++;

        lvl71 = (Button) findViewById(R.id.buttonlvl71);
        lvl71.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl71.setClickable(true);
            lvl71.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl71,doneCounter,counter);
        }
        counter++;

        lvl72 = (Button) findViewById(R.id.buttonlvl72);
        lvl72.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl72.setClickable(true);
            //lvl6.setBackgroundColor(-65536);
            lvl72.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl72,doneCounter,counter);
        }
        counter++;

        lvl73 = (Button) findViewById(R.id.buttonlvl73);
        lvl73.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl73.setClickable(true);
            lvl73.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl73,doneCounter,counter);
        }
        counter++;

        lvl74 = (Button) findViewById(R.id.buttonlvl74);
        lvl74.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl74.setClickable(true);
            lvl74.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            levelIsDone(lvl74,doneCounter,counter);
        }
        counter++;

        lvl75 = (Button) findViewById(R.id.buttonlvl75);
        lvl75.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl75.setClickable(true);
            lvl75.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl75,doneCounter,counter);
        }
        counter++;

        lvl76 = (Button) findViewById(R.id.buttonlvl76);
        lvl76.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl76.setClickable(true);
            lvl76.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            levelIsDone(lvl76,doneCounter,counter);
        }
        counter++;

        lvl77 = (Button) findViewById(R.id.buttonlvl77);
        lvl77.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()) {
            lvl77.setClickable(true);
            lvl77.setBackground(getDrawable(R.drawable.sparta_helm));
        }  else {
            levelIsDone(lvl77,doneCounter,counter);
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
            case R.id.buttonlvl67:
                Intent intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl68:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl69:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl70:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl71:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl72:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl73:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl74:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl75:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl76:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl77:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;






        }


    }
}
