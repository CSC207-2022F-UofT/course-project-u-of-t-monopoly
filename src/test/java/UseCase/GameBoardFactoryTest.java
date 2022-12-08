package UseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class GameBoardFactoryTest {

    @Test
    public void GameBoardFactoryTests(){
        // this test tests that a gameboard object is correctly created by the
        // gbf. Further, it test the getter methods within the GameBoardFactory classs
        // at the same time
        GameBoardFactory gbf = new GameBoardFactory();
        Assertions.assertEquals(40, gbf.getGameBoard().getProperties().size());
        Assertions.assertEquals(0, gbf.getPlayers().size());

    }


}
