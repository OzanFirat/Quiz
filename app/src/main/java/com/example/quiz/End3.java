package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class End3 extends AppCompatActivity implements View.OnClickListener{

    private Button btnMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end3);

        btnMainMenu=(Button) findViewById(R.id.btnmainMenu2);
        btnMainMenu.setOnClickListener(this);

        QuizDBHelper db = new QuizDBHelper(this);
        db.alterTable();

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
