import appliance.AirConditioner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirConditionerTest {

    AirConditioner airConditioner = new AirConditioner();

    @Test
    void getCopy() {
        AirConditioner airConditioner2 = new AirConditioner();
        assertEquals(airConditioner2.toString(), airConditioner.toString());
    }

    /**
     * Author: Brandon on 12/15/2017
     */
    @Test
    void getApplianceType() {
        assertEquals(airConditioner.getApplianceType(), "Air Conditioner");
    }

    @Test
    void getPrice() {
        assertEquals(airConditioner.getPrice(), 300.0);
    }

    @Test
    void toStringTest() {
        airConditioner = new AirConditioner("Model", "Brand", 111.0);
        assertEquals(airConditioner.toString(), "Air Conditioner Model Brand 111.0");
    }
}