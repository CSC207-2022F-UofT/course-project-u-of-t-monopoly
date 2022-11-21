package tutorial;

import java.util.ArrayList;
import java.util.Random;

public class ChanceCard extends OpportunityCard {

    int moneychange;
    int movement;
    String cardname;

    public ChanceCard(String cardname, int moneyamount, int displacement) {
        super();
        this.cardname = cardname;
        this.moneychange = moneyamount;
        this.movement = displacement;
    }

    public String getCard() {
        return this.cardname;
    }

    public int getMoneychange() {
        return this.moneychange;
    }

    public int getMovement() {
        return this.movement;
    }
}
