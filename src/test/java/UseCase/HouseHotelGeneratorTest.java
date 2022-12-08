package UseCase;
import Entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class HouseHotelGeneratorTest {

    @Test
    public void GenerateHouseTest(){
        // Test to see if a House object is contstructed
        HouseHotelGenerator hhg = new HouseHotelGenerator();
        House h = hhg.generateHouse(200, 200, 200);
        Assertions.assertEquals(200, h.getMortgageValue());
        Assertions.assertEquals(200, h.getPrice());
        Assertions.assertEquals(200, h.getRent());
    }

    @Test
    public void GenerateHotelTest(){
        // Test to see if a House object is contstructed
        HouseHotelGenerator hhg = new HouseHotelGenerator();
        Hotel h = hhg.generateHotel(200, 200, 200);
        Assertions.assertEquals(200, h.getMortgageValue());
        Assertions.assertEquals(200, h.getPrice());
        Assertions.assertEquals(200, h.getRent());
    }

}
