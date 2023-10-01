package com.kimswartz.diceLab;

import org.w3c.dom.ls.LSOutput;

import static com.kimswartz.diceLab.Scanner.MyScanner.*;

import java.util.ArrayList;

public class GamePlay {

    ArrayList<Player> ListOfPlayers = new ArrayList<>();

    // 3: Empty int´s for players and dice
    int numberOfPlayers;
    int numberOfDice;

    // 4: Create a six sided die
    private Die dice = new Die();

    public void CreatePlayers() {

        // #1 User input number of players:
        System.out.println("Would you like to add players? Enter Y / N");
        String answer = scan.nextLine();

        while (answer.equalsIgnoreCase("y")) {
            System.out.println("Enter the player name: ");
            String playerName = scan.nextLine();
            Player newPlayer = new Player(playerName);
            ListOfPlayers.add(newPlayer);

            System.out.println("Great, " + playerName + " is added! Would you like to add another player? Enter Y / N");
            answer = scan.nextLine();
        }
    }

    protected void PlayDice() {

        for (Player player : ListOfPlayers) {
            int firstRoll = dice.roll();
            int secondRoll = dice.roll();

            int currentScore = firstRoll + secondRoll;

            System.out.println(player.getName() + " rolled " + firstRoll + " and " + secondRoll);

            player.setTotalScore(currentScore);

            System.out.println(player.getName() + " scored for a total of: " + player.getTotalScore() + " points!");


        }

    }

    public void theWinner () {

        for (Player player : ListOfPlayers) {
            System.out.println(player.getName() + " has total" + player.getTotalScore());
        }

        }

    }









