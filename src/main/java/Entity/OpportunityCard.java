package Entity;

import java.util.ArrayList;

abstract class OpportunityCard {
    String cardname;
    int moneychange;
    int movement;

    /**
     * Instantiate an Opportunity card object. This is an abstarct class
     */
    public OpportunityCard() {}

    /**
     * Abstarct parent class 
     * @return card 
     */
    abstract String getCard();
    //will be implemented in child class

    /**
     * Abstract method 
     * @return int 
     */
    abstract int getMovement();

    /**
     * Abstract method
     * 
     * @return int 
     */
    abstract int getMoneychange();
}
