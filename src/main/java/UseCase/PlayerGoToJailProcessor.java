package tutorial;


public class PlayerGoToJailProcessor{

    private Player player;
    private GameBoard gameboard;

    public PlayerGoToJailProcessor(Player player, GameBoard gameboard){
        this.player = player;
        this.gameboard = gameboard;

    }

    public boolean PlayerGoToJail(){
        if(this.player.playerPosition == 30) {
        if(this.player.inJail == false ){
            this.player.inJail = true;
            this.player.setPlayerPosition(10); // an input in setPlayerPosition would be the index position of the jail cell
                return true;
            }
        }
        return false;
    }
}
