package Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class PlayerTest {

    @Test
    public void testgetUsername(){
        Player p = new Player("Johnny", 1);
        Assertions.assertEquals(p.getUsername(), "Johnny");

    }
    @Test
    public void testgetMoney() {
        Player p = new Player("Johnny", 1);
        Assertions.assertEquals(p.getMoney(), 1500);
    }
    @Test
    public void testloseMoney() {
        Player p = new Player("Johnny", 1);
        p.loseMoney(500);
        Assertions.assertEquals(p.getMoney(), 1000);
    }
    @Test
    public void testplayerInJail() {
        Player p = new Player("Johnny", 1);
        Assertions.assertFalse(p.playerInJail());
    }

    @Test
    public void testsetPlayerPosition() {
        Player p = new Player("Johnny", 1);
        p.setPlayerPosition(10);
        Assertions.assertEquals(p.playerPosition, 10);
    }
}
