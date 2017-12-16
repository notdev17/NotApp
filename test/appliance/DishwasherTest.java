import appliance.Dishwasher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by notDev on 12/15/2017
 * NOTE: This was copied from AirCleanerTest and slightly edited. See AirCleanerTest for relevent documentation.
 */
class DishwasherTest {

    Dishwasher dishwasher = new Dishwasher();

    @Test
    void getCopy() {
        Dishwasher dishwasher2 = new Dishwasher();
        assertEquals(dishwasher2.toString(), dishwasher.toString());
    }

    @Test
    void getApplianceType() {
        assertEquals(dishwasher.getApplianceType(), "Dishwasher");
    }

    @Test
    void toStringTest() {
        dishwasher = new Dishwasher("Model", "Brand", 83.0);
        assertEquals(dishwasher.toString(), "Dishwasher Model Brand 83.0");
    }
}