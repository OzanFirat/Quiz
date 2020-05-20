package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import com.example.quiz.QuizContract.*;
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
                QuestionsTable.TABLE_NAME+" ( "+
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                QuestionsTable.COLUMN_QUESTION + " TEXT, "+
                QuestionsTable.COLUMN_OPTION1+ " TEXT, "+
                QuestionsTable.COLUMN_OPTION2+ " TEXT, "+
                QuestionsTable.COLUMN_OPTION3+ " TEXT, "+
                QuestionsTable.COLUMN_OPTION4+ " TEXT, "+
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, "+
                QuestionsTable.COLUMN_LEVEL+" INTEGER, "+
                QuestionsTable.RATING+" INTEGER"+
                ")";

                db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionTable(){
        Question q1 = new Question("A is correct", "A", "B", "C", "D", 1, 1, 0);
        Question q2 = new Question("B is correct", "A", "B", "C", "D", 2, 2, 0);
        Question q3 = new Question("C is correct", "A", "B", "C", "D", 3, 3, 0);
        Question q4 = new Question("D is correct", "A", "B", "C", "D", 4, 4,0);
        Question q5 = new Question("A is correct", "A", "B", "C", "D", 1, 5,0);
        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);

    }

    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOpt1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOpt2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOpt3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOpt4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_LEVEL, question.getLevelNr());
        cv.put(QuestionsTable.RATING, question.getRatingStars());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);

    }

    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME, null);
        int levelCounter=1;
        if(c.moveToFirst()){
            do {

               Question question = new Question();
               question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
               question.setOpt1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOpt2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOpt3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOpt4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setLevelNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_LEVEL)));
                question.setRatingStars(c.getInt(c.getColumnIndex(QuestionsTable.RATING)));
                questionList.add(question);


            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public void addRating(int level, int ratingStars){
        db=getWritableDatabase();
        Question rightQuestion = getAllQuestions().get(level-1);
        rightQuestion.setRatingStars(ratingStars);
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, rightQuestion.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, rightQuestion.getOpt1());
        cv.put(QuestionsTable.COLUMN_OPTION2, rightQuestion.getOpt2());
        cv.put(QuestionsTable.COLUMN_OPTION3, rightQuestion.getOpt3());
        cv.put(QuestionsTable.COLUMN_OPTION4, rightQuestion.getOpt4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, rightQuestion.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_LEVEL, rightQuestion.getLevelNr());
        cv.put(QuestionsTable.RATING, rightQuestion.getRatingStars());
        db.update(QuestionsTable.TABLE_NAME, cv, "RATING = ?", new String[] { ""+ratingStars });
    }



}
