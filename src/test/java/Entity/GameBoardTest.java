package Entity;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameBoardTest {

//    @Test
//    public void GameBoardCreate(){
//
//    }

    @Test
    public void GameBoardRollDice(){

        GameBoard game = new GameBoard();
        ArrayList rolls = game.rollDice();

        Assertions.assertEquals(2, rolls.size());
        Integer num1 = (Integer) rolls.get(2);
        Integer num2 = (Integer) rolls.get(1);
        Assertions.assertTrue((num1 + num2) <= 12);

    }


}
