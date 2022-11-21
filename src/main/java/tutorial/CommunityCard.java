package tutorial;

import java.util.ArrayList;
import java.util.Random;

public class CommunityCard extends OpportunityCard{
    int moneychange;
    int movement;
    String cardname;

    //public CommunityCard() {
    //    super();
    //    communitycard = new ArrayList<String>();
    //    communitycard.add("Advance to \"Go\". (Collect $200)");
    //    communitycard.add("Bank error in your favor. Collect $200.");
    //    communitycard.add("Doctor's fees. {fee} Pay $50.");
    //    communitycard.add("Get Out of Jail Free.");
    //    communitycard.add("Go to Jail.");
        //set up cards in community card deck
    //}

    public CommunityCard(String cardname, int moneyamount, int displacement) {
        super();
        this.cardname = cardname;
        this.moneychange = moneyamount;
        this.movement = displacement;
    }

    public String getCard() {return this.cardname;}

    public int getMoneychange() {return this.moneychange;}

    public int getMovement() {return this.movement;}
}
