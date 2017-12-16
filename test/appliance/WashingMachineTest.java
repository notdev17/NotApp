import appliance.WashingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WashingMachineTest {

    WashingMachine washingMachine = new WashingMachine();

    @Test
    void getCopy() {
        WashingMachine washingMachine2 = washingMachine.getCopy();
        assertEquals(washingMachine2.toString(), washingMachine.toString());
    }

    @Test
    void getApplianceType() {
        assertEquals(washingMachine.getApplianceType(), "Washer");
    }

    @Test
    void getPrice() {
        assertEquals(washingMachine.getPrice(),550.0);
    }

    @Test
    void toStringTest() {
        washingMachine = new WashingMachine("Model", "Brand", 31.0);
        assertEquals(washingMachine.toString(), "Washer Model Brand 31.0");
    }
}