package usecase;

import entity.Jail;
import entity.Player;

/**
 * Class to check the number of times a Player has spent in jail and update the new 
 * Player variable 
 */
public class SpentTurnsInJail {

    private Jail jail;

    /**
     * Instantiate a new SpentTurnsInJail object 
     * @param jail the Jail object associated with this class
     */
    public SpentTurnsInJail(Jail jail) {
        this.jail = jail;
    }

    /**
     * Update the Players turns in jail variable
     */
    public void spend() {
        // this method should ONLY be called when a turn ends.
        for (Player player : this.jail.getPlayers()){
            player.setTurnsInJail(player.getTurnsInJail() - 1);
            if (player.getTurnsInJail() == 0){
                player.setInJail(false);
                this.jail.removePlayer(player);
            }
        }
    }
}
