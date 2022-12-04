package UseCase;

import Entity.GameBoard;
import Entity.Player;

import java.util.ArrayList;

public class MovePlayer {

    private Player player;
    private GameBoard gameboard;

    public MovePlayer(Player player, GameBoard gameboard){
        this.player = player;
        this.gameboard = gameboard;
    }

    public int move(ArrayList<Integer> diceroll){
        this.player.setPlayerPosition(this.player.getPlayerPosition() + diceroll.get(0) + diceroll.get(1));
        return this.player.getPlayerPosition();
    }
}
