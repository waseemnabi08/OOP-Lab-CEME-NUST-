#include <iostream>
#include <math.h>
using namespace std;

class Point{
    float x, y;

    public:


    Point(float x1 = 0, float y1 = 0){
        x = x1;
        y = y1;
    }


    Point (Point & P){
        x = P.x;
        y = P.y;
    }

    //setters

    void setX(float x){
        x = x;
    }

    void setY(float y){
        y = y;
    }

    //Getters

    float getX(){
        return x;
    }

    float getY(){
        return y;
    }

    //Input fucntion

    Point input(){
        cout << "Point x: ";
        cin >> x;
        cout << "Point y: ";
        cin >> y;
        return Point(x, y);
    }

    float distance(Point P)
    {
        return (sqrt(pow((x - P.x), 2) + pow((y - P.y),2)));
    }

    bool isZero(){
        if ((x == 0) && (y == 0))
            return true;
       return false;
    }

    Point MidPoint(){
        return Point((x/2), (y/2));
    }

    bool isEqualTo(Point &P){
        if((x == P.x) && (y == P.y))
            return true;
        return false;
    }

    bool isGreater(Point &P){
        float d1 = distance(Point(0, 0));
        float d2 = P.distance(Point(0, 0));

        if (d1 > d2){
            return true;
        }

        return false;
    }

    void output(){
        cout << "X: " << x << " Y: " << y << endl;
    }

};


int main(){
    Point p1;
    p1.input();
    p1.output();
    Point p2(3, 4);
    p2.output();
    cout << "Distance between P1 and p2 is : " << p1.distance(p2) << endl;
    cout << "Is p1 greater than p2: " << p1.isGreater(p2) << endl;
    Point p3 = p1;
    cout <<"IS P3 equals to p2: " <<  p3.isEqualTo(p2) << endl;
    p2.output();
    Point p4 = p2.MidPoint();
    cout << "Midpoints of p2 are: ";
    p4.output();

}