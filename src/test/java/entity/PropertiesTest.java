package entity;



import org.junit.Test;

import static org.junit.Assert.*;

public class PropertiesTest {

    @Test
    public void testGetPrice1() {
        Properties p = new Properties("A",100, 30, "red", 50);
        assertEquals(100, p.getPrice());

    }

    @Test
    public void testGetPrice2() {
        Properties p = new Properties("B",100, 30,  "red", 50);
        Hotel h1 = new Hotel(300, 50, 150);
        Hotel h2 = new Hotel(400, 70, 200);
        House h3 = new House(100, 10, 50);
        p.buildBuilding(h1);
        p.buildBuilding(h2);
        p.buildBuilding(h3);
        assertEquals(900, p.getPrice());
    }

    @Test
    public void testGetRent1() {
        Properties p = new Properties("C", 100, 30, "red", 50);
        assertEquals(30, p.getRent());

    }

    @Test
    public void testGetRent2() {
        Properties p = new Properties("D", 100, 30, "red", 50);
        Hotel h1 = new Hotel(300, 50, 150);
        Hotel h2 = new Hotel(400, 70, 200);
        House h3 = new House(100, 10, 50);
        p.buildBuilding(h1);
        p.buildBuilding(h2);
        p.buildBuilding(h3);
        assertEquals(160, p.getRent());
    }

    @Test
    public void testResetOwner() {
        Properties p = new Properties("E",100, 30, "red", 50);
        assertFalse(p.OwnedByPlayer());


    }


}
