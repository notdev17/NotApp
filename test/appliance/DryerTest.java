import appliance.Dryer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by notDev on 12/15/2017
 * NOTE: This was copied from AirCleanerTest and slightly edited. See AirCleanerTest for relevent documentation.
 */
class DryerTest {

    Dryer dryer = new Dryer();

    @Test
    void getCopy() {
        Dryer dryer2 = dryer.getCopy();
        assertEquals(dryer2.toString(), dryer.toString());
    }

    @Test
    void getApplianceType() {
        assertEquals(dryer.getApplianceType(), "Dryer");
    }

    @Test
    void toStringTest() {
        dryer = new Dryer("Model", "Brand", 38.0);
        assertEquals(dryer.toString(), "Dryer Model Brand 38.0");
    }
}