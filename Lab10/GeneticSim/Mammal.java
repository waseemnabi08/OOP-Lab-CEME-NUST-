public class Mammal extends Organism implements Mutator, Reproducer {
    // Additional attributes for Mammals
    private boolean hasFur;
    private int numberOfLimbs;

    // Constructor
    public Mammal(String geneticCode, String name, int age, int health, int maxHealth, boolean hasFur, int numberOfLimbs) {
        super(geneticCode, name, age, health, maxHealth);
        this.hasFur = hasFur;
        this.numberOfLimbs = numberOfLimbs;
    }

    // Additional methods for Mammals
    @Override
    public void inheritTraits(Organism parent) {
        if(parent instanceof Mammal) {
            this.hasFur = ((Mammal) parent).hasFur;
            this.numberOfLimbs = ((Mammal) parent).numberOfLimbs;
        }
    }

    @Override
    public void eat(){
        this.health += 10; // Increase health after eating
    }

    @Override
    public void sleep() {
        this.health += 5; // Increase health after sleeping
    }

    @Override
    public void die() {
        this.health = 0; // Set health to 0 when dying
    }


    public void move() {
        this.health -= 5; // Decrease health after moving
    }


   public void speak() {
        System.out.println("Mammal speaking"); // Print message when speaking
    }

    @Override
    public void reproduce() {
        // Create a new Mammal with inherited traits
        Mammal offspring = new Mammal(this.geneticCode, "Offspring", 0, 100, 100, this.hasFur, this.numberOfLimbs);
        offspring.inheritTraits(this);
    }

    @Override
    public void mutate() {
        this.geneticCode = "mutatedCode"; // Change genetic code when mutating
    }

    // Additional methods specific to Mammals
    public void giveBirth() {
        this.reproduce(); // Call reproduce method when giving birth
    }

    public void groom() {
        this.health += 5; // Increase health after grooming
    }

    public String toString() {
        return "Mammal: " + this.name + " hasFur: " + this.hasFur + " numberOfLimbs: " + this.numberOfLimbs;
    }
}
