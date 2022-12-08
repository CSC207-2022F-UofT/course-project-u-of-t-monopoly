package UseCase;

import Entity.Player;
import Entity.*;


import UseCase.UserBuyUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserBuyUtilitiesTest{

    @Test
    public void UserBuyUtilitiesEnoughMoney(){
        int rolls = 10;
        Player player1 = new Player("BOB", 1);
        Utilities utility = new Utilities("BASE", 100);
        UserBuyUtilities action = new UserBuyUtilities(player1, utility);
        action.BuyUtility();
        Assertions.assertTrue(utility.getOwner() == player1);

    }

    @Test
    public void UserBuyUtilitiesNotEnoughMoney(){
        Player player1 = new Player("BOB", 1);
        int rolls = 10;
        Utilities utility = new Utilities("BASE", 1600);
        UserBuyUtilities action = new UserBuyUtilities(player1, utility);
        action.BuyUtility();
        Assertions.assertTrue(utility.getOwner() != player1);

    }
}


