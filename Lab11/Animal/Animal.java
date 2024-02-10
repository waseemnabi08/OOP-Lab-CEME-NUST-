public class Animal{
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }
}
