import appliance.Freezer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by notDev on 12/15/2017
 * NOTE: This was copied from AirCleanerTest and slightly edited. See AirCleanerTest for relevent documentation.
 */
class FreezerTest {

    Freezer freezer = new Freezer();

    @Test
    void getCopy() {
        Freezer freezer2 = freezer.getCopy();
        assertEquals(freezer2.toString(), freezer.toString());
    }

    @Test
    void getApplianceType() {
        assertEquals(freezer.getApplianceType(), "Freezer");
    }

    @Test
    void toStringTest() {
        freezer = new Freezer("Model", "Brand", 111.0);
        assertEquals(freezer.toString(), "Freezer Model Brand 111.0");
    }
}