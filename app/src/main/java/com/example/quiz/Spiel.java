package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Spiel extends Activity implements View.OnClickListener {
    Button btnAnswer,btnAnswer1,btnAnswer2,btnAnswer3;

TextView textVFrage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel);

        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        btnAnswer1 = (Button) findViewById(R.id.btnAnswer1);
        btnAnswer2 = (Button) findViewById(R.id.btnAnswer2);
        btnAnswer3 = (Button) findViewById(R.id.btnAnswer3);

        textVFrage = (TextView)  findViewById(R.id.textVFrage);


        btnAnswer.setOnClickListener(this);
        btnAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAnswer:
                break;
            case R.id.btnAnswer1:
                break;
            case R.id.btnAnswer2:
                break;
            case R.id.btnAnswer3:
                break;
        }
    }
}
