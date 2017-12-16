package appliance;

/**
 * Created by Devon on 12/9/2017
 */
public class Dishwasher extends Appliance {

    private String applianceType = "Dishwasher";

    /**
     * Created by Devon on 12/9/2017
     **/
    public Dishwasher(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    public Dishwasher() {
        super();
    }

    //Used when populating lists from database (to avoid call by reference issues)
    public Dishwasher getCopy() {
        return new Dishwasher(this.getModel(), this.getBrand(), this.getEnergy());
    }

    /**
     * Created by Devon on 12/9/2017
     **/
    public String getApplianceType() {
        return applianceType;
    }

    @Override
    public String toString() {
        return applianceType + " " + model + " " + brand + " " + energy;
    }
}
