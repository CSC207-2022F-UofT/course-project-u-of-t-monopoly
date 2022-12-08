package Entity;

import java.util.ArrayList;

import java.util.Random;

public class Player {

    String username; // name of the player
    int money;
    int playerPosition;
    String opportunityCards;
    ArrayList<TileCanBuy> tile = new ArrayList<TileCanBuy>();

    boolean inJail;

    int turnsInJail;

    boolean playerTurn;


    int id;

    int outofJailFreeCard;

    /**
     * Instantiate a Player object 
     * @param username the name of the Player 
     * @param id the id of the Player 
     */
    public Player(String username, int id) {
        this.username = username;
        this.money = 1500;
        this.playerPosition = 0;
        this.id = id;
        this.inJail = false;
        this.playerTurn = true;
        this.turnsInJail = 0;
        this.outofJailFreeCard = 0;
    }

    /**
     * Getter method to return the name of the player 
     * @return the player's name 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter method to return the money of the Player 
     * @return the player's money 
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Take away the amount from the Player's money 
     * If they do not have enough, set money to zero 
     * @param amount the amount the player will lose. 
     */
    public void loseMoney(int amount) {
        if (this.money >= amount) {
            this.money -= amount;
        } else {
            this.money = 0;
        }
    }

    /**
     * return whether this Player is in jail 
     * @return boolean true if the player is in jail, false otherwise 
     */
    public boolean playerInJail(){
        return this.inJail;
    }

    /**
     * move the Player based on the position and the movement required 
     * @param player1 the player to be moved 
     * @param movement the movement of the player 
     */
    public void movePlayer(Player player1, int movement){
        player1.playerPosition = (player1.playerPosition + movement)%40;
        //update player posisiton with index
        //how are we keeping track of player location

    }

    /**
     * Roll the dice for the Player 
     * @return an arraylist with two ints, each representing a dice roll 
     */
    public ArrayList<Integer> rollDice(){
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        Random num = new Random();
        int max = 6;
        int min = 1;
        int randnum = num.nextInt((max - min) + 1) + min;
        int randnum2 = num.nextInt((max-min) + 1) + min;
        rolls.add(randnum);
        rolls.add(randnum2);
        //Or return the sum of the rolls
        //int sum = randnum + randnum2;
        //return sum;
        return rolls;
    }

    /**
     * Getter method for the Player's position 
     * @return this player's position 
     */
    public int getPlayerPosition() {
        return this.playerPosition;
    }

    /**
     * Setter method to set this Player's position 
     * @param position the new position of the player 
     */
    public void setPlayerPosition(int position){
        this.playerPosition = position; // Move this player's location to a specific tile in the index.
    }

    /**
     * Add money to the player 
     * @param amount the amount of money to be added 
     */
    public void addMoney(int amount) {
        this.money += amount;
    }

    /**
     * Add property to the player's owned Properties 
     * @param property the new owned Properties object 
     */
    public void addProperty(Properties property) {
        this.tile.add(property);
    }

    /**
     * Return the tile ArrayList representing the owned Tiles of the Player 
     * @return this.tile, representing the Player's owned tiles 
     */
    public ArrayList<TileCanBuy> getTile(){
        return this.tile;
    }

    /**
     * remove a tile from this player's owned tiles 
     * @param tileCanBuy the removed tile from the players owned tiles 
     */
    public void removeTile(TileCanBuy tileCanBuy) {
        this.tile.remove(tileCanBuy);
    }

    /**
     * check if this player is bankrupt. If they have no money, they are bankrupt 
     * @return true if the player is bankrupt, false otherwise 
     */
    public boolean checkBankruptcy() {
        if (this.money <= 0) {
            return true;
        }
        return false;
    }
//    public void turnSuspended() {
//        // player can still conduct activities, collect rent, auction, mortgage, et
//        // player is locked in jail up to a max of 3 turns
//        // skip turn
//        // player can either bail or attempt to roll a double, or buy a get out of jail free card from another player
//        player.rollDice();             // Will there be a separate class for rolling dice?
//        if (player.rolledDouble) {     // How are double dice roll kept track of? boolean? during the rollDice() method?
//            this.outOfJail();
//        }
//    }

    /**
     * Set the player to be out of jail 
     */
    public void outOfJail() {
        // roll doubles, player moves amount thrown. double rule do not apply
        // if (rolledDoubles) player.move() the rolled number, if payBail(), roll and move
        this.inJail = false;
        turnsInJail = 0;
    }

//    public void payBail() {
//        // $50
//        // either pay before first or second turn dice roll, double roll applies
//        // must after third turn
//
//        player.loseMoney(50); // lose to the bank
//    }

    /**
     * getter method to check if the Player is in jail 
     * @return this.inJail
     */
    public boolean isInJail() {
        return inJail;
    }

    /**
     * set the player's inJail state 
     * @param state boolean true if the player is inJail, false otherwise 
     */
    public void setInJail(boolean state) {
        this.inJail = state;
    }

    /**
     * return the number of turns this player has spent in jail 
     * @return this.turnsInJail
     */
    public int getTurnsInJail() {
        return turnsInJail;
    }

    /**
     * Set the number of turns that this player has spent in jail
     * @param turnsInJail the amount of turns this player has spent in jail
     */
    public void setTurnsInJail(int turnsInJail) {
        this.turnsInJail = turnsInJail;
    }

    /**
     * return the number of getOutOfJailFree cards that this player has 
     * @return the number of get out of jail free cards that Player has 
     */
    public int getOutofJailFreeCard(){
        return this.outofJailFreeCard;
    }

    /**
     * Adda a get out of jail free card to the count that the player has 
     */
    public void addOutOfJailFreeCard() {
        this.outofJailFreeCard += 1;
    }

    /**
     * use a get out of jail free card for the player.
     * take away one from the PLayer;s outofJailFreeCard variable 
     */
    public void useOutOfJailFreeCard() {this.outofJailFreeCard -= 1;}

}
