package appliance;

/**
 * Created by Devon on 12/9/2017
 **/
public class Appliance {
    protected String model;
    protected String brand;
    //Holds estimated energy use in kilowatt hours
    protected double energy;

    /**
     * Created by Devon on 12/9/2017
     **/
    public Appliance(String inModel, String inBrand, double inEnergy) {
        model = inModel;
        brand = inBrand;
        energy = inEnergy;
    }

    //Default constructor. Also used in sub-types. Used for easy program testing.
    public Appliance() {
        model = "";
        brand = "";
        energy = 0;
    }

    //TODO test this with other sub-type getCopys. (Might need override statements for them to work properly)
    public Appliance getCopy() {
        Appliance copy = new Appliance(model, brand, energy);
        return copy;
    }

    /**
     * Created by Devon on 12/9/2017
     **/
    public String getModel() {
        return model;
    }

    /**
     * Created by Devon on 12/9/2017
     **/
    public String getBrand() {
        return brand;
    }

    /**
     * Created by Devon on 12/9/2017
     **/
    public double getEnergy() {
        return energy;
    }

    /**
     * Created by Devon on 12/15/2017
     * Compares 'this' to some Object o. Returns 0 if 'this' is equivalent to o.
     **/
    public int compareTo(Object o) {
        if(o.getClass().getName().compareTo(this.getClass().getName()) == 0) {
            Appliance obj = (Appliance) o;
            if(obj.getBrand().compareTo(this.getBrand()) == 0 && obj.getModel().compareTo(this.getModel()) == 0) {
                return 0;
            }
            else {
                if(obj.getBrand().compareTo(this.getBrand()) == 0) {
                    return obj.getModel().compareTo(this.getModel());
                }
                else {
                    return obj.getBrand().compareTo(this.getBrand());
                }
            }
        }
        else {
            return 1;
        }
    }
}
