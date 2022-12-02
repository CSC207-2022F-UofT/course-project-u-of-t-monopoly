package Entity;

import java.util.ArrayList;
import java.util.Random;

public class CommunityCard extends OpportunityCard{
    int moneychange;
    int movement;
    String cardname;


    /**
     * Construct a community card class
     * @param cardname The name of this community card.
     * @param moneyamount Amount of money changed for the player.
     * @param displacement Movement for the player.
     */
    public CommunityCard(String cardname, int moneyamount, int displacement) {
        super();
        this.cardname = cardname;
        this.moneychange = moneyamount;
        this.movement = displacement;
    }

     /**
     * Show the community card name.
     * @return the name of the card.
     */
    public String getCard() {return this.cardname;}

     /**
     * Show amount of money changed for the player.
     * @return amount of money changed
     */
    public int getMoneychange() {return this.moneychange;}
    
    /**
     * Show the movement for the player.
     * @return the movement for the player
     */
    public int getMovement() {return this.movement;}
}
