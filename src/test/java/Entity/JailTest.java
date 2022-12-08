package Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JailTest {

    @Test
    void testAddPlayer() {
        Player p1 = new Player("P1", 1);
        Player p2 = new Player("P2", 2);
        Jail jail = new Jail();
        jail.addPlayer(p1);
        jail.addPlayer(p2);
        assertEquals(2, jail.getPlayers().size());
        assertTrue(jail.getPlayers().contains(p1));
        assertTrue(jail.getPlayers().contains(p2));
    }

    @Test
    void testRemovePlayer() {
        Player p1 = new Player("P1", 1);
        Player p2 = new Player("P2", 2);
        Jail jail = new Jail();
        jail.addPlayer(p1);
        jail.addPlayer(p2);
        jail.removePlayer(p1);
        assertEquals(1, jail.getPlayers().size());
        assertTrue(jail.getPlayers().contains(p2));
        assertFalse(jail.getPlayers().contains(p1));
    }


}