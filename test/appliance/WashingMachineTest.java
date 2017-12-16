import appliance.WashingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by notDev on 12/15/2017
 * NOTE: This was copied from AirCleanerTest and slightly edited. See AirCleanerTest for relevent documentation.
 */
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
    void toStringTest() {
        washingMachine = new WashingMachine("Model", "Brand", 31.0);
        assertEquals(washingMachine.toString(), "Washer Model Brand 31.0");
    }
}