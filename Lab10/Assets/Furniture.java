public class Furniture extends Asset {
    private String material;
    private double price;

    public Furniture(String name, String SerialNumber, String material, double price) {
        super(name, SerialNumber);
        this.material = material;
        this.price = price;
    }

    public void setMaterial(String material) { this.material = material; }
    public String getMaterial() { return material; }
    public void setPrice(double price) { this.price = price; }
    public double getPrice() { return price; }

    public String toString() {
        return "Furniture: " + getName() + " is made of " + material + " and costs " + price + "pkr";
    }


}
