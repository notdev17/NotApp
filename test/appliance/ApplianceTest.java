import appliance.Appliance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplianceTest {

    Appliance appliance= new Appliance();

    @Test
    void getCopy() {
        Appliance appliance2 = appliance.getCopy();
        assertEquals(appliance2.toString(), appliance.toString());
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