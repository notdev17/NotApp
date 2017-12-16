import appliance.Dishwasher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void getPrice() {
        assertEquals(dishwasher.getPrice(), 150.0);
    }

    @Test
    void toStringTest() {
        dishwasher = new Dishwasher("Model", "Brand", 83.0);
        assertEquals(dishwasher.toString(), "Dishwasher Model Brand 83.0");
    }
}