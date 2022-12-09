package use_case;

import entity.*;

/**
 * Class to build Hotel and House objects for the purpose of adding them to a 
 * Properties object 
 */
public class HouseHotelGenerator {
    // this class is to solve hard dependency issue (this can be tested independently)
    // when controller calls BuildProcessor, it should also call this generator as well

    /**
     * Build a House object 
     * @param price the price of the house 
     * @param rent the rent associated with the house 
     * @param mortgageValue the mortgage value of the house object 
     * @return the House object 
     */
    public House generateHouse(Integer price, Integer rent, Integer mortgageValue) {
        return new House(price,rent,mortgageValue);
    }

    /**
     * Build a Hotel object 
     * @param price the price of the Hotel 
     * @param rent the rent of the Hotel 
     * @param mortgageValue the mortgageValue of the Hotel 
     * @return the newly built Hotel Object
     */
    public Hotel generateHotel(Integer price, Integer rent, Integer mortgageValue) {
        return new Hotel(price, rent, mortgageValue);
    }
}
