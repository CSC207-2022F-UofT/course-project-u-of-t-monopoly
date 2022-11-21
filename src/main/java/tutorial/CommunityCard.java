package tutorial;

public class CommunityCard extends OpportunityCard{
    int moneychange;
    int movement;
    String cardname;



    public CommunityCard(String cardname, int moneyamount, int displacement) {
        super();
        this.cardname = cardname;
        this.moneychange = moneyamount;
        this.movement = displacement;
    }

    public String getCard() {return this.cardname;}

    public int getMoneychange() {return this.moneychange;}

    public int getMovement() {return this.movement;}
}
