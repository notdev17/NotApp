package appliance;

/**
 * Represents air cleaner/purifier machines.
 */
public class Dryer extends Appliance {

    private String applianceType = "Dryer";

    /**
     * See Appliance for 'super' method. applianceType is pre-defined and does not change,
     * so no additional constructor input is necessary
     **/
    public Dryer(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    /**
     * See super()
     */
    public Dryer() {
        super();
    }

    /**
     * See super()
     */
    public Dryer getCopy() {
        return new Dryer(this.getModel(), this.getBrand(), this.getEnergy());
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

