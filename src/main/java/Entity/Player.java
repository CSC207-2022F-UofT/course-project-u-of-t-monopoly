package Entity;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    String username; // name of the player
    int money;
    int playerPosition;
    String opportunityCards;
    ArrayList<Building> buildings = new ArrayList<Building>();

    boolean inJail;

    int turnsInJail;

    boolean playerTurn;

    //Jail jail;

    int id;

    int getOutofJailFreeCard;

    /**
     * Initialize a player object
     * @param username the name of the player
     * @param id the id number of the player
     */

    public Player(String username, int id) {
        this.username = username;
        this.money = 1500;
        this.playerPosition = 0;
        this.id = id;
        this.inJail = false;
        this.playerTurn = true;
        this.turnsInJail = 0;
        this.getOutofJailFreeCard = 0;
    }

    /**
     * Getter method to return the players username
     * @return the String of this.username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter method to return the money the player object has
     * @return the int representing the players bank balance
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Update the players money to lose the inputted amount
     * @param amount the amount of money the player should lose
     */
    public void loseMoney(int amount) {
        if (this.money >= amount) {
            this.money -= amount;
        } else {
            this.money = 0;
        }
    }

    /**
     * Get the boolean representing whether the player is in jail or not
     * @return true if the player is in jail and false if not
     */
    public boolean playerInJail(){
        return this.inJail;
    }

    /**
     * Move the player based on the number of tiles to be moved (movement)
     * @param player1 the player to be moved
     * @param movement the movement of the player
     */
    public void movePlayer(Player player1, int movement){
        player1.playerPosition = (player1.playerPosition + movement)%40;
        //update player posisiton with index
        //how are we keeping track of player location

    }

    /**
     * The roll dice method, which returns the sum of rolls completed by the dice
     *
     * @return the sum of rolls for the dice roll
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
     * Return the players position on the board
     * @return return this.playerPosition
     */
    public int getPlayerPosition() {
        return this.playerPosition;
    }

    /**
     * Update the player position to the inputted index value position
     * @param position the new position of the player, a int between 0 and 39
     */
    public void setPlayerPosition(int position){
        this.playerPosition = position; // Move this player's location to a specific tile in the index.
    }

    /**
     * Add money to the players money balance in the amount of amount
     * @param amount the amount to be added to the players bank balance
     */
    public void addMoney(int amount) {
        this.money += amount;
    }

    /**
     * Add an owned property to this player's properties
     * @param property the property that the player bought
     */
    public void addProperty(Building property) {
        buildings.add(property);
    }

    /**
     * check whether the player is bankrupt
     * @return a boolean to check if the player is bankrupt
     */
    public boolean checkBankruptcy() {
        if (this.money == 0) {
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
     * update the players position in terms of whether they are in jail or not and the amont
     * of turns they have been in jail
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
     *
     * @return the boolean to check if this player is in jail
     */
    public boolean isInJail() {
        return inJail;
    }

    /**
     * set the inJail variable to true or false
     * @param inJail the boolean to whether this player is in jail or not
     */
    public void setInJail(boolean inJail) {
        this.inJail = !inJail;
    }

    /**
     * return the amount of turns this player has been in jail
     * @return the turnsInJail variable
     */
    public int getTurnsInJail() {
        return turnsInJail;
    }

    /**
     * set the turns in jail variable
     * @param turnsInJail the turnsInJail variable depicting the amount of turns a player has spent in jail
     */
    public void setTurnsInJail(int turnsInJail) {
        this.turnsInJail = turnsInJail;
    }
}
