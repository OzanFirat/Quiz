package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Spiel extends Activity implements View.OnClickListener {
    Button btnAnswer,btnAnswer1,btnAnswer2,btnAnswer3;

TextView textVFrage;

    int aktuelleFrage = 0, level = 0;
    boolean win = false

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

    private void fragenLaden(){
        Fragen fragenC = new Fragen();
        ArrayList fragen = fragenC.getFragen();
        String[] frage = (String[]) fragen.get(aktuelleFrage);

        textVFrage.setText(frage[0]);
        int zufallszahl = (int) (Math.random() * (4-1)+1);

        //soll anzeigen wie man die Fragen an anderen Orten bleiben
        switch(zufallszahl){
            case 1:
                btnAnswer.setText(frage[1]);
                btnAnswer1.setText(frage[2]);
                btnAnswer2.setText(frage[3]);
                btnAnswer3.setText(frage[4]);
                break;
            case 2:
                btnAnswer.setText(frage[4]);
                btnAnswer1.setText(frage[1]);
                btnAnswer2.setText(frage[2]);
                btnAnswer3.setText(frage[3]);
                break;
            case 3:
                btnAnswer.setText(frage[3]);
                btnAnswer1.setText(frage[4]);
                btnAnswer2.setText(frage[1]);
                btnAnswer3.setText(frage[2]);
                break;
            case 4:
                btnAnswer.setText(frage[2]);
                btnAnswer1.setText(frage[3]);
                btnAnswer2.setText(frage[4]);
                btnAnswer3.setText(frage[1]);
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAnswer:
                if(antwortAuswerten(btnAnswer.getText().toString())){
                    level++;
                    win = true;

                    Intent intent = new Intent(this, Ende.class);
                    startActivity(intent);
                    this.finish;

                } else {

                    win = false;

                }
                break;
            case R.id.btnAnswer1:

                if(antwortAuswerten(btnAnswer1.getText().toString())){
                    level++;
                    win = true;

                } else {

                    win = false;
                }
                    break;
            case R.id.btnAnswer2:
                if(antwortAuswerten(btnAnswer2.getText().toString())){
                    level++;
                    win = true;
                    Intent intent = new Intent(this, Ende.class);
                    startActivity(intent);
                    this.finish;

                } else {

                    win = false;
                }


                break;
            case R.id.btnAnswer3:

                if(antwortAuswerten(btnAnswer3.getText().toString())){
                    level++;
                    win = true;

                } else {

                    win = false;
                }
                break;
        }
    }

    private boolean antwortAuswerten (String btnText){
        boolean frage = false;
        Fragen fragenC = new Fragen();
       ArrayList fragen = fragenC.getFragen();
       String[] speicher = (String[]) fragen.get(aktuelleFrage);
       if (Speicher[1].equals(btnText)){
           frage=true;
       }
        return frage;
    }
}
