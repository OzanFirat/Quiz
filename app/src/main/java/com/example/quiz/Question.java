package com.example.quiz;

public class Question {

    private String question, opt1, opt2, opt3, opt4, lvlDone;
    private int answerNr, levelNr, ratingStars, amountOfFailures, fiftyJoker, addTime;



    public Question(){

    }

    public int getLevelNr() {
        return levelNr;
    }

    public void setLevelNr(int levelNr) {
        this.levelNr = levelNr;
    }

    public int getAmountOfFailures() {
        return amountOfFailures;
    }

    public void setAmountOfFailures(int amountOfFailures) {
        this.amountOfFailures = amountOfFailures;
    }

    public int getFiftyJoker() {
        return fiftyJoker;
    }

    public void setFiftyJoker(int fiftyJoker) {
        this.fiftyJoker = fiftyJoker;
    }

    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    public Question(String question, String opt1, String opt2, String opt3, String opt4, int answerNr,
                    int levelNr, int ratingStars, String lvlDone, int amountOfFailures, int fiftyJoker, int addTime) {
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.answerNr = answerNr;
        this.levelNr = levelNr;
        this.ratingStars=ratingStars;
        this.lvlDone = lvlDone;
        this.amountOfFailures = amountOfFailures;
        this.fiftyJoker=fiftyJoker;
        this.addTime=addTime;

    }

    public String getLvlDone() {
        return lvlDone;
    }

    public void setLvlDone(String lvlDone) {
        this.lvlDone = lvlDone;
    }

    public String getQuestion() {
        return question;
    }

    public int getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(int ratingStars) {
        this.ratingStars = ratingStars;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}
