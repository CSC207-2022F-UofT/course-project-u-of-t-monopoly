package UseCase;

import Entity.Player;

/**
 * Class for returning the name of a Player object as a use case rather than at the Entity level 
 */
public class PlayerNameGetter {

    /**
     * return the name of the Player object 
     * @param player the Player object who's name is needed
     * @return the name of the Player object 
     */
    public String getName(Player player) {
        return player.getUsername();
    }
}
