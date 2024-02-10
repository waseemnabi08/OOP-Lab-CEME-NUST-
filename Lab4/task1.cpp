#include <iostream>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       #include <iostream>
#include <cstring>

using namespace std;

class Polynomial {
private:
    int degree;
    int* coefficients;

public:
    // Default constructor
    Polynomial() : degree(0), coefficients(nullptr) {}

    // Parameterized constructor
    Polynomial(int deg, int* coef) : degree(deg) {
        coefficients = new int[degree + 1];
        memcpy(coefficients, coef, sizeof(int) * (degree + 1));
    }

    // Copy constructor
    Polynomial(const Polynomial& other) : degree(other.degree) {
        coefficients = new int[degree + 1];
        memcpy(coefficients, other.coefficients, sizeof(int) * (degree + 1));
    }

    // Destructor
    ~Polynomial() {
        delete[] coefficients;
    }

    // Function to add two polynomials
    Polynomial add(const Polynomial& other) const {
        int maxDegree = max(degree, other.degree);
        int* resultCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; ++i) {
            int thisCoef = (i <= degree) ? coefficients[i] : 0;
            int otherCoef = (i <= other.degree) ? other.coefficients[i] : 0;
            resultCoefficients[i] = thisCoef + otherCoef;
        }

        Polynomial result(maxDegree, resultCoefficients);
        delete[] resultCoefficients;
        return result;
    }

    // Function to subtract two polynomials
    Polynomial subtract(const Polynomial& other) const {
        int maxDegree = max(degree, other.degree);
        int* resultCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; ++i) {
            int thisCoef = (i <= degree) ? coefficients[i] : 0;
            int otherCoef = (i <= other.degree) ? other.coefficients[i] : 0;
            resultCoefficients[i] = thisCoef - otherCoef;
        }

        Polynomial result(maxDegree, resultCoefficients);
        delete[] resultCoefficients;
        return result;
    }

    // Function to multiply two polynomials
    Polynomial multiply(const Polynomial& other) const {
        int resultDegree = degree + other.degree;
        int* resultCoefficients = new int[resultDegree + 1];
        memset(resultCoefficients, 0, sizeof(int) * (resultDegree + 1));

        for (int i = 0; i <= degree; ++i) {
            for (int j = 0; j <= other.degree; ++j) {
                resultCoefficients[i + j] += coefficients[i] * other.coefficients[j];
            }
        }

        Polynomial result(resultDegree, resultCoefficients);
        delete[] resultCoefficients;
        return result;
    }

    // Function to display the polynomial
    void display() const {
        for (int i = degree; i >= 0; --i) {
            if (coefficients[i] != 0) {
                cout << coefficients[i];
                if (i > 0) {
                    cout << "x^" << i << " + ";
                }
            }
        }
        cout << endl;
    }

    // Function to input polynomial from user
    void input() {
        cout << "Enter the degree of the polynomial: ";
        cin >> degree;
        coefficients = new int[degree + 1];
        for (int i = degree; i >= 0; --i) {
            cout << "Enter coefficient for x^" << i << ": ";
            cin >> coefficients[i];
        }
    }
};

int main() {
    Polynomial poly1, poly2, poly3;
    
    cout << "Enter the first polynomial: ";
    poly1.input();
    
    cout << "Enter the second polynomial: ";
    poly2.input();
    
    // Display the polynomials
    cout << "Polynomial 1: ";
    poly1.display();
    cout << "Polynomial 2: ";
    poly2.display();
    
    // Add, subtract, and multiply
    Polynomial sum = poly1.add(poly2);
    Polynomial diff = poly1.subtract(poly2);
    Polynomial product = poly1.multiply(poly2);
    
    cout << "Sum: ";
    sum.display();
    cout << "Difference: ";
    diff.display();
    cout << "Product: ";
    product.display();
    
    return 0;
}
