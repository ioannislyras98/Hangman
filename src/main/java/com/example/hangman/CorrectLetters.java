package com.example.hangman;

public class CorrectLetters {
    private static int correctLetters;
    public static int AddCorrectLetters(){
        correctLetters = correctLetters + 1;
        return correctLetters;
    }
    public static int StartingCorrectLetters(){
        correctLetters = 0;
        return correctLetters;
    }
}
