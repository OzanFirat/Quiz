package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class gameOverview extends AppCompatActivity implements View.OnClickListener{

    Button topic1, topic2, topic3, topic4;
    private int counter, doneCounter, questionCountTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_uebersicht);

        topic1= (Button) findViewById(R.id.btnTopic1);
        topic2= (Button) findViewById(R.id.btnTopic2);
        topic3= (Button) findViewById(R.id.btnTopic3);
        topic4= (Button) findViewById(R.id.btnTopic4);

        topic1.setOnClickListener(this);
        topic2.setOnClickListener(this);
        topic3.setOnClickListener(this);
        topic4.setOnClickListener(this);

        QuizDBHelper dbHelper = new QuizDBHelper(this);
        List<Question> questionList = dbHelper.getAllQuestions();

        topic1.setClickable(false);
        topic2.setClickable(false);
        topic3.setClickable(false);
        topic4.setClickable(false);

        while (counter<questionCountTotal){

            if(questionList.get(counter).getLvlDone().equalsIgnoreCase("yes")){

                doneCounter++;

            }
            counter++;

        }

        if(doneCounter<=20){
            counter=0;
            topic1.setClickable(true);


        }
        if(doneCounter>20 && doneCounter<=40){
            counter=20;
            topic2.setClickable(true);
        }
        if(doneCounter>40 && doneCounter<=60){
            counter=40;
            topic3.setClickable(true);
        }
        if(doneCounter>60 && doneCounter<=80){
            counter=60;
            topic4.setClickable(true);
        }
        if(doneCounter>80 && doneCounter<=100){
            counter=80;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTopic1:
                Intent intent = new Intent(this, LvlOverview.class);
                startActivity(intent);
                this.finish();
                break;
        }

        switch (v.getId()){
            case R.id.btnTopic2:
                Intent intent = new Intent(this, LvlOverview.class);
                startActivity(intent);
                this.finish();
                break;
        }

        switch (v.getId()){
            case R.id.btnTopic3:
                Intent intent = new Intent(this, LvlOverview.class);
                startActivity(intent);
                this.finish();
                break;
        }

        switch (v.getId()){
            case R.id.btnTopic4:
                Intent intent = new Intent(this, LvlOverview.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }
}
