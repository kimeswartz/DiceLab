package com.kimswartz.diceLab;

public class Player {

    private String name;
    private int totalScore;


    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Score:

    public int getTotalScore() {
        return totalScore;
    }

    void setTotalScore(int score) {
        totalScore += score;
    }


}
