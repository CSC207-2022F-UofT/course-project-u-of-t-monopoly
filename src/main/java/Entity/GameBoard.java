package Tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    public List<Player> players;
    public Properties[] board = new Properties[40];
    //private int goPosition = 0;
    //private int jailPosition = 30;
    //private int[] chanceCard = new int[]{7, 22, 36};
    //  private int[] oppurtunityCard = new int[]{2, 17, 33};
    static int turn = 0;

    public GameBoard(){

    }


    // monopoly overall class that will keep game organized

    public GameBoard(List<Player> inputPlayers, Properties[] lstProperties){
        this.players = inputPlayers;
        this.board = lstProperties;

    }

    public void addPlayer(Player player1){
        players.add(player1);
    }


   

    public int getNumPlayers(){
        return players.size();

    }

    public Properties getTile(int index){
        return board[index];
    }

    public int getTileIndex(Properties place){
        for (int i = 0; i <board.length; i++){
            if (place == board[i]){
                return i;
            }
        }
    }

    public void movePlayer(Player player1, int movement){
        player1.location = (player1.location + movement)%40;
        //update player posisiton with index
        //how are we keeping track of player location

    }

    public boolean checkGameEnd(){
        // what is the game end
        int numPlayers = players.size();
        int count = 0;

        for (Player person : players){
            if (person.checkBankruptcy()){
                count += 1;

            }
            if (count == (numPlayers - 1)){
                return true;
            }
        }
        return false;
    }


    public Player nextTurn(){
        if (turn == 0){
            turn +=1;
        }
        for (Player person : players){
            if (person.id == turn % getNumPlayers()){
                return person;
                turn += 1;
            }
        }
    }
}
