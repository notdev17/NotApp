package appliance;

/** 
 *     "Pseudo-abstract" Appliance class. Used for polymorphism and easy method inheritance for the sub-types.
 *     (abstract class wasn't used because most method implementations are universal to its sub-types)
 **/

public class Appliance {

    protected String model;
    protected String brand;
    //Holds estimated energy use in kilowatt hours
    protected double energy;
    /*
    *  Values will be used to calculate estimated yearly cost of energy with this appliance object
    */
    protected double price = 0.0;
    protected double result = 0.0;

    /**
     * Constructor for general appliances
     **/
    public Appliance(String inModel, String inBrand, double inEnergy) {
        model = inModel;
        brand = inBrand;
        energy = inEnergy;

        /*
           Added price and result fields 
        */
        price = 0.0;
        result = 0.0;
    }

    /**
     * Dummy constructor. Used for program testing.
     **/
    public Appliance() {
        model = "";
        brand = "";
        energy = 0;
        /*
           Added price and result fields */
        price = 0.0;
        result = 0.0;
    }

    /**
     * Used to populate various lists (ensures object permanence)
     * PRE: N/A
     * POST: Returns a copy of 'this'
     **/
    public Appliance getCopy() {
        Appliance copy = new Appliance(model, brand, energy);
        return copy;
    }

    /**
     * Returns model.
     **/
    public String getModel() {
        return model;
    }

    /**
     * Returns brand.
     **/
    public String getBrand() {
        return brand;
    }

    /**
     * Returns estimated energy used per year (in kilowatt hours)
     **/
    public double getEnergy() {
        return energy;
    }

    /**
     * Used in calculateSavingsController to read the user's input for their power company's rates
     **/
    public void setPrice(double thePrice)
    {
        price = Math.round(thePrice);
        result = Math.round(price * getEnergy());

    }

    /**
     * Used in the calculate savings page to show the price of one kilowatt hour of energy from a user's energy company
     **/
    public double getPrice()
    {
        return price;
    }

    /**
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
