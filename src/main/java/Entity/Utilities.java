package Entity;

public class Utilities {
    private Player owned_player;
    private int player_id;
    //subject to change as we have not decided which to use to indicate the owner.

    private int price;
    int num_rolls;
    private String name;

    /**
     * Intialize a Utilites object given the inputted Player name and the number of rolls multiplier
     * @param owned_player the string representing the name of the owned player
     * @param num_rolls the number of rolls of the last turn (for pay rent functionality)
     */
    public Utilities(String owned_player, int num_rolls) {
        this.name = owned_player;
        this.num_rolls = num_rolls;
    }

    /**
     * Intialize a Utilites object given the inputted Player object (owner) and the num_rolls,
     * along with the name of the Utilities object
     * @param owner the player that owns this utility tile
     * @param num_rolls the number of rolls for the rent functionality
     * @param name the name of the utility tile
     * @param prices the price to buy the utilities tile
     */
    public Utilities(String name, int num_rolls, int prices) {
        this.owned_player = null;
        this.num_rolls = num_rolls;
        this.name = name;
        this.price = prices;
    }

    /**
     * Create a Utilities object based on the inputted name
     * @param name the name of the utility tile
     */
    public Utilities(String name){
            this.name = name;
    }

    /**
     * return the money change that would occur to a player for landing on the Utilities object
     * @return money change to a Player landing on the Utilities
     */
    public int getMoneyChange1(){return 4 * this.num_rolls;}


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
     * Returns the money change if 2 utilities are owned by the same owner
     * @return the money change if 2 utilites are owned by the same owner
     */
    public int getMoneyChange2(){return 10 * this.num_rolls;}

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

}





