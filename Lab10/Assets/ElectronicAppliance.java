public class ElectronicAppliance extends Asset {
    private String brand;
    private String model;
    private String voltage;
    private String frequency;


    public ElectronicAppliance(String name, String SerialNumber, String brand, String model, String voltage, String frequency) {
        super(name, SerialNumber);
        this.brand = brand;
        this.model = model;
        this.voltage = voltage;
        this.frequency = frequency;
    }

    public void setBrand(String brand) { this.brand = brand; }

    public String getBrand() { return brand; }

    public void setModel(String model) { this.model = model; }

    public String getModel() { return model; }

    public void setVoltage(String voltage) { this.voltage = voltage; }

    public String getVoltage() { return voltage; }


    public void setFrequency(String frequency) { this.frequency = frequency; }

    public String getFrequency() { return frequency; }

    public String toString() {
        return "ElectronicAppliance: " + getName() + " is " + brand + " " + model + " " + voltage + " " + frequency;
    }
}
