package Entity;

public class Utilities {
    private Player owned_player;

    private int price;

    private String name;

    private int mortgageValue;


    /**
     * Intialize a Utilites object given the inputted Player object (owner) and the num_rolls,
     * along with the name of the Utilities object
     * @param name the name of the utility tile
     * @param prices the price to buy the utilities tile
     */
    public Utilities(String name, int prices) {
        this.owned_player = null;
        this.name = name;
        this.price = prices;
        this.mortgageValue = prices/2;
    }


    /**
     * returns the name of the Utilities
     * @return return the name of this utility tile
     */
    public String getName(){return this.name;}

    /**
     *Return the price of this utility object
     * @return this.price
     */
    public int getPrice(){return this.price;}



    /**
     * Set the owner of this utility property to player1
     * @param player1 the new owner of this utility
     */
    public void setOwner(Player player1){
        this.owned_player = player1;
    }

    /**
     *
     * @return the boolean as to whether this utility is owned by a player
     */
    public boolean ownedByPlayer(){
        return this.owned_player != null;
    }

    /**
     * return the id of the owner
     * @return return this.player_id
     */
    public Player getOwner(){return this.owned_player;}

    /**
     * Another method for money change whereby the number of rolls can be inputted into the method
     * @param num_roll the number of rolls associated with the pay rent functionality
     * @return the money change based on the num_rolls
     */
    public int getMoneyChange1(int num_roll){return 4 * num_roll;}

    /**
     * Another method for money change whereby the number of rolls can be inputted into the method.
     * This is used when an owner owns two utilities
     * @param num_roll the number of rolls associated with the pay rent functionality
     * @return the money change based on the num_rolls
     */
    public int getMoneyChange2(int num_roll){return 10 * num_roll;}
    
    /**
     * return the mortgage value of the property 
     * @return this.mortgageValue for the Utilities object 
     */
    public int getMortgageValue(){return this.mortgageValue}

}




