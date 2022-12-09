package entity;

public class CommunityCard extends OpportunityCard{
    int moneyChange;
    int movement;
    String cardName;


    /**
     * Construct a community card class
     * @param cardName The name of this community card.
     * @param moneyAmount Amount of money changed for the player.
     * @param displacement Movement for the player.
     */
    public CommunityCard(String cardName, int moneyAmount, int displacement) {
        super();
        this.cardName = cardName;
        this.moneyChange = moneyAmount;
        this.movement = displacement;
    }

     /**
     * Show the community card name.
     * @return the name of the card.
     */
    public String getCard() {return this.cardName;}

     /**
     * Show amount of money changed for the player.
     * @return amount of money changed
     */
    public int getMoneyChange() {return this.moneyChange;}
    
    /**
     * Show the movement for the player.
     * @return the movement for the player
     */
    public int getMovement() {return this.movement;}
}
