public class Main{
    public static void main(String[] args){
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(5);
        shapes[1] = new Square(15);

       
        shapes[0].display();
        shapes[1].display();


    }
}
