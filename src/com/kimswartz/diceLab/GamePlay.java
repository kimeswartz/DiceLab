package com.kimswartz.diceLab;
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
        System.out.println("Would you like to create a player? Enter Y / N");
        String answer = scan.nextLine();

        while (answer.equalsIgnoreCase("y")){
            System.out.println("Enter the player name: ");
            String playerName = scan.nextLine();
            Player newPlayer = new Player(playerName);
            ListOfPlayers.add(newPlayer);

            System.out.println("Great, " + playerName + " is added! Would you like to add another player? Enter Y / N");
            answer = scan.nextLine();
        }


    }
}
