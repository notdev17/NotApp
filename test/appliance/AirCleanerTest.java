package appliance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AirCleanerTest {

    AirCleaner airCleaner;

    @Test
    //DEVON Tests getCopy
    void getCopy() {
        //DEVON Main body of getCopy tested in ApplianceTest.java
        //Price and appliance type are pre-defined and immutable, so this is a trivial test. Might not need
        //these first 3.
    }

    @Test
    void getApplianceType() {
        airCleaner = new AirCleaner();
        Assertions.assertEquals("Air Cleaner", airCleaner.getApplianceType());
    }

    @Test
    void getPrice() {
    }

    @Test
    void toStringTest() {
    }
}