package appliance;

/**
 * Created by Devon on 12/9/2017
 */
public class Dryer extends Appliance {

    private String applianceType = "Dryer";
    private double price = 150.00;

    /**Created by Devon on 12/9/2017**/
    public Dryer(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
    }

    public Dryer() {
        super();
    }

    //Used when populating lists from database (to avoid call by reference issues)
    public Dryer getCopy() {
        return new Dryer(this.getModel(), this.getBrand(), this.getEnergy());
    }

    /**Created by Devon on 12/9/2017**/
    public String getApplianceType() {
        return applianceType;
    }

    /**Created by Devon on 12/9/2017**/
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return model + " " + brand + " " + energy;
    }
}

