package appliance;

import appliance.Dryer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void getPrice() {
        assertEquals(dryer.getPrice(), 150.0);
    }

    @Test
    void toStringTest() {
        dryer = new Dryer("Model", "Brand", 38.0);
        assertEquals(dryer.toString(), "Dryer Model Brand 38.0");
    }
}