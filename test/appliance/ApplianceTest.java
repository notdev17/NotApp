package appliance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplianceTest {

    Appliance app;

    @Test
    void compareTo() {
        AirCleaner airCleaner = new AirCleaner("Model", "Brand", 5.0);
        AirCleaner identicalCleaner = new AirCleaner("Model", "Brand", 5.0);
        AirConditioner testConditioner = new AirConditioner("Model", "Brand", 5.0);
        app = new Appliance("Model", "Brand", 5.0);

        if(airCleaner.compareTo(app) == 0) {
            Assertions.fail("Appliance object cannot equal a child instance. You fail!");
        }
        else if(airCleaner.compareTo(testConditioner) == 0) {
            Assertions.fail("Different appliance types cannot be equal. You fail!");
        }
        else {
            Assertions.assertEquals(airCleaner.compareTo(identicalCleaner), 0);
        }
    }

    @Test
    void getModel() {
        app = new Appliance("Model", "Brand", 5.0);

        Assertions.assertEquals("Model", app.getModel());
    }

    @Test
    void getBrand() {
        app = new Appliance("Model", "Brand", 5.0);

        Assertions.assertEquals("Model", app.getModel());
    }

    @Test
    void getEnergy() {
        app = new Appliance("Model", "Brand", 5.0);

        Assertions.assertEquals(5.0, app.getEnergy());
    }

    @Test
    void getCopy() {
        app = new Appliance("Model", "Brand", 5.0);
        Appliance app2 = app.getCopy();

        Assertions.assertNotSame(app, app2);
        Assertions.assertEquals(app.getBrand(), app2.getBrand());
        Assertions.assertEquals(app.getModel(), app2.getModel());
        Assertions.assertEquals(app.getEnergy(), app2.getEnergy());
    }
}