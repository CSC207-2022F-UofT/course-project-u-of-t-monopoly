package UseCase;

import Entity.*;

import java.util.ArrayList;
import java.util.Objects;


public class MovePlayer {

    private Player player;
    private GameBoard gameboard;

    public MovePlayer(Player player, GameBoard gameboard){
        this.player = player;
        this.gameboard = gameboard;
    }

    public Integer getPosition(){
        return this.player.getPlayerPosition();
    }

    public int move(ArrayList<Integer> diceroll){
        this.player.setPlayerPosition(this.player.getPlayerPosition() + diceroll.get(0) + diceroll.get(1));
        return this.player.getPlayerPosition();
    }

    public void move(int position){
        this.player.setPlayerPosition(position);
    }

    public void passGo(){
        this.player.addMoney(200);
    }

    public Object getTileLanded(Integer id){
        return this.gameboard.getTile(id);
    }

    public Player getPropertyOwner(TileCanBuy tileCanBuy) {
        return tileCanBuy.getOwner();
    }

    public Player getUtilityOwner(Utilities utilities) {return utilities.getOwner();}

    public String taxPlayer(Integer amount) {
        if (this.player.getMoney() >= amount) {
            this.player.loseMoney(amount);
            return "Success";
        }
        else{
            UserTileInteractor uti = new UserTileInteractor(null, this.player, this.gameboard);
            return uti.MortgageToPay(amount);
        }
    }

    public void PlayerOut(){
        this.gameboard.PlayerOut(this.player);
    }
}
