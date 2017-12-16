package appliance;

/**
 * Created by Devon on 12/9/2017
 */
public class AirCleaner extends Appliance {

    private String applianceType = "Air Cleaner";
    private double price = 150.00;

    /**
     * Created by Devon on 12/9/2017
     **/
    public AirCleaner(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    public AirCleaner() {
        super();
    }

    //Used when populating lists from database (to avoid call by reference issues)
    public AirCleaner getCopy() {
        return new AirCleaner(this.getModel(), this.getBrand(), this.getEnergy());
    }

    /**
     * Created by Devon on 12/9/2017
     **/
    public String getApplianceType() {
        return applianceType;
    }

    /**
     * Created by Devon on 12/9/2017
     **/
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return applianceType + " " + model + " " + brand + " " + energy;
    }
}
