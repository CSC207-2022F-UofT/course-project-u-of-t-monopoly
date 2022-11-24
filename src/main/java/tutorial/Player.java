package tutorial;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    String username; // name of the player
    int money;
    int playerPosition;
    String opportunityCards;
    ArrayList<Building> buildings = new ArrayList<Building>();

    Jail jail;

    int id;

    public Player(String username, int money, int position, String opportunityCards, int id) {
        this.username = username;
        this.money = money;
        this.playerPosition = position;
        this.opportunityCards = opportunityCards;
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public int getMoney() {
        return this.money;
    }

    public int loseMoney(int amount) {
        if (this.money >= amount) {
            this.money -= amount;
        } else {
            this.money = 0;
        }
        return amount;
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
}
