package Entity;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
public class Deck {
    ArrayList<CommunityCard> communitycardlist;
    ArrayList<ChanceCard> chancecardlist;
    public Deck() {
        communitycardlist = new ArrayList<CommunityCard>();
        communitycardlist.add(new CommunityCard("Advance to \"Go\". (Collect $200)", 200, 0));
        communitycardlist.add(new CommunityCard("Bank error in your favor. Collect $200.", 200, 0));
        communitycardlist.add(new CommunityCard("Doctor's fees. {fee} Pay $50.",-50,0));
        communitycardlist.add(new CommunityCard("Get Out of Jail Free.",0,0));
        communitycardlist.add(new CommunityCard("Go to Jail.",0,0));
        chancecardlist = new ArrayList<ChanceCard>();
        chancecardlist.add(new ChanceCard("Get Out of Jail Free.",0,0));
        chancecardlist.add(new ChanceCard("Go to Jail.",0,0));
    }

    /**
     * randomly draw a card from deck.
     * @param cardtype cardtype should only be either "community" or "chance".
     * @return the drawed card.
     */
    public OpportunityCard getCard(String cardtype) { // random draw a card from deck
        if (Objects.equals(cardtype, "community")) {
            Random rand = new Random();
            int upperbound = communitycardlist.size();
            int int_random = rand.nextInt(upperbound);
            return communitycardlist.get(int_random);
        } else {
            Random rand = new Random();
            int upperbound = chancecardlist.size();
            int int_random = rand.nextInt(upperbound);
            return communitycardlist.get(int_random);
        }
    }
    // cardtype should only be either "community" or "chance".

    /**
     * remove "get out of jail" from deck
     * @param cardtype cardtype should only be either "community" or "chance".
     * @return if the card is successfully removed, return TRUE, otherwise, FALSE.
     */
    public boolean updateDeck(String cardtype) { // remove "get out of jail" from deck
        if (Objects.equals(cardtype, "community")) {
            for (CommunityCard communitycard : communitycardlist) {
                if (Objects.equals(communitycard.getCard(), "Get Out of Jail Free.")) {
                    communitycardlist.remove(communitycard);
                    return true;
                }
            }
        } else {
            for (ChanceCard chancecard : chancecardlist) {
                if (Objects.equals(chancecard.getCard(), "Get Out of Jail Free.")) {
                    chancecardlist.remove(chancecard);
                    return true;
                }
            }
        }
        return false;
    }
    // cardtype should only be either "community" or "chance".

    /**
     * add a community card
     * @param card the community card type object
     */
    public void addCommunityCard(CommunityCard card) {
        this.communitycardlist.add(card);
    }

    /**
     * add a chance card
     * @param card the chance card type object
     */
    public void addChanceCard(ChanceCard card) {
        this.chancecardlist.add(card);
    }
}
