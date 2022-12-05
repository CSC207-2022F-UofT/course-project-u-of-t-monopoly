package UseCase;

import Entity.Player;

public class PlayerNameGetter {


    public String getName(Player player) {
        return player.getUsername();
    }
}
