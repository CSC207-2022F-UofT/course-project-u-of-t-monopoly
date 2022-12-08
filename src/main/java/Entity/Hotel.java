package Entity;

public class Hotel extends Building{
    //subclass of Building

    /**
     * Instantiate a Hotel Object 
     * @param price the price of the Hotel 
     * @param rent the rent of the Hotel 
     * @param mortgageValue the mortgageValue of the Hotel
     */
    public Hotel(Integer price, Integer rent, Integer mortgageValue){
        super(price, rent, mortgageValue);
    }


}
