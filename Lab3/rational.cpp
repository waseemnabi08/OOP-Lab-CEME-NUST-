#include <iostream>
using namespace std;

class Rational{
    int numerator, denominator;

    public:
    //Default const
    Rational()
    {
        numerator = 0;
        denominator = 0;
    }

    //Parametrized cons
    Rational(int numr, int denom){
        setvalues(numr, denom);

    }

    // Copy const

    Rational(Rational &R){
        numerator = R.numerator;
        denominator = R.denominator;
    }

    // Input
    void InputRational(){
        cout << "Input Numerator: ";
        cin >> numerator;

        cout << "Input denominator: ";
        cin >> denominator;
    }

    //setters
    void setvalues(int n, int d){
        numerator = n;

        if (d != 0)
            denominator = d;
        else
            cout << "Denominator cannot be zero\n";
    }

    //getters

    int getnumerator(){
        return numerator;
    }

    int getdenominator(){
        return denominator;
    }

    //Add func

    Rational add(Rational &R){
        int num1 = (denominator*R.numerator + R.denominator * numerator);
        int num2 = (denominator * R.denominator);

        return Rational(num1, num2);
        }

    Rational multiply(Rational &R){
        int num1 = numerator * R.numerator;
        int num2 = denominator * R.denominator;
        return Rational(num1, num2);
    }


    Rational divide(Rational &R){
        int num1 = numerator * R.denominator;
        int num2 = denominator * R.numerator;
        return Rational(num1, num2);
    }
    // Functiom to write in reduce form;
    void reduce(){
        int rem = denominator % numerator;
        numerator /=  rem;
        denominator /= rem;
    }


    void floatprint(){
        cout << (float) numerator / (float) denominator << endl;
    }

    void reduceprint(){
        reduce();
        cout << "Result in reduce form: " << endl;
        cout << numerator << "/" << denominator << endl;
    }

};


int main(){

	Rational a;
	Rational b;
 	a.setvalues(7,8);
	b.setvalues(6,5);
	a.add(b);
	Rational c;
	c.setvalues(-5,7);
	c.multiply(b);
	c=a;
    c.reduceprint();
    c.floatprint();
	Rational j=b;
	a=b.divide(c);
	Rational d;
	d.setvalues(-5,0);
	c.multiply(d);
    a.InputRational();
    b.InputRational();
    a.add(b);
    a.reduceprint();


}