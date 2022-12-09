package entity;

import use_case.GameBoardFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameBoardPlayerTest {
    // Please run tests in build.gradle
    @Test
    public void TestCheckGameEnd(){
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        Player p1 = new Player("A", 1);
        Player p2 = new Player("B", 2);
        gb.addPlayer(p1);
        gb.addPlayer(p2);
        gb.PlayerOut(p1);
        Assertions.assertTrue(gb.checkGameEnd());

    }
    @Test
    public void TestPlayerOut1(){
        Player p1 = new Player("A", 1);
        p1.addProperty(new Properties("Mediterranean Avenue", 60, 2, "Brown", 30));
        p1.addProperty(new RailRoad("Reading RailRoad", 200));
        p1.addProperty(new Utilities("Electric Company", 150));
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        gb.addPlayer(p1);
        gb.PlayerOut(p1);
        System.out.println(p1.getTile().size());
        Assertions.assertEquals(0, p1.getTile().size());
    }

    @Test
    public void TestPlayerOut2(){
        Player p1 = new Player("A", 1);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        gb.addPlayer(p1);
        gb.PlayerOut(p1);
        Assertions.assertEquals(0, gb.getNumPlayers());
    }


}
