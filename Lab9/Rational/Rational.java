class Rational{
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational add(Rational r){
        int num = this.numerator * r.denominator + r.numerator * this.denominator;
        int den = this.denominator * r.denominator;
        return new Rational(num, den);
    }

    public Rational subtract(Rational r){
        int num = this.numerator * r.denominator - r.numerator * this.denominator;
        int den = this.denominator * r.denominator;
        return new Rational(num, den);
    }

    public Rational multiply(Rational r){
        int num = this.numerator * r.numerator;
        int den = this.denominator * r.denominator;
        int gcd = gcd(num, den);
        return new Rational(num / gcd , den / gcd);
    }

    public Rational divide(Rational r){
        int num = this.numerator * r.denominator;
        int den = this.denominator * r.numerator;
        //call gcd
        int gcd = gcd(num, den);
        return new Rational(num / gcd , den / gcd);
    }

    public void printFloat(){
        System.out.println((float)this.numerator/this.denominator);
    }

    public int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

    public String toString(){
        return this.numerator + "/" + this.denominator;
    }

    public boolean greaterThan(Rational r){
        return this.numerator * r.denominator > r.numerator * this.denominator;
    }

    public boolean lessThan(Rational r){
        return this.numerator * r.denominator < r.numerator * this.denominator;
    }

    public boolean equals(Rational r){
        return this.numerator * r.denominator == r.numerator * this.denominator;
    }


}
