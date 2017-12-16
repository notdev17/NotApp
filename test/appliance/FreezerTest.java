import appliance.Freezer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void getPrice() {
        assertEquals(freezer.getPrice(), 150.0);
    }

    @Test
    void toStringTest() {
        freezer = new Freezer("Model", "Brand", 111.0);
        assertEquals(freezer.toString(), "Freezer Model Brand 111.0");
    }
}