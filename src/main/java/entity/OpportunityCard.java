package entity;

abstract class OpportunityCard {
    String cardName;
    int moneyChange;
    int movement;

    public OpportunityCard() {}

    abstract String getCard();
    //will be implemented in child class

    abstract int getMovement();
    abstract int getMoneyChange();
}
