package UseCase;

import Entity.*;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class to move a player on the gameBoard for the Monopoly game
 */
public class MovePlayer {

    private Player player;
    private GameBoard gameboard;

    /**
     * Create a MovePlayer object 
     * @param player the Player object to be moved 
     * @param gameboard the GameBoard object associated with the players move
     */
    public MovePlayer(Player player, GameBoard gameboard){
        this.player = player;
        this.gameboard = gameboard;
    }

    /**
     * Getter method to return the posiiton of the player 
     * @return the Integer of the Players position
     */
    public Integer getPosition(){
        return this.player.getPlayerPosition();
    }

    /**
     * Move method to update the Players position 
     * @param diceroll the ArrayList holding the two dice rolls associated with this Players turn 
     * @return the new position of the Player 
     */
    public int move(ArrayList<Integer> diceroll){
        this.player.setPlayerPosition(this.player.getPlayerPosition() + diceroll.get(0) + diceroll.get(1));
        return this.player.getPlayerPosition();
    }

    /**
     * move the player, not based on a dice roll but rather a int 
     * @param position the number of spaces Player is to be moved 
     */
    public void move(int position){
        this.player.setPlayerPosition(position);
    }

    /**
     * Add $200 to the players money balance for passing go 
     */
    public void passGo(){
        this.player.addMoney(200);
    }

    /**
     * return the tile located at the id 
     * @param id the value of the tile that is being looked for (based on indexing)
     * @return the tile that is located at index id 
     */
    public Object getTileLanded(Integer id){
        return this.gameboard.getTile(id);
    }

    /**
     * Getter method to return the property owner of the given TileCanBuy object 
     * @param tileCanBuy the tile object that can be purchased based on the implemented interface 
     * @return the Player object who owns the tileCanBuy object
     */
    public Player getPropertyOwner(TileCanBuy tileCanBuy) {
        return tileCanBuy.getOwner();
    }

    /**
     * Return the owner of the Utilities object
     * @param utilities the Utileiies tile object
     * @return the Player who owns the Utilities object 
     */
    public Player getUtilityOwner(Utilities utilities) {return utilities.getOwner();}

    /**
     * Tax the Player for the Integer amount
     * @param amount the value the player will lose from the tax 
     * @return a String representing whether the Player paid the tax or mortgaged properties to so 
     */
    public String taxPlayer(Integer amount) {
        if (this.player.getMoney() >= amount) {
            this.player.loseMoney(amount);
            return "Success";
        }
        else{
            UserTileInteractor uti = new UserTileInteractor(null, this.player, this.gameboard);
            return uti.MortgageToPay(amount);
        }
    }

    /**
     * Take the Player out of the GameBoard 
     */
    public void PlayerOut(){
        this.gameboard.PlayerOut(this.player);
    }
}
