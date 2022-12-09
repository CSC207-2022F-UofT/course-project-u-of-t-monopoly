package entity;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameBoardTest {



    @Test
    public void gameBoardAddPlayer() {
        // test the add player method in GameBoard
        // test the getNumPlayers method at the same time
        ArrayList<Object> lst = new ArrayList<>(40);
        lst.add("Go"); //done
        lst.add(new Properties("Mediterranean Avenue", 60, 2, "Brown", 30));//done
        lst.add("Community Chest");
        lst.add(new Properties("Baltic Avenue", 60, 4, "Brown", 30)); //done
        lst.add("Income Tax"); //minus 200 //done
        lst.add(new RailRoad("Reading RailRoad", 200));//done
        lst.add(new Properties("Oriental Avenue", 100, 6, "Light Blue", 50));//done
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
        lst.add(new Properties("Kentucky", 220, 18, "Red", 110));//done
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

        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("Bill", 1);
        players.add(player1);

        GameBoard game = new GameBoard(players, lst);

        Assertions.assertEquals(1, game.getNumPlayers());
        Player player2 = new Player("BOB", 2);
        game.addPlayer(player2);

        Assertions.assertEquals(2, game.getNumPlayers());
    }

    @Test
    public void gameBoardPlayerOut() {
        // test the PlayerOut method in the GameBoard Class
        ArrayList<Object> lst = new ArrayList<>(40);
        lst.add("Go"); //done
        lst.add(new Properties("Mediterranean Avenue", 60, 2, "Brown", 30));//done
        lst.add("Community Chest");
        lst.add(new Properties("Baltic Avenue", 60, 4, "Brown", 30)); //done
        lst.add("Income Tax"); //minus 200 //done
        lst.add(new RailRoad("Reading RailRoad", 200));//done
        lst.add(new Properties("Oriental Avenue", 100, 6, "Light Blue", 50));//done
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
        lst.add(new Properties("Kentucky", 220, 18, "Red", 110));//done
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

        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("Bill", 1);
        players.add(player1);

        GameBoard game = new GameBoard(players, lst);

        Assertions.assertEquals(1, game.getNumPlayers());
        Player player2 = new Player("BOB", 2);
        game.addPlayer(player2);

        Assertions.assertEquals(2, game.getNumPlayers());
        game.playerOut(player2);
        Assertions.assertEquals(1, game.getNumPlayers());

    }
}


