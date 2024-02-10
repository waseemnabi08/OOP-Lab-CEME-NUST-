#include <iostream>
using namespace std;

struct Complex {
    int real;
    int imag;
};

void getComplex(Complex &c1, Complex &c2) {
    cout << "Number 1:" << endl;
    cout << "Real part: ";
    cin >> c1.real;
    cout << "Imaginary part: ";
    cin >> c1.imag;

    cout << "Number 2:" << endl;
    cout << "Real part: ";
    cin >> c2.real;
    cout << "Imaginary part: ";
    cin >> c2.imag;
}

void addComplex(const Complex &c1, const Complex &c2, Complex &result) {
    result.real = c1.real + c2.real;
    result.imag = c1.imag + c2.imag;
}

void subtractComplex(const Complex &c1, const Complex &c2, Complex &result) {
    result.real = c1.real - c2.real;
    result.imag = c1.imag - c2.imag;
}

void displayResult(const Complex &addResult, const Complex &subResult) {
    cout << "Addition result: " << addResult.real << " + i" << addResult.imag << endl;
    cout << "Subtraction result: " << subResult.real << " - i" << subResult.imag << endl;
}

int main() {
    Complex c1, c2, addResult, subResult;

    getComplex(c1, c2);
    addComplex(c1, c2, addResult);
    subtractComplex(c1, c2, subResult);
    displayResult(addResult, subResult);

    return 0;
}
