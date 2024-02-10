public class Main{
    public static void main(String[] args){
        Animal[] animals = new Animal[4];
        animals[0] = new Cat("Tom", 3, "Black");
        animals[1] = new Dog("Spike", 5, "Pug");
        animals[2] = new Tiger("Shera", 10, "Forest");
        animals[3] = new Fish("Nemo", 1, "River");



        for(Animal animal: animals){
            animal.display();
            if(animal instanceof Pet){
                ((Pet)animal).play();
            }
        }
    }
}
