package appliance;

/**
 * Created by Devon on 12/9/2017
 * Represents air cleaner/purifier machines.
 */
public class AirConditioner extends Appliance {


    private String applianceType = "Air Conditioner";

    /**
     * Author: Devon on 12/9/2017
     * See Appliance for 'super' method. applianceType and price are pre-defined and do not change,
     * so no constructor input is necessary
     **/
    public AirConditioner(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    /**
     * Author: Devon on 12/9/2017
     * See super()
     */
    public AirConditioner() {
        super();
    }

    /**
     * Author: Devon on 12/9/2017
     * See super()
     */
    public AirConditioner getCopy() {
        return new AirConditioner(this.getModel(), this.getBrand(), this.getEnergy());
    }

    /**
     * Author: Devon on 12/9/2017
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
