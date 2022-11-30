package tutorial;



import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;
import java.util.Optional;
import java.util.Properties;

public class UtilitiesTest {

    @Test
    public void testUtilities1(){
        Properties properties = new Properties("A", 100, 30, flase, "red", 50);
        Player player = new Player("Davidson", 1500, 1, "",1);
        Utilities waterWorks = new Utilities("Water Works");
        waterWorks.setOwner(player.id);
        assertEquals(48, waterWorks.getMoneyChange1(12));
    }

    @Test
    public void testUtilities2(){
        Properties properties = new Properties("A", 100, 30, flase, "red", 50);
        Player player = new Player("Davidson", 1500, 1, "",1);
        Utilities waterWorks = new Utilities("Water Works");
        waterWorks.setOwner(player.id);
        assertEquals(120, waterWorks.getMoneyChange2(12));
    }
}
