package tutorial;

import java.util.ArrayList;

abstract class OpportunityCard {
    String cardname;
    int moneychange;
    int movement;

    public OpportunityCard() {}

    abstract String getCard();
    //will be implemented in child class

    abstract int getMovement();
    abstract int getMoneychange();
}