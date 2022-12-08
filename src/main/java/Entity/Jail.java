package Entity;

import java.util.ArrayList;

public class Jail {
    // How to go to Jail:
    // roll double thrice consecutively
    // go to jail chance card (if passed go to land on card chest, collect go money, else go directly to jail)
    // land on jail (visiting, no penalty)
    private ArrayList<Player> players;

    /**
     * Initialize Jail Object
     *
     */

    public Jail() {
        this.players = new ArrayList<>();
    }

    /**
     * Getter method to get all players currently in Jail
     *
     */
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    /**
     * set player to jail
     * @param player: a player
     */
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    /**
     * remove player from jail
     * @param player: a player
     */
    public void removePlayer(Player player) {
        this.players.remove(player);
    }




}
