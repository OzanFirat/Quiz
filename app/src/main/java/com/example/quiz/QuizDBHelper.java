package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.example.quiz.QuizContract.*;
public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    private static final int DATABASE_VERSION = 1;
    private List<Question> questionList;

    public SQLiteDatabase getDb() {
        return db;
    }

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
                QuestionsTable.RATING+" INTEGER, "+
                QuestionsTable.COLUMN_FIFTY_JOKER+" INTEGER, "+
                QuestionsTable.COLUMN_ADD_TIME_JOKER+" INTEGER, "+
                QuestionsTable.COLUMN_SWITCH_JOKER+" INTEGER"+
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);

        if(questionList.isEmpty()){
            fillQuestionTable();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ QuizContract.QuestionsTable.TABLE_NAME);
        questionList.clear();
        onCreate(db);
    }

    public void fillQuestionTable(){
        //Computer und IT
        Question q1 = new Question("Wie schreibt man IP-Adressen (IPv4)?", "8 Punkt getrennte Hexadezimal", "32-Bit stellige binäre Zahl ", "10 Stellige dezimale Zahl", "4 durch Punkt getrennte Zahlen", 4, 1, 0, "no", 0, 1, 1, 1);
        Question q2 = new Question("Was bedeutet SMTP?", "simple mother terminal protocol", "Schweizer Militärsteamputze", "scientific mail translocation protocol", "simple mail transfer protocol", 4, 2, 0, "no",0, 0,0,0);
        Question q3 = new Question("Wie nennt man die Anmeldung bei verschiedenen Homepages?", "Logout", "Login", "Lockdown", "Entry", 2, 3, 0, "no",0,0,0,0);
        Question q4 = new Question("Was hat nichts mit einem Server zu tun", "Roxy", "Proxy", "Apache", "Q-Mail", 1, 4,0, "no",0,0,0,0);
        Question q5 = new Question("Wie nennt man vorsätzliches Registrieren und Blockieren von Domains, an denen Rechte Dritter bestehen?", "Boykott", "Domainstopping", "Dispute-Eintrag", "Domaingrabbing", 4, 5,0, "no",0, 0,0,0);
        Question q6 = new Question("Welches Programm schützt vor unbefugten Zugriffen aus dem Internet", "Firewall", "Snowwall", "Waterfall", "Mainboard", 1, 6,0, "no",0,0,0,0);
        Question q7 = new Question("Wie nennt man die marktübliche Technik für Ferngespräche über das Internet?", "Voice over IP", "Talk over IT", "WalkiTalk", "Phone over intranet", 1, 7,0, "no",0, 0,0,0);
        Question q8 = new Question("Welche dieser HTML-Arten gibt es nicht?", "DHTML", "XHTML", "SHTML", "NHTML", 4, 8,0, "no",0, 0,0,0);
        Question q9 = new Question("Wie heisst der erste Microprozessor?", "Apple 44", "Intel 404", "Intel 4004", "Pentium 1", 3, 9,0, "no",0, 0,0,0);
        Question q10 = new Question("Wofür steht die Abkürzung CPU?", "Cypher Pool Urgent", "Central Processing Unit", "Computer Power Unit", "Computer Processing Use", 2, 10,0, "no",0, 0,0,0);
        Question q11 = new Question("Welche der gennanten Programmier Sprachen ist die älteste?", "ASP", "PERL", "C#", "JAVA", 2, 11, 0, "no",0, 0,0,0);

        //Geschichte
        Question q12 = new Question("Wer umsegelte als erster die Welt?", "Columbus", "Vespucci", "Gustavo Amerigo", "Magellan", 4, 12, 0, "no",0, 1,1,1);
        Question q13 = new Question("Wie hieß der erste Präsident der USA?", "Washington", "Lincoln", "Roosevelt", "Bushy", 1, 13, 0, "no",0, 0,0,0);
        Question q14 = new Question("Im Jahre 1207 eroberten die Seldschuken von den Byzantinern ...", "Konstantinopel", "Athen", "Antalya", "Rom", 3, 14,0, "no",0, 0,0,0);
        Question q15 = new Question("In welchem Jahr wurden die Vereinten Nationen gegründet?", "1946", "1944", "1948", "1945", 4, 15,0, "no",0, 0,0,0);
        Question q16 = new Question("Wie hießen die beiden Jugendorganisationen im dritten Reich?", "HJ & BDM", "SS-Junior und SS-Mädel", "SS, HJ", "Jugend ohne Gott", 1, 16,0, "no",0, 0,0,0);
        Question q17 = new Question("Wann erschien Das Kapital von Karlmarx", "1867", "1845", "1857", "1898", 1, 17,0, "no",0, 0,0,0);
        Question q18 = new Question("Wer sagte veni, vidi, vici (Ich kam, sah, siegte)?", "Julius Gaius Caesar", "Marcus Antonius", "Petrus Metrus", "Optimus Primus", 1, 18,0, "no",0, 0,0,0);
        Question q19 = new Question("Wer entdeckte im Jahre 1497 den für den Handel so wichtigen Seeweg nach Indien?", "Vasco da Gama", "Columbus", "Amerigo Vespucci", "Fernando Magellan", 1, 19,0, "no",0, 0,0,0);
        Question q20 = new Question("In welchem Jahrhundert war die Reformation?", "15.", "17.", "16.", "18.", 3, 20,0, "no",0, 0,0,0);
        Question q21 = new Question("Zwischen welchen Jahren fand der 30 Jährige Krieg statt?", "1556 bis 1586", "1618 bis 1648", "1914 bis 1944", "1752 bis 1782", 2, 21, 0, "no",0, 0,0,0);
        Question q22 = new Question("Wann war die Reichsteilung im Römischen Reich?", "395 n.C", "41 v.C", "895 n.C", "980 n.C", 1, 22, 0, "no",0, 0,0,0);

        //Chemie
        Question q23 = new Question("Ist Erdgas leichter als Luft?", "Ja", "Nein", "Vielleicht", "Keine Ahnung", 1, 23, 0, "no",0, 1,1,1);
        Question q24 = new Question("Was ist ein Schwermetall?", "Lithium", "Titan", "Sillizium", "Indium", 4, 24,0, "no",0, 0,0,0);
        Question q25 = new Question("Alle Edelmetalle sind ...", "radioaktiv", "Schwermetalle", "Platin Metalle", "keine Metalle", 2, 25,0, "no",0, 0,0,0);
        Question q26 = new Question("Welches Metall hat die größte Dichte?", "Gold", "Iridium", "Blei", "Uran", 2, 26,0, "no",0, 0,0,0);
        Question q27 = new Question("Welches Getränk enthält über 2000 verschiedene chemische Verbindungen?", "Milch", "Cola", "Wein", "Kaffee", 4, 27,0, "no",0, 0,0,0);
        Question q28 = new Question("Das chemische zeichen für Zink?", "Zk", "Zn", "Cn", "Zi", 2, 28, 0, "no",0, 0,0,0);
        Question q29 = new Question("Welche Farbe bildet Jod, wenn es sich in Alkohol löst?", "Braun", "Blau", "Gelb", "Rot", 1, 29, 0, "no",0, 0,0,0);
        Question q30 = new Question("Welches Element hat den niedrigsten Schmelzpunkt?", "Wasserstoff", "Neon", "Fluor", "Sauerstoff", 1, 30, 0, "no",0, 0,0,0);
        Question q31 = new Question("Bei welcher Temperatur wird (unter Normaldruck) Luft flüssig", "0.15K", "-98° C ", "-213° C", "bei keiner", 3, 31,0, "no",0, 0,0,0);
        Question q32 = new Question("Wie sind die Doppelbindungen in einer konjugierten Kohlenwasserstoffkette gesetzt?", "abwechselnd", "irgendwie", "gar nicht", "am Ende und am Anfang", 32, 15,0, "no",0, 0,0,0);
        Question q33 = new Question("Extrem reaktionsträge Stoffe wie Glas und die Edelgase sind ...", "alkalisch", "alert", "chalkogen", "inert", 4, 33,0, "no",0, 0,0,0);

        //Tierwelt
        Question q34 = new Question("Sind Termiten große Ameisen?", "Ja", "Nein", "Könnte sein", "Hab kein Spickzettel", 2, 34,0, "no",0, 1,1,1);
        Question q35 = new Question("Wie heißt das asiatische Hochgebirgsrind?", "Wagyu", "Kobe Bryant", "Yang", "Yak", 4, 35, 0, "no",0, 0,0,0);
        Question q36 = new Question("Was ist Guano?", "Affenart", "Fisch", "Droge", "Vogelkot", 4, 36, 0, "no",0, 0,0,0);
        Question q37 = new Question("Wie nennt man weibliche Pferde?", "Alpha Weibchen", "Stute", "Hengst", "Pony", 2, 37, 0, "no",0, 0,0,0);
        Question q38 = new Question("Wie groß ist eine Giraffe?", "ca. 8 Meter", "ca. 5 Meter", "ca. 7 Meter", "ca. 6 Meter", 4, 38,0, "no",0, 0,0,0);
        Question q39 = new Question("Die Nachahmung wehrhafter Tiere durch Form- und Farbanpassung nennt man ...?", "Mimose", "Mimik", "Mimikry", "Mime", 3, 39,0, "no",0, 0,0,0);
        Question q40 = new Question("Glühwürmchen sind ...", "Würmer", "Zecken", "Kaefer", "Bienen", 3, 40,0, "no",0, 0,0,0);
        Question q41 = new Question("Wie nennt man die Welt der Tiere?", "Fabel", "Fauna", "Sauna", "Haivana", 2, 41,0, "no",0, 0,0,0);
        Question q42 = new Question("Wie viele Flügel hat eine Biene?", "2", "3", "4", "6", 3, 42, 0, "no",0, 0,0,0);
        Question q43 = new Question("BWie viele Beine hat eine Krabbe?", "4", "6", "8", "12", 3, 43, 0, "no",0, 0,0,0);
        Question q44 = new Question("Die Giraffe reisst die Blätter mit der Zunge vom Baum. Was für eine Farbe hat ihre Zunge?", "Weiss", "Rot", "Blau", "Rosa", 3, 44, 0, "no",0, 0,0,0);

        //Geographie
        Question q45 = new Question("Der Teil des Mittelmeeres zwischen Griechenland und der Türkei heißt...", "Der Golf von Mexiko", "Adriatisches Meer", "Mittelmeer", "Aegaeisches Meer", 4, 45,0, "no",0, 1,1,1);
        Question q46 = new Question("Die Mojavewüste liegt in ...", "Asien", "Balkan", "Afrika", "Nordamerika", 4, 46,0, "no",0, 0,0,0);
        Question q47 = new Question("Welche Sprache ist die Amtssprache im Iran?", "Arabisch", "Persisch", "Iranisch", "Paschto", 2, 47,0, "no",0, 0,0,0);
        Question q48 = new Question("In welchem Land liegt die größte Wüste Amerikas?", "USA", "Brasilien", "Argentinien", "Kanada", 3, 48,0, "no",0, 0,0,0);
        Question q49 = new Question("Welche der gennanten Programmier Sprachen ist die älteste?", "ASP", "PERL", "C#", "JAVA", 2, 49, 0, "no",0, 0,0,0);
        Question q50 = new Question("Die Hauptstadt von Uruguay ist...", "Montevideo", "Bogota", "Vuvuzuela", "Baskia", 1, 50, 0, "no",0, 0,0,0);
        Question q51 = new Question("In welcher Gebirgskette ist der K2 (der zweithöchste Berg der Welt)?", "Karakorum", "Anden", "Himalaya", "Kaukasus", 1, 51, 0, "no",0, 0,0,0);
        Question q52 = new Question("Welches afrikanische Land hat die größte Fläche?", "Algerien", "Mali", "Sudan", "Libyen", 1, 52,0, "no",0, 0,0,0);
        Question q53 = new Question("Wie viele Sterne sieht man auf Kubas Flagge?", "1", "2", "3", "keine", 1, 53,0, "no",0, 0,0,0);
        Question q54 = new Question("Welches Land wird `Grüne Insel` genannt?", "Irland", "Bahrain", "Costa Rica", "Island", 1, 54,0, "no",0, 0,0,0);
        Question q55 = new Question("Paramaribo ist die Hauptstadt von ...", "Ecuador", "Suriname", "Guyana", "Belize", 2, 55,0, "no",0, 0,0,0);

        //Religion
        Question q56 = new Question("Wo steht Christi Geburtskirche?", "Jerusalem", "Bethlehem", "Nazareth", "Haifa", 2, 56, 0, "no",0, 1,1,1);
        Question q57 = new Question("Wie heißt Versöhnungstag auf Hebräisch?", "Gemara", "Jom Kippur", "Jom An-Nur", "Rosch Ha-Schana", 2, 57, 0, "no",0, 0,0,0);
        Question q58 = new Question("Was ist keines der fünf Bücher Mose?", "Genesis", "Numeri", "Hesekiel", "Leviticus", 3, 58, 0, "no",0,0,0,0);
        Question q59 = new Question("In welcher Religion spielt Reinkarnation eine große Rolle?", "Islam", "Taoismus", "Christentum", "Hinduismus und Buddhismus", 4, 59,0, "no",0, 0,0,0);
        Question q60 = new Question(" Mit welchem Tag beginnt das katholische Kirchenjahr?", "1. Advent", "Silvester", "Ostermontag", "37614", 1, 60,0, "no",0, 0,0,0);
        Question q61 = new Question("Wie nannten die Griechen den Strom des Vergessens in der Unterwelt?", "Acheron", "Lethe", "Hades", "Styx", 2, 61,0, "no",0, 0,0,0);
        Question q62 = new Question("Über welche Kirche erhebt sich die größte gemauerte Kuppel der Welt?", "Petersdom", "Stephansdom", "Karlskirche", "Mailaender Dom", 1, 62,0, "no",0, 0,0,0);
        Question q63 = new Question("Wer rief 1096 zum ersten Kreuzzug auf?", "Papst Leo III.", "Papst Urban I.", "Kaiser Friedrich Barbossa I. (Rotbart)", "Papst Urban II.", 4, 63, 0, "no",0, 0,0,0);
        Question q64 = new Question("Was bedeutet orthodox?", "Aberglauben verfallen", "rechtgläubig", "linksgläubig", "heidnisch", 2, 64, 0, "no",0, 0,0,0);
        Question q65 = new Question("Wann gab es die letzte Hinrichtung wegen Hexerei in England?", "1685", "1495", "1895", "1817", 1, 65, 0, "no",0, 0,0,0);
        Question q66 = new Question("Welcher Staat der USA gilt als Heimat der Mormonen?", "Utah", "Texas", "Iowa", "Wisconsin", 1, 66,0, "no",0, 0,0,0);

        //Erotik
        Question q67 = new Question("Wer einer Rumänin oder einem Rumänen seine Zuneigung mitteilen will, sagt: ", "Te Amo", "Te Iubiu", "Ti Amo", "Te iubesc", 4, 15,0, "no",0, 0,0,0);
        Question q68 = new Question("Wie nannten die Römer ihre Göttin der Liebe?", "Juno", "Venus", "Aurora", "Amor", 3, 16,0, "no",0, 0,0,0);
        Question q69 = new Question("Treue: Wie viel Prozent der Frauen gehen häufig fremd?", "25", "20", "30", "35", 1, 17,0, "no",0, 0,0,0);
        Question q70 = new Question("Was ist ein Aphrodisiakum? ", "Französische Liebesgöttin", "Luststeigerungsmittel", "Verhüttungsmittel", "Aphrodites Haare", 2, 11, 0, "no",0, 0,0,0);
        Question q71 = new Question("Was ist ein Diaphragma?", "Verhüttungsmittel für Frauen", "Ein Intimschmuck", "Kondom", "gemoetrische Form mit 7 Kanten und 8 Ecken", 1, 12, 0, "no",0, 0,0,0);
        Question q72 = new Question("Wie hieß der Liebesgott der Griechen?", "Ares", "Amor", "Eros", "Eos", 3, 13, 0, "no",0, 0,0,0);
        Question q73 = new Question("Wie setzten die alten Chinesen die Pfauenfeder beim Liebesspiel ein? ", "Sie legen sie beim Akt unter sich ", "Die Akupunkturpunkte werden stimuliert ", "Haut wurde gestreichelt ", "Damit sorgte man für Kühle Luft ", 2, 14,0, "no",0, 0,0,0);
        Question q74 = new Question("Was bezeichnet gesteigerten Geschlechtstrieb bei Frauen?", "Androidie", "Andromanie", "Androphobie", "Androgynie", 2, 15,0, "no",0, 0,0,0);
        Question q75 = new Question("Wann ist für üblich der Tag der Liebe?", "14.02", "21.03", "06.06", "12.06", 1, 16,0, "no",0, 0,0,0);
        Question q76 = new Question("Welche Blume ist verbildlicht die Liebe?", "Tulpe", "Nelke", "Orchidee", "Rose", 1, 17,0, "no",0, 0,0,0);
        Question q77 = new Question("Liebesgedicht der Araber heisst?", "Gazelle", "Gaze", "Gaz", "Gazhel", 4, 12, 0, "no",0, 0,0,0);

        Question q78= new Question("Zusammen mit welchem Land veranstaltete Österreich die Fußball-Europameisterschaft 2008?", "England", "Deutschland", "Tschechien", "Schweiz", 4, 15,0, "no",0, 0,0,0);
        Question q79 = new Question("Was wird beim Fußball vom Schiedsrichter als Foul gepfiffen?", "Feuermelder", "Warnblinker", "Alermmelder", "Notbremse", 4, 16,0, "no",0, 0,0,0);
        Question q80 = new Question("Welche dieser Personen ist kein berühmter Sportler?", "Zinedine Zidane", "Usain Bolt", "Bill Gates", "Ronaldo", 3, 17,0, "no",0, 0,0,0);
        Question q81 = new Question("Wie hiess der Olympionike, der Gold bei den Sommerspielen 1920 und bei Winterspielen 1932 gewann?", "Mark Medlock", "Eddie Eagan", "Simon Amman", "Paavo Nurmi", 2, 11, 0, "no",0, 0,0,0);
        Question q82 = new Question("Wie nennt man beim Dartsport die einzelnen Spiele?", "Legs", "Heads", "Feed", "Arm", 1, 12, 0, "no",0, 0,0,0);
        Question q83 = new Question("In welcher Sportart gibt es eine Fallschule?", "Fussball", "Judo", "Basketball", "Badminton", 2, 13, 0, "no",0, 0,0,0);
        Question q84 = new Question("Wodurch fallen Hooligans auf?", "Ihre musik", "Hosen", "Taschenmesser", "Ihr aggressives Verhalten", 4, 14,0, "no",0, 0,0,0);
        Question q85 = new Question("Welchen Fußballer nennt man den Kaiser?", "Franz Beckenbauer", "Ronaldinho", "Messi", "Cristiano Ronaldo", 1, 15,0, "no",0, 0,0,0);
        Question q86 = new Question("Mit welcher Aktion wird das Spiel beim Eishockey eröffnet?", "Pucky", "Anstoss", "Bully", "Einwurf", 3, 16,0, "no",0, 0,0,0);
        Question q87 = new Question("Wie wird der mehrfache italienische Fußballmeister Juventus Turin liebevoll genannt?", "Alte Dame", "Der Kaiser des Nordens", "Pizzaiolo Nummer 1", "Bianco Champions", 1, 17,0, "no",0, 0,0,0);
        Question q88 = new Question("Bei welcher Sportart findet man ein sogenanntes Wicket?", "Polo", "Curling", "Cricket", "Dart", 3, 12, 0, "no",0, 0,0,0);

        Question q89= new Question("Was bedeuted DB ausgesprochen?", "Datenbank", "Die Bulls", "Definitiv bestanden", "Durchbeissen", 1, 15,0, "no",0, 0,0,0);
        Question q90 = new Question("Wann war der Mauerfall in Deutschland?", "1990", "1989", "1993", "1992", 2, 16,0, "no",0, 0,0,0);
        Question q91 = new Question("Wie nennt man eine Kreuzung zwischen Löwe und Tiger", "Tiwe", "Tigerilöw", "Löwger", "Liger", 4, 17,0, "no",0, 0,0,0);
        Question q92 = new Question("Welche der gennanten Programmier Sprachen ist die älteste?", "ASP", "PERL", "C#", "JAVA", 2, 11, 0, "no",0, 0,0,0);
        Question q93 = new Question("Welches der Folgenden Städte hat mehr Winwohner", "Aarau", "Basel", "Istanbul", "Berlin", 3, 12, 0, "no",0, 0,0,0);
        Question q94 = new Question("Welche Religion hat die meisten Anhänger?", "Christentum", "Buddhismus", "Islam", "Hiduismus", 1, 13, 0, "no",0, 0,0,0);
        Question q95 = new Question("Was muss man kaufen wenn man einer Frau ein Antrag machen will?", "Ring", "Ball", "Rhabarber", "Designer Kleidung", 1, 14,0, "no",0, 0,0,0);
        Question q96 = new Question("Wo fand die Fußball-EM 2016 statt?", "Andorra", "Belgien", "Italien", "Frankreich", 4, 15,0, "no",0, 0,0,0);




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
        addQuestion(q21);
        addQuestion(q22);
        addQuestion(q23);
        addQuestion(q24);
        addQuestion(q25);
        addQuestion(q26);
        addQuestion(q27);
        addQuestion(q28);
        addQuestion(q29);
        addQuestion(q30);
        addQuestion(q31);
        addQuestion(q32);
        addQuestion(q33);
        addQuestion(q34);
        addQuestion(q35);
        addQuestion(q36);
        addQuestion(q37);
        addQuestion(q38);
        addQuestion(q39);
        addQuestion(q40);
        addQuestion(q41);
        addQuestion(q42);
        addQuestion(q43);
        addQuestion(q44);
        addQuestion(q45);
        addQuestion(q46);
        addQuestion(q47);
        addQuestion(q48);
        addQuestion(q49);
        addQuestion(q50);
        addQuestion(q51);
        addQuestion(q52);
        addQuestion(q53);
        addQuestion(q54);
        addQuestion(q55);
        addQuestion(q56);
        addQuestion(q57);
        addQuestion(q58);
        addQuestion(q59);
        addQuestion(q60);
        addQuestion(q61);
        addQuestion(q62);
        addQuestion(q63);
        addQuestion(q64);
        addQuestion(q65);
        addQuestion(q66);
        addQuestion(q67);
        addQuestion(q68);
        addQuestion(q69);
        addQuestion(q70);
        addQuestion(q71);
        addQuestion(q72);
        addQuestion(q73);
        addQuestion(q74);
        addQuestion(q75);
        addQuestion(q76);
        addQuestion(q77);
        addQuestion(q78);
        addQuestion(q79);
        addQuestion(q80);
        addQuestion(q81);
        addQuestion(q82);
        addQuestion(q83);
        addQuestion(q84);
        addQuestion(q85);
        addQuestion(q86);
        addQuestion(q87);
        addQuestion(q88);
        addQuestion(q89);
        addQuestion(q90);
        addQuestion(q91);
        addQuestion(q92);
        addQuestion(q93);
        addQuestion(q94);
        addQuestion(q95);
        addQuestion(q96);



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
        cv.put(QuestionsTable.COLUMN_FAILS, question.getAmountOfFailures());
        cv.put(QuestionsTable.COLUMN_FIFTY_JOKER, question.getFiftyJoker());
        cv.put(QuestionsTable.COLUMN_ADD_TIME_JOKER, question.getAddTime());
        cv.put(QuestionsTable.COLUMN_SWITCH_JOKER, question.getSwitchQuestion());
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
                question.setAmountOfFailures(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_FAILS)));
                question.setFiftyJoker(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_FIFTY_JOKER)));
                question.setAddTime(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ADD_TIME_JOKER)));
                question.setSwitchQuestion(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_SWITCH_JOKER)));
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

    public void updateJoker(int currentLvl, int fiftyJokerNew, int fiftyJokerOld, int addTimeJokerNew, int addTimeJokerOld, int switchJokerNew, int switchJokerOld ){
        db=getWritableDatabase();
        if (currentLvl%11==0){
            currentLvl=currentLvl++;
            String query = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_FIFTY_JOKER+
                    " = '"+1+"' WHERE "+QuestionsTable._ID+ " = '"+currentLvl+"'"+
                    " AND "+ QuestionsTable.COLUMN_FIFTY_JOKER+ " = '"+fiftyJokerOld+"'";
            Log.d(TAG, "updateRating: query "+query);
            Log.d(TAG, "updateName: Setting Fifty fifty Joker Button to "+fiftyJokerNew);
            db.execSQL(query);

            String query1 = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_ADD_TIME_JOKER+
                    " = '"+1+"' WHERE "+QuestionsTable._ID+ " = '"+currentLvl+"'"+
                    " AND "+ QuestionsTable.COLUMN_ADD_TIME_JOKER+ " = '"+addTimeJokerOld+"'";
            Log.d(TAG, "updateRating: query "+query);
            Log.d(TAG, "updateName: Setting Time Joker Button to "+addTimeJokerNew);
            db.execSQL(query1);

            String query2 = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_SWITCH_JOKER+
                    " = '"+1+"' WHERE "+QuestionsTable._ID+ " = '"+currentLvl+"'"+
                    " AND "+ QuestionsTable.COLUMN_SWITCH_JOKER+ " = '"+switchJokerOld+"'";
            Log.d(TAG, "updateRating: query "+query);
            Log.d(TAG, "updateName: Setting Switch Joker Button to "+switchJokerNew);
            db.execSQL(query2);
        } else {
            String query = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_FIFTY_JOKER+
                    " = '"+fiftyJokerNew+"' WHERE "+QuestionsTable._ID+ " = '"+currentLvl+"'"+
                    " AND "+ QuestionsTable.COLUMN_FIFTY_JOKER+ " = '"+fiftyJokerOld+"'";
            Log.d(TAG, "updateRating: query "+query);
            Log.d(TAG, "updateName: Setting Fifty fifty Joker Button to "+fiftyJokerNew);
            db.execSQL(query);

            String query1 = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_ADD_TIME_JOKER+
                    " = '"+addTimeJokerNew+"' WHERE "+QuestionsTable._ID+ " = '"+currentLvl+"'"+
                    " AND "+ QuestionsTable.COLUMN_ADD_TIME_JOKER+ " = '"+addTimeJokerOld+"'";
            Log.d(TAG, "updateRating: query "+query);
            Log.d(TAG, "updateName: Setting Time Joker Button to "+addTimeJokerNew);
            db.execSQL(query1);

            String query2 = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_SWITCH_JOKER+
                    " = '"+switchJokerNew+"' WHERE "+QuestionsTable._ID+ " = '"+currentLvl+"'"+
                    " AND "+ QuestionsTable.COLUMN_SWITCH_JOKER+ " = '"+switchJokerOld+"'";
            Log.d(TAG, "updateRating: query "+query);
            Log.d(TAG, "updateName: Setting Switch Joker Button to "+switchJokerNew);
            db.execSQL(query2);
            updateNextQuestion(currentLvl+1,  fiftyJokerNew, addTimeJokerNew,switchJokerNew);
        }

    }

    private void updateNextQuestion(int nextLvl, int fiftyJokerNew, int addTimeJokerNew,int switchJokerNew) {
        db=getWritableDatabase();
        String query = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_FIFTY_JOKER+
                " = '"+fiftyJokerNew+"' WHERE "+QuestionsTable._ID+ " = '"+nextLvl+"'"+
                " AND "+ QuestionsTable.COLUMN_FIFTY_JOKER+ " = '"+0+"'";
        Log.d(TAG, "updateRating: query "+query);
        Log.d(TAG, "updateName: Setting Fifty fifty Joker Button to "+fiftyJokerNew);
        db.execSQL(query);

        String query1 = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_ADD_TIME_JOKER+
                " = '"+addTimeJokerNew+"' WHERE "+QuestionsTable._ID+ " = '"+nextLvl+"'"+
                " AND "+ QuestionsTable.COLUMN_ADD_TIME_JOKER+ " = '"+0+"'";
        Log.d(TAG, "updateRating: query "+query);
        Log.d(TAG, "updateName: Setting Time Joker Button to "+addTimeJokerNew);
        db.execSQL(query1);

        String query2 = "UPDATE "+ QuestionsTable.TABLE_NAME +" SET "+QuestionsTable.COLUMN_SWITCH_JOKER+
                " = '"+switchJokerNew+"' WHERE "+QuestionsTable._ID+ " = '"+nextLvl+"'"+
                " AND "+ QuestionsTable.COLUMN_SWITCH_JOKER+ " = '"+0+"'";
        Log.d(TAG, "updateRating: query "+query);
        Log.d(TAG, "updateName: Setting Switch Joker Button to "+switchJokerNew);
        db.execSQL(query2);
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



   public boolean dropTable(Context context){

        String query = "DROP TABLE "+QuestionsTable.TABLE_NAME;
        db.execSQL(query);

        onCreate(db);


        return true;
    }





}
