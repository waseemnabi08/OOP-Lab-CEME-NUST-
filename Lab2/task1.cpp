#include <iostream>
#include <cmath>

using namespace std;

class complex {
    float real, imag;

public:
    complex(float r = 0, float im = 0) {
        setreal(r);
        setimag(im);
    }

    void setreal(float r) {
        real = r;
    }

    void setimag(float im) {
        imag = im;
    }

    float getreal() {
        return real;
    }

    float getimag() {
        return imag;
    }

    void inputcomplex() {
        cout << "Enter a complex number: " << endl;
        cout << "Real: ";
        cin >> real;
        cout << "Imaginary: ";
        cin >> imag; 
    }

    complex addcomplex(complex C) {
        complex result;
        result.real = real + C.real;
        result.imag = imag + C.imag;
        return result;
    }

    complex subcomplex(complex C) {
        complex result;
        result.real = real - C.real;
        result.imag = imag - C.imag;
        return result;
    }

    float calcmagnitude() {
        return sqrt(real * real + imag * imag); // Simplified
    }

    void display() {
        cout << "Result: " << real;
        if (imag >= 0) {
            cout << " + " << imag << "i" << endl;
        } else {
            cout << " - " << -imag << "i" << endl; // Display minus sign for negative imaginary part
        }
    }
};

int main() {
    complex c1, c2;
    cout << "Enter the first complex number:" << endl;
    c1.inputcomplex();
    cout << "Enter the second complex number:" << endl;
    c2.inputcomplex();

    complex add = c1.addcomplex(c2);
    complex sub = c1.subcomplex(c2);

    cout << "Addition: ";
    add.display();

    cout << "Subtraction: ";
    sub.display();

    return 0;
}
