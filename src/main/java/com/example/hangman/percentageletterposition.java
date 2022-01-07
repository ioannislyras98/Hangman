package com.example.hangman;

import java.io.Serializable;

public class percentageletterposition implements Serializable {
    private double percentage;
    private char letter;
    private int position;
    public percentageletterposition(double percentage, char letter, int position){
        this.percentage = percentage;
        this.letter = letter;
        this.position = position;
    }
    public Double getpercentage(){
        return percentage;
    }
    public char getletter(){
        return letter;
    }
    public int getposition(){
        return position;
    }
    @Override
    public String toString() {
        return (this.getpercentage()+"% " +
                 this.getposition()+ " " +
                 this.getletter()
                );
    }
}
