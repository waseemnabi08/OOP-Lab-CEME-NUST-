#include <iostream>
using namespace std;

class BankAccount {
    float balance;

public:
    // Constructor to initialize balance
    BankAccount(float bal = 0) {
        setBalance(bal);
    }

    // Setter for balance
    void setBalance(float bal) {
        if (bal >= 0) {
            balance = bal;
        } else {
            cout << "Balance cannot be negative. Setting it to 0." << endl;
            balance = 0;
        }
    }

    // Getter for balance
    float getBalance() const {
        return balance;
    }

    float deposit() {
        float dep;
        do {
            cout << "Enter the amount to deposit: ";
            cin >> dep;
        } while (dep <= 0);

        balance += dep;
        return balance;
    }

    void withdraw() {
        float amount;

        do {
            cout << "Enter the withdrawal amount: ";
            cin >> amount;
        } while (amount <= 0);

        if (amount <= balance) {
            balance -= amount;
            cout << "Withdrawn successfully... " << endl;
        } else {
            cout << "Insufficient funds.... " << endl;
        }
    }

    void display() const {
        cout << "Your account balance is " << balance << endl;
    }
};

int main() {
    float initialBalance;
    cout << "Enter the initial balance: ";
    cin >> initialBalance;

    BankAccount bank(initialBalance);
    bank.deposit();
    bank.withdraw();
    bank.display();

    return 0;
}
