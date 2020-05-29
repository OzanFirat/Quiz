package com.example.quiz;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract(){

    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
        public static final String COLUMN_LEVEL = "level_number";
        public static final String LEVEL_DONE = "level_done";
        public static final String RATING = "rating_stars";
        public static final String COLUMN_FAILS= "fail_count";
        public static final String COLUMN_FIFTY_JOKER= "fifty_joker";
        public static final String COLUMN_ADD_TIME_JOKER= "add_time_joker";
        public static final String COLUMN_SWITCH_JOKER= "swicht_joker";
    }


}
