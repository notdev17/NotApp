
import appliance.Appliance;
import appliance.Calculate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTest {

    @Test
    void costPerYear() {
        Appliance a = new Appliance("Model", "Brand", 200);
        assertEquals(Calculate.costPerYear(a, 1, 1), 9600.0);
    }
}