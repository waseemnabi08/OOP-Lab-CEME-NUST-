public abstract class Organism {
    // Other common genetic attributes
    protected String geneticCode;
    protected String name;
    protected int age;
    protected int health;
    protected int maxHealth;

    public Organism(String geneticCode, String name, int age, int health, int maxHealth) {
        this.geneticCode = geneticCode;
        this.name = name;
        this.age = age;
        this.health = health;
        this.maxHealth = maxHealth;

    }

    String getGeneticCode() {
        return this.geneticCode;
    }

    public String getName() {
        return this.name;
    }

    public void setHealth(int health) {
        this.health = health;
    }


   public  int getHealth() {
        return this.health;
    }

    //get age, get maxhealth
    int getAge() {
        return this.age;
    }

   public int getMaxHealth() {
        return this.maxHealth;
    }


    public abstract void inheritTraits(Organism parent);
    // Other common genetic behaviors
    public abstract void eat();
    public abstract void sleep();
    public abstract void die();


}
