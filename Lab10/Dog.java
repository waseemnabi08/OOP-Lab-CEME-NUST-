public class Dog extends Pet {
    private double weight;

    public Dog(String name, double weight) {
        super(name);
        this.weight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() { return weight; }

    public String toString() {
        return "Dog: " + getName() + " weighs " + weight + " kg";
    }


}
