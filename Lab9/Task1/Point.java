import java.util.Scanner;
class Point{
    private int x;
    private int y;

    public Point(){
        x = 0;
        y = 0;
    }

    public Point(int _x, int _y){
        x = _x;
        y = _y;
    }

    public Point input(){
        Scanner input = new Scanner(System.in);
        System.out.print("X:");
        int x1 = input.nextInt();
        System.out.print("Y:");
        int y1 = input.nextInt();

        Point P = new Point(x1, y1);
        return P;
    }

    public void display(){
        System.out.println("X_axis: " + x);
        System.out.println("Y_axis: " + y);
    }

    public boolean isZero(){
        if ((x == 0) && (y == 0)){
            return true;
        }
        else {
            return false;
        }
    }

    public Point middlePoint(Point P){
        int x1 = (x + P.x) / 2;
        int y2 = (y + P.y) / 2;

        Point point = new Point(x1, y2);

        return point;
    }


    public double distance(Point p){
        return Math.sqrt(((x - p.x)*(x - p.x)) + ((y - p.y)*(y - p.y)));
    }

    public boolean isEqual(Point P){
        if ((x == P.x) && (y == P.y)){
            return true;
        }

        else{
            return false;
        }
    }

    public boolean isGreater(Point P){
        Point p = new Point();
        double distance1 = distance(p);
        double distance2 = P.distance(p);

        if (distance1 > distance2){
            return true;
        }

        else {
            return false;
        }
    }


}

