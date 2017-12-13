package appliance;

/**
 * Created by Tim on 12/7/2017.
 * Edited by Devon on 12/9/2017
 */
public class Refrigerator extends Appliance {

    private String applianceType = "Refrigerator";
    private double price = 150.00;

<<<<<<< HEAD
    /**Created by Devon on 12/9/2017**/
    public Refrigerator(String inModel, String inBrand, double inEnergy) {
        super(inModel, inBrand, inEnergy);
=======
    public Refrigerator() {
        model = "";
        brand = "";
        energy = 0;
    }

    public Refrigerator(String m, String b, double e) {
        model = m;
        brand = b;
        energy = e;
>>>>>>> origin/dayday
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
