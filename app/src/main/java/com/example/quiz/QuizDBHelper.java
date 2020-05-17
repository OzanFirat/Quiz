package com.example.quiz;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                FragenContract.QuestionsTable.TABLE_NAME+" ( "+
                FragenContract.QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                FragenContract.QuestionsTable.COLUMN_OPTION1+ " TEXT, "+
                FragenContract.QuestionsTable.COLUMN_OPTION2+ " TEXT, "+
                FragenContract.QuestionsTable.COLUMN_OPTION3+ " TEXT, "+
                FragenContract.QuestionsTable.COLUMN_OPTION4+ " TEXT, "+
                FragenContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER"

                db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ FragenContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    privatevoid fillQustionTable(){

    }
}
