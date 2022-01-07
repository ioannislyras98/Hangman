package com.example.hangman;

import java.io.Serializable;

public class RoundStats implements Serializable {
    private int wins;
    private String selectedwords;
    private int tries;
    private int highscore;
    public RoundStats(int wins, String selectedwords, int tries, int highscore){
        this.wins = wins;
        this.selectedwords = selectedwords;
        this.tries = tries;
        this.highscore = highscore;
    }
    public int getwins(){
        return wins;
    }
    public String getselectedwords(){
        return selectedwords;
    }
    public int gettries(){
        return tries;
    }
    public int gethighscore(){
        return highscore;
    }
}
