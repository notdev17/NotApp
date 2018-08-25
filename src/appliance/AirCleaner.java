package appliance;

/**
 * Represents air cleaner/purifier machines.
 */
public class AirCleaner extends Appliance {

    private static String applianceType = "Air Cleaner";

    /**
     * See Appliance for 'super' method. applianceType is pre-defined and does not change,
     * so no additional constructor input is necessary
     **/
    public AirCleaner(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    /**
     * See super()
     */
    public AirCleaner() {
        super();
    }

    /**
     * See super()
     */
    public AirCleaner getCopy() {
        return new AirCleaner(this.getModel(), this.getBrand(), this.getEnergy());
    }

    /**
     * Returns appliance type.
     **/
    public String getApplianceType() {
        return applianceType;
    }

    @Override
    public String toString() {
        return applianceType + " " + model + " " + brand + " " + energy;
    }
}
