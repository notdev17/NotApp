import appliance.Appliance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * Created 12/15/2017 by notDev
 */
class ApplianceTest {

    Appliance appliance;

    /**
     * Author: Devon on 12/15/2017
     * Unit test for Appliance.getCopy()
     */
    @Test
    void getCopy() {
        appliance = new Appliance("Model", "Brand", 5.0);
        Appliance appliance2 = appliance.getCopy();
        //ensure that all fields are equal to each other
        assertEquals(appliance.getModel(), appliance2.getModel());
        assertEquals(appliance.getBrand(), appliance2.getBrand());
        assertEquals(appliance.getEnergy(), appliance2.getEnergy());
        //ensure that getCopy does not turn a copy by reference.
        assertNotSame(appliance, appliance2);
    }

    /**
     * Author Tim on 12/15/2016
     */
    @Test
    void getModel() {
        appliance = new Appliance("Model", "Brand", 5.0);
        assertEquals("Model", appliance.getModel());
    }

    /**
     * Author Michelle on 12/15/2016
     */
    @Test
    void getBrand() {
        appliance = new Appliance("Model", "Brand", 5.0);
        assertEquals("Brand", appliance.getBrand());
    }

    /**
     * Author Brandon on 12/15/2016
     */
    @Test
    void getEnergy() {
        appliance = new Appliance("Model", "Brand", 5.0);
        assertEquals(5.0, appliance.getEnergy());
    }

    /**
     * Author: Daylen on 12/15/2017
     */
    @Test
    void getSetPrice() {
        appliance = new Appliance("Model", "Brand", 5.0);
        appliance.setPrice(10.0);
        assertEquals(10.0, appliance.getPrice());
    }
}