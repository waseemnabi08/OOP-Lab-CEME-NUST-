#include <iostream>
#include <string>
using namespace std;

class HugeInteger {
private:
    int arr[40];

public:
    HugeInteger() {
        for (int i = 0; i < 40; i++) {
            arr[i] = 0;
        }
    }

    HugeInteger(int size, int arrr[]) {
        for (int i = 0; i < 40; i++) {
            if (i < 40 - size) {
                arr[i] = 0; // Initialize leading zeros
            } else {
                arr[i] = arrr[i - (40 - size)]; // Copy relevant elements
            }
        }
    }

    static HugeInteger Input() {
    string s;
    cin >> s;
    int size = s.length();
    int array[40];  // Initialize to size 40

    // Initialize the entire array with zeros
    for (int i = 0; i < 40; i++) {
        array[i] = 0;
    }

    for (int i = 40 - size, j = 0; i < 40; i++, j++) {
        array[i] = s[j] - '0'; // Convert character to integer
    }

    return HugeInteger(40, array);
}



    bool isZero() const {
        // Check if the huge integer is zero
        for (int i = 0; i < 40; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    bool isEqualTo(const HugeInteger& other) const {
        // Check if two huge integers are equal
        for (int i = 0; i < 40; i++) {
            if (arr[i] != other.arr[i]) {
                return false;
            }
        }
        return true;
    }

    bool operator>(const HugeInteger& other) const {
        // Compare two huge integers
        for (int i = 0; i < 40; i++) {
            if (arr[i] < other.arr[i]) {
                return false;
            } else if (arr[i] > other.arr[i]) {
                return true;
            }
        }
        return false; // If both are equal
    }

    HugeInteger operator+(const HugeInteger& other) const {
        // Perform addition of two huge integers
        int carry = 0;
        int result[40];
        for (int i = 39; i >= 0; i--) {
            result[i] = arr[i] + other.arr[i] + carry;
            carry = result[i] / 10;
            result[i] %= 10;
        }
        return HugeInteger(40, result);
    }

    HugeInteger operator-(const HugeInteger& other) const {
        // Perform subtraction of two huge integers
        int borrow = 0;
        int result[40];
        for (int i = 39; i >= 0; i--) {
            result[i] = arr[i] - other.arr[i] - borrow;
            if (result[i] < 0) {
                result[i] += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
        }
        return HugeInteger(40, result);
    }

    void output() const {
    int startIndex = 0; // Find the index of the first non-zero digit
    while (startIndex < 40 && arr[startIndex] == 0) {
        startIndex++;
    }

    if (startIndex == 40) {
        cout << "0"; // If the number is zero, display a single zero.
    } else {
        for (int i = startIndex; i < 40; i++) {
            cout << arr[i];
        }
    }
    cout << endl;
}



    friend istream& operator>>(istream& input, HugeInteger& c);
    friend ostream& operator<<(ostream& output, const HugeInteger& c);
};

// Overload the extraction operator >>
istream& operator>>(istream& input, HugeInteger& c) {
    c.Input();
    return input;
}

// Overload the insertion operator <<
// Overload the insertion operator <<
ostream& operator<<(ostream& output, const HugeInteger& c) {
    for (int i = 0; i < 40; i++) {
        output << c.arr[i];
    }
    return output;
}

int main() {
    HugeInteger h1, h2;

    cout << "Enter the first huge integer: ";
    cin >> h1;

    cout << "Enter the second huge integer: ";
    cin >> h2;

    // Test various member functions
    cout << "Is h1 zero? " << (h1.isZero() ? "Yes" : "No") << endl;
    cout << "Is h1 equal to h2? " << (h1.isEqualTo(h2) ? "Yes" : "No") << endl;
    cout << "Is h1 greater than h2? " << (h1 > h2 ? "Yes" : "No") << endl;

    // Perform addition and subtraction
    HugeInteger sum = h1 + h2;
    HugeInteger diff = h1 - h2;

    cout << "h1: " << h1 << endl;
    cout << "Sum: " << sum << endl;
    cout << "Difference: " << diff << endl;

    return 0;
}