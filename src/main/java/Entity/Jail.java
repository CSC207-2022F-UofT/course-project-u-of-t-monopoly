package Entity;
// How to go to Jail:
// roll double thrice consecutively
// go to jail chance card (if passed go to land on card chest, collect go money, else go directly to jail)
// land on jail (visiting, no penalty)

import java.util.ArrayList;

public class Jail {
    Player player;
    private int turnsInJail;
    private boolean inJail;

    /**
     * Initialize Jail Object
     *
     * @param p Player
     */
    public Jail(Player p) {
        player = p;
        turnsInJail = 0;
        inJail = true;
    }
    
    public Jail() {
        this.players = new ArrayList<>();
    }

    /**
     * While suspended, Player can attempt to roll doubles to get out
     *
     * While in Jail, Player cannot move from their position
     * Their turn is suspended up to 3 turns, they can attempt to bail, or roll to get out
     * Player can still conduct activities such as collect rent, auction, mortgage, etc
     */
    public void turnSuspended() {
        ArrayList<Integer> dice = player.rollDice();
        if ((int) dice.get(1) == (int) dice.get(2)) {
            this.outOfJail();
        }
    }

    /**
     * Player moves out of jail, the instance variables resets
     *
     * Player moves out of jail after rolling doubles (Player moves amount thrown, double rule do not apply)
     * or by paying bail (see payBail)
     */
    public void outOfJail() {
        this.inJail = false;
        turnsInJail = 0;
    }

    /**
     * Player pays $50 to the bank
     *
     * Player can pay bail either before first or second turn
     * Player must pay bail at third turn
     */
    public void payBail() {
        player.loseMoney(50); // lose to the bank
    }

    /**
     * The followings are all getters and setters for the instance variable
     * @return instance variables
     */
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
