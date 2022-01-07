package com.example.hangman;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class listPossibleWords {
    private final ArrayList<String> PossibleWords = new ArrayList<>();
    private final ArrayList<percentageletterposition> Percentages = new ArrayList<>();
    private final ArrayList<Integer> numbers = new ArrayList<>();
    private int len = 0;
    public void storewords(@NotNull ArrayList<String> d, int length) {
        len = length;
        PossibleWords.clear();
         for(String i: d){
             if((i.length() == length)== true){
                 PossibleWords.add(i);
             }
         }
    }
    public void correctletter(char ch, int number){
        numbers.add(number);
        for(int j = 0; j<PossibleWords.size(); j++){
            char character = PossibleWords.get(j).charAt(number-1);
            if((character!=ch)==true){
                PossibleWords.remove(j);
                j--;
            }
        }
    }
    public void falseletter(char ch, int number){
        System.out.println(PossibleWords.size());
        for(int j = 0; j<PossibleWords.size(); j++){
            char character = PossibleWords.get(j).charAt(number-1);
            if((character==ch)==true){
                PossibleWords.remove(j);
                j--;
            }
        }
    }
    public void emptylist(){
        Percentages.clear();
        numbers.clear();
    }
    public ArrayList<percentageletterposition> statistics(){
        Percentages.clear();
        Hashtable<Character, Double> table = new Hashtable<Character, Double>();
        double x;
        for(int i = 1; i<=len; i++){
            int flag=0;
            for(int j=1; j<= numbers.size(); j++) {
                if (numbers.get(j-1)==i) {
                    flag=1;
                }
            }
            if(flag==1)continue;
                    for(int j = 0; j<PossibleWords.size(); j++){
                        char character = PossibleWords.get(j).charAt(i-1);
                        if (table.containsKey(character)) {
                            x = table.get(character)+1.00;
                        }
                        //if letter is not already in table
                        else {
                            x=1.00;
                        }
                        table.put(character, x);
                    }
            Iterator it = table.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                char m = (Character) pair.getKey();
                double k = ((Double) pair.getValue()).doubleValue();
                k = k * 100 / PossibleWords.size();
                BigDecimal bd = new BigDecimal(k).setScale(1, RoundingMode.HALF_UP);
                k = bd.doubleValue();
                    Percentages.add(new percentageletterposition(k, m , i));
                it.remove(); // avoids a ConcurrentModificationException
            }
            table.clear();
        }
        Percentages.sort(Comparator.comparing(percentageletterposition::getpercentage).reversed());
        return Percentages;
    }
    public ArrayList<percentageletterposition> showstatistics(){
        return Percentages;
    }
}
