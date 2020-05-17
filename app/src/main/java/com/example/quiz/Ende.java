package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Ende extends AppCompatActivity implements View.OnClickListener{

    Button btnStartMenu, btnNextLvl;

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    int erreichtePunkte;
    final String KEY = "speicherPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ende);

        btnStartMenu = (Button) findViewById(R.id.btnmainMenu);
        btnStartMenu.setOnClickListener(this);

        this.preferences = this.getSharedPreferences("highscore", MODE_PRIVATE);
        preferencesEditor = preferences.edit();

       // Bundle extras = getIntent().getExtras();
    }

    @Override
    public void onClick(View v) {

    }
}
