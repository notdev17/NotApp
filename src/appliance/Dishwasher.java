package appliance;

/**
 * Represents air cleaner/purifier machines.
 */
public class Dishwasher extends Appliance {

    private String applianceType = "Dishwasher";

    /**
     * See Appliance for 'super' method. applianceType is pre-defined and does not change,
     * so no additional constructor input is necessary
     **/
    public Dishwasher(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    /**
     * See super()
     */
    public Dishwasher() {
        super();
    }

    /**
     * See super()
     */
    public Dishwasher getCopy() {
        return new Dishwasher(this.getModel(), this.getBrand(), this.getEnergy());
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
