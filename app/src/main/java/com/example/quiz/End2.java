package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class End2 extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartMenu;
    private RatingBar rtBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end2);

        this.btnStartMenu = (Button) findViewById(R.id.btnmainMenu1);
        btnStartMenu.setOnClickListener(this);

        rtBar = (RatingBar) findViewById(R.id.ratingBarEnd);
        rtBar.setNumStars(3);
        rtBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnmainMenu1:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }
}
