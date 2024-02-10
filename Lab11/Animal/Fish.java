public class Fish extends Animal{
    private String waterType;

    public Fish(String name, int age, String waterType){
        super(name, age);
        this.waterType = waterType;
    }

    public String getWaterType(){
        return this.waterType;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Water Type: " + this.waterType);
    }


}
