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


    int id;

    int outofJailFreeCard;

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

    public String getUsername() {
        return this.username;
    }

    public int getMoney() {
        return this.money;
    }

    public void loseMoney(int amount) {
        if (this.money >= amount) {
            this.money -= amount;
        } else {
            this.money = 0;
        }
    }

    public boolean playerInJail(){
        return this.inJail;
    }

    public void movePlayer(Player player1, int movement){
        player1.playerPosition = (player1.playerPosition + movement)%40;
        //update player posisiton with index
        //how are we keeping track of player location

    }
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

    public int getPlayerPosition() {
        return this.playerPosition;
    }

    public void setPlayerPosition(int position){
        this.playerPosition = position; // Move this player's location to a specific tile in the index.
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void addProperty(Building property) {
        buildings.add(property);
    }

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

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean state) {
        this.inJail = state;
    }

    public int getTurnsInJail() {
        return turnsInJail;
    }

    public void setTurnsInJail(int turnsInJail) {
        this.turnsInJail = turnsInJail;
    }
    public int getOutofJailFreeCard(){
        return this.outofJailFreeCard;
    }
    public void addOutOfJailFreeCard() {
        this.outofJailFreeCard += 1;
    }
    
    public void useOutOfJailFreeCard() {
        this.outofJailFreeCard -= 1;
    }
}
