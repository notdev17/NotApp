package appliance;

/**
 * Created by Tim on 12/7/2017.
 */
public class WashingMachine implements Appliance {

    String model;
    String brand;
    double energy;

    public WashingMachine(String m, String b, double e) {
        model = m;
        brand = b;
        energy = e;
    }

    @Override
    public String getApplianceType() {
        return "washingmachine";
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public double getEnergy() {
        return energy;
    }
}
