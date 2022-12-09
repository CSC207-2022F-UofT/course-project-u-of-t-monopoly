package tutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserPayRentTest{

    @Test
    public void UserPayRentNotEnoughMoney(){
        // check the case where the player does not have enough money to pay rent
        Player player1 = new Player("BOB", 50, 4, "cards", 1);
        Player owner  = new Player("BILL", 100, 9, "cards", 2);
        Properties property = new Properties("BAHEN", 100, 60, false, "Blue", 100);
        UserPayRent action = new UserPayRent(player1, property);
        action.PayRent();
        Assertions.assertEquals(0, player1.getMoney());
        Assertions.assertEquals(150, owner.getMoney());
    }

    @Test
    public void UserPayRentEnoughMoney(){
        // check the case where the player does not have enough money to pay rent
        Player player1 = new Player("BOB", 70, 4, "cards", 1);
        Player owner  = new Player("BILL", 100, 9, "cards", 2);
        Properties property = new Properties("BAHEN", 100, 60, false, "Blue", 100);
        UserPayRent action = new UserPayRent(player1, property);
        action.PayRent();
        Assertions.assertEquals(10, player1.getMoney());
        Assertions.assertEquals(160, owner.getMoney());
    }
}