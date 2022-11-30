package tutorial;

import java.util.Scanner;

public class initializeGame{
    Player player;
    Gameboard gameboard;
    Deck deck;

    public initializeGame(Gameboard gameboard, Deck deck){
        this.gameboard = gameboard;
        this.deck = deck;

        Scanner input = new Scanner(System.in);

        int numplayers;

        // initialize number of players
        do{
            System.out.println("Enter number of players, between 1-4");
            numplayers = input.nextInt();
            input.nextLine();
        } while (numplayers < 1 || numplayers > 4);

        // Initialize username of players
        for (int i = 0; i < numplayers; i++){
            System.out.print("Enter username for player " + (i + 1) + ": ");
            player = new Player(input.nextLine(), 1500, 0, "", i);
        }
    }
}