public class Bacteria extends Organism implements Mutator, Reproducer {
    // Additional attributes for Bacteria
    private boolean aerobic;
    private String shape;

    // Constructor
    public Bacteria(String geneticCode, String name, int age, int health, int maxHealth, boolean aerobic, String shape) {
        super(geneticCode, name, age, health, maxHealth);
        this.aerobic = aerobic;
        this.shape = shape;
    }

    // Additional methods for Bacteria
    @Override
    public void inheritTraits(Organism parent) {
        if(parent instanceof Bacteria) {
            this.aerobic = ((Bacteria) parent).aerobic;
            this.shape = ((Bacteria) parent).shape;
        }
    }

    @Override
    public void eat() {
        this.health += 10; // Increase health after absorbing nutrients
    }

    @Override
    public void sleep() {
        this.health += 5; // Increase health after entering dormant state
    }

    @Override
    public void die() {
        this.health = 0; // Set health to 0 when dying
    }

   public void move() {
        this.health -= 5; // Decrease health after moving
    }

    public void speak() {
        System.out.println("Bacteria producing chemical signals"); // Print message when producing chemical signals
    }

    @Override
    public void reproduce() {
        // Create a new Bacteria with inherited traits
        Bacteria offspring = new Bacteria(this.geneticCode, "Offspring", 0, 100, 100, this.aerobic, this.shape);
        offspring.inheritTraits(this);
    }

    @Override
    public void mutate() {
        this.geneticCode = "mutatedCode"; // Change genetic code when mutating
    }

    // Additional methods specific to Bacteria
    public void exchangeGeneticMaterial() {
        this.geneticCode = "exchangedCode"; // Change genetic code after exchanging genetic material
    }

    public void formBiofilm() {
        this.health += 5; // Increase health after forming biofilm
    }
//return all traits of the bacteria
    public String toString() {
        return "Bacteria: " + this.name + " (" + this.geneticCode + ")" + " aerobic: " + this.aerobic + " shape: " + this.shape + " age: " + this.age + " health: " + this.health + " maxHealth: " + this.maxHealth;
    }
}
