#include <iostream>
#include <cmath>
#include <string>
using namespace std;

class Point{
    float x;
    float y;

    public:
        Point(int _x = 0.0, int _y = 0.0){
            x = _x;
            y = -y;
        }

        ~Point(){
        }

        void setP(int _x = 0.0, int _y = 0.0){
            x = _x;
            y = _y;
        }

        pair <float, float> getP(){
            return make_pair(x, y);
        }


        friend class Line;

};


class Line{
    Point P1;
    Point P2;

    public:
    //Default const
        Line(){}
        Line(Point _P1, Point _P2) : P1(_P1), P2(_P2){
        }

    //Copy const
        Line(Line &other){
            P1 = other.P1;
            P2 = other.P2;
        }

        //Distructor

        ~Line(){
        }

        float length() {
    return sqrt(pow((P1.x - P2.x), 2) + pow((P1.y - P2.y), 2));
    }

       string compare(Line &other){
    if (length() > other.length())
        return "Is greater";
    else if (length() < other.length())
        return "Is less than";
    else
        return "Are equal";
    }
};


int main(){
    Point y(6,6), j(9,0);
    Line h(y, j);
    h.length();
    Line r;
    cout<<h.compare(r) << endl;
    Line o=h;
    cout<<h.compare(o) << endl;
    Line c(y, j);
    cout << c.length() << endl ;
    cout<<c.compare(h) << endl;

}