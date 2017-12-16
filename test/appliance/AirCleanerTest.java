
import appliance.AirCleaner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirCleanerTest {

    private AirCleaner airCleaner= new AirCleaner();

    @Test
    void getCopy() {
        AirCleaner airCleaner2 = new AirCleaner();
        assertEquals(airCleaner2.toString(), airCleaner.toString());
    }

    @Test
    void getApplianceType() {
        assertEquals(airCleaner.getApplianceType(), "Air Cleaner");
    }

    @Test
    void getPrice() {
        assertEquals(airCleaner.getPrice(), 150.00);
    }

    @Test
    void toStringTest() {
        airCleaner = new AirCleaner("Model", "Brand", 200);
        assertEquals(airCleaner.toString(), "Model Brand 200.0");
    }
}