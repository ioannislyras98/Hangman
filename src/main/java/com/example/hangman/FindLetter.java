package com.example.hangman;

public class FindLetter {
   public static boolean find(String word, String letter, int position){
       char l = letter.charAt(0);
       char charat = word.charAt(position);
       if(charat == l) {
           return true;
       }
       else{
           return false;
       }
   }
}
