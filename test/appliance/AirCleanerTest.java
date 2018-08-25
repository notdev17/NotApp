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
    void toStringTest() {
        airCleaner = new AirCleaner("Model", "Brand", 200);
        assertEquals(airCleaner.toString(), "Air Cleaner: Model, Brand, 200.0");
    }
}