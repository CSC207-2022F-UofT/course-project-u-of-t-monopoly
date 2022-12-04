package UseCase;

import Entity.Player;
import java.util.ArrayList;

public class PayPlayerGoSquare {

    Player player;

    int diceRoll;

    public PayPlayerGoSquare(Player player, int diceRoll){
        this.player = player;
        this.diceRoll = diceRoll;
    }

    /**
     * Make sure to call this method after the dice roll is renewed for the player.
     *
     * The below method should be called for each single player turns, such that it may check whether the player has
     * passed the GoSquare or not in every turn.
     */
    public void PayPlayerPassedGoSquare(){
        if ((this.player.getPlayerPosition() >= 28) && ((this.player.getPlayerPosition() + diceRoll) >= 0)){
            this.player.addMoney(200);
        }
    }
}
