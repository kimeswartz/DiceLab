package com.kimswartz.diceLab;
import static com.kimswartz.diceLab.Scanner.MyScanner.*;

import java.util.ArrayList;

public class GamePlay {

    // #1 We store players in an ArrayList:
    ArrayList<Player> ListOfPlayers = new ArrayList<>();

    // #2: We create a six sided die object for players to roll:
    private Die dice = new Die();


    // #3: Our method to let user add players and store it in our ArrayList:
    public void CreatePlayers() {

        do {
            System.out.println("Please enter the first player's name");
            String playerName = scan.nextLine();
            Player newPlayer = new Player(playerName);
            ListOfPlayers.add(newPlayer);

            System.out.println("Great, " + playerName + " is added! Would you like to add another player? Enter Y / N");
        } while (scan.nextLine().equalsIgnoreCase("y"));

    }

    // #4: Our method to start the game by letting rolling the dice:
    protected void PlayDice() {

        /*  We for-loop through our ArrayList: ListOfPlayers to add and save the dice values */
        for (Player player : ListOfPlayers) {

            int firstRoll = dice.roll();
            int secondRoll = dice.roll();
            int currentScore = firstRoll + secondRoll;

            System.out.println(player.getName() + " rolled " + firstRoll + " and " + secondRoll);

            player.setTotalScore(currentScore); // We save the value to setTotalScore-method in Player class

            System.out.println(player.getName() + " scored for a total of: " + player.getTotalScore() + " points!");
        }
    }

    // #5 Our method to determine and announce the winner:
    public void theWinner() {

        // We assume the 1:st player in our ArrayList is the initial winner.
        Player winner = ListOfPlayers.get(0);

        for (Player player : ListOfPlayers) {
            if (player.getTotalScore() > winner.getTotalScore()) {
                winner = player; // Update the winner if a player has a higher score.
            }
        }
        System.out.println("The winner is: " + winner.getName() + " with a total score of " + winner.getTotalScore() + " points!");


        /*

        else {
                System.out.println("It's a tie! Both players have a score of " + winner.getTotalScore() + ".");
            }


         */

    }

}