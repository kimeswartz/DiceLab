package com.kimswartz.diceLab;

import static com.kimswartz.diceLab.Scanner.MyScanner.*;

import java.util.ArrayList;

public class GamePlay {

    ArrayList<Player> ListOfPlayers = new ArrayList<>(); // We save our players in an ArrayList

    int numberOfPlayers; // User input amount of players value in game step #1.
    Die dice = new Die();
    int noOfDice; // User input amount of dice value in game step #2.
    int score = 0; // We set our score variable to count from 0 for our playDice() method.

    // Our method to call the entire game in Main.
    public void runGame() {

        int choice;

        while (true) {
            try {
                displayMenu();
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You chose option 1: Add players!");
                        addPlayers();
                        break;
                    case 2:
                        System.out.println("You chose option 2: Enter number of dice!");
                        addDice();
                        break;
                    case 3:
                        System.out.println("You chose option 3: Play the game!");
                        rollDice();
                        break;

                    case 4:
                        System.out.println("You chose option 4: See player scores!");
                        getTotalScore();
                        break;

                    case 5:
                        System.out.println("You chose option 5: Reveal the winner!");
                        getWinners();
                        break;

                    case 6:
                        System.out.println("You chose option 6: Exiting the game");
                        scan.close();
                        System.exit(0);

                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option!");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Oops! Invalid input. Try again!");
                scan.next();
            }
        }
    }

    // Our method to display the switch menu with user options.
    public void displayMenu() {
        System.out.println("Menu Options:");
        System.out.println("1. Add players");
        System.out.println("2. Add dice");
        System.out.println("3. Play!");
        System.out.println("4. See score");
        System.out.println("5. Reveal winner(s)");
        System.out.println("6. Exit");
    }

    // #1 Our method to add amount of players and names.
    public void addPlayers() {
        System.out.println("Enter number of (at least two) players:");
        numberOfPlayers = scan.nextInt();

        // If user enter less than 2 players.
        if (numberOfPlayers < 2) {
            System.out.println("Sorry! You must enter at least two players, please try again!");
            addPlayers();
        } else {
            System.out.println("Great! You are now " + numberOfPlayers + " players!");

            // Input player names. For loop run until the number of players is reached.
            for (int i = 1; i <= numberOfPlayers; i++) {

                System.out.print("Enter the name of player " + i + ": ");
                String playerName = scan.next();
                ListOfPlayers.add(new Player(playerName));
                System.out.println(playerName + " is added to the game!");
            }
        }
    }

    // #4 Our method to roll the dice.
    public void addDice() {
        System.out.println("Enter number of dice (at least 2) for each player:");

        // If number of dice is less than 2' we will ask user to try again.
        try {
            noOfDice = scan.nextInt();

            if (noOfDice < 2) {
                System.out.println("Sorry, it seems like you chose less than two dice, try again!");
                addDice();
            } else {
                System.out.println("All set! Each player has " + noOfDice + " dice!");
            }

            // if user input is a string we will ask to try again.
        } catch (java.util.InputMismatchException e) {
            System.out.println("Oops! Invalid input, try again!");
            scan.next();
        }
    }

    // #5 Roll the dice and play the game.
    public void rollDice() {
        if (ListOfPlayers.isEmpty()) {
            System.out.println("You must enter players first");
        } else {

            // After checking if there are any players added, we for-loop the Dice object as many times as noOfDice is set, and add the result to the player score.

            for (Player player : ListOfPlayers) {

                for (int i = 1; i <= noOfDice; i++) {
                    int currentScore = score + dice.roll();

                    System.out.printf(player.getName() + " rolled dice no'%d", i);
                    player.setTotalScore(currentScore);
                    System.out.println(" and scored " + currentScore + " points");
                }
            }
        }
    }

    // #6 See the total score
    public void getTotalScore() {

        // We start to check if there are any players, and the loop the entire Player ArrayLst to show each name and total score.
        if (ListOfPlayers.isEmpty()) {
            System.out.println("You must enter players, dice and play the game first!");
        } else {
            for (Player player : ListOfPlayers) {
                System.out.println(player.getName() + "´s total score is: " + player.getTotalScore());
            }
        }
    }

    // #7 Reveal the winner(s)
    public void getWinners() {

        // We start to check if user has added players.
        if (ListOfPlayers.isEmpty()) {
            System.out.println("You must enter players, dice and play the game first!");
        } else {

            // See more info below.
            /*
            1. We assume all players in ListOfPlayers are winners by setting a low masScore.
            2. We create another ArrayList named winners, and add our players in it by looping our players list.
            All players are added to the winners ArrayList since they all have higher score than -1.
            3. If there´s only one winner in winners ArrayList he will be announced as the winner. If there are several winners in the list,
            these will be presented as a tie.
             */

            int maxScore = -1;

            // Find the player with the highest score
            for (Player player : ListOfPlayers) {
                if (player.getTotalScore() > maxScore) {
                    maxScore = player.getTotalScore();
                }
            }

            // Determine the winner(s) and add all players to the winners ArrayList.
            ArrayList<Player> winners = new ArrayList<>();
            for (Player player : ListOfPlayers) {
                if (player.getTotalScore() == maxScore) {
                    winners.add(player);
                }
            }

            // Announce the winner(s) from winners ArrayList.
            if (winners.size() == 1) {
                System.out.println(winners.get(0).getName() + " wins with a score of " + maxScore);
            } else {
                System.out.println("It's a tie between the following players:");
                for (Player winner : winners) {
                    System.out.println(winner.getName() + " with a score of " + maxScore);
                }
            }

        }

    }

}