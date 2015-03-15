package com.example.hai.magiccounter;

/**
 * Created by Hai on 29/11/2014.
 */
public class Player {
    private int score;
    private String name;

    public Player(int score, String name){
        this.score = score;
        this.name = name;
    }

    public void incrementScore(){
        this.score++;
    }

    public String getScore(){
        return String.format("%d", score);
    }

    public String getName(){
        return name;
    }

    public void decrementScore(){
        this.score--;
    }
}
