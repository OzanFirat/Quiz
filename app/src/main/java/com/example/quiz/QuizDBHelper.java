package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import com.example.quiz.QuizContract.*;
public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private List<Question> questionList;

    private SQLiteDatabase db;

    private static final String TAG = "ListDataActivity";

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
                QuestionsTable.LEVEL_DONE+" TEXT, "+
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, "+
                QuestionsTable.COLUMN_LEVEL+" INTEGER, "+
                QuestionsTable.RATING+" INTEGER"+
                ")";

                db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        if(questionList.isEmpty()){
            fillQuestionTable();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionTable(){
        Question q1 = new Question("Wie schreibt man IP-Adressen (IPv4)?", "8 durch Doppelpunkt getrennte Hexadezimal Zeichen", "32-Bit stellige binäre Zahl ", "10 Stellige dezimale Zahl", "4 durch Punkt getrennte Zahlen", 4, 1, 0, "no");
        Question q2 = new Question("Was bedeutet SMTP?", "simple mother terminal protocol", "Schweizer Militärsteamputze", "scientific mail translocation protocol", "simple mail transfer protocol", 4, 2, 0, "no");
        Question q3 = new Question("Wie nennt man die Anmeldung bei verschiedenen Homepages?", "Logout", "Login", "Lockdown", "Entry", 2, 3, 0, "no");
        Question q4 = new Question("Was hat nichts mit einem Server zu tun", "Roxy", "Proxy", "Apache", "Q-Mail", 1, 4,0, "no");
        Question q5 = new Question("A is correct", "A", "B", "C", "D", 1, 5,0, "no");
        Question q6 = new Question("A is correct", "A", "B", "C", "D", 1, 6,0, "no");
        Question q7 = new Question("A is correct", "A", "B", "C", "D", 1, 7,0, "no");
        Question q8 = new Question("A is correct", "A", "B", "C", "D", 1, 8,0, "no");
        Question q9 = new Question("A is correct", "A", "B", "C", "D", 1, 9,0, "no");
        Question q10 = new Question("A is correct", "A", "B", "C", "D", 1, 10,0, "no");
        Question q11 = new Question("A is correct", "A", "B", "C", "D", 1, 11, 0, "no");
        Question q12 = new Question("B is correct", "A", "B", "C", "D", 2, 12, 0, "no");
        Question q13 = new Question("C is correct", "A", "B", "C", "D", 3, 13, 0, "no");
        Question q14 = new Question("D is correct", "A", "B", "C", "D", 4, 14,0, "no");
        Question q15 = new Question("A is correct", "A", "B", "C", "D", 1, 15,0, "no");
        Question q16 = new Question("A is correct", "A", "B", "C", "D", 1, 16,0, "no");
        Question q17 = new Question("A is correct", "A", "B", "C", "D", 1, 17,0, "no");
        Question q18 = new Question("A is correct", "A", "B", "C", "D", 1, 18,0, "no");
        Question q19 = new Question("A is correct", "A", "B", "C", "D", 1, 19,0, "no");
        Question q20 = new Question("A is correct", "A", "B", "C", "D", 1, 20,0, "no");
        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);
        addQuestion(q11);
        addQuestion(q12);
        addQuestion(q13);
        addQuestion(q14);
        addQuestion(q15);
        addQuestion(q16);
        addQuestion(q17);
        addQuestion(q18);
        addQuestion(q19);
        addQuestion(q20);

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
        cv.put(QuestionsTable.LEVEL_DONE, question.getLvlDone());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);


    }

    public List<Question> getAllQuestions(){
        questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME, null);

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
                question.setLvlDone(c.getString(c.getColumnIndex(QuestionsTable.LEVEL_DONE)));
                questionList.add(question);


            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    public boolean addRating(int level, int ratingStars, String oldRating, String actualLvlStatus, String oldLvlStatus){
        db=getWritableDatabase();

        String rating = String.valueOf(ratingStars);

        String query = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.RATING+
                " = '"+rating+"' WHERE "+QuestionsTable._ID+ " = '"+level+"'"+
                " AND "+ QuestionsTable.RATING+ " = '"+oldRating+"'";
        Log.d(TAG, "updateRating: query "+query);
        Log.d(TAG, "updateName: Setting Rating to "+rating);
        db.execSQL(query);

        String query2 = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.LEVEL_DONE+
                " = '"+actualLvlStatus+"' WHERE "+QuestionsTable._ID+ " = '"+level+"'"+
                " AND "+ QuestionsTable.LEVEL_DONE+ " = '"+oldLvlStatus+"'";
        Log.d(TAG, "updateRating: query "+query);
        Log.d(TAG, "updateName: Setting Lvl Status to "+actualLvlStatus);
        db.execSQL(query2);


        return true;
    }

    public boolean alterTable(){
        String query = "DROP TABLE "+ QuestionsTable.TABLE_NAME;

        return true;
    }



}
