package com.example.hangman;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class dictionary {
    private ArrayList<String> dictionaryWords = new ArrayList<String>();

    public void storeDictionary(String word) {
         dictionaryWords.add(word);
    }
    public int DictionaryLength(){return dictionaryWords.size();}
    public ArrayList<String> showDictionaryWords(){
        return(dictionaryWords);
    }
    public void deleteDictionary(){
        dictionaryWords.clear();
    }
    public ArrayList<String> statsDictionary(){
        ArrayList<String> stats = new ArrayList<String>();
        double six = 0;
        double sevennine = 0;
        double tenandmore = 0;
        for (int counter = 0; counter < dictionaryWords.size(); counter++) {
            if(dictionaryWords.get(counter).length()==6){
               six = 1.0 + six;
            }
            else if(dictionaryWords.get(counter).length()>6&&dictionaryWords.get(counter).length()<=9) {
                sevennine = 1.0 + sevennine;
            }
            else if(dictionaryWords.get(counter).length()>=10){
                tenandmore = 1.0 + tenandmore;
            }
            }
        six=six*100/dictionaryWords.size();
        BigDecimal bd = new BigDecimal(six).setScale(1, RoundingMode.HALF_UP);
        six = bd.doubleValue();
        sevennine=sevennine*100/dictionaryWords.size();
        bd = new BigDecimal(sevennine).setScale(1, RoundingMode.HALF_UP);
        sevennine = bd.doubleValue();
        tenandmore=tenandmore*100/dictionaryWords.size();
        bd = new BigDecimal(tenandmore).setScale(1, RoundingMode.HALF_UP);
        tenandmore = bd.doubleValue();
        System.out.println("six:"+six+" sevennine:"+sevennine+" tenandmore"+tenandmore);
        stats.add(Double.toString(six)+"%");
        stats.add(Double.toString(sevennine)+"%");
        stats.add(Double.toString(tenandmore)+"%");
        return stats;
    }
    public String randomWord() {
        if(dictionaryWords.isEmpty()) return "";
        return dictionaryWords.get((int)(Math.random()*dictionaryWords.size()));
    }
}
