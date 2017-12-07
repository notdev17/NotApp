package appliance;

public interface Appliance {
    private String model;
    private String brand;
    private double energy;

    public String getApplianceType();
    public String getModel();
    public String getBrand();
    public double getEnergy();
    }
}
