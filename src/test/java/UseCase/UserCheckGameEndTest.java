package UseCase;

import Entity.GameBoard;
import Entity.Jail;
import Entity.Player;
import Entity.Properties;
import Entity.RailRoad;
import Entity.Utilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserCheckGameEndTest {

    /**
     * Test to assert that with two players who have money, the game has not ended
     */
    @Test
    public void UserCheckGameEndFalse(){
        Player player = new Player("BOB", 1);
        Player player2 = new Player("BILL", 2);
        List<Player> playerlst = new ArrayList<Player>();
        playerlst.add(player);
        playerlst.add(player2);
        ArrayList<Object> lst= new ArrayList<>(40);
        lst.add("Go"); //done
        lst.add(new Properties("Mediterranean Avenue", 60, 2, "Brown", 30));
        lst.add("Community Chest");
        lst.add(new Properties("Baltic Avenue", 60, 4, "Brown", 30));
        lst.add("Income Tax"); //minus 200 //done
        lst.add(new RailRoad("Reading RailRoad", 200, 50));
        lst.add(new Properties("Oriental Avenue", 100, 6, "Light Blue", 50));
        lst.add(new Properties("Vermont Avenue", 100, 6, "Light Blue", 50));
        lst.add(new Properties("Connecticut Avenue", 120, 8, "Light Blue", 60));
        lst.add(new Jail());
        lst.add(new Properties("St. Charles Place", 140, 10, "Purple", 70));
        lst.add(new Utilities("Electric Company", 150));
        lst.add(new Properties("States Avenue", 140, 10, "Purple", 70));
        lst.add(new Properties("Virginia Avenue", 160, 12, "Purple", 80));
        lst.add(new RailRoad("Pennsylvania RailRoad", 200, 50));
        lst.add(new Properties("St. James Place", 180, 14, "Orange", 90));
        lst.add("Community Chest");
        lst.add(new Properties("Tennessee Avenue", 180, 14, "Orange", 90));
        lst.add(new Properties("New York Avenue", 200, 16, "Orange", 100));
        lst.add("Parking"); //done
        lst.add(new Properties("Kentucky", 220, 18, "Red", 110));
        lst.add("Chance Card");
        lst.add(new Properties("Indiana Avenue", 220, 18, "Red", 110));
        lst.add(new Properties("Illinois Avenue", 240, 20, "Red", 120));
        lst.add(new RailRoad("B. & O. RailRoad", 200, 50));
        lst.add(new Properties("Atlantic Avenue", 260, 22, "Yellow", 130));
        lst.add(new Properties("Ventnor Avenue", 260, 22, "Yellow", 130));
        lst.add(new Utilities("Water Works", 150));
        lst.add(new Properties("Marvin Gardens", 280, 24, "Yellow", 140));
        lst.add("Go to Jail"); //done
        lst.add(new Properties("Pacific Avenue", 300, 26, "Green", 150));
        lst.add(new Properties("North Carolina Avenue", 300, 26, "Green", 150));
        lst.add("Community Chest");
        lst.add(new Properties("Pennsylvania Avenue", 320, 28, "Green", 160));
        lst.add(new RailRoad("Short Line RailRoad", 200, 50));
        lst.add("Chance Card");
        lst.add(new Properties("Park Place", 350, 35, "Dark Blue", 175));
        lst.add("Luxury Tax"); //minus 100  //done
        lst.add(new Properties("Boardwalk", 400, 50, "Dark Blue", 200));

        GameBoard gameBoard = new GameBoard(playerlst, lst);
        UserCheckGameEnd ucge = new UserCheckGameEnd();
        Assertions.assertEquals(false, ucge.CheckGameEnd(gameBoard));


    }

    /**
     * Test to assert that a GameBoard object with only one player has ended given that no other players are playing
     */
    @Test
    public void UserCheckGameEndTrue() {
        Player player = new Player("BOB", 1);
        List<Player> playerlst = new ArrayList<Player>();
        playerlst.add(player);
        ArrayList<Object> lst = new ArrayList<>(40);
        lst.add("Go"); //done
        lst.add(new Properties("Mediterranean Avenue", 60, 2, "Brown", 30));
        lst.add("Community Chest");
        lst.add(new Properties("Baltic Avenue", 60, 4, "Brown", 30));
        lst.add("Income Tax"); //minus 200 //done
        lst.add(new RailRoad("Reading RailRoad", 200, 50));
        lst.add(new Properties("Oriental Avenue", 100, 6, "Light Blue", 50));
        lst.add(new Properties("Vermont Avenue", 100, 6, "Light Blue", 50));
        lst.add(new Properties("Connecticut Avenue", 120, 8, "Light Blue", 60));
        lst.add(new Jail());
        lst.add(new Properties("St. Charles Place", 140, 10, "Purple", 70));
        lst.add(new Utilities("Electric Company", 150));
        lst.add(new Properties("States Avenue", 140, 10, "Purple", 70));
        lst.add(new Properties("Virginia Avenue", 160, 12, "Purple", 80));
        lst.add(new RailRoad("Pennsylvania RailRoad", 200, 50));
        lst.add(new Properties("St. James Place", 180, 14, "Orange", 90));
        lst.add("Community Chest");
        lst.add(new Properties("Tennessee Avenue", 180, 14, "Orange", 90));
        lst.add(new Properties("New York Avenue", 200, 16, "Orange", 100));
        lst.add("Parking"); //done
        lst.add(new Properties("Kentucky", 220, 18, "Red", 110));
        lst.add("Chance Card");
        lst.add(new Properties("Indiana Avenue", 220, 18, "Red", 110));
        lst.add(new Properties("Illinois Avenue", 240, 20, "Red", 120));
        lst.add(new RailRoad("B. & O. RailRoad", 200, 50));
        lst.add(new Properties("Atlantic Avenue", 260, 22, "Yellow", 130));
        lst.add(new Properties("Ventnor Avenue", 260, 22, "Yellow", 130));
        lst.add(new Utilities("Water Works", 150));
        lst.add(new Properties("Marvin Gardens", 280, 24, "Yellow", 140));
        lst.add("Go to Jail"); //done
        lst.add(new Properties("Pacific Avenue", 300, 26, "Green", 150));
        lst.add(new Properties("North Carolina Avenue", 300, 26, "Green", 150));
        lst.add("Community Chest");
        lst.add(new Properties("Pennsylvania Avenue", 320, 28, "Green", 160));
        lst.add(new RailRoad("Short Line RailRoad", 200, 50));
        lst.add("Chance Card");
        lst.add(new Properties("Park Place", 350, 35, "Dark Blue", 175));
        lst.add("Luxury Tax"); //minus 100  //done
        lst.add(new Properties("Boardwalk", 400, 50, "Dark Blue", 200));

        GameBoard gameBoard = new GameBoard(playerlst, lst);
        UserCheckGameEnd ucge = new UserCheckGameEnd();
        Assertions.assertEquals(true, ucge.CheckGameEnd(gameBoard));

    }
}
