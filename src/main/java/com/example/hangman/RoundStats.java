package com.example.hangman;

/**
 * This class is responsible for creating an object RoundStats with 4 values.
 * <p>
 * @author johnlyras98
 */
public class RoundStats{
    private int wins;
    private int defeats;
    private String selectedwords;
    private int tries;
    private int highscore;
    /**
     * Class constructor.
     * @author johnlyras98
     * @param wins
     * @param selectedwords
     * @param highscore
     * @param tries
     * @param defeats
     */
    public RoundStats(int wins, int defeats, String selectedwords, int tries, int highscore){
        this.wins = wins;
        this.defeats = defeats;
        this.selectedwords = selectedwords;
        this.tries = tries;
        this.highscore = highscore;
    }

    /**
     * Getter for wins from the object RoundStats
     * @author johnlyras98
     * @return int wins
     */
    public int getwins(){
        return wins;
    }
    /**
     * Getter for defeats from the object RoundStats
     * @author johnlyras98
     * @return int defeats
     */
    public int getdefeats(){
        return defeats;
    }
    /**
     * Getter for selectedwords from the object RoundStats
     * @author johnlyras98
     * @return selectedwords
     */
    public String getselectedwords(){
        return selectedwords;
    }
    /**
     * Getter for tries from the object RoundStats
     * @author johnlyras98
     * @return tries
     */
    public int gettries(){
        return tries;
    }
    /**
     * Getter for highscore from the object RoundStats
     * @author johnlyras98
     * @return highscore
     */
    public int gethighscore(){
        return highscore;
    }
}
