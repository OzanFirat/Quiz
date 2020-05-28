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
                QuestionsTable.COLUMN_FAILS+" INTEGER, "+
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
        //Computer und IT
        Question q1 = new Question("Wie schreibt man IP-Adressen (IPv4)?", "8 durch Doppelpunkt getrennte Hexadezimal Zeichen", "32-Bit stellige binäre Zahl ", "10 Stellige dezimale Zahl", "4 durch Punkt getrennte Zahlen", 4, 1, 0, "no", 0);
        Question q2 = new Question("Was bedeutet SMTP?", "simple mother terminal protocol", "Schweizer Militärsteamputze", "scientific mail translocation protocol", "simple mail transfer protocol", 4, 2, 0, "no",0);
        Question q3 = new Question("Wie nennt man die Anmeldung bei verschiedenen Homepages?", "Logout", "Login", "Lockdown", "Entry", 2, 3, 0, "no",0);
        Question q4 = new Question("Was hat nichts mit einem Server zu tun", "Roxy", "Proxy", "Apache", "Q-Mail", 1, 4,0, "no",0);
        Question q5 = new Question("Wie nennt man vorsätzliches Registrieren und Blockieren von Domains, an denen Rechte Dritter bestehen?", "Boykott", "Domainstopping", "Dispute-Eintrag", "Domaingrabbing", 4, 5,0, "no",0);
        Question q6 = new Question("Welches Programm schützt vor unbefugten Zugriffen aus dem Internet", "Firewall", "Snowwall", "Waterfall", "Mainboard", 1, 6,0, "no",0);
        Question q7 = new Question("Wie nennt man die marktübliche Technik für Ferngespräche über das Internet?", "Voice over IP", "Talk over IT", "WalkiTalk", "Phone over intranet", 1, 7,0, "no",0);
        Question q8 = new Question("Welche dieser HTML-Arten gibt es nicht?", "DHTML", "XHTML", "SHTML", "NHTML", 4, 8,0, "no",0);
        Question q9 = new Question("Wie heisst der erste Microprozessor?", "Apple 44", "Intel 404", "Intel 4004", "Pentium 1", 3, 9,0, "no",0);
        Question q10 = new Question("Wofür steht die Abkürzung CPU?", "Cypher Pool Urgent", "Central Processing Unit", "Computer Power Unit", "Computer Processing Use", 2, 10,0, "no",0);
        Question q11 = new Question("Welche der gennanten Programmier Sprachen ist die älteste?", "ASP", "PERL", "C#", "JAVA", 2, 11, 0, "no",0);

        //Geschichte
        Question q12 = new Question("Wer umsegelte als erster die Welt?", "Columbus", "Vespucci", "Gustavo Amerigo", "Magellan", 4, 12, 0, "no",0);
        Question q13 = new Question("Wie hieß der erste Präsident der USA?", "Washington", "Lincoln", "Roosevelt", "Bushy", 1, 13, 0, "no",0);
        Question q14 = new Question("Im Jahre 1207 eroberten die Seldschuken von den Byzantinern ...", "Konstantinopel", "Athen", "Antalya", "Rom", 3, 14,0, "no",0);
        Question q15 = new Question("In welchem Jahr wurden die Vereinten Nationen gegründet?", "1946", "1944", "1948", "1945", 4, 15,0, "no",0);
        Question q16 = new Question("Wie hießen die beiden Jugendorganisationen im dritten Reich?", "HJ & BDM", "SS-Junior und SS-Mädel", "SS, HJ", "Jugend ohne Gott", 1, 16,0, "no",0);
        Question q17 = new Question("Wann erschien Das Kapital von Karlmarx", "1867", "1845", "1857", "1898", 1, 17,0, "no",0);
        Question q18 = new Question("Wer sagte veni, vidi, vici (Ich kam, sah, siegte)?", "Julius Gaius Caesar", "Marcus Antonius", "Petrus Metrus", "Optimus Primus", 1, 18,0, "no",0);
        Question q19 = new Question("Wer entdeckte im Jahre 1497 den für den Handel so wichtigen Seeweg nach Indien?", "Vasco da Gama", "Columbus", "Amerigo Vespucci", "Fernando Magellan", 1, 19,0, "no",0);
        Question q20 = new Question("In welchem Jahrhundert war die Reformation?", "15.", "17.", "16.", "18.", 3, 20,0, "no",0);
        Question q21 = new Question("Zwischen welchen Jahren fand der 30 Jährige Krieg statt?", "1556 bis 1586", "1618 bis 1648", "1914 bis 1944", "1752 bis 1782", 2, 11, 0, "no",0);
        Question q22 = new Question("Wann war die Reichsteilung im Römischen Reich?", "395 n.C", "41 v.C", "895 n.C", "980 n.C", 1, 12, 0, "no",0);

        //Chemie
        Question q23 = new Question("Ist Erdgas leichter als Luft?", "Ja", "Nein", "Vielleicht", "Keine Ahnung", 1, 13, 0, "no",0);
        Question q24 = new Question("Was ist ein Schwermetall?", "Lithium", "Titan", "Sillizium", "Indium", 4, 14,0, "no",0);
        Question q25 = new Question("Alle Edelmetalle sind ...", "radioaktiv", "Schwermetalle", "Platin Metalle", "keine Metalle", 2, 15,0, "no",0);
        Question q26 = new Question("Welches Metall hat die größte Dichte?", "Gold", "Iridium", "Blei", "Uran", 2, 16,0, "no",0);
        Question q27 = new Question("Welches Getränk enthält über 2000 verschiedene chemische Verbindungen?", "Milch", "Cola", "Wein", "Kaffee", 4, 17,0, "no",0);
        Question q28 = new Question("Das chemische zeichen für Zink?", "Zk", "Zn", "Cn", "Zi", 2, 11, 0, "no",0);
        Question q29 = new Question("Welche Farbe bildet Jod, wenn es sich in Alkohol löst?", "Braun", "Blau", "Gelb", "Rot", 1, 12, 0, "no",0);
        Question q30 = new Question("Welches Element hat den niedrigsten Schmelzpunkt?", "Wasserstoff", "Neon", "Fluor", "Sauerstoff", 1, 13, 0, "no",0);
        Question q31 = new Question("Bei welcher Temperatur wird (unter Normaldruck) Luft flüssig", "0.15K", "-98° C ", "-213° C", "bei keiner", 3, 14,0, "no",0);
        Question q32 = new Question("Wie sind die Doppelbindungen in einer konjugierten Kohlenwasserstoffkette gesetzt?", "abwechselnd", "irgendwie", "gar nicht", "am Ende und am Anfang", 1, 15,0, "no",0);
        Question q33 = new Question("Extrem reaktionsträge Stoffe wie Glas und die Edelgase sind ...", "alkalisch", "alert", "chalkogen", "inert", 4, 16,0, "no",0);

        //Tierwelt
        Question q34 = new Question("Sind Termiten große Ameisen?", "Ja", "Nein", "Könnte sein", "Hab kein Spickzettel", 2, 17,0, "no",0);
        Question q35 = new Question("Wie heißt das asiatische Hochgebirgsrind?", "Wagyu", "Kobe Bryant", "Yang", "Yak", 4, 11, 0, "no",0);
        Question q36 = new Question("Was ist Guano?", "Affenart", "Fisch", "Droge", "Vogelkot", 4, 12, 0, "no",0);
        Question q37 = new Question("Wie nennt man weibliche Pferde?", "Alpha Weibchen", "Stute", "Hengst", "Pony", 2, 13, 0, "no",0);
        Question q38 = new Question("Wie groß ist eine Giraffe?", "ca. 8 Meter", "ca. 5 Meter", "ca. 7 Meter", "ca. 6 Meter", 4, 14,0, "no",0);
        Question q39 = new Question("Die Nachahmung wehrhafter Tiere durch Form- und Farbanpassung nennt man ...?", "Mimose", "Mimik", "Mimikry", "Mime", 3, 15,0, "no",0);
        Question q40 = new Question("Glühwürmchen sind ...", "Würmer", "Zecken", "Kaefer", "Bienen", 3, 16,0, "no",0);
        Question q41 = new Question("Wie nennt man die Welt der Tiere?", "Fabel", "Fauna", "Sauna", "Haivana", 2, 17,0, "no",0);
        Question q42 = new Question("Wie viele Flügel hat eine Biene?", "2", "3", "4", "6", 3, 11, 0, "no",0);
        Question q43 = new Question("BWie viele Beine hat eine Krabbe?", "4", "6", "8", "12", 3, 12, 0, "no",0);
        Question q44 = new Question("Die Giraffe reisst die Blätter mit der Zunge vom Baum. Was für eine Farbe hat ihre Zunge?", "Weiss", "Rot", "Blau", "Rosa", 3, 13, 0, "no",0);

        //Geographie
        Question q45 = new Question("Der Teil des Mittelmeeres zwischen Griechenland und der Türkei heißt...", "Der Golf von Mexiko", "Adriatisches Meer", "Mittelmeer", "Aegaeisches Meer", 4, 14,0, "no",0);
        Question q46 = new Question("Die Mojavewüste liegt in ...", "Asien", "Balkan", "Afrika", "Nordamerika", 4, 15,0, "no",0);
        Question q47 = new Question("Welche Sprache ist die Amtssprache im Iran?", "Arabisch", "Persisch", "Iranisch", "Paschto", 2, 16,0, "no",0);
        Question q48 = new Question("In welchem Land liegt die größte Wüste Amerikas?", "USA", "Brasilien", "Argentinien", "Kanada", 3, 17,0, "no",0);
        Question q49 = new Question("Welche der gennanten Programmier Sprachen ist die älteste?", "ASP", "PERL", "C#", "JAVA", 2, 11, 0, "no",0);
        Question q50 = new Question("Die Hauptstadt von Uruguay ist...", "Montevideo", "Bogota", "Vuvuzuela", "Baskia", 1, 12, 0, "no",0);
        Question q51 = new Question("In welcher Gebirgskette ist der K2 (der zweithöchste Berg der Welt)?", "Karakorum", "Anden", "Himalaya", "Kaukasus", 1, 13, 0, "no",0);
        Question q52 = new Question("Welches afrikanische Land hat die größte Fläche?", "Algerien", "Mali", "Sudan", "Libyen", 1, 14,0, "no",0);
        Question q53 = new Question("Wie viele Sterne sieht man auf Kubas Flagge?", "1", "2", "3", "keine", 1, 15,0, "no",0);
        Question q54 = new Question("Welches Land wird `Grüne Insel` genannt?", "Irland", "Bahrain", "Costa Rica", "Island", 1, 16,0, "no",0);
        Question q55 = new Question("Paramaribo ist die Hauptstadt von ...", "Ecuador", "Suriname", "Guyana", "Belize", 2, 17,0, "no",0);

        //Religion
        Question q56 = new Question("Wo steht Christi Geburtskirche?", "Jerusalem", "Bethlehem", "Nazareth", "Haifa", 2, 11, 0, "no",0);
        Question q57 = new Question("Wie heißt Versöhnungstag auf Hebräisch?", "Gemara", "Jom Kippur", "Jom An-Nur", "Rosch Ha-Schana", 2, 12, 0, "no",0);
        Question q58 = new Question("Was ist keines der fünf Bücher Mose?", "Genesis", "Numeri", "Hesekiel", "Leviticus", 3, 13, 0, "no",0);
        Question q59 = new Question("In welcher Religion spielt Reinkarnation eine große Rolle?", "Islam", "Taoismus", "Christentum", "Hinduismus und Buddhismus", 4, 14,0, "no",0);
        Question q60 = new Question(" Mit welchem Tag beginnt das katholische Kirchenjahr?", "1. Advent", "Silvester", "Ostermontag", "37614", 1, 15,0, "no",0);
        Question q61 = new Question("Wie nannten die Griechen den Strom des Vergessens in der Unterwelt?", "Acheron", "Lethe", "Hades", "Styx", 2, 16,0, "no",0);
        Question q62 = new Question("Über welche Kirche erhebt sich die größte gemauerte Kuppel der Welt?", "Petersdom", "Stephansdom", "Karlskirche", "Mailaender Dom", 1, 17,0, "no",0);
        Question q63 = new Question("Wer rief 1096 zum ersten Kreuzzug auf?", "Papst Leo III.", "Papst Urban I.", "Kaiser Friedrich Barbossa I. (Rotbart)", "Papst Urban II.", 4, 11, 0, "no",0);
        Question q64 = new Question("Was bedeutet orthodox?", "Aberglauben verfallen", "rechtgläubig", "linksgläubig", "heidnisch", 2, 12, 0, "no",0);
        Question q65 = new Question("Wann gab es die letzte Hinrichtung wegen Hexerei in England?", "1685", "1495", "1895", "1817", 1, 13, 0, "no",0);
        Question q66 = new Question("Welcher Staat der USA gilt als Heimat der Mormonen?", "Utah", "Texas", "Iowa", "Wisconsin", 1, 14,0, "no",0);

        Question q67 = new Question("A is correct", "A", "B", "C", "D", 1, 15,0, "no",0);
        Question q68 = new Question("A is correct", "A", "B", "C", "D", 1, 16,0, "no",0);
        Question q69 = new Question("A is correct", "A", "B", "C", "D", 1, 17,0, "no",0);
        Question q70 = new Question("Welche der gennanten Programmier Sprachen ist die älteste?", "ASP", "PERL", "C#", "JAVA", 2, 11, 0, "no",0);
        Question q71 = new Question("B is correct", "A", "B", "C", "D", 2, 12, 0, "no",0);
        Question q72 = new Question("C is correct", "A", "B", "C", "D", 3, 13, 0, "no",0);
        Question q73 = new Question("D is correct", "A", "B", "C", "D", 4, 14,0, "no",0);
        Question q74 = new Question("A is correct", "A", "B", "C", "D", 1, 15,0, "no",0);
        Question q75 = new Question("A is correct", "A", "B", "C", "D", 1, 16,0, "no",0);
        Question q76 = new Question("A is correct", "A", "B", "C", "D", 1, 17,0, "no",0);
        Question q77 = new Question("B is correct", "A", "B", "C", "D", 2, 12, 0, "no",0);


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
                question.setAmountOfFailures(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_FAILS)));
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

    public boolean updateAmountOfFailure (int level, String oldAmount, String newAmount){
        db=getWritableDatabase();
        String query = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_FAILS+
                " = '"+newAmount+"' WHERE "+QuestionsTable._ID+ " = '"+level+"'"+
                " AND "+ QuestionsTable.COLUMN_FAILS+ " = '"+oldAmount+"'";
        Log.d(TAG, "updateFail: query "+query);
        Log.d(TAG, "updateName: Setting Fails to "+newAmount);
        db.execSQL(query);
       return true;
    }

    public boolean alterTable(){
        String query = "DROP TABLE "+ QuestionsTable.TABLE_NAME;
        db.execSQL(query);

        return true;
    }



}
