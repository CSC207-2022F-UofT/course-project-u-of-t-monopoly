package tutorial;

import java.util.ArrayList;

abstract class OpportunityCard {
    ArrayList<String> communitycard;
    ArrayList<String> chancecard;

    public OpportunityCard() {}

    abstract String getCard(String cardtype);

    abstract void updateDeck();
}
