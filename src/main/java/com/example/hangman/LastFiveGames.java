package com.example.hangman;

import java.util.ArrayList;

public class LastFiveGames {
    private static ArrayList<RoundStats> lastfivegames = new ArrayList<>();
    public void addlastfivegames(String word, int tries , int resultgame, int highscore){
            if(lastfivegames.size()==5){
                lastfivegames.remove(0);
            }
        lastfivegames.add(new RoundStats(resultgame , word , tries, highscore));
    }

    public static ArrayList<RoundStats> getlastfivegames() {
        return lastfivegames;
    }
}
