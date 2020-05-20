package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gameOverview extends AppCompatActivity implements View.OnClickListener{

    Button topic1, topic2, topic3, topic4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_uebersicht);

        topic1= (Button) findViewById(R.id.btnTopic1);
        topic2= (Button) findViewById(R.id.btnTopic2);
        topic3= (Button) findViewById(R.id.btnTopic3);
        topic4= (Button) findViewById(R.id.btnTopic4);

        topic1.setOnClickListener(this);
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
    }
}
