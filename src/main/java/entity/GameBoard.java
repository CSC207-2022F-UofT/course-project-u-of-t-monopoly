package entity;

import java.util.ArrayList;

// create a GameBoard class with a list of players and a board (array of properties)
// The class has methods to find property tiles, by name and index
// The class can return both the board and players list
// The class can move players, add players, and set the next turn (to a player)
// The class has the functionality to check the game end.
public class GameBoard {
    private ArrayList<Player> players;
    private ArrayList<Object> board;
    //private int goPosition = 0;
    //private int jailPosition = 30;
    //private int[] chanceCard = new int[]{7, 22, 36};
    //  private int[] oppurtunityCard = new int[]{2, 17, 33};
    static int turn = 0;

    public GameBoard(){

    }


    // monopoly overall class that will keep game organized

    /**
     * Create a new GameBoard Object based on the inputted list of players and list of properties
     *
     * @param inputPlayers
     * @param lstProperties
     */

    public GameBoard(ArrayList<Player> inputPlayers,  ArrayList<Object> lstProperties){
        this.players = inputPlayers;
        this.board = lstProperties;
    }

    /**
     * Add a player to the player list associated with this GameBoard
     * @param player1
     */
    public void addPlayer(Player player1){
        players.add(player1);
    }

    /**
     * Return the list of players asscociated with this GameBoard
     * @return this.players
     */
    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    /**
     * Return the list of properties associated with this GameBoard
     * @return this.properties
     */
    public ArrayList<Object> getProperties(){
        return this.board;
    }

    /**
     * Return the number of players currenly playing with the GameBoard
     * @return int of number of players
     */
    public int getNumPlayers(){
        return players.size();
    }

    /**
     * using the index, return the properties object at the index.
     *
     * @param index
     * @return a properties object given the index
     */
    public Object getTile(int index){
        return board.get(index);
    }

    /**
     * Given the inputted Properties object, return the index that the property is at. An int from 0-39
     * @param place
     * @return the int at which place is located
     */
//    public int getTileIndex(Properties place){
//        for (int i = 0; i <board.length; i++){
//            if (place == board[i]){
//                return i;
//            }
//        }
//
//    }

    /**
     * Given the inputted movement, move player along the board (using the player.playerPosition variable
     * @param player1
     * @param movement
     * 
     */
    public void movePlayer(Player player1, int movement){
        player1.playerPosition = (player1.playerPosition + movement)%40;
        //update player posisiton with index
        //how are we keeping track of player location
    }

    /**
     * Check the game end based on the number of players that are bankrupt relative ot the total number of players
     * @return a boolean to whether this game has ended
     */
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


    /**
     * Return the player object who has the current turn
     * 
     * @return retrun the player object who has the current turn
     */
//    public Player nextTurn(){
//        if (turn == 0){
//            turn +=1;
//        }
//        for (Player person : players){
//            if (person.id == turn % getNumPlayers()){
//                return person;
//                turn += 1;
//            }
//        }
//    }

    /**
     * Given a player, remove the player from players.
     *
     */

    public void playerOut(Player player){
        if (this.players.contains(player)){
            ArrayList<TileCanBuy> tiles = (ArrayList<TileCanBuy>) player.getTile().clone();
            for (TileCanBuy tile : tiles){
                player.removeTile(tile);
                tile.resetOwner();
            }
        }
        this.players.remove(player);
    }
}
