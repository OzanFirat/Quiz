package com.example.quiz;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class End extends Activity implements View.OnClickListener{

    private Button btnStartMenu, btnNextLvl;
    private RatingBar rtBar;
    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    private int erreichtePunkte;
    private final String KEY = "speicherPreferences";
    private QuizDBHelper dbHelper;
    private List<Question> questionList;
    private int level;

    private TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ende);

       this.btnStartMenu = (Button) findViewById(R.id.btnmainMenu);
       btnStartMenu.setOnClickListener(this);

       this.rtBar = (RatingBar) findViewById(R.id.ratingBar);


        dbHelper = new QuizDBHelper(this);
        questionList = dbHelper.getAllQuestions();

        level=1;
        this.test = (TextView) findViewById(R.id.test);
       // test.setText(questionList.get(level).getRatingStars());
        test.setText(questionList.get(level).getRatingStars()+" "+questionList.get(level).getQuestion());

       // rtBar.setRating(questionList.get(level).getRatingStars());
        rtBar.setNumStars(3);
        float num = questionList.get(level).getRatingStars();
        rtBar.setRating(num);




       // this.preferences = this.getSharedPreferences("highscore", MODE_PRIVATE);
      //  preferencesEditor = preferences.edit();

       // Bundle extras = getIntent().getExtras();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.btnmainMenu:
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
            break;
    }
}
}
