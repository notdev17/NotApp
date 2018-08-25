package appliance;

/**
 * Represents air cleaner/purifier machines.
 */
public class Refrigerator extends Appliance {

    private String applianceType = "Refrigerator";

    /**
     * See Appliance for 'super' method. applianceType is pre-defined and does not change,
     * so no additional constructor input is necessary
     **/
    public Refrigerator(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    /**
     * See super()
     */
    public Refrigerator() {
        super();
    }

    /**
     * See super()
     */
    public Refrigerator getCopy() {
        return new Refrigerator(this.getModel(), this.getBrand(), this.getEnergy());
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
