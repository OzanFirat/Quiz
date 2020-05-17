package com.example.quiz;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ende extends Activity implements View.OnClickListener{

    private Button btnStartMenu, btnNextLvl;
    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    private int erreichtePunkte;
    private final String KEY = "speicherPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ende);

       this.btnStartMenu = (Button) findViewById(R.id.btnmainMenu);
       btnStartMenu.setOnClickListener(this);

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
