public class Tiger extends Animal{
    private String habitat;

    public Tiger(String name, int age, String habitat){
        super(name, age);
        this.habitat = habitat;
    }

    public String getHabitat(){
        return this.habitat;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Habitat: " + this.habitat);
    }


}
