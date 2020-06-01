package com.example.quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quiz.R.drawable;

import java.util.List;

import static com.example.quiz.R.drawable.*;

public class gameOverview extends AppCompatActivity implements View.OnClickListener{

    Button topic1, topic2, topic3, topic4, topic5, topic6, topic7, topic8, buttonHelp;
    private int counter, doneCounter, questionCountTotal;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_uebersicht);

        this.buttonHelp =(Button) findViewById(R.id.buttonHelp);
        buttonHelp.setClickable(true);
        buttonHelp.setOnClickListener(this);

        topic1= (Button) findViewById(R.id.btnTopic1);
        topic2= (Button) findViewById(R.id.btnTopic2);
        topic3= (Button) findViewById(R.id.btnTopic3);
        topic4= (Button) findViewById(R.id.btnTopic4);
        topic5= (Button) findViewById(R.id.btnTopic5);
        topic6= (Button) findViewById(R.id.btnTopic6);
        topic7= (Button) findViewById(R.id.btnTopic7);
        topic8= (Button) findViewById(R.id.btnTopic8);

        topic1.setOnClickListener(this);
        topic2.setOnClickListener(this);
        topic3.setOnClickListener(this);
        topic4.setOnClickListener(this);
        topic5.setOnClickListener(this);
        topic6.setOnClickListener(this);
        topic7.setOnClickListener(this);
        topic8.setOnClickListener(this);

        QuizDBHelper dbHelper = new QuizDBHelper(this);
        List<Question> questionList = dbHelper.getAllQuestions();
        questionCountTotal=questionList.size();

        topic1.setClickable(false);
        topic2.setClickable(false);
        topic3.setClickable(false);
        topic4.setClickable(false);
        topic5.setClickable(false);
        topic6.setClickable(false);
        topic7.setClickable(false);
        topic8.setClickable(false);

        while (counter<questionCountTotal){

            if(questionList.get(counter).getLvlDone().equalsIgnoreCase("yes")){

                doneCounter++;

            }
            counter++;

        }

        if(doneCounter<11){

            topic1.setClickable(true);



            topic2.setAlpha((float) 0.5);
            topic3.setAlpha((float) 0.5);
            topic4.setAlpha((float) 0.5);
            topic5.setAlpha((float) 0.5);
            topic6.setAlpha((float) 0.5);
            topic7.setAlpha((float) 0.5);
            topic8.setAlpha((float) 0.5);




        }
        if(doneCounter>=11 && doneCounter<=22){
            topic1.setText("Erobert");
            //topic1.setForeground(done);
            topic1.setBackground(getDrawable(banner4_done));

            topic2.setClickable(true);

            topic3.setAlpha((float) 0.5);
            topic4.setAlpha((float) 0.5);
            topic5.setAlpha((float) 0.5);
            topic6.setAlpha((float) 0.5);
            topic7.setAlpha((float) 0.5);
            topic8.setAlpha((float) 0.5);

        }
        if(doneCounter>22 && doneCounter<=33){

            topic1.setBackground(getDrawable(banner4_done));
            topic2.setBackground(getDrawable(banner2_done));

            topic3.setClickable(true);

            topic4.setAlpha((float) 0.5);
            topic5.setAlpha((float) 0.5);
            topic6.setAlpha((float) 0.5);
            topic7.setAlpha((float) 0.5);
            topic8.setAlpha((float) 0.5);

        }
        if(doneCounter>33 && doneCounter<=44){
            topic1.setText("Erobert!");
            topic2.setText("Erobert!");
            topic3.setText("Erobert!");

            topic1.setBackground(getDrawable(banner4_done));
            topic2.setBackground(getDrawable(banner1_done));
            topic3.setBackground(getDrawable(banner7_done));

            topic4.setClickable(true);

            topic5.setAlpha((float) 0.5);
            topic6.setAlpha((float) 0.5);
            topic7.setAlpha((float) 0.5);
            topic8.setAlpha((float) 0.5);
        }
        if(doneCounter>44 && doneCounter<=55){
            topic1.setText("Erobert!");
            topic2.setText("Erobert!");
            topic3.setText("Erobert!");
            topic4.setText("Erobert!");

            topic1.setBackground(getDrawable(banner4_done));
            topic2.setBackground(getDrawable(banner1_done));
            topic3.setBackground(getDrawable(banner7_done));
            topic4.setBackground(getDrawable(banner5_done));

            topic5.setClickable(true);

            topic6.setAlpha((float) 0.5);
            topic7.setAlpha((float) 0.5);
            topic8.setAlpha((float) 0.5);
        }

        if(doneCounter>55 && doneCounter<=66){
            topic1.setText("Erobert!");
            topic2.setText("Erobert!");
            topic3.setText("Erobert!");
            topic4.setText("Erobert!");
            topic5.setText("Erobert!");

            topic1.setBackground(getDrawable(banner4_done));
            topic2.setBackground(getDrawable(banner1_done));
            topic3.setBackground(getDrawable(banner7_done));
            topic4.setBackground(getDrawable(banner5_done));
            topic5.setBackground(getDrawable(banner3_done));


            topic6.setClickable(true);

            topic7.setAlpha((float) 0.5);
            topic8.setAlpha((float) 0.5);
        }

        if(doneCounter>66 && doneCounter<=77){
            topic1.setText("Erobert!");
            topic2.setText("Erobert!");
            topic3.setText("Erobert!");
            topic4.setText("Erobert!");
            topic5.setText("Erobert!");
            topic6.setText("Erobert!");

            topic1.setBackground(getDrawable(banner4_done));
            topic2.setBackground(getDrawable(banner1_done));
            topic3.setBackground(getDrawable(banner7_done));
            topic4.setBackground(getDrawable(banner5_done));
            topic5.setBackground(getDrawable(banner3_done));
            topic6.setBackground(getDrawable(banner2_done));

            topic7.setClickable(true);
            topic8.setAlpha((float) 0.5);
        }

        if(doneCounter>77 && doneCounter<=88){
            topic1.setText("Erobert!");
            topic2.setText("Erobert!");
            topic3.setText("Erobert!");
            topic4.setText("Erobert!");
            topic5.setText("Erobert!");
            topic6.setText("Erobert!");
            topic7.setText("Erobert!");

            topic1.setBackground(getDrawable(banner4_done));
            topic2.setBackground(getDrawable(banner1_done));
            topic3.setBackground(getDrawable(banner7_done));
            topic4.setBackground(getDrawable(banner5_done));
            topic5.setBackground(getDrawable(banner3_done));
            topic6.setBackground(getDrawable(banner2_done));
            topic7.setBackground(getDrawable(banner6_done));


            topic8.setClickable(true);

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
                Intent intent = new Intent(this, lvlOverview2.class);
                startActivity(intent);
                this.finish();
                break;
        }

        switch (v.getId()){
            case R.id.btnTopic3:
                Intent intent = new Intent(this, lvlOverview3.class);
                startActivity(intent);
                this.finish();
                break;
        }

        switch (v.getId()){
            case R.id.btnTopic4:
                Intent intent = new Intent(this, lvlOverview4.class);
                startActivity(intent);
                this.finish();
                break;
        }

        switch (v.getId()){
            case R.id.btnTopic5:
                Intent intent = new Intent(this, lvlOverview5.class);
                startActivity(intent);
                this.finish();
                break;
        }
        switch (v.getId()){
            case R.id.btnTopic6:
                Intent intent = new Intent(this, lvlOverview6.class);
                startActivity(intent);
                this.finish();
                break;
        }
        switch (v.getId()){
            case R.id.btnTopic7:
                Intent intent = new Intent(this, lvlOverview7.class);
                startActivity(intent);
                this.finish();
                break;
        }
        switch (v.getId()){
            case R.id.btnTopic8:
                Intent intent = new Intent(this, lvlOverview8.class);
                startActivity(intent);
                this.finish();
                break;
        }
        switch (v.getId()){
            case R.id.buttonHelp:
                Intent intent = new Intent(this, Hilfemenue.class);
                startActivity(intent);
                this.finish();
                break;
        }

    }
}
