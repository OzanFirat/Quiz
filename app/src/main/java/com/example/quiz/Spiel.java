package com.example.quiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;



public class Spiel extends AppCompatActivity implements View.OnClickListener {
    private Button btnAnswer,btnAnswer1,btnAnswer2,btnAnswer3, btnFifty, btnSwitch, btnAddTime;
    private List<Question> questionList;
    private ColorStateList textColorDefaultRb;
    private Question currentQuestion;

    private int score, questionCountTotal, amountOfFails, fiftyJokerNew, addTimeNew, switchNew;
    private boolean answered;

    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private TextView textViewCountDown, textVFrage, txtViewLevel;


    private QuizDBHelper dbHelper;





    int aktuelleFrage = 0, level = 0, ratingStar;
    boolean win;
    int rightAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        btnAnswer1 = (Button) findViewById(R.id.btnAnswer1);
        btnAnswer2 = (Button) findViewById(R.id.btnAnswer2);
        btnAnswer3 = (Button) findViewById(R.id.btnAnswer3);

        textVFrage = (TextView)  findViewById(R.id.textVFrage);
        textViewCountDown = (TextView) findViewById(R.id.txtVTimer);




        //textColorDefaultRb = btnAnswer.getTextColors();

       textColorDefaultCd = textViewCountDown.getTextColors();

       dbHelper = new QuizDBHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
       // Collections.shuffle(questionList);

        btnAddTime = (Button) findViewById(R.id.btnAddTime);
        txtViewLevel= (TextView) findViewById(R.id.txtViewLevel) ;


        btnSwitch = (Button) findViewById(R.id.btnSwitch);


        btnFifty = (Button) findViewById(R.id.btnFifty);


        showNextQuestion();




        btnAnswer.setOnClickListener(this);
        btnAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);




    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAnswer:
               if (rightAnswer==1){
                   win=true;
                   setTheScore(win);

               } else {
                    win=false;
                    setTheScore(win);
               }

                break;
            case R.id.btnAnswer1:

                if (rightAnswer==2){
                    win=true;
                    setTheScore(win);
                } else {
                    win=false;
                    setTheScore(win);
                }
                    break;
            case R.id.btnAnswer2:
                if (rightAnswer==3){
                    win=true;
                    setTheScore(win);
                } else {
                    win=false;
                    setTheScore(win);
                }
                break;
            case R.id.btnAnswer3:

                if (rightAnswer==4){
                    win=true;
                    setTheScore(win);
                } else {
                    win=false;
                    setTheScore(win);
                }
                break;

            case R.id.btnAddTime:
                addTenSeconds();
                break;

            case R.id.btnFifty:
                fiftyFiftyJoker();
                break;
            case R.id.btnSwitch:
                switchQuestion(currentQuestion.getLevelNr());
                break;


        }
    }

        private void switchQuestion(int currentLevel) {
            int switchQuestion=89;
            if (currentLevel>=0){
                rightAnswer= questionList.get(switchQuestion).getAnswerNr();
                textVFrage.setText(questionList.get(switchQuestion).getQuestion());
                btnAnswer.setText(questionList.get(switchQuestion).getOpt1());
                btnAnswer1.setText(questionList.get(switchQuestion).getOpt2());
                btnAnswer2.setText(questionList.get(switchQuestion).getOpt3());
                btnAnswer3.setText(questionList.get(switchQuestion).getOpt4());

                this.switchNew=0;
            }switchQuestion++;
            if (currentLevel>=11){

                rightAnswer= questionList.get(switchQuestion).getAnswerNr();
                textVFrage.setText(questionList.get(switchQuestion).getQuestion());
                btnAnswer.setText(questionList.get(switchQuestion).getOpt1());
                btnAnswer1.setText(questionList.get(switchQuestion).getOpt2());
                btnAnswer2.setText(questionList.get(switchQuestion).getOpt3());
                btnAnswer3.setText(questionList.get(switchQuestion).getOpt4());

                this.switchNew=0;
            }switchQuestion++;
            if (currentLevel>=22){

                rightAnswer= questionList.get(switchQuestion).getAnswerNr();
                textVFrage.setText(questionList.get(switchQuestion).getQuestion());
                btnAnswer.setText(questionList.get(switchQuestion).getOpt1());
                btnAnswer1.setText(questionList.get(switchQuestion).getOpt2());
                btnAnswer2.setText(questionList.get(switchQuestion).getOpt3());
                btnAnswer3.setText(questionList.get(switchQuestion).getOpt4());

                this.switchNew=0;
            }switchQuestion++;
            if (currentLevel>=33){

                rightAnswer= questionList.get(switchQuestion).getAnswerNr();
                textVFrage.setText(questionList.get(switchQuestion).getQuestion());
                btnAnswer.setText(questionList.get(switchQuestion).getOpt1());
                btnAnswer1.setText(questionList.get(switchQuestion).getOpt2());
                btnAnswer2.setText(questionList.get(switchQuestion).getOpt3());
                btnAnswer3.setText(questionList.get(switchQuestion).getOpt4());

                this.switchNew=0;
            }
            if (currentLevel>=44){

                rightAnswer= questionList.get(switchQuestion).getAnswerNr();
                textVFrage.setText(questionList.get(switchQuestion).getQuestion());
                btnAnswer.setText(questionList.get(switchQuestion).getOpt1());
                btnAnswer1.setText(questionList.get(switchQuestion).getOpt2());
                btnAnswer2.setText(questionList.get(switchQuestion).getOpt3());
                btnAnswer3.setText(questionList.get(switchQuestion).getOpt4());

                this.switchNew=0;
            }switchQuestion++;
            if (currentLevel>=55){

                rightAnswer= questionList.get(switchQuestion).getAnswerNr();
                textVFrage.setText(questionList.get(switchQuestion).getQuestion());
                btnAnswer.setText(questionList.get(switchQuestion).getOpt1());
                btnAnswer1.setText(questionList.get(switchQuestion).getOpt2());
                btnAnswer2.setText(questionList.get(switchQuestion).getOpt3());
                btnAnswer3.setText(questionList.get(switchQuestion).getOpt4());

                this.switchNew=0;
            }switchQuestion++;

            if (currentLevel>=66){

                rightAnswer= questionList.get(switchQuestion).getAnswerNr();
                textVFrage.setText(questionList.get(switchQuestion).getQuestion());
                btnAnswer.setText(questionList.get(switchQuestion).getOpt1());
                btnAnswer1.setText(questionList.get(switchQuestion).getOpt2());
                btnAnswer2.setText(questionList.get(switchQuestion).getOpt3());
                btnAnswer3.setText(questionList.get(switchQuestion).getOpt4());

                this.switchNew=0;
            }
            switchQuestion++;
            if (currentLevel>=77){
                switchQuestion++;
                rightAnswer= questionList.get(switchQuestion).getAnswerNr();
                textVFrage.setText(questionList.get(switchQuestion).getQuestion());
                btnAnswer.setText(questionList.get(switchQuestion).getOpt1());
                btnAnswer1.setText(questionList.get(switchQuestion).getOpt2());
                btnAnswer2.setText(questionList.get(switchQuestion).getOpt3());
                btnAnswer3.setText(questionList.get(switchQuestion).getOpt4());

                this.switchNew=0;
            }

            this.btnSwitch.setClickable(false);
            this.btnSwitch.setAlpha((float) 0.5);
        }

    private void fiftyFiftyJoker() {
        int root=currentQuestion.getAnswerNr();
        if(root==1 || root==3){
            btnAnswer1.setClickable(false);
            btnAnswer1.setAlpha((float) 0.5);
            btnAnswer3.setClickable(false);
            btnAnswer3.setAlpha((float) 0.5);
        } else {
            btnAnswer.setClickable(false);
            btnAnswer.setAlpha((float) 0.5);
            btnAnswer2.setClickable(false);
            btnAnswer2.setAlpha((float) 0.5);
        }
        this.fiftyJokerNew=0;
        this.btnFifty.setClickable(false);
        this.btnFifty.setAlpha((float) 0.5);

    }


    private void setTheScore(boolean winORLoss){
        countDownTimer.cancel();
        if (winORLoss==true){
           String oldRating = ""+currentQuestion.getRatingStars();
           String actualLvlStatus="yes", oldLvlStatus = "no";
           level = currentQuestion.getLevelNr();
           boolean update = dbHelper.addRating(level, ratingStar, oldRating, actualLvlStatus, oldLvlStatus);

            dbHelper.updateJoker(level, fiftyJokerNew, currentQuestion.getFiftyJoker(), addTimeNew, currentQuestion.getAddTime(), switchNew, currentQuestion.getSwitchQuestion());

            Intent intent = new Intent(this, End.class);
            startActivity(intent);
            this.finish();
        } else {
            ratingStar=0;
            countDownTimer.cancel();
            amountOfFails=amountOfFails+1;
            dbHelper.updateAmountOfFailure(currentQuestion.getLevelNr(), currentQuestion.getAmountOfFailures()+"", amountOfFails+"");
            if(amountOfFails==3){
                /*
                dbHelper.dropTable();
                dbHelper = new QuizDBHelper(this);


                 */

                dbHelper.onUpgrade(dbHelper.getDb(), dbHelper.getDatabaseVersion(), dbHelper.getDatabaseVersion()+1);

                Intent intent = new Intent(this, End3.class);
                startActivity(intent);
                this.finish();

            } else {
                Intent intent = new Intent(this, End2.class);
                startActivity(intent);
                this.finish();
            }

        }

    }

    private void showNextQuestion(){
        /*
        btnAnswer.setTextColor(textColorDefaultRb);
        btnAnswer1.setTextColor(textColorDefaultRb);
        btnAnswer2.setTextColor(textColorDefaultRb);
        btnAnswer3.setTextColor(textColorDefaultRb);

         */

        int counter=0, doneCounter=0;
        while (counter<questionCountTotal){

            if(questionList.get(counter).getLvlDone().equalsIgnoreCase("yes")){

                doneCounter++;

            }
            counter++;

        }
    level=doneCounter;
    currentQuestion = questionList.get(level);
    textVFrage.setText(currentQuestion.getQuestion());
    btnAnswer.setText(currentQuestion.getOpt1());
        btnAnswer1.setText(currentQuestion.getOpt2());
        btnAnswer2.setText(currentQuestion.getOpt3());
        btnAnswer3.setText(currentQuestion.getOpt4());

        //Prove the fails
        proveFails(doneCounter);
        proveJokers(currentQuestion);

        /*
        int previousQuestion = doneCounter-1;
        if(currentQuestion.getLevelNr()==1){
            amountOfFails=currentQuestion.getAmountOfFailures();
        } else{

            if(currentQuestion.getAmountOfFailures()>=questionList.get(previousQuestion).getAmountOfFailures()){
                amountOfFails=currentQuestion.getAmountOfFailures();
                Toast.makeText(Spiel.this, "New updated"+amountOfFails, Toast.LENGTH_LONG).show();
                /*currentQuestion.setAmountOfFailures(amountOfFails);
                dbHelper.updateAmountOfFailure(currentQuestion.getLevelNr(), currentQuestion.getAmountOfFailures()+"", amountOfFails+"");

            } else {
                amountOfFails=questionList.get(previousQuestion).getAmountOfFailures();
                Toast.makeText(Spiel.this, "Old updated "+amountOfFails, Toast.LENGTH_LONG).show();
                dbHelper.updateAmountOfFailure(currentQuestion.getLevelNr(), currentQuestion.getAmountOfFailures()+"", amountOfFails+"");
                currentQuestion.setAmountOfFailures(amountOfFails);
            }


        }

         */


        this.fiftyJokerNew=currentQuestion.getFiftyJoker();
        this.addTimeNew=currentQuestion.getAddTime();
        this.switchNew=currentQuestion.getSwitchQuestion();
        int i = level+1;
        txtViewLevel.setText("Level "+i);
        rightAnswer=currentQuestion.getAnswerNr();

        timeLeftInMillis = COUNTDOWN_IN_MILLIS;

        startCountDown();





    }

    private void proveJokers(Question currentQuestion) {
        if(currentQuestion.getAddTime()==1){
            btnAddTime.setOnClickListener(this);
        } else {
            btnAddTime.setAlpha((float) 0.5);
            btnAddTime.setClickable(false);
        }

        if (currentQuestion.getFiftyJoker()==1){
            btnFifty.setOnClickListener(this);
        } else{
            btnFifty.setAlpha((float) 0.5);
            btnFifty.setClickable(false);
        }

        if (currentQuestion.getFiftyJoker()==1){
            btnFifty.setOnClickListener(this);
        } else{
            btnFifty.setAlpha((float) 0.5);
        }

        if(currentQuestion.getSwitchQuestion()==1){
            btnSwitch.setOnClickListener(this);
        } else {
            btnSwitch.setAlpha((float) 0.5);
            btnSwitch.setClickable(false);
        }

    }

    private void proveFails(int doneCounter) {
        int previousQuestion = doneCounter-1;
        if(currentQuestion.getLevelNr()==1){
            amountOfFails=currentQuestion.getAmountOfFailures();
        } else{

            if(currentQuestion.getAmountOfFailures()>=questionList.get(previousQuestion).getAmountOfFailures()){
                amountOfFails=currentQuestion.getAmountOfFailures();
                Toast.makeText(Spiel.this, "New updated"+amountOfFails, Toast.LENGTH_LONG).show();
                /*currentQuestion.setAmountOfFailures(amountOfFails);
                dbHelper.updateAmountOfFailure(currentQuestion.getLevelNr(), currentQuestion.getAmountOfFailures()+"", amountOfFails+"");
*/
            } else {
                amountOfFails=questionList.get(previousQuestion).getAmountOfFailures();
                Toast.makeText(Spiel.this, "Old updated "+amountOfFails, Toast.LENGTH_LONG).show();
                dbHelper.updateAmountOfFailure(currentQuestion.getLevelNr(), currentQuestion.getAmountOfFailures()+"", amountOfFails+"");
                currentQuestion.setAmountOfFailures(amountOfFails);
            }


        }
    }

    private void endGame() {
        countDownTimer.cancel();
        ratingStar=0;
        amountOfFails++;
        dbHelper.updateAmountOfFailure(currentQuestion.getLevelNr(), currentQuestion.getAmountOfFailures()+"", amountOfFails+"");
        if(amountOfFails==3){
            Intent intent = new Intent(this, End3.class);
            startActivity(intent);
            this.finish();
            /*dbHelper.dropTable();
            dbHelper = new QuizDBHelper(this);

             */
            dbHelper.fillQuestionTable();
        } else {
            Intent intent = new Intent(this, End2.class);
            startActivity(intent);
            this.finish();
        }

    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();


            }


        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int)(timeLeftInMillis / 1000) / 60;
        int seconds = (int)(timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);
        if (timeLeftInMillis==0){
            endGame();
        }

        if (timeLeftInMillis>=20000){
            ratingStar=3;
        }
        if (timeLeftInMillis<20000){
            ratingStar=2;
        }
        if (timeLeftInMillis<10000){
            ratingStar=1;
        }


        if (timeLeftInMillis < 10000){
            textViewCountDown.setTextColor(Color.RED);

        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }

    }

    public void addTenSeconds(){
        countDownTimer.cancel();
        timeLeftInMillis=timeLeftInMillis+10000;
        addTimeNew=0;
        this.btnAddTime.setClickable(false);
        this.btnAddTime.setAlpha((float) 0.5);

        startCountDown();
    }


}
