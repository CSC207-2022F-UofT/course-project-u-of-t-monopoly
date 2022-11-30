
package UseCase;

import Entity.Utilities;
import Entity.Player;


public class UserPayRentUtility {
    private Utilities utility;
    private Player player;
    private int roll;

    public UserPayRentUtility(Utilities place, Player player1, int rolls){
        this.player = player1;
        this.utility = place;
        this.roll = rolls;
    }

    /**
     * Checks to see if the player has enough funds to pay the rent. If yes the player loses the
     * rent and the owner gains it in their money. If no, then the player loses all the money they have.
     * @return a string depending on if the player has enough funds to pay rent
     */
    public String payRentOneOwner(){
        //check to see if the player can pay rent for the Utilities.
        // If they dont have enough funds they lose all their funds and are bankrupt
        int rent = utility.getMoneyChange1(roll);
        if (player.getMoney() < rent){
            int loss = player.getMoney();
            player.loseMoney(loss);
            utility.getOwner().addMoney(loss);
            return "Non-Sufficient Funds - Player Bankrupt";
        }
        // Player has the money to pay rent
        // Transfer money from the player to the owner of Property
        player.loseMoney(rent);
        utility.getOwner().addMoney(rent);
        return "Paid Rent to " + utility.getOwner().getUsername();


    }

    /**
     * A method that updates the player's money as well as the owner of the utilities class. If the lease payment is
     * larger than the player's money, they lose all their money (and it goes to the owner)
     *
     * @return the string demonstrating what has happened in terms of how much money tha player has lost
     */
    public String payRentTwoOwner(){
        //check to see if the player can pay rent for the Utilities.
        // If they dont have enough funds they lose all their funds and are bankrupt
        int lease = utility.getMoneyChange2(roll);
        if (player.getMoney() < lease){
            int loss = player.getMoney();
            player.loseMoney(loss);
            utility.getOwner().addMoney(loss);
            return "Non-Sufficient Funds - Player Bankrupt";
        }
        // Player has the money to pay rent
        // Transfer money from the player to the owner of Property
        player.loseMoney(lease);
        utility.getOwner().addMoney(lease);
        return "Paid Rent to " + utility.getOwner().getUsername();


    }
}
