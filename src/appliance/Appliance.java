package appliance;

/**
 * Created by Devon on 12/9/2017
 * "Pseudo-abstract" Appliance class. Used for polymorphism and easy method inheritance for the sub-types.
 *     (abstract class wasn't used because most method implementations are universal to its sub-types)
 **/

public class Appliance {
    protected String model;
    protected String brand;
    //Holds estimated energy use in kilowatt hours
    protected double energy;
    /* Edited by Brandon 12/15/2017
    *  Values will be used to calculate estimated yearly cost of energy with this appliance object
    */
    protected double price = 0.0;
    protected double result = 0.0;

    /**
     * Author: Devon
     * Constructor.
     **/
    public Appliance(String inModel, String inBrand, double inEnergy) {
        model = inModel;
        brand = inBrand;
        energy = inEnergy;
        /* Edited by Brandon 12/15/2017
           Added price and result fields */
        price = 0.0;
        result = 0.0;
    }

    /**
     * Author: Devon
     * Dummy constructor. Used for program testing.
     **/
    public Appliance() {
        model = "";
        brand = "";
        energy = 0;
        /* Edited by Brandon 12/15/2017
           Added price and result fields */
        price = 0.0;
        result = 0.0;
    }

    /**
     * Author: Devon 12/9/2017
     * Used to populate various lists (ensures object permanence)
     * PRE: N/A
     * POST: Returns a copy of 'this'
     **/
    public Appliance getCopy() {
        Appliance copy = new Appliance(model, brand, energy);
        return copy;
    }

    /**
     * Author: Devon 12/9/2017
     * Returns model.
     **/
    public String getModel() {
        return model;
    }

    /**
     * Author: Devon 12/9/2017
     * Returns brand.
     **/
    public String getBrand() {
        return brand;
    }

    /**
     * Author: Devon 12/9/2017
     * Returns estimated energy used per year (in kilowatt hours)
     **/
    public double getEnergy() {
        return energy;
    }

    /**
     * Author: Brandon 12/15/2017
     * Used in calculateSavingsController to read the user's input for their power company's rates
     **/
    public void setPrice(double thePrice)
    {
        price = Math.round(thePrice);
        result = Math.round(price * getEnergy());

    }

    /**
     * Author: Brandon 12/15/2017
     * Used in the calculate savings page to show the price of one kilowatt hour of energy from a user's energy company
     **/
    public double getPrice()
    {
        return price;
    }

    /**
     * Author: Brandon 12/15/2017
     * Used in the calculate savings page to show the price of one kilowatt hour of energy from a user's energy company
     **/
    public double getResult()
    {
        return result;
    }

    @Override
    public String toString() {
        return "Appliance";
    }
}
