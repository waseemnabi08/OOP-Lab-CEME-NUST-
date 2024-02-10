#include <iostream>
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

    void input() {
        string s;
        cin >> s;
        int size = s.length();
        for (int i = 0; i < 40 - size; i++) {
            arr[i] = 0; // Initialize leading zeros
        }

        for (int i = 40 - size, j = 0; i < 40; i++, j++) {
            arr[i] = s[j] - '0'; // Convert character to integer
        }
    }

    void output() const {
        int startIndex = 0;
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
    }

    bool isZero() const {
        for (int i = 0; i < 40; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    bool isEqualTo(const HugeInteger& other) const {
        for (int i = 0; i < 40; i++) {
            if (arr[i] != other.arr[i]) {
                return false;
            }
        }
        return true;
    }

    bool operator >(const HugeInteger& other) const {
        for (int i = 0; i < 40; i++) {
            if (arr[i] < other.arr[i]) {
                return false;
            } else if (arr[i] > other.arr[i]) {
                return true;
            }
        }
        return false;
    }

    HugeInteger operator+(const HugeInteger& other) const {
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

    bool operator==(const HugeInteger& other) const {
        return isEqualTo(other);
    }

    bool operator!=(const HugeInteger& other) const {
        return !isEqualTo(other);
    }

    friend istream& operator>>(istream& input, HugeInteger& c);
    friend ostream& operator<<(ostream& output, const HugeInteger& c);
};


// Overload the extraction operator >>
istream& operator>>(istream& input, HugeInteger& c) {
    c.input();
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
    HugeInteger g;
    cout << "Enter first number: ";
    cin >> g;

    cout << "Enter another number: ";


    HugeInteger f;
    cin >> f;
    cout << "First number: "  << g << endl;
    cout << "Second number: " << f << endl;

    cout << "g + f: " << (g + f);
    cout << endl;
    HugeInteger j = f - g;
    cout << "f - g: " << j;
    cout << endl;

    HugeInteger k = f;
    cout << "k == f: " << (k == f) << endl;

    cout << "g > f: " << (g > f) << endl;
    cout << "k != g: " << (k != g) << endl;

    HugeInteger m;
    cout << "m == 0: " << (m.isZero()) << endl;

    return 0;
}
