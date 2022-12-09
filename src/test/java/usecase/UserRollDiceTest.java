package usecase;
import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserRollDiceTest {

    @Test
    public void testUserRollDiceReact(){
        //test the react method in the UserRollDice use case. Ensure
        // that the arraylist is returned, and that the sum is less than or equal to
        // 12
        Player player1 = new Player("Bill", 1);
        UserRollDice urd = new UserRollDice(player1);
        ArrayList<Integer> lst = urd.react();
        Assertions.assertEquals(2, lst.size());
        int roll1 = lst.get(0);
        int roll2 = lst.get(1);
        Assertions.assertTrue( (roll1 + roll2) <= 12);

    }
}
