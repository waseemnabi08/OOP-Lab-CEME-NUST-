#include <iostream>
using namespace std;

void getRadius(int &radius)
{
    cout << "Enter radius: ";
    cin >> radius;
}

void calculateArea(int radius)
{
    double area = 3.14 * radius * radius;
    cout << "Area of circle is " << area << endl;
}

void calculateCircumference(int radius)
{
    double circumference = 2 * 3.14 * radius;
    cout << "Circumference of circle is " << circumference << endl;
}

int main()
{
    int radius;

    // Function calls
    getRadius(radius);
    calculateArea(radius);
    calculateCircumference(radius);

    return 0;
}
