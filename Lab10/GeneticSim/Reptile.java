public class Reptile extends Organism implements Mutator, Reproducer {
    // Additional attributes for Reptiles
    private boolean coldBlooded;
    private String scaleType;

    // Constructor
    public Reptile(String geneticCode, String name, int age, int health, int maxHealth, boolean coldBlooded, String scaleType) {
        super(geneticCode, name, age, health, maxHealth);
        this.coldBlooded = coldBlooded;
        this.scaleType = scaleType;
    }

    // Additional methods for Reptiles
    @Override
    public void inheritTraits(Organism parent) {
        if(parent instanceof Reptile) {
            this.coldBlooded = ((Reptile) parent).coldBlooded;
            this.scaleType = ((Reptile) parent).scaleType;
        }
    }

    @Override
    public void eat() {
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
        System.out.println("Reptile making sound"); // Print message when making sound
    }

    @Override
    public void reproduce() {
        // Create a new Reptile with inherited traits
        Reptile offspring = new Reptile(this.geneticCode, "Offspring", 0, 100, 100, this.coldBlooded, this.scaleType);
        offspring.inheritTraits(this);
    }

    @Override
    public void mutate() {
        this.geneticCode = "mutatedCode"; // Change genetic code when mutating
    }

    // Additional methods specific to Reptiles
    public void baskInSun() {
        this.health += 5; // Increase health after sunbathing
    }

    public void shedSkin() {
        this.health -= 5; // Decrease health after shedding skin
    }

    public void layEggs() {
        this.health -= 5; // Decrease health after laying eggs
    }
   public String toString() {
        return "Reptile: " + this.name + "Age: " + this.age + "Health: " + this.health + "Max Health: " + this.maxHealth + "Cold Blooded: " + this.coldBlooded + "Scale Type: " + this.scaleType + "Genetic Code: " + this.geneticCode + "\n ";
    }
}
