package use_case;

import entity.*;

/**
 * A use case class to set, check, and update the Players position in jail 
 */
public class PlayerGoToJailProcessor{

    private Player player;
    private GameBoard gameboard;
    private Jail jail;
    /**
     * Instantiate a new PlayerGoToJailProcessor 
     * @param player the Player object to be updated 
     * @param gameboard the GameBoard object associated with the game 
     */
    public PlayerGoToJailProcessor(Player player, GameBoard gameboard){
        this.player = player;
        this.gameboard = gameboard;
        this.jail = (Jail) gameboard.getTile(10);
    }

    /**
     * Update the Players position in jail
     * @return true if the Player was set to jail, false otherwise 
     */
    public boolean PlayerGoToJail(){
        if(this.player.isInJail() == false ){
            this.jail.addPlayer(this.player);
            this.player.setInJail(true);
            this.player.setPlayerPosition(10); // an input in setPlayerPosition would be the index position of the jail cell
            this.player.setTurnsInJail(3);
            return true;
        }

        return false;
    }
}
