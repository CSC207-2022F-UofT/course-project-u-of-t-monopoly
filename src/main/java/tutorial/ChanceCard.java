package tutorial;

import java.util.ArrayList;
import java.util.Random;

public class ChanceCard extends OpportunityCard{

    ArrayList<String> chancecard;

    public ChanceCard() {
        super();
        chancecard = new ArrayList<String>();
        chancecard.add("Get Out of Jail Free.");
        chancecard.add("Go to Jail.");
        //set up cards
    }

    public String getCard(String cardtype) {
        Random rand = new Random();
        int upperbound = chancecard.size();
        int int_random = rand.nextInt(upperbound);
        //generate a random int from 0 to the length of chancecard - 1
        return chancecard.get(int_random);
        //return the card at index of the random int
    }

    public void updateDeck() {
        communitycard.remove("Get Out of Jail Free.");
    }
}
