package appliance;

/**
 * Represents air cleaner/purifier machines.
 */
public class AirConditioner extends Appliance {


    private String applianceType = "Air Conditioner";

    /**
     * See Appliance for 'super' method. applianceType and price are pre-defined and do not change,
     * so no constructor input is necessary
     **/
    public AirConditioner(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    /**
     * See super()
     */
    public AirConditioner() {
        super();
    }

    /**
     * See super()
     */
    public AirConditioner getCopy() {
        return new AirConditioner(this.getModel(), this.getBrand(), this.getEnergy());
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
