#include <iostream>
using namespace std;

class Box {
    float height, width, length;

public:
    // Constructor to initialize dimensions
    Box(float h = 0, float w = 0, float l = 0) {
        setHeight(h);
        setWidth(w);
        setLength(l);
    }

    // Setters for height, width, and length
    void setHeight(float h) {
        if (h > 0) {
            height = h;
        } else {
            cout << "Height cannot be zero or negative. Setting it to 0." << endl;
            height = 0;
        }
    }

    void setWidth(float w) {
        if (w > 0) {
            width = w;
        } else {
            cout << "Width cannot be zero or negative. Setting it to 0." << endl;
            width = 0;
        }
    }

    void setLength(float l) {
        if (l > 0) {
            length = l;
        } else {
            cout << "Length cannot be zero or negative. Setting it to 0." << endl;
            length = 0;
        }
    }

    // User-defined getters for height, width, and length
    float getHeight() {
        return height;
    }

    float getWidth() {
        return width;
    }

    float getLength() {
        return length;
    }

    float CalcVolume() {
        return height * length * width;
    }

    float CalcPerimeter() {
        return 4 * (height + length + width);
    }

    void displayLength() {
        cout << "Length of each side of the cube is: " << length << endl;
    }

    void display() {
        cout << "Volume of the box is " << CalcVolume() << endl;
        cout << "Perimeter of the box is " << CalcPerimeter() << endl;
    }
};

int main() {
    Box B1, B2;

    float length, height, width;

    cout << "Enter the dimensions for the first box:" << endl;
    cout << "Height: ";
    cin >> height;
    B1.setHeight(height);
    cout << "Width: ";
    cin >> width;
    B1.setWidth(width);
    cout << "Length: ";
    cin >> length;
    B1.setLength(length);

    B1.displayLength();
    B1.display();

    cout << "Enter the dimensions for the second box:" << endl;
    cout << "Height: ";
    cin >> height;
    B2.setHeight(height);
    cout << "Width: ";
    cin >> width;
    B2.setWidth(width);
    cout << "Length: ";
    cin >> length;
    B2.setLength(length);

    B2.displayLength();
    B2.display();

    return 0;
}
