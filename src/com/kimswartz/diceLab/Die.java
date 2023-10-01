package com.kimswartz.diceLab;
import java.util.Random;

public class Die {

    private final static int numberOfSides = 6;

    public int rollDice() {
        int result;
        Random randomNumberGenerator = new Random();
        result = randomNumberGenerator.nextInt(numberOfSides) + 1;
        return result;
    }
}
