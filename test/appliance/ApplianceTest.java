import appliance.Appliance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class ApplianceTest {

    Appliance appliance= new Appliance();

    /**
     * Author: Devon on 12/15/2017
     * Unit test for Appliance.getCopy()
     */
    @Test
    void getCopy() {
        Appliance appliance2 = appliance.getCopy();
        //ensure that all fields are equal to each other
        assertEquals(appliance.getModel(), appliance2.getModel());
        assertEquals(appliance.getBrand(), appliance2.getBrand());
        assertEquals(appliance.getEnergy(), appliance2.getEnergy());
        //ensure that getCopy does not turn a copy by reference.
        assertNotSame(appliance, appliance2);
    }

    @Test
    void getModel() {
        assertEquals(appliance.getModel(), "");
    }

    @Test
    void getBrand() {
        assertEquals(appliance.getBrand(), "");
    }

    @Test
    void getEnergy() {
        assertEquals(appliance.getEnergy(), 0);
    }
}