package appliance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirCleanerTest {

    AirCleaner airCleaner;

    @Test
    void getCopy() {
        airCleaner = new AirCleaner();
        AirCleaner airCleaner2 = new AirCleaner();
        assertEquals(airCleaner2, airCleaner);
    }

    @Test
    void getApplianceType() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void toStringTest() {
    }
}