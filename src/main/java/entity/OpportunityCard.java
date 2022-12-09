package entity;

import java.util.ArrayList;

abstract class OpportunityCard {
    private String cardname;
    private int moneychange;
    private int movement;

    public OpportunityCard() {}

    abstract String getCard();
    //will be implemented in child class

    abstract int getMovement();
    abstract int getMoneychange();
}
