package UseCase;

import tutorial.Player;

public class PlayerFactory {
    public Player createPlayer(int id, String name) {
        return new Player(id, name);
    }
}
