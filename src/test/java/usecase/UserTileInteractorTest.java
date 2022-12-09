package usecase;
import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserTileInteractorTest {
    // Please run tests in build.gradle

    @Test
    public void testBuy1(){
        Player p = new Player("A", 1);
        //player has no money right now
        p.loseMoney(1500);
        Properties properties = new Properties("Ventnor Avenue", 260, 22, "Yellow", 130);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        UserTileInteractor uti = new UserTileInteractor(properties,p,gb);
        Assertions.assertEquals("Not Enough Money", uti.buy());
    }

    @Test
    public void testBuy2(){
        Player p = new Player("A", 1);
        //player has money right now
        Properties properties = new Properties("Ventnor Avenue", 260, 22, "Yellow", 130);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        UserTileInteractor uti = new UserTileInteractor(properties,p,gb);
        Assertions.assertEquals( "Success",uti.buy());
    }

    @Test
    public void testGetRent1(){
        Player p = new Player("A", 1);
        Properties properties = new Properties("Ventnor Avenue", 260, 22, "Yellow", 130);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        UserTileInteractor uti = new UserTileInteractor(properties,p,gb);
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls.add(3);
        rolls.add(3);
        Assertions.assertEquals(22, uti.getRent(rolls));
    }


    @Test
    public void testGetRent2(){
        Player p = new Player("A", 1);
        Properties properties = new Properties("Ventnor Avenue", 260, 22, "Yellow", 130);
        properties.buildBuilding(new House(50, 4, 25));
        properties.buildBuilding(new House(50, 5, 25));
        properties.buildBuilding(new House(50, 2, 25));
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        UserTileInteractor uti = new UserTileInteractor(properties,p,gb);
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls.add(3);
        rolls.add(3);
        Assertions.assertEquals(33,uti.getRent(rolls));
    }

    @Test
    public void testGetRent3(){
        Player p = new Player("A", 1);
        RailRoad railRoad = new RailRoad("Short Line RailRoad", 200);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        UserTileInteractor uti = new UserTileInteractor(railRoad,p,gb);
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls.add(3);
        rolls.add(3);
        Assertions.assertEquals(50, uti.getRent(rolls));
    }

    @Test
    public void testGetRent4(){
        Player p = new Player("A", 1);
        Player p1 = new Player("B", 2);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        Utilities utilities = (Utilities) gb.getTile(11);
        utilities.resetOwner(p1);
        UserTileInteractor uti = new UserTileInteractor(utilities,p,gb);
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls.add(3);
        rolls.add(3);
        Assertions.assertEquals(24, uti.getRent(rolls));
    }

    @Test
    public void testGetRent5(){
        Player p = new Player("A", 1);
        Player p1 = new Player("B", 2);
        Player p2 = new Player("C", 3);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        Utilities utilities = (Utilities) gb.getTile(11);
        Utilities utilities1 = (Utilities) gb.getTile(27);
        utilities.resetOwner(p1);
        utilities1.resetOwner(p2);
        UserTileInteractor uti = new UserTileInteractor(utilities,p,gb);
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls.add(3);
        rolls.add(3);
        Assertions.assertEquals(60, uti.getRent(rolls));
    }

    @Test
    public void testMortgageToPay(){
        Player p = new Player("A", 1);
        p.loseMoney(1500);
        p.addProperty(new Properties("Illinois Avenue", 240, 20, "Red", 120));
        Properties properties = new Properties("Ventnor Avenue", 260, 22, "Yellow", 130);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        UserTileInteractor uti = new UserTileInteractor(properties,p,gb);
        Assertions.assertEquals("Illinois Avenue", uti.mortgageToPay(22));
    }

    @Test
    public void testPayRent1(){
        //player p has enough money
        Player p = new Player("A", 1);
        Player p1 = new Player("B", 2);
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls.add(3);
        rolls.add(3);
        Properties properties = new Properties("Ventnor Avenue", 260, 22, "Yellow", 130);
        properties.resetOwner(p1);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        UserTileInteractor uti = new UserTileInteractor(properties,p,gb);
        Assertions.assertEquals("Paid Rent to B", uti.payRent(rolls));
    }
    @Test
    public void testPayRent2(){
        Player p = new Player("A", 1);
        //player p has no money and nothing to be mortgaged.
        p.loseMoney(1500);
        Player p1 = new Player("B", 2);
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls.add(3);
        rolls.add(3);
        Properties properties = new Properties("Ventnor Avenue", 260, 22, "Yellow", 130);
        properties.resetOwner(p1);
        GameBoardFactory gbf = new GameBoardFactory();
        GameBoard gb = gbf.getGameBoard();
        UserTileInteractor uti = new UserTileInteractor(properties,p,gb);
        Assertions.assertEquals("Bankrupt", uti.payRent(rolls));
    }

}
