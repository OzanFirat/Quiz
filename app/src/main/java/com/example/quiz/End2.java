package com.example.quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
    private TextView txtScore, textViewLostCount;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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

        int currentAmountF = questionList.get(doneCounter).getAmountOfFailures();
        currentAmountF=3-currentAmountF;
        this.textViewLostCount = (TextView) findViewById(R.id.textViewLostCount);

        textViewLostCount.setText(currentAmountF+" tries left until failure");

        this.btnStartMenu = (Button) findViewById(R.id.btnlvlOverview2);
        btnStartMenu.setOnClickListener(this);

        this.btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
        this.btnTryAgain.setOnClickListener(this);

        this.txtScore = (TextView) findViewById(R.id.txtScore);



        setBanner(doneCounter);





    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setBanner(int doneCounter) {
        if(doneCounter<=10){
            txtScore.setBackground(getDrawable(R.drawable.banner4));
        }
        if(doneCounter>10&&doneCounter<=21){
            txtScore.setBackground(getDrawable(R.drawable.banner1));
        }
        if(doneCounter>21&&doneCounter<=32){
            txtScore.setBackground(getDrawable(R.drawable.banner7));
        }
        if(doneCounter>32&&doneCounter<=43){
            txtScore.setBackground(getDrawable(R.drawable.banner5));
        }
        if(doneCounter>43&&doneCounter<=54){
            txtScore.setBackground(getDrawable(R.drawable.banner3));
        }
        if(doneCounter>54&&doneCounter<=65){
            txtScore.setBackground(getDrawable(R.drawable.banner2));
        }
        if(doneCounter>65&&doneCounter<=76){
            txtScore.setBackground(getDrawable(R.drawable.banner6));
        }

        if(doneCounter>76&&doneCounter<=87){
            txtScore.setBackground(getDrawable(R.drawable.banner8));
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
