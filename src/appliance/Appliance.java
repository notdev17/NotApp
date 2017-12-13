package appliance;

/**Created by Devon on 12/9/2017**/
public class Appliance {
    protected String model;
    protected String brand;
    //Holds estimated energy use in kilowatt hours
    protected double energy;

    /**Created by Devon on 12/9/2017**/
    public Appliance(String inModel, String inBrand, double inEnergy) {
        model = inModel;
        brand = inBrand;
        energy = inEnergy;
    }

    public Appliance() {
        model = "";
        brand = "";
        energy = 0;
    }

    /**Created by Devon on 12/9/2017**/
    public String getModel() {
        return model;
    }

    /**Created by Devon on 12/9/2017**/
    public String getBrand() {
        return brand;
    }

    /**Created by Devon on 12/9/2017**/
    public double getEnergy() {
        return energy;
    }
}
