package com.example.quiz;

import java.util.ArrayList;

public class Fragen {

    ArrayList<String[]> fragen;

    public Fragen (){
        fragen = new ArrayList<>(2);
        listeFuellen();
    }

    private void listeFuellen(){
        String[] frage1 = new String[5];
        frage1[0] = "Was ist Java?";
        frage1[1] = "Objectorientierte Sprache";
        frage1[2] = "Eine Kaffeesorte";
        frage1[3] = "EU-Mitgliedstaat";
        frage1[4] = "Eine Fluggesellschaft";


        String[] frage2 = new String[5];
        frage2[0] = "Welches Land möchstest du?";
        frage2[1] = "Türkei";
        frage2[2] = "Island";
        frage2[3] = "Schweden";
        frage2[4] = "USA";


        fragen.add(0, frage1);
        fragen.add(1, frage2);


    }

    public ArrayList<String[]> getFragen(){
        return fragen;
    }


}
