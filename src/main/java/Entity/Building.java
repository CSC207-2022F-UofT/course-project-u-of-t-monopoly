package Entity;

/**
 * Abstract class to be extended by the House and Hotel Classes 
 */
public abstract class Building{
    // Abstract class Building

    private Integer price;
    private Integer rent;
    private Integer mortgageValue;


    /**
     * Instantiate a building object 
     * @param price the price of the Building 
     * @param rent the rent of the Building 
     * @param mortgageValue the mortgageValue of the Building 
     */
    public Building(Integer price, Integer rent, Integer mortgageValue) {
        this.price = price;
        this.rent = rent;
        this.mortgageValue =  mortgageValue;
    }

    /**
     * Getter method for the price 
     * @return the price of the building 
     */
    public int getPrice(){return this.price;}

    /**
     * Getter method for the rent 
     * @return the rent of the building 
     */
    public int getRent(){return this.rent;}

    /**
     * Getter method for the mortgageValue 
     * @return the mortgageValue of the building 
     */
    public int getMortgageValue(){return this.mortgageValue;}
}
