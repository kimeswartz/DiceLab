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

    public void theWinner() {

        Player winner = ListOfPlayers.get(0); // Assume the first player is the initial winner.

        for (Player player : ListOfPlayers) {
            if (player.getTotalScore() > winner.getTotalScore()) {
                winner = player; // Update the winner if a player has a higher score.
            }
        }

        System.out.println("The winner is: " + winner.getName() + " with a total score of " + winner.getTotalScore());

    }

}









