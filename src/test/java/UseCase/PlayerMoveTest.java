package UseCase;

import Entity.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestPlayerMove {
    @Test
    public void testMoveOnce() {
        Player a = new Player("A", 100);
        GameBoard g = new GameBoard();
        MovePlayer m = new MovePlayer(a, g);
        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        m.move(num);
        assertEquals(3, a.getPlayerPosition());
    }

    @Test
    public void testMoveTwice() {
        Player a = new Player("A", 100);
        GameBoard g = new GameBoard();
        MovePlayer m = new MovePlayer(a, g);
        ArrayList<Integer> num1 = new ArrayList<>();
        num1.add(1);
        num1.add(2);
        ArrayList<Integer> num2 = new ArrayList<>();
        num2.add(3);
        num2.add(4);
        m.move(num1);
        m.move(num2);
        assertEquals(10, a.getPlayerPosition());
    }

    @Test
    public void testMoveMost() {
        Player a = new Player("A", 100);
        GameBoard g = new GameBoard();
        MovePlayer m = new MovePlayer(a, g);
        ArrayList<Integer> num1 = new ArrayList<>();
        num1.add(6);
        num1.add(6);
        ArrayList<Integer> num2 = new ArrayList<>();
        num2.add(6);
        num2.add(6);
        m.move(num1);
        m.move(num2);
        assertEquals(24, a.getPlayerPosition());
    }

    @Test
    public void testMoveLeast() {
        Player a = new Player("A", 100);
        GameBoard g = new GameBoard();
        MovePlayer m = new MovePlayer(a, g);
        ArrayList<Integer> num1 = new ArrayList<>();
        num1.add(1);
        num1.add(1);
        ArrayList<Integer> num2 = new ArrayList<>();
        num2.add(1);
        num2.add(1);
        m.move(num1);
        m.move(num2);
        assertEquals(4, a.getPlayerPosition());
    }
    @Test
    public void testGetTileLanded(){
        ArrayList<Object> lst= new ArrayList<>(40);
        lst.add("Go"); //done
        lst.add(new Properties("Mediterranean Avenue", 60, 2, "Brown", 30));//done
        lst.add("Community Chest");
        lst.add(new Properties("Baltic Avenue", 60, 4, "Brown", 30)); //done
        lst.add("Income Tax"); //minus 200 //done
        lst.add(new RailRoad("Reading RailRoad", 200));//done
        lst.add(new Properties("Oriental Avenue", 100, 6, "Light Blue", 50));//done 6
        lst.add(new Properties("Vermont Avenue", 100, 6, "Light Blue", 50));//done
        lst.add(new Properties("Connecticut Avenue", 120, 8, "Light Blue", 60));//done
        lst.add(new Jail()); //done
        lst.add(new Properties("St. Charles Place", 140, 10, "Purple", 70));//done
        lst.add(new Utilities("Electric Company", 150));//done
        lst.add(new Properties("States Avenue", 140, 10, "Purple", 70));//done
        lst.add(new Properties("Virginia Avenue", 160, 12, "Purple", 80));//done
        lst.add(new RailRoad("Pennsylvania RailRoad", 200));//done
        lst.add(new Properties("St. James Place", 180, 14, "Orange", 90));//done
        lst.add("Community Chest");
        lst.add(new Properties("Tennessee Avenue", 180, 14, "Orange", 90));//done
        lst.add(new Properties("New York Avenue", 200, 16, "Orange", 100));//done
        lst.add("Parking"); //done
        lst.add(new Properties("Kentucky Avenue", 220, 18, "Red", 110));//done
        lst.add("Chance Card");
        lst.add(new Properties("Indiana Avenue", 220, 18, "Red", 110));//done
        lst.add(new Properties("Illinois Avenue", 240, 20, "Red", 120));//done
        lst.add(new RailRoad("B. & O. RailRoad", 200));//done
        lst.add(new Properties("Atlantic Avenue", 260, 22, "Yellow", 130));//done
        lst.add(new Properties("Ventnor Avenue", 260, 22, "Yellow", 130));//done
        lst.add(new Utilities("Water Works", 150));//done
        lst.add(new Properties("Marvin Gardens", 280, 24, "Yellow", 140));//done
        lst.add("Go to Jail"); //done
        lst.add(new Properties("Pacific Avenue", 300, 26, "Green", 150));
        lst.add(new Properties("North Carolina Avenue", 300, 26, "Green", 150));//done
        lst.add("Community Chest");
        lst.add(new Properties("Pennsylvania Avenue", 320, 28, "Green", 160));//done
        lst.add(new RailRoad("Short Line RailRoad", 200));//done
        lst.add("Chance Card");
        lst.add(new Properties("Park Place", 350, 35, "Dark Blue", 175));//done
        lst.add("Luxury Tax"); //minus 100  //done
        lst.add(new Properties("Boardwalk", 400, 50, "Dark Blue", 200));//done

        Player a = new Player("A", 100);
        ArrayList<Player> players = new ArrayList<>();
        players.add(a);
        GameBoard g = new GameBoard(players, lst);
        MovePlayer m = new MovePlayer(a, g);
        Assertions.assertEquals(g.getTile(0), m.getTileLanded(0));
        Assertions.assertEquals(g.getTile(1), m.getTileLanded(1));
        Assertions.assertEquals(g.getTile(2), m.getTileLanded(2));
        Assertions.assertEquals(g.getTile(3), m.getTileLanded(3));
        Assertions.assertEquals(g.getTile(4), m.getTileLanded(4));
        Assertions.assertEquals(g.getTile(5), m.getTileLanded(5));
        Assertions.assertEquals(g.getTile(6), m.getTileLanded(6));
        Assertions.assertEquals(g.getTile(7), m.getTileLanded(7));
        Assertions.assertEquals(g.getTile(8), m.getTileLanded(8));
        Assertions.assertEquals(g.getTile(9), m.getTileLanded(9));
        Assertions.assertEquals(g.getTile(10), m.getTileLanded(10));
        Assertions.assertEquals(g.getTile(11), m.getTileLanded(11));
        Assertions.assertEquals(g.getTile(12), m.getTileLanded(12));
        Assertions.assertEquals(g.getTile(13), m.getTileLanded(13));
        Assertions.assertEquals(g.getTile(14), m.getTileLanded(14));
        Assertions.assertEquals(g.getTile(15), m.getTileLanded(15));
        Assertions.assertEquals(g.getTile(16), m.getTileLanded(16));
        Assertions.assertEquals(g.getTile(17), m.getTileLanded(17));
        Assertions.assertEquals(g.getTile(18), m.getTileLanded(18));
        Assertions.assertEquals(g.getTile(19), m.getTileLanded(19));
        Assertions.assertEquals(g.getTile(20), m.getTileLanded(20));
        Assertions.assertEquals(g.getTile(21), m.getTileLanded(21));
        Assertions.assertEquals(g.getTile(22), m.getTileLanded(22));
        Assertions.assertEquals(g.getTile(23), m.getTileLanded(23));
        Assertions.assertEquals(g.getTile(24), m.getTileLanded(24));
        Assertions.assertEquals(g.getTile(25), m.getTileLanded(25));
        Assertions.assertEquals(g.getTile(26), m.getTileLanded(26));
        Assertions.assertEquals(g.getTile(27), m.getTileLanded(27));
        Assertions.assertEquals(g.getTile(28), m.getTileLanded(28));
        Assertions.assertEquals(g.getTile(29), m.getTileLanded(29));
        Assertions.assertEquals(g.getTile(30), m.getTileLanded(30));
        Assertions.assertEquals(g.getTile(31), m.getTileLanded(31));
        Assertions.assertEquals(g.getTile(32), m.getTileLanded(32));
        Assertions.assertEquals(g.getTile(33), m.getTileLanded(33));
        Assertions.assertEquals(g.getTile(34), m.getTileLanded(34));
        Assertions.assertEquals(g.getTile(35), m.getTileLanded(35));
        Assertions.assertEquals(g.getTile(36), m.getTileLanded(36));
        Assertions.assertEquals(g.getTile(37), m.getTileLanded(37));
        Assertions.assertEquals(g.getTile(38), m.getTileLanded(38));
    }

    @Test
    public void testTaxPlayerSuccess() {
        Player a = new Player("A", 100);
        GameBoard g = new GameBoard();
        MovePlayer m = new MovePlayer(a, g);
        m.taxPlayer(500);
        Assertions.assertEquals(1000, a.getMoney());
        Assertions.assertEquals("Success", m.taxPlayer(500));
    }

    @Test
    public void testTaxPlayerMortgage() {
        Player a = new Player("A", 100);
        GameBoard g = new GameBoard();
        MovePlayer m = new MovePlayer(a, g);
        Properties p = new Properties("Mediterranean Avenue", 60, 2, "Brown", 30);
        a.addProperty(p);
        a.loseMoney(1480);
        String message = m.taxPlayer(30);
        Assertions.assertEquals(20, a.getMoney());
        Assertions.assertEquals("Mediterranean Avenue", message);
    }
}
