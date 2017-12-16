package appliance;

/**
 * Created by Tim on 12/7/2017.
 * Edited by Devon on 12/9/2017
 */
public class Refrigerator extends Appliance {

    private String applianceType = "Refrigerator";

    /**
     * Created by Devon on 12/9/2017
     **/
    public Refrigerator(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    public Refrigerator() {
        super();
    }

    //Used when populating lists from database (to avoid call by reference issues)
    public Refrigerator getCopy() {
        return new Refrigerator(this.getModel(), this.getBrand(), this.getEnergy());
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
