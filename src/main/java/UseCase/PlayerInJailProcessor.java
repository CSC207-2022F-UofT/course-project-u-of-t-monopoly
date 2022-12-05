package UseCase;

import Entity.Player;
import Entity.Jail;

public class PlayerInJailProcessor {

    private Player player;
    private Jail jail;

    public PlayerInJailProcessor(Player player, Jail jail){
        this.player = player;
        this.jail = jail;
    }

    public boolean playerInJail(){
        return this.player.isInJail();

    }

    public boolean playerHasFreeCard() {
        return this.player.getOutofJailFreeCard() > 0;
    }

    public void playerUseFreeCard() {this.player.useOutOfJailFreeCard();}

    public void setPlayerFree() {
        this.player.setInJail(false);
        this.player.setTurnsInJail(0);
        this.jail.removePlayer(this.player);
    }

}
