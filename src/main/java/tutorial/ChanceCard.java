package Entity;

public class ChanceCard extends OpportunityCard {
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

