package com.kimswartz.diceLab;
import java.util.Random;

public class Die {

    // We set six sides
    private final static int numberOfSides = 6;

    // We random our six sided-dice, count from 1 so it won´t show 0-5. We want it to be 1-6.
    public int roll() {
        int result;
        Random randomNumberGenerator = new Random();
        result = randomNumberGenerator.nextInt(numberOfSides) + 1;

        return result;
    }
}
