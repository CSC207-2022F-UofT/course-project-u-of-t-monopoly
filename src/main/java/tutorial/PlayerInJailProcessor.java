package tutorial;

public class PlayerInJailProcessor {

    private Player player;
    private Jail jail;

    public PlayerInJailProcessor(Player player){
        this.player = player;
    }

    public boolean playerInJail(){
        if(this.player.inJail){
            return true;
        }
        if(this.player.getOutofJailFreeCard > 0){
            return true;
        }
        return false;
    }

}
