public class Plant extends Organism implements Mutator, Reproducer {
    // Additional attributes for Plants
    private boolean hasFlowers;
    private String typeOfRoot;

    // Constructor
    public Plant(String geneticCode, String name, int age, int health, int maxHealth, boolean hasFlowers, String typeOfRoot) {
        super(geneticCode, name, age, health, maxHealth);
        this.hasFlowers = hasFlowers;
        this.typeOfRoot = typeOfRoot;
    }

    // Additional methods for Plants
    @Override
    public void inheritTraits(Organism parent) {
        if(parent instanceof Plant) {
            this.hasFlowers = ((Plant) parent).hasFlowers;
            this.typeOfRoot = ((Plant) parent).typeOfRoot;
        }
    }

    @Override
    public void eat() {
        this.health += 10; // Increase health after absorbing nutrients
    }

    @Override
    public void sleep() {
        this.health += 5; // Increase health after resting
    }

    @Override
    public void die() {
        this.health = 0; // Set health to 0 when dying
    }



    @Override
    public void reproduce() {
        // Create a new Plant with inherited traits
        Plant offspring = new Plant(this.geneticCode, "Offspring", 0, 100, 100, this.hasFlowers, this.typeOfRoot);
        offspring.inheritTraits(this);
    }

    @Override
    public void mutate() {
        this.geneticCode = "mutatedCode"; // Change genetic code when mutating
    }

    // Additional methods specific to Plants
    public void photosynthesize() {
        this.health += 15; // Increase health after photosynthesis
    }

    public void shedLeaves() {
        this.health -= 5; // Decrease health after shedding leaves
    }

    public void grow() {
        this.health += 5; // Increase health after growing
    }

    public String toString() {
        return "Plant: " + this.name + " (" + this.geneticCode + ")";
    }
}
