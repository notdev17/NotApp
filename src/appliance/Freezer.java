package appliance;

/**
 * Represents air cleaner/purifier machines.
 */
public class Freezer extends Appliance {

    private String applianceType = "Freezer";

    /**
     * See Appliance for 'super' method. applianceType is pre-defined and does not change,
     * so no additional constructor input is necessary
     **/
    public Freezer(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    /**
     * See super()
     */
    public Freezer() {
        super();
    }

    /**
     * See super()
     */
    public Freezer getCopy() {
        return new Freezer(this.getModel(), this.getBrand(), this.getEnergy());
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
