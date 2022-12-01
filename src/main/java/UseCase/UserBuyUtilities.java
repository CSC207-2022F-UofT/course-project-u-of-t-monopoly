package UseCase;
import Entity.Player;
import Entity.Utilities;


public class UserBuyUtilities {
    private Player player;
    private Utilities utility;

    public UserBuyUtilities(Player player1, Utilities utility1){
        this.player = player1;
        this.utility = utility1;

    }

    public String BuyUtility(){
        if (this.player.getMoney() >= this.utility.getPrice()) {
            if (!this.utility.ownedByPlayer()){
                this.player.loseMoney(this.utility.getPrice());
                this.utility.setOwner(this.player);
                return "Purchase Successful";
            }
        }

        return "You don't have enough money";
    }

}