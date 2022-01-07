package com.example.hangman;

import java.util.ArrayList;

public class Points {
    private static int points;
    public static int StartingPoints(){
        points = 0;
        return points;
    }
    public static int Points(int position, String letter, ArrayList<percentageletterposition> percentageletterposition){
        double percentage = 0.00;
        for ( percentageletterposition plp : percentageletterposition) {
            char c =letter.charAt(0);
            if(plp.getletter()== c && position == plp.getposition()){
                percentage = plp.getpercentage();
                break;
            }
        }
        if(percentage >= 60.00){
            points = points+5;
        }
        else if(percentage<60.00 && percentage>=40.00){
            points = points+10;
        }
        else if(percentage<40.00 && percentage>=25.00){
            points = points+15;
        }
        else if(percentage < 25.00){
            points = points+30;
        }
        return points;
    }
    public static int RemovePoints(){
        points=points-15;
        if(points<0){
            points =0;
        }
        return points;
    }
}
