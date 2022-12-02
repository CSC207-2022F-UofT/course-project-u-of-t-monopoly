package Entity;

import java.util.ArrayList;
import java.util.Random;

public class ChanceCard extends OpportunityCard {

    int moneychange;
    int movement;
    String cardname;

    //public ChanceCard() {
    //    super();
    //    chancecard = new ArrayList<String>();
    //    chancecard.add("Get Out of Jail Free.");
    //    chancecard.add("Go to Jail.");
    //set up cards in chance card deck
    //}

    //public String getCard(String cardtype) {
    //    Random rand = new Random();
    //    int upperbound = chancecard.size();
    //    int int_random = rand.nextInt(upperbound);
    //generate a random int from 0 to the length of chancecard - 1
    //    return chancecard.get(int_random);
    //return the card at index of the random int
    //}

    
    /**
     * Construct a Chance Card
     *
     * @param cardname     the name of the card
     * @param moneyamount  amount of money changed for the player
     * @param displacement movement for the player.
     */
    public ChanceCard(String cardname, int moneyamount, int displacement) {
        super();
        this.cardname = cardname;
        this.moneychange = moneyamount;
        this.movement = displacement;
    }
    
    /**
     * show the card name.
     *
     * @return card name
     */
    public String getCard() {
        return this.cardname;
    }

    /**
     * show amount of money changed
     *
     * @return amount of money changed
     */
    public int getMoneychange() {
        return this.moneychange;
    }

    /**
     * show the movement
     *
     * @return place movement.
     */
    public int getMovement() {
        return this.movement;
    }
}
