package Entity;

public class House extends Building{
    //subclass of Building

    /**
     * Instantiate a House Object
     * @param price the price of the House 
     * @param rent the Rent of the House 
     * @param mortgageValue the mortgageValue of the House 
     */
    public House(Integer price, Integer rent, Integer mortgageValue){
        super(price, rent, mortgageValue);
    }


}
