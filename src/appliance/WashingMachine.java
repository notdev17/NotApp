package appliance;

/**
 * Represents air cleaner/purifier machines.
 */
public class WashingMachine extends Appliance {

    private String applianceType = "Washer";

    /**
     * See Appliance for 'super' method. applianceType is pre-defined and does not change,
     * so no additional constructor input is necessary
     **/
    public WashingMachine(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    /**
     * See super()
     */
    public WashingMachine() {
        super();
    }

    /**
     * See super()
     */
    public WashingMachine getCopy() {
        return new WashingMachine(this.getModel(), this.getBrand(), this.getEnergy());
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
