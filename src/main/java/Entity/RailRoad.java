package Entity;

public class RailRoad {
    //class to represent the railRoad tiles on the monopoly board
    private int price;
    private int rent;
    private String name;
    private Player owner;
    private int mortgageValue;

    /**
     * create a RailRoad object based on the inputted names, prices, and rents parameters
     * @param names the name of the tile
     * @param prices the price to buy the tile
     * @param rents the rent when a player lands on a tile that is owned
     */
    public RailRoad(String names, int prices, int rents){
        this.name = names;
        this.price = prices;
        this.rent = rents;
        this.owner = null;
        this.mortgageValue = prices/2;
    }

    /**
     * Return the name of this RailRoad object
     * @return this.name for the RailRoad
     */
    public String getName(){return this.name}

    /**
     * return the price of the RailRoad object
     * @return this.price for the RailRoad
     */
    public int getPrice(){return this.price;}

    /**
     * return the rent amount associated with this RailRoad
     * @return this.rent for the RailRoad
     */
    public int getRent(){return this.rent;}

    /**
     * set the this.owner for the RailRoad to the inputted player1 parameter
     * @param player1 the new owner of the RailRoad object
     */
    public void setOwner(Player player1){
        this.owner = player1;
    }

    /**
     * return the owner of the RailRoad object
     * @return this.owner for the RailRoad object
     */
    public Player getOwner(){
        return this.owner;
    }

    /**
     * return the mortgage value of the RailRoad
     * @return this.mortgageValue
     */
    public int getMortgageValue(){return this.mortgageValue;}
}


