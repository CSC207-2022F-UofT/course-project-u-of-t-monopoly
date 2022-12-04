package Entity;

import java.util.ArrayList;
import java.util.Random;

public class ChanceCard extends OpportunityCard {

    int moneychange;
    int movement;
    String cardname;

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
