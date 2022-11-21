package tutorial;

import java.util.ArrayList;
import java.util.Random;

public class CommunityCard extends OpportunityCard{
    ArrayList<String> communitycard;

    public CommunityCard() {
        super();
        communitycard = new ArrayList<String>();
        communitycard.add("Advance to \"Go\". (Collect $200)");
        communitycard.add("Bank error in your favor. Collect $200.");
        communitycard.add("Doctor's fees. {fee} Pay $50.");
        communitycard.add("Get Out of Jail Free.");
        communitycard.add("Go to Jail.");
        //set up cards
    }

    public String getCard(String cardtype) {
        Random rand = new Random();
        int upperbound = communitycard.size();
        int int_random = rand.nextInt(upperbound);
        //generate a random int from 0 to the length of communitycard - 1
        return communitycard.get(int_random);
        //return the card at index of the random int
    }

    public void updateDeck() {
        communitycard.remove("Get Out of Jail Free.");
    }
}
