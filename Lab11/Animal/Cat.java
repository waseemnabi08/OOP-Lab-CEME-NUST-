public class Cat extends Animal implements Pet{
    private String color;

    public Cat(String name, int age, String color){
        super(name, age);
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public void play(){
        System.out.println("Cat is playing");
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Color: " + this.color);
    }
}
