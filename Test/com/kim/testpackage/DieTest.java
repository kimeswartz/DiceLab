package com.kim.testpackage;

import com.kimswartz.diceLab.Die;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    @Test

    public void testRollingInRange() {

        Die dice = new Die();

        for (int i = 0; i < 1000; i++) {
            int result = dice.roll();
            assertTrue(result >= 1 && result <= 6, "Dice roll result out of range " + result);
        }

    }

}