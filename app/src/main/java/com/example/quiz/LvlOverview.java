package com.example.quiz;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.quiz.R.*;

public class LvlOverview extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String SHARED_PREFS = "keyHighscore";
    Button lvl1, lvl2, lvl3, lvl4, lvl5, lvl6, lvl7, lvl8, lvl9, lvl10, lvl11, lvl12, lvl13, lvl14, lvl15, lvl16, lvl17, lvl18, lvl19, lvl20;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        QuizDBHelper dbHelper = new QuizDBHelper(this);
        List<Question> questionList = dbHelper.getAllQuestions();
        //Toast.makeText(LvlOverview.this, "Data updated"+questionList.get(0).getLvlDone(), Toast.LENGTH_LONG).show();
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
        if(doneCounter>20 && doneCounter<=40){
            counter=20;
        }
        if(doneCounter>40 && doneCounter<=60){
            counter=40;
        }
        if(doneCounter>60 && doneCounter<=80){
            counter=60;
        }
        if(doneCounter>80 && doneCounter<=100){
            counter=80;
        }

      //  Toast.makeText(LvlOverview.this, "Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_lvl_overview);


        lvl1 = (Button) findViewById(id.buttonlvl1);
        lvl1.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl1.setClickable(true);
            //lvl1.setBackgroundColor(@ColorInt);
          //  lvl1.setBackgroundColor(-65536);
            lvl1.setBackground(getDrawable(drawable.sparta_helm));
        } else {
            lvl1.setClickable(false);
            if(questionList.get(counter).getLevelNr()<=doneCounter){
                if(questionList.get(counter).getRatingStars()==3){
                    lvl1.setBackground(getDrawable(drawable.sieges_banner_drei_sterne));
                    lvl1.setText("");
                }
                if(questionList.get(counter).getRatingStars()==2){
                    lvl1.setBackground(getDrawable(drawable.sieges_banner_zwei_sterne));
                    lvl1.setText("");
                }
                if(questionList.get(counter).getRatingStars()==1){
                    lvl1.setBackground(getDrawable(drawable.sieges_banner_ein_stern));
                    lvl1.setText("");
                }
            }
        }
        counter++;
       // Toast.makeText(LvlOverview.this, "Second Data updated"+doneCounter, Toast.LENGTH_LONG).show();
        lvl2 = (Button) findViewById(id.buttonlvl2);
        lvl2.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl2.setClickable(true);
          //  lvl2.setBackgroundColor(-65536);
            lvl2.setBackground(getDrawable(drawable.sparta_helm));
        }  else {
        lvl2.setClickable(false);
            if(questionList.get(counter).getLevelNr()<=doneCounter){
                if(questionList.get(counter).getRatingStars()==3){
                    lvl2.setBackground(getDrawable(drawable.sieges_banner_drei_sterne));
                }
                if(questionList.get(counter).getRatingStars()==2){
                    lvl2.setBackground(getDrawable(drawable.sieges_banner_zwei_sterne));
                }
                if(questionList.get(counter).getRatingStars()==1){
                    lvl2.setBackground(getDrawable(drawable.sieges_banner_ein_stern));
                }
            }
    }
        counter++;

        lvl3 = (Button) findViewById(id.buttonlvl3);
        lvl3.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl3.setClickable(true);
            lvl3.setBackground(getDrawable(drawable.sparta_helm));
        } else {
            lvl3.setClickable(false);
            if(questionList.get(counter).getLevelNr()<=doneCounter){
                if(questionList.get(counter).getRatingStars()==3){
                    lvl3.setBackground(getDrawable(drawable.sieges_banner_drei_sterne));
                }
                if(questionList.get(counter).getRatingStars()==2){
                    lvl3.setBackground(getDrawable(drawable.sieges_banner_zwei_sterne));
                }
                if(questionList.get(counter).getRatingStars()==1){
                    lvl3.setBackground(getDrawable(drawable.sieges_banner_ein_stern));
                }
            }
        }
        counter++;

        lvl4 = (Button) findViewById(id.buttonlvl4);
        lvl4.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl4.setClickable(true);
            lvl4.setBackground(getDrawable(drawable.sparta_helm));
        } else {
            lvl4.setClickable(false);
        }
        counter++;

        lvl5 = (Button) findViewById(id.buttonlvl5);
        lvl5.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl5.setClickable(true);
            lvl5.setBackground(getDrawable(drawable.sparta_helm));
        } else {
            lvl5.setClickable(false);
        }
        counter++;

        lvl6 = (Button) findViewById(id.buttonlvl6);
        lvl6.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl6.setClickable(true);
            //lvl6.setBackgroundColor(-65536);
            lvl6.setBackground(getDrawable(drawable.sparta_helm));
        }else {
            lvl6.setClickable(false);
        }
        counter++;

        lvl7 = (Button) findViewById(id.buttonlvl7);
        lvl7.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl7.setClickable(true);
            lvl7.setBackgroundColor(-65536);
        }else {
            lvl7.setClickable(false);
        }
        counter++;

        lvl8 = (Button) findViewById(id.buttonlvl8);
        lvl8.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl8.setClickable(true);
            lvl8.setBackgroundColor(-65536);
        }else {
            lvl8.setClickable(false);
        }
        counter++;

        lvl9 = (Button) findViewById(id.buttonlvl9);
        lvl9.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl9.setClickable(true);
            lvl9.setBackgroundColor(-65536);
        } else {
            lvl9.setClickable(false);
        }
        counter++;

        lvl10 = (Button) findViewById(id.buttonlvl10);
        lvl10.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl10.setClickable(true);
            lvl10.setBackgroundColor(-65536);
        } else {
            lvl10.setClickable(false);
        }
        counter++;

        /*lvl11 = (Button) findViewById(id.buttonlvl11);
        lvl11.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl11.setClickable(true);
            lvl11.setBackgroundColor(-65536);
        } else {
            lvl11.setClickable(false);
        }
        counter++;

        lvl12 = (Button) findViewById(id.buttonlvl12);
        lvl12.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl12.setClickable(true);
            lvl12.setBackgroundColor(-65536);
        } else {
            lvl12.setClickable(false);
        }
        counter++;

        lvl13 = (Button) findViewById(id.buttonlvl13);
        lvl13.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl13.setClickable(true);
            lvl13.setBackgroundColor(-65536);
        } else {
            lvl13.setClickable(false);
        }
        counter++;

        lvl14 = (Button) findViewById(id.buttonlvl14);
        lvl14.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl14.setClickable(true);
            lvl14.setBackgroundColor(-65536);
        } else {
            lvl14.setClickable(false);
        }
        counter++;

        lvl15 = (Button) findViewById(id.buttonlvl15);
        lvl15.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl15.setClickable(true);
            lvl15.setBackgroundColor(-65536);
        } else {
            lvl15.setClickable(false);
        }
        counter++;

        lvl16 = (Button) findViewById(id.buttonlvl16);
        lvl16.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl16.setClickable(true);
            lvl16.setBackgroundColor(-65536);
        } else {
            lvl16.setClickable(false);
        }
        counter++;

        lvl17 = (Button) findViewById(id.buttonlvl17);
        lvl17.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl17.setClickable(true);
            lvl17.setBackgroundColor(-65536);
        } else {
            lvl17.setClickable(false);
        }
        counter++;

        lvl18 = (Button) findViewById(id.buttonlvl18);
        lvl18.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl18.setClickable(true);
            lvl18.setBackgroundColor(-65536);
        } else {
            lvl18.setClickable(false);
        }
        counter++;

        lvl19 = (Button) findViewById(id.buttonlvl19);
        lvl19.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl19.setClickable(true);
            lvl19.setBackgroundColor(-65536);
        } else {
            lvl19.setClickable(false);
        }
        counter++;

        lvl20 = (Button) findViewById(id.buttonlvl20);
        lvl20.setOnClickListener(this);
        if(doneCounter+1==questionList.get(counter).getLevelNr()){
            lvl20.setClickable(true);
            lvl20.setBackgroundColor(-65536);
        } else {
            lvl20.setClickable(false);
        }
*/












    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case id.buttonlvl1:
                Intent intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl2:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl3:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl4:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl5:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl6:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl7:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl8:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl9:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl10:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            /*case id.buttonlvl11:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl12:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl13:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl14:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl15:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl16:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl17:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl18:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl19:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;

            case id.buttonlvl20:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;
*/


        }


    }
}
