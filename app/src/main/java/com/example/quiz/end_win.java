package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class end_win extends AppCompatActivity implements View.OnClickListener{
    private QuizDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_win);

        QuizDBHelper db = new QuizDBHelper(this);

        db.getAllQuestions();
        Button btnWmainMenu = (Button) findViewById(R.id.mainMenu);
        btnWmainMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mainMenu:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }


    }
}
