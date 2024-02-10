public class Cat extends Pet {
    private String color;

    public Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() { return color; }


    public String toString() {
        return "Cat: " + getName() + " is " + color;
    }
}
