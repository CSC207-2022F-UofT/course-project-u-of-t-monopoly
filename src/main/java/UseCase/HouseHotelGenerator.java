package UseCase;

import Entity.Hotel;
import Entity.House;

public class HouseHotelGenerator {
    // this class is to solve hard dependency issue (this can be tested independently)
    // when controller calls BuildProcessor, it should also call this generator as well

    public House generateHouse(Integer price, Integer rent, Integer mortgageValue) {
        return new House(price,rent,mortgageValue);
    }

    public Hotel generateHotel(Integer price, Integer rent, Integer mortgageValue) {
        return new Hotel(price, rent, mortgageValue);
    }
}
