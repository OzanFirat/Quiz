package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnNewQuiz, btnContinueQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewQuiz = (Button) findViewById(R.id.btnNewQuiz);
        btnNewQuiz.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNewQuiz:

                QuizDBHelper dbHelper = new QuizDBHelper(this);
                dbHelper.alterTable();
                dbHelper = new QuizDBHelper(this);
                List<Question> questionList = dbHelper.getAllQuestions();
                Intent intent = new Intent(this, gameOverview.class);
                startActivity(intent);
                this.finish();

                break;




        }
    }
}
