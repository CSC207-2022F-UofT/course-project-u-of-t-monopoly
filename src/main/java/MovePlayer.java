package UseCases;

import tutorial.GameBoard;
import tutorial.Player;

public class MovePlayer {

    private Player player;
    private GameBoard gameboard;

    public MovePlayer(Player player, GameBoard gameboard){
        this.player = player;
        this.gameboard = gameboard;
    }

    public int MovePlayer(int diceroll){
        this.player.setPlayerPosition(this.player.getPlayerPosition() + diceroll);
        return this.player.getPlayerPosition();
    }
}
