
import appliance.AirCleaner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirCleanerTest {

    private AirCleaner airCleaner= new AirCleaner();

    /**
     * Author: Brandon on 12/15/2017
     */
    @Test
    void getCopy() {
        AirCleaner airCleaner2 = new AirCleaner();
        assertEquals(airCleaner2.toString(), airCleaner.toString());
    }

    /**
     * Author: Daylen on 12/15/2017
     */
    @Test
    void getApplianceType() {
        assertEquals(airCleaner.getApplianceType(), "Air Cleaner");
    }

    /**
     * Author: Tim on 12/15/2017
     */
    @Test
    void getPrice() {
        assertEquals(airCleaner.getPrice(), 150.00);
    }

    /**
     * Author: Michelle on 12/15/2017
     */
    @Test
    void toStringTest() {
        airCleaner = new AirCleaner("Model", "Brand", 200);
        assertEquals(airCleaner.toString(), "Air Cleaner Model Brand 200.0");
    }
}