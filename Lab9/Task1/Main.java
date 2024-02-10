public class Main{
    public static void main(String[] args)
    {
        Point P = new Point(4, 5);
        P.display();
        Point P2 = new Point();
        P2.input();

        
        System.out.print("Distance: ");
        System.out.println(P.distance(P2));

        System.out.print("Is greater than: ");
        System.out.println(P.isGreater(P2));

         System.out.print("Is equal to: ");
        System.out.println(P.isEqual(P2));

        System.out.print("Is Zero: ");
        System.out.println(P.isZero());
    }
}
