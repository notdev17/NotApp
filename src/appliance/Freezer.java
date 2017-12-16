package appliance;

/**
 * Created by Devon on 12/9/2017
 */
public class Freezer extends Appliance {

    private String applianceType = "Freezer";

    /**
     * Created by Devon on 12/9/2017
     **/
    public Freezer(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    public Freezer() {
        super();
    }

    //Used when populating lists from database (to avoid call by reference issues)
    public Freezer getCopy() {
        return new Freezer(this.getModel(), this.getBrand(), this.getEnergy());
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
