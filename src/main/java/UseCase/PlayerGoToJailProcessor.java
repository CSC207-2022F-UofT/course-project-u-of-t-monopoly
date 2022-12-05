package UseCase;

import Entity.Player;
import Entity.GameBoard;

public class PlayerGoToJailProcessor{

    private Player player;
    private GameBoard gameboard;

    public PlayerGoToJailProcessor(Player player, GameBoard gameboard){
        this.player = player;
        this.gameboard = gameboard;

    }

    public boolean PlayerGoToJail(){
        if(this.player.getPlayerPosition() == 30) {
            if(this.player.isInJail() == false ){
                this.player.setInJail(true);
                this.player.setPlayerPosition(10); // an input in setPlayerPosition would be the index position of the jail cell
                this.player.setTurnsInJail(3);
                return true;
            }
        }
        return false;
    }
}
