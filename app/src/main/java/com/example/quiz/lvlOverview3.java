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

public class lvlOverview3 extends AppCompatActivity implements View.OnClickListener{



        private static final int REQUEST_CODE_QUIZ = 1;

        public static final String SHARED_PREFS = "sharedPrefs";
        //public static final String SHARED_PREFS = "keyHighscore";
        Button lvl23, lvl24, lvl25, lvl26, lvl27, lvl28, lvl29, lvl30, lvl31, lvl32, lvl33;
    private  List<Question> questionList;



        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lvl_overview3);
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

            counter=22;

            //  Toast.makeText(LvlOverview.this, "Data updated"+doneCounter, Toast.LENGTH_LONG).show();



            lvl23 = (Button) findViewById(R.id.buttonlvl23);
            lvl23.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl23.setClickable(true);
                lvl23.setBackground(getDrawable(R.drawable.sparta_helm));
            } else {
                levelIsDone(lvl23,doneCounter,counter);
            }
            counter++;
            // Toast.makeText(LvlOverview.this, "Second Data updated"+doneCounter, Toast.LENGTH_LONG).show();
            lvl24 = (Button) findViewById(R.id.buttonlvl24);
            lvl24.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl24.setClickable(true);
                //  lvl2.setBackgroundColor(-65536);
                lvl24.setBackground(getDrawable(R.drawable.sparta_helm));
            }  else {
                levelIsDone(lvl24,doneCounter,counter);
            }
            counter++;

            lvl25 = (Button) findViewById(R.id.buttonlvl25);
            lvl25.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl25.setClickable(true);
                lvl25.setBackground(getDrawable(R.drawable.sparta_helm));
            } else {
                levelIsDone(lvl25,doneCounter,counter);
            }
            counter++;

            lvl26 = (Button) findViewById(R.id.buttonlvl26);
            lvl26.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl26.setClickable(true);
                lvl26.setBackground(getDrawable(R.drawable.sparta_helm));
            } else {
                levelIsDone(lvl26,doneCounter,counter);
            }
            counter++;

            lvl27 = (Button) findViewById(R.id.buttonlvl27);
            lvl27.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl27.setClickable(true);
                lvl27.setBackground(getDrawable(R.drawable.sparta_helm));
            } else {
                levelIsDone(lvl27,doneCounter,counter);
            }
            counter++;

            lvl28 = (Button) findViewById(R.id.buttonlvl28);
            lvl28.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl28.setClickable(true);
                //lvl6.setBackgroundColor(-65536);
                lvl28.setBackground(getDrawable(R.drawable.sparta_helm));
            }else {
                levelIsDone(lvl28,doneCounter,counter);
            }
            counter++;

            lvl29 = (Button) findViewById(R.id.buttonlvl29);
            lvl29.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl29.setClickable(true);
                lvl29.setBackground(getDrawable(R.drawable.sparta_helm));
            }else {
                levelIsDone(lvl29,doneCounter,counter);
            }
            counter++;

            lvl30 = (Button) findViewById(R.id.buttonlvl30);
            lvl30.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl30.setClickable(true);
                lvl30.setBackground(getDrawable(R.drawable.sparta_helm));
            }else {
                levelIsDone(lvl30,doneCounter,counter);
            }
            counter++;

            lvl31 = (Button) findViewById(R.id.buttonlvl31);
            lvl31.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl31.setClickable(true);
                lvl31.setBackground(getDrawable(R.drawable.sparta_helm));
            } else {
                levelIsDone(lvl31,doneCounter,counter);
            }
            counter++;

            lvl32 = (Button) findViewById(R.id.buttonlvl32);
            lvl32.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl32.setClickable(true);
                lvl32.setBackground(getDrawable(R.drawable.sparta_helm));
            } else {
                levelIsDone(lvl32,doneCounter,counter);
            }
            counter++;

            lvl33 = (Button) findViewById(R.id.buttonlvl33);
            lvl33.setOnClickListener(this);
            if(doneCounter+1==questionList.get(counter).getLevelNr()){
                lvl33.setClickable(true);
                lvl33.setBackground(getDrawable(R.drawable.sparta_helm));
            } else {
                levelIsDone(lvl33,doneCounter,counter);
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
                case R.id.buttonlvl23:
                    Intent intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl24:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl25:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl26:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl27:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl28:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl29:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl30:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl31:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl32:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;

                case R.id.buttonlvl33:
                    intent = new Intent(this, Spiel.class);
                    startActivity(intent);
                    this.finish();
                    break;






            }


        }
    }


