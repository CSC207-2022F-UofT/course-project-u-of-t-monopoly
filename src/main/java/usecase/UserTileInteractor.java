package usecase;

import entity.*;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class to buy, getName, getRent, payRent, and MortgageToPay TileCanBuy Objects
 */
public class UserTileInteractor {

    private TileCanBuy tileCanBuy;
    private Player player;

    private GameBoard board;

    /**
     * Instantiate a UserTIleInteractor
     * @param tileCanBuy Object tile to be interacted with
     * @param player the Player object associated with the TileCanBuy Object
     * @param board the GameBoard keeping track of the state of the game
     */
    public UserTileInteractor(TileCanBuy tileCanBuy, Player player, GameBoard board) {this.tileCanBuy = tileCanBuy;this.player = player;this.board = board;}

    /**
     * A method to buy the TileCanBuy object
     * @return a String as to whether purchase was successful
     */
    public String buy(){
        if (this.player.getMoney() >= tileCanBuy.getPrice()){
            if (tileCanBuy.getOwner() == null){
                this.player.loseMoney(tileCanBuy.getPrice());
                tileCanBuy.resetOwner(this.player);
                return "Success";
            }
        }
        return "Not Enough Money";
    }

    /**
     * Return the name of the TileCanBuy variable
     * @return the name of the TileCanBuy Object
     */
    public String getName(){return tileCanBuy.getName();}


    /**
     * Return the rent of the tile
     * @param rolls the amount rolled on a Players last turn
     * @return the amount of rent to be paid
     */
    public int getRent(ArrayList<Integer> rolls){
        if (tileCanBuy instanceof Utilities) {
            int counter = 0;
            for (Object tile : this.board.getProperties()) {
                if (tile instanceof Utilities) {
                    if (((Utilities) tile).getOwner() != null) {
                        counter += 1;
                    }
                }
            }
            if (counter == 1) {
                return ((Utilities) tileCanBuy).getMoneyChange1(rolls.get(0) + rolls.get(1));
            }
            else {
                return ((Utilities) tileCanBuy).getMoneyChange2(rolls.get(0) + rolls.get(1));
            }
        }
        return tileCanBuy.getRent();
    }

    public String payRent(ArrayList<Integer> rolls){
        Player owner = tileCanBuy.getOwner();
        int amount = this.getRent(rolls);
        if (player.getMoney() < amount){
            String message = this.mortgageToPay(amount);
            if (Objects.equals(message, "Bankrupt")){
                owner.addMoney(this.player.getMoney());
                this.player.loseMoney(this.player.getMoney());
            }
            return message;
        }
        else {
            player.loseMoney(tileCanBuy.getRent());
            owner.addMoney(tileCanBuy.getRent());
            return "Paid Rent to " + owner.getUsername();
        }
    }


    /**
     * If not enough money is available for a Player to pay rent, taxes etc, mortgage their Properties
     * @param required the required tax, rent, etc, to be paid
     * @return a message indicating if the Player is bankrupt or if they mortgaged their Properties
     */
    public String mortgageToPay(Integer required) {
        TileCanBuy t;
        ArrayList<TileCanBuy> lst = new ArrayList<>();
        for (TileCanBuy tile : this.player.getTile()){
            if (tile.getMortgageValue() + this.player.getMoney() >= required){
                lst.add(tile);
            }
        }
        // no tile can be mortgaged, Bankrupt.
        if(lst.size() == 0) {return "Bankrupt";}
        // find the tile has the least mortgage value, if same, compare potential profit
        t = lst.get(0);
        for (TileCanBuy tile: lst) {
            if (tile.getMortgageValue() < t.getMortgageValue()){
                t = tile;
            }
            else if (tile.getMortgageValue() == t.getMortgageValue()){
                if (tile.getRent() <= t.getRent()){
                    t = tile;
                }
            }
        }
        this.player.addMoney(t.getMortgageValue());
        this.player.removeTile(t);
        t.resetOwner();
        if (t instanceof Properties) {((Properties) t).removeBuilding();}
        this.player.loseMoney(required);
        return t.getName();
    }
}
