package UseCase;

import Entity.Player;
import java.util.ArrayList;

public class UserRollDice {


    Player player;
//    GameBoard gameboard;

    /**
     * This class will be used when one player roll a die and make movement.
     *
     * @param player The player who rolls the die and reacts.
     */

    public UserRollDice(Player player) {
        this.player = player;
    }

    /**
     * This method is used to roll a die and make corresponding changes.
     *
     * @return the method returns a list of size 2 represent the rolls of this player.
     */

    public ArrayList<Integer> react() {
        
        return this.player.rollDice();

    }
}

