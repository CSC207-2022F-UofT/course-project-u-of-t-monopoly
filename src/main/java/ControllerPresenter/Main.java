package ControllerPresenter;

import UseCase.*;
import Entity.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        initializeGame ig = new initializeGame(gb);
        ig.initialize();
        ArrayList<Player> players = gbf.getPlayers();
        GameBoardPresenter gbp = new GameBoardPresenter();
        gbp.presentBoard(players);

        UserCheckGameEnd ucge = new UserCheckGameEnd();
        while (!ucge.CheckGameEnd(gb)){
            for(Player player : gbf.getPlayers()){
                Controller controller = new Controller(player, gb);
                controller.PlayerTakesTurn();
                Thread.sleep(5000);
            }
//            SpentTurnsInJail stij = new SpentTurnsInJail()
        }
        System.exit(0);



    }
}
