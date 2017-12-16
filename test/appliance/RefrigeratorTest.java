import appliance.Refrigerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by notDev on 12/15/2017
 * NOTE: This was copied from AirCleanerTest and slightly edited. See AirCleanerTest for relevent documentation.
 */
class RefrigeratorTest {

    Refrigerator refrigerator = new Refrigerator();

    @Test
    void getCopy() {
        Refrigerator refrigerator2 = refrigerator.getCopy();
        assertEquals(refrigerator2.toString(), refrigerator.toString());
    }

    @Test
    void getApplianceType() {
        assertEquals(refrigerator.getApplianceType(), "Refrigerator");
    }

    @Test
    void toStringTest() {
        refrigerator = new Refrigerator("Model", "Brand", 1311.0);
        assertEquals(refrigerator.toString(), "Refrigerator Model Brand 1311.0");
    }
}