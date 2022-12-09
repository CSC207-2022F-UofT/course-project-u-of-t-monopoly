package use_case;

import entity.*;

/**
 * Class to update and check the Players position relative to being in Jail
 */
public class PlayerInJailProcessor {

    private Player player;
    private Jail jail;

    /**
     * Instantiate a new PlayerInJailProcessor 
     * @param player the player object to be checked 
     * @param jail the jail object to be checked against the Player 
     */
    public PlayerInJailProcessor(Player player, Jail jail){
        this.player = player;
        this.jail = jail;
    }

    /**
     * check if the Player is in jail 
     * @return true if the player is in jail, false otherwise 
     */
    public boolean playerInJail(){
        return this.player.isInJail();

    }

    /**
     * Check to see of the Player has a get out of jail free card 
     * @return return true of the player has a get out of jail free card, false otherwise 
     */
    public boolean playerHasFreeCard() {
        return this.player.getOutofJailFreeCard() > 0;
    }

    /**
     * The player uses their get out of jail free card 
     */
    public void playerUseFreeCard() {this.player.useOutOfJailFreeCard();}

    /**
     * Set the Player free. Update the associated variables for whether the Player is in jail, the 
     * amount if turns they have spent in jail and update the jail object. 
     */
    public void setPlayerFree() {
        this.player.setInJail(false);
        this.player.setTurnsInJail(0);
        this.jail.removePlayer(this.player);
    }

    /**
     * This player spent 1 turn in jail.
     */

    public void spentOneTurn(){this.player.spentTurnInJail();}



}
