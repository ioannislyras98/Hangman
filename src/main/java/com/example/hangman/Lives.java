package com.example.hangman;

public class Lives {
    private static int lives;
    public static int RemoveLives(){
        lives=lives-1;
        return lives;
    }
    public static int StartingLives(){
        lives = 6;
        return lives;
    }
}
