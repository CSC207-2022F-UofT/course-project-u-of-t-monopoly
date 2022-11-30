package UseCase;

import Entity.Player;
import Entity.*;




import UseCase.UserPayRentUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserPayRentUtilityTest {

    // test the UserPayRentUtility Use case
    @Test
    public void UserPayRentUtilityNotEnoughMoney(){
        int rolls = 376;
        Player player1 = new Player("BOB", 1);
        Player owner  = new Player("BILL", 2);
        Utilities utility = new Utilities("BASE", rolls, 100);
        utility.setOwner(owner);
        UserPayRentUtility action = new UserPayRentUtility(utility, player1, rolls);
        action.payRentOneOwner();
        Assertions.assertEquals(0, player1.getMoney());
        Assertions.assertEquals(3000, owner.getMoney());
        Assertions.assertTrue(player1.getMoney() == 0);

    }

    @Test
    public void UserPayRentUtilityNotEnoughMoney2(){
        int rolls = 400;
        Player player1 = new Player("BOB", 1);
        Player owner  = new Player("BILL", 2);
        Utilities utility = new Utilities("BASE", rolls, 100);
        utility.setOwner(owner);
        UserPayRentUtility action = new UserPayRentUtility(utility, player1, rolls);
        action.payRentOneOwner();
        Assertions.assertEquals(0, player1.getMoney());
        Assertions.assertEquals(3000, owner.getMoney());
        Assertions.assertTrue(player1.getMoney() == 0);

    }

    @Test
    public void UserPayRentUtilityEnoughMoney(){
        int rolls = 12;
        Player player1 = new Player("BOB", 1);
        Player owner  = new Player("BILL", 2);
        Utilities utility = new Utilities("BASE", rolls, 100);
        utility.setOwner(owner);
        UserPayRentUtility action = new UserPayRentUtility(utility, player1, rolls);
        action.payRentOneOwner();
        Assertions.assertEquals(1452, player1.getMoney());
        Assertions.assertEquals(1548, owner.getMoney());

    }

    @Test
    public void UserPayRentUtilityNotEnoughMoney2Owned(){
        int rolls = 376;
        Player player1 = new Player("BOB", 1);
        Player owner  = new Player("BILL", 2);
        Utilities utility = new Utilities("BASE", rolls, 100);
        utility.setOwner(owner);
        UserPayRentUtility action = new UserPayRentUtility(utility, player1, rolls);
        action.payRentTwoOwner();
        Assertions.assertEquals(0, player1.getMoney());
        Assertions.assertEquals(3000, owner.getMoney());
        Assertions.assertTrue(player1.getMoney() == 0);

    }

    @Test
    public void UserPayRentUtilityEnoughMoney2Owned(){
        int rolls = 10;
        Player player1 = new Player("BOB", 1);
        Player owner  = new Player("BILL", 2);
        Utilities utility = new Utilities("BASE", rolls, 100);
        utility.setOwner(owner);
        UserPayRentUtility action = new UserPayRentUtility(utility, player1, rolls);
        action.payRentTwoOwner();
        Assertions.assertEquals(1400, player1.getMoney());
        Assertions.assertEquals(1600, owner.getMoney());
        Assertions.assertTrue(player1.getMoney() == 0);

    }
}
