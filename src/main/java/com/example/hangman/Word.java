package com.example.hangman;

public class Word {
    private String showWord = new String();
    private String hiddenWord = new String();
    public void showSave(String w){
        showWord = w;
    }
    public void hiddenSave(String w){
        hiddenWord = w;
    }
    public String hiddenWord(){
        return hiddenWord;
    }
    public String showWord(){
        return showWord;
    }
}
