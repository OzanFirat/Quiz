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

public class lvlOverview6 extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String SHARED_PREFS = "keyHighscore";
    Button lvl21, lvl22, lvl12, lvl13, lvl14, lvl15, lvl16, lvl17, lvl18, lvl19, lvl20;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_overview3);
        QuizDBHelper dbHelper = new QuizDBHelper(this);
        List<Question> questionList = dbHelper.getAllQuestions();

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



        lvl12 = (Button) findViewById(R.id.buttonlvl12);
        lvl12.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl12.setClickable(true);
            //lvl1.setBackgroundColor(@ColorInt);
            //  lvl1.setBackgroundColor(-65536);
            lvl12.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            lvl12.setClickable(false);
            if(questionList.get(counter).getLevelNr()<=doneCounter){
                if(questionList.get(counter).getRatingStars()==3){
                    lvl12.setBackground(getDrawable(R.drawable.sieges_banner_drei_sterne));
                    lvl12.setText("");
                }
                if(questionList.get(counter).getRatingStars()==2){
                    lvl12.setBackground(getDrawable(R.drawable.sieges_banner_zwei_sterne));
                    lvl12.setText("");
                }
                if(questionList.get(counter).getRatingStars()==1){
                    lvl12.setBackground(getDrawable(R.drawable.sieges_banner_ein_stern));
                    lvl12.setText("");
                }
            }
        }
        counter++;
        // Toast.makeText(LvlOverview.this, "Second Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        lvl13 = (Button) findViewById(R.id.buttonlvl13);
        lvl13.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl13.setClickable(true);
            //  lvl2.setBackgroundColor(-65536);
            lvl13.setBackground(getDrawable(R.drawable.sparta_helm));
        }  else {
            lvl13.setClickable(false);
            if(questionList.get(counter).getLevelNr()<=doneCounter){
                if(questionList.get(counter).getRatingStars()==3){
                    lvl13.setBackground(getDrawable(R.drawable.sieges_banner_drei_sterne));
                }
                if(questionList.get(counter).getRatingStars()==2){
                    lvl13.setBackground(getDrawable(R.drawable.sieges_banner_zwei_sterne));
                }
                if(questionList.get(counter).getRatingStars()==1){
                    lvl13.setBackground(getDrawable(R.drawable.sieges_banner_ein_stern));
                }
            }
        }
        counter++;

        lvl14 = (Button) findViewById(R.id.buttonlvl14);
        lvl14.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl14.setClickable(true);
            lvl14.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            lvl14.setClickable(false);
            if(questionList.get(counter).getLevelNr()<=doneCounter){
                if(questionList.get(counter).getRatingStars()==3){
                    lvl14.setBackground(getDrawable(R.drawable.sieges_banner_drei_sterne));
                }
                if(questionList.get(counter).getRatingStars()==2){
                    lvl14.setBackground(getDrawable(R.drawable.sieges_banner_zwei_sterne));
                }
                if(questionList.get(counter).getRatingStars()==1){
                    lvl14.setBackground(getDrawable(R.drawable.sieges_banner_ein_stern));
                }
            }
        }
        counter++;

        lvl15 = (Button) findViewById(R.id.buttonlvl15);
        lvl15.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl15.setClickable(true);
            lvl15.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            lvl15.setClickable(false);
        }
        counter++;

        lvl16 = (Button) findViewById(R.id.buttonlvl16);
        lvl16.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl16.setClickable(true);
            lvl16.setBackground(getDrawable(R.drawable.sparta_helm));
        } else {
            lvl16.setClickable(false);
        }
        counter++;

        lvl17 = (Button) findViewById(R.id.buttonlvl17);
        lvl17.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl17.setClickable(true);
            //lvl6.setBackgroundColor(-65536);
            lvl17.setBackground(getDrawable(R.drawable.sparta_helm));
        }else {
            lvl17.setClickable(false);
        }
        counter++;

        lvl18 = (Button) findViewById(R.id.buttonlvl18);
        lvl18.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl18.setClickable(true);
            lvl18.setBackgroundColor(-65536);
        }else {
            lvl18.setClickable(false);
        }
        counter++;

        lvl19 = (Button) findViewById(R.id.buttonlvl19);
        lvl19.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl19.setClickable(true);
            lvl19.setBackgroundColor(-65536);
        }else {
            lvl19.setClickable(false);
        }
        counter++;

        lvl20 = (Button) findViewById(R.id.buttonlvl20);
        lvl20.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl20.setClickable(true);
            lvl20.setBackgroundColor(-65536);
        } else {
            lvl20.setClickable(false);
        }
        counter++;

        lvl21 = (Button) findViewById(R.id.buttonlvl21);
        lvl21.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl21.setClickable(true);
            lvl21.setBackgroundColor(-65536);
        } else {
            lvl21.setClickable(false);
        }
        counter++;

        lvl22 = (Button) findViewById(R.id.buttonlvl22);
        lvl22.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl22.setClickable(true);
            lvl22.setBackgroundColor(-65536);
        } else {
            lvl22.setClickable(false);
        }
        counter++;














    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonlvl12:
                Intent intent = new Intent(this, Spiel.class);
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

            case R.id.buttonlvl21:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.buttonlvl22:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;






        }


    }
}
