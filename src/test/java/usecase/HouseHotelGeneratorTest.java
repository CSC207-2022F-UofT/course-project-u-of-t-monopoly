package usecase;
import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class HouseHotelGeneratorTest {

    @Test
    public void testGenerateHouse(){
        // Test to see if a House object is contstructed
        HouseHotelGenerator hhg = new HouseHotelGenerator();
        House h = hhg.generateHouse(200, 200, 200);
        Assertions.assertEquals(200, h.getMortgageValue());
        Assertions.assertEquals(200, h.getPrice());
        Assertions.assertEquals(200, h.getRent());
    }

    @Test
    public void testGenerateHotel(){
        // Test to see if a House object is contstructed
        HouseHotelGenerator hhg = new HouseHotelGenerator();
        Hotel h = hhg.generateHotel(200, 200, 200);
        Assertions.assertEquals(200, h.getMortgageValue());
        Assertions.assertEquals(200, h.getPrice());
        Assertions.assertEquals(200, h.getRent());
    }

}
