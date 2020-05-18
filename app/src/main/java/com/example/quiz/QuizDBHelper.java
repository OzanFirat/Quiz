package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    QuizDBHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE "+
                QuizContract.QuestionsTable.TABLE_NAME+" ( "+
                QuizContract.QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                QuizContract.QuestionsTable.COLUMN_OPTION1+ " TEXT, "+
                QuizContract.QuestionsTable.COLUMN_OPTION2+ " TEXT, "+
                QuizContract.QuestionsTable.COLUMN_OPTION3+ " TEXT, "+
                QuizContract.QuestionsTable.COLUMN_OPTION4+ " TEXT, "+
                QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER"+
                ")";

                db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQustionTable(){
        Question q1 = new Question("A is correct", "A", "B", "C", "D", 1);
        Question q2 = new Question("B is correct", "A", "B", "C", "D", 2);
        Question q3 = new Question("C is correct", "A", "B", "C", "D", 3);
        Question q4 = new Question("D is correct", "A", "B", "C", "D", 4);
        Question q5 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQestion(q1);
    }

    private void addQestion (Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOpt1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOpt2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOpt3());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION4, question.getOpt4());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);

    }

    public List<Question> getAllQuestions(){
        List<Question>  questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ QuizContract.QuestionsTable.TABLE_NAME, null);

        if(c.moveToFirst()){
            do {
               Question question = new Question();
               question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
               question.setOpt1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOpt2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOpt3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setOpt4(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);


            } while (c.moveToNext());
        }
        return questionList;
    }


}
