package entity;

public class ChanceCard extends OpportunityCard {

    int moneyChange;
    int movement;
    String cardName;

    /**
     * Construct a Chance Card
     *
     * @param cardName     the name of the card
     * @param moneyAmount  amount of money changed for the player
     * @param displacement movement for the player.
     */
    public ChanceCard(String cardName, int moneyAmount, int displacement) {
        super();
        this.cardName = cardName;
        this.moneyChange = moneyAmount;
        this.movement = displacement;
    }
    
    /**
     * show the card name.
     *
     * @return card name
     */
    public String getCard() {
        return this.cardName;
    }

    /**
     * show amount of money changed
     *
     * @return amount of money changed
     */
    public int getMoneyChange() {
        return this.moneyChange;
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
