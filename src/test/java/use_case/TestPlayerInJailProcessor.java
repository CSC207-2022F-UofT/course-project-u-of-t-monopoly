package use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entity.*;

import static org.junit.Assert.assertEquals;
public class TestPlayerInJailProcessor {
    @Test
    public void testPlayerInJailTrue(){
        Player a = new Player("A", 100);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard g = gbf.getGameBoard();
        Jail j = new Jail();
        PlayerGoToJailProcessor go = new PlayerGoToJailProcessor(a,g);
        go.PlayerGoToJail();
        PlayerInJailProcessor in = new PlayerInJailProcessor(a,j);
        Assertions.assertTrue(in.playerInJail());
    }
    @Test
    public void testPlayerInJailFalse(){
        Player a = new Player("A", 100);
        GameBoard g = new GameBoard();
        Jail j = new Jail();
        PlayerInJailProcessor in = new PlayerInJailProcessor(a,j);
        Assertions.assertFalse(in.playerInJail());
    }
    @Test
    public void testPlayerHasFreeCardTrue(){
        Player a = new Player("A", 100);
        Jail j = new Jail();
        PlayerInJailProcessor in = new PlayerInJailProcessor(a,j);
        a.addOutOfJailFreeCard();
        Assertions.assertTrue(in.playerHasFreeCard());
    }

    @Test
    public void testPlayerHasFreeCardFalse(){
        Player a = new Player("A", 100);
        Jail j = new Jail();
        PlayerInJailProcessor in = new PlayerInJailProcessor(a,j);
        Assertions.assertFalse(in.playerHasFreeCard());
    }

    @Test
    public void testPlayerUseFreeCard(){
        Player a = new Player("A", 100);
        Jail j = new Jail();
        PlayerInJailProcessor in = new PlayerInJailProcessor(a,j);
        a.addOutOfJailFreeCard();
        in.playerUseFreeCard();
        Assertions.assertFalse(in.playerInJail());
    }

    @Test
    public void testSetPlayerFree(){
        Player a = new Player("A", 100);
        Jail j = new Jail();
        PlayerInJailProcessor in = new PlayerInJailProcessor(a,j);
        in.setPlayerFree();
        Assertions.assertFalse(a.isInJail());
        Assertions.assertEquals(0, a.getTurnsInJail());
        Assertions.assertFalse(j.getPlayers().contains(a));
    }

}
