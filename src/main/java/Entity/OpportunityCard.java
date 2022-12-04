package Entity;

import java.util.ArrayList;

public abstract class OpportunityCard {
    String cardname;
    int moneychange;
    int movement;

    public OpportunityCard() {}

    public abstract String getCard();
    //will be implemented in child class

    public abstract int getMovement();
    public abstract int getMoneychange();
}
