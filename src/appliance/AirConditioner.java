package appliance;

/**
 * Created by Tim on 12/7/2017.
 * Edited and expanded by Devon on 12/9/2017
 */
public class AirConditioner extends Appliance {

    private double price = 300.00;

    private String applianceType = "Air Conditioner";

    /**
     * Created by Devon on 12/9/2017
     **/
    public AirConditioner(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    public AirConditioner() {
        super();
    }

    //Used when populating lists from database (to avoid call by reference issues)
    public AirConditioner getCopy() {
        return new AirConditioner(this.getModel(), this.getBrand(), this.getEnergy());
    }

    public String getApplianceType() {
        return applianceType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return model + " " + brand + " " + energy;
    }
}
