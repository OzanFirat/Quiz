package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class End2 extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartMenu, btnTryAgain;
    private RatingBar rtBar;
    private TextView txtScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end2);

        QuizDBHelper db = new QuizDBHelper(this);
       List<Question>questionList= db.getAllQuestions();

        int counter = 0, doneCounter = 0;
        while (counter < questionList.size()) {

            if (questionList.get(counter).getLvlDone().equalsIgnoreCase("yes")) {

                doneCounter++;

            }

            counter++;  }

        this.btnStartMenu = (Button) findViewById(R.id.btnlvlOverview2);
        btnStartMenu.setOnClickListener(this);

        this.btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
        this.btnTryAgain.setOnClickListener(this);

        this.txtScore = (TextView) findViewById(R.id.txtScore);
        txtScore.setText("Das ist deine "+questionList.get(doneCounter).getAmountOfFailures()+""+" Niederlage: \nNoch "
                +(3-questionList.get(doneCounter).getAmountOfFailures())+"");

        setBanner(doneCounter);





    }

    private void setBanner(int doneCounter) {
        if(doneCounter<=11){

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnlvlOverview2:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.btnTryAgain:
                intent = new Intent(this, Spiel.class);
                startActivity(intent);
                this.finish();
                break;
        }


    }
}
