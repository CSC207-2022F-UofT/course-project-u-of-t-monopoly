package tutorial;



import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;
import java.util.Optional;

public class BuyPropertyProcessorTest {

    @Test
    public void testBuyProperty1() {
        Properties properties = new Properties("A",100, 30, false, "red", 50);
        Player player = new Player("Jimmy", 1500, 1,"", 1);
        BuyPropertyProcessor processor = new BuyPropertyProcessor(player, properties);
        assertTrue(processor.BuyProperty());
        assertEquals(1400, player.getMoney());
    }


    @Test
    public void testBuyProperty2() {
        Properties properties = new Properties("B",100, 30, false, "red", 50);
        Player player1 = new Player("Jimmy", 1500, 1,"", 1);
        properties.resetOwner(player1);
        Player player2 = new Player("JimmyNumber2", 1500, 1,"", 1);
        BuyPropertyProcessor processor = new BuyPropertyProcessor(player2, properties);
        assertFalse(processor.BuyProperty());
        assertEquals(1500, player2.getMoney());
    }



}
