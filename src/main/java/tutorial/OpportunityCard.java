package tutorial;

import java.util.ArrayList;

abstract class OpportunityCard {
    ArrayList<String> communitycard;
    ArrayList<String> chancecard;

    public OpportunityCard() {}

    abstract String getCard(String cardtype);
    //will be implemented in child class

    abstract void updateDeck();
}
