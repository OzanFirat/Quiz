package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class end_win extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_win);
        QuizDBHelper dbHelper = new QuizDBHelper(this);
        dbHelper.onUpgrade(dbHelper.getDb(), dbHelper.getDatabaseVersion(), dbHelper.getDatabaseVersion()+1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnmainMenu2:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }


    }
}
