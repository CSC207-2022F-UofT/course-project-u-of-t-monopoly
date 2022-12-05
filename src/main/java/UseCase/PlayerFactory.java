package UseCase;

import Entity.Player;
import Entity.GameBoard;

public class PlayerFactory {

    private final GameBoard gameBoard;

    public PlayerFactory (GameBoard gb){
        this.gameBoard = gb;
    }

    public void createPlayer(int id, String name) {

        Player player = new Player(name, id);
        this.gameBoard.addPlayer(player);
    }

}
