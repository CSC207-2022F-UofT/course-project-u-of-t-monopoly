package ControllerPresenter;


import Entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import Entity.Player;
import Entity.GameBoard;
import Entity.Deck;
import ControllerPresenter.InitialPresenter;
import UseCase.GameBoardFactory;
import UseCase.PlayerFactory;

public class initializeGame {
    Player player;
    GameBoard gameboard;
    //Deck deck;

    public initializeGame(GameBoard gameBoard) {
        this.gameboard = gameBoard;
        // this.deck = deck;
    }

    public void initialize() {

        ArrayList<Integer> lst = new ArrayList<>(1);
        lst.add(0);
        InitialPresenter ip = new InitialPresenter();
        ip.presentNum(lst);

        while (lst.get(0) == 0) {
            System.out.println("");
        }
        int numplayers = lst.get(0);

//        GameBoardFactory gbf = new GameBoardFactory();
//        GameBoard gb = gbf.getGameBoard();
        for (int i = 0; i < numplayers; i++) {
            ArrayList<String> name = new ArrayList<>(1);
            name.add("");
            ip.presentName(name);
            while (Objects.equals(name.get(0), "")) {
                System.out.println("");
            }
            String n = name.get(0);
            PlayerFactory pf = new PlayerFactory(this.gameboard);
            pf.createPlayer(i+1, n);
        }

        ArrayList<Object> lst1 = new ArrayList<>(1);
        lst1.add(null);
        ip.startGame(lst1);
        while (lst1.get(0) == null){
            System.out.println("");
        }

    }


}


