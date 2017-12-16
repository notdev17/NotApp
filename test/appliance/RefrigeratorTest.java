import appliance.Refrigerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void getPrice() {
        assertEquals(refrigerator.getPrice(), 150.0);
    }

    @Test
    void toStringTest() {
        refrigerator = new Refrigerator("Model", "Brand", 1311.0);
        assertEquals(refrigerator.toString(), "Model Brand 1311.0");
    }
}