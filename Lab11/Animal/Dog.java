public class Dog extends Animal implements Pet{
    private String breed;

    public Dog(String name, int age,  String breed){
        super(name, age);
        this.breed = breed;
    }

    public String getBreed(){
        return this.breed;
    }

    public void play(){
        System.out.println("Dog is playing");
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Breed: " + this.breed);
    }
}
