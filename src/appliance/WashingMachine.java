package appliance;

/**
 * Created by Tim on 12/7/2017.
 * Edited by Devon on 12/9/2017
 */
public class WashingMachine extends Appliance {

    private String applianceType = "Washer";
    private double price = 550.00;

<<<<<<< HEAD
    /**Created by Devon on 12/9/2017**/
    public WashingMachine(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
=======
    public WashingMachine() {
        model = "";
        brand = "";
        energy = 0;
    }

    public WashingMachine(String m, String b, double e) {
        model = m;
        brand = b;
        energy = e;
>>>>>>> origin/dayday
    }

    public String getApplianceType() {
        return applianceType;
    }

    public double getPrice() { return price; }

    @Override
    public String toString() {
        return model + " " + brand + " " + energy;
    }
}
