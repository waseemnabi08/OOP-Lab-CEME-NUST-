#include <iostream>
using namespace std;

int gcd(int a, int b){ // a < b
    if (a == 0)
        return b;
    else
        return gcd(b % a , a);
}

int main(){
    cout << gcd (6, 18) << endl;
    cout << gcd (1456, 1860) << endl;
    return 0;
}
