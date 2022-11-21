package tutorial;
// How to go to Jail:
// roll double thrice consecutively
// go to jail chance card (if passed go to land on card chest, collect go money, else go directly to jail)
// land on jail (visiting, no penalty)

import java.util.ArrayList;

public class Jail {
    Player player;
    private int turnsInJail;
    private boolean inJail;

    public Jail(Player p) {
        player = p;
        turnsInJail = 0;
        inJail = true;
    }

    public void turnSuspended() {
        // player can still conduct activities, collect rent, auction, mortgage, et
        // player is locked in jail up to a max of 3 turns
        // skip turn
        // player can either bail or attempt to roll a double, or buy a get out of jail free card from another player
        ArrayList<Integer> dice = player.rollDice();             // Will there be a separate class for rolling dice?
        if (dice.get(1) == dice.get(2)) {     // How are double dice roll kept track of? boolean? during the rollDice() method?
            this.outOfJail();
        }
    }

    public void outOfJail() {
        // roll doubles, player moves amount thrown. double rule do not apply
        // if (rolledDoubles) player.move() the rolled number, if payBail(), roll and move
        this.inJail = false;
        turnsInJail = 0;
    }

    public void payBail() {
        // $50
        // either pay before first or second turn dice roll, double roll applies
        // must after third turn

        player.loseMoney(50); // lose to the bank
    }

    public int getTurnsInJail() {
        return turnsInJail;
    }

    public void setTurnsInJail(int turnsInJail) {
        this.turnsInJail = turnsInJail;
    }

    public boolean getInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }
}
// Temporary
