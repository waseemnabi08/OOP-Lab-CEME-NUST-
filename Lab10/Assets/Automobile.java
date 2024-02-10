public class Automobile extends Asset{
    private String make;
    private String model;
    private int year;
    private double mileage;

    public Automobile(String name, String SerialNumber, String make, String model, int year, double mileage) {
        super(name, SerialNumber);
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public void setMake(String make) { this.make = make; }
    public String getMake() { return make; }
    public void setModel(String model) { this.model = model; }
    public String getModel() { return model; }
    public void setYear(int year) { this.year = year; }
    public int getYear() { return year; }
    public void setMileage(double mileage) { this.mileage = mileage; }
    public double getMileage() { return mileage; }

    public String toString() {
        return "Automobile: " + getName() + " is a " + year + " " + make + " " + model + " with " + mileage + " miles";
    }


}
