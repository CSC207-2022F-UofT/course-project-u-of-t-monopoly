package UseCase;
import Entity.GameBoard;
import Entity.Jail;
import Entity.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PlayerGoToJailProcessorTest {
    @Test
    public void TestGoToJail1(){
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        Player p = new Player("A", 1);
        Jail jail = (Jail) gb.getTile(9);
        PlayerGoToJailProcessor pgtjp = new PlayerGoToJailProcessor(p,gb);
        pgtjp.PlayerGoToJail();
        Assertions.assertEquals(1, jail.getPlayers().size());
        Assertions.assertTrue(p.isInJail());
        Assertions.assertEquals(9, p.getPlayerPosition());
        Assertions.assertEquals(3,p.getTurnsInJail());
    }
}
