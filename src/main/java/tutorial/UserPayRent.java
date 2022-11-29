package tutorial;

public class UserPayRent {

    private Player player;
    private Properties property;

    public UserPayRent(Player player1, Properties tile){
        this.player = player1;
        this.property = tile;
    }

    public String PayRent(){
        //check to see if the player can pay rent.
        // If they dont have enough funds they lose all their funds and are bankrupt
        Player owner = property.getOwner();
        if (player.getMoney() < property.getRent()){
            int loss = player.getMoney();
            player.loseMoney(loss);
            owner.addMoney(loss);

            return "Non-Sufficient Funds - Player Bankrupt";
        }
        // Player has enough money to pay rent
        // Transfer money from the player to the owner of Property

        int rent = property.getRent();
        player.loseMoney(rent);
        owner.addMoney(rent);
        return "Paid Rent to " + owner.getUsername();
    }
}
