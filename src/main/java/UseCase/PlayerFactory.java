package UseCase;

import Entity.Player;
import Entity.GameBoard;

/**
 * Class to create and add Players to the GameBaord 
 */
public class PlayerFactory {

    private final GameBoard gameBoard;

    public PlayerFactory (GameBoard gb){
        this.gameBoard = gb;
    }

    /**
     * Create a Player object based on the inputted id and name
     * @param id the id of the player 
     * @param name the name of the Player 
     */
    public void createPlayer(int id, String name) {

        Player player = new Player(name, id);
        this.gameBoard.addPlayer(player);
    }

}
