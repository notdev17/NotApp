package appliance;

/**
 * Created by Devon on 12/9/2017
 */
public class AirCleaner extends Appliance implements Comparable {

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

//    /**BACKUP. DON'T ERASE!!!
//     * Created by Devon on 12/15/2017
//     * Compares 'this' to some Object o. Returns 0 if 'this' is equivalent to o.
//     **/
//    public int compareTo(Object o) {
//        if(o.getClass().getName().compareTo(this.getClass().getName()) == 0) {
//            AirCleaner obj = (AirCleaner) o;
//            if(obj.getBrand().compareTo(this.getBrand()) == 0 && obj.getModel().compareTo(this.getModel()) == 0) {
//                return 0;
//            }
//            else {
//                if(obj.getBrand().compareTo(this.getBrand()) == 0) {
//                    return obj.getModel().compareTo(this.getModel());
//                }
//                else {
//                    return obj.getBrand().compareTo(this.getBrand());
//                }
//            }
//        }
//        else {
//            return 1;
//        }
//    }

    @Override
    public String toString() {
        return model + " " + brand + " " + energy;
    }
}
