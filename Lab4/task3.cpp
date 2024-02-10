#include <iostream>
using namespace std;

class ORGate {
private:
    int* inputs;
        int size;

        public:
            // Default constructor
                ORGate() : inputs(nullptr), size(0) {}

                    // Parameterized constructor
                        ORGate(int n, const int* in) : size(n) {
                                inputs = new int[size];
                                        for (int i = 0; i < size; i++) {
                                                    inputs[i] = in[i];
                                                            }
                                                                }

                                                                    // Copy constructor
                                                                        ORGate(const ORGate& other) : size(other.size) {
                                                                                inputs = new int[size];
                                                                                        for (int i = 0; i < size; i++) {
                                                                                                    inputs[i] = other.inputs[i];
                                                                                                            }
                                                                                                                }

                                                                                                                    // Assignment operator
                                                                                                                        ORGate& operator=(const ORGate& other) {
                                                                                                                                if (this != &other) {
                                                                                                                                            delete[] inputs;  // Free existing memory
                                                                                                                                                        size = other.size;
                                                                                                                                                                    inputs = new int[size];
                                                                                                                                                                                for (int i = 0; i < size; i++) {
                                                                                                                                                                                                inputs[i] = other.inputs[i];
                                                                                                                                                                                                            }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                            return *this;
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                    // Destructor
                                                                                                                                                                                                                                        ~ORGate() {
                                                                                                                                                                                                                                                delete[] inputs;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                        // Evaluate the OR gate
                                                                                                                                                                                                                                                            int evaluate() {
                                                                                                                                                                                                                                                                    int result = 0;
                                                                                                                                                                                                                                                                            for (int i = 0; i < size; i++) {
                                                                                                                                                                                                                                                                                        result = result || inputs[i];
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                        return result;
                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                // Display the result
                                                                                                                                                                                                                                                                                                                    void displayResult() {
                                                                                                                                                                                                                                                                                                                            cout << "Result: " << evaluate() << endl;
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                };

                                                                                                                                                                                                                                                                                                                                int main() {
                                                                                                                                                                                                                                                                                                                                    int input1[] = {0, 1};
                                                                                                                                                                                                                                                                                                                                        ORGate orGate(2, input1);

                                                                                                                                                                                                                                                                                                                                            cout << "Result of orGate: ";
                                                                                                                                                                                                                                                                                                                                                orGate.displayResult();

                                                                                                                                                                                                                                                                                                                                                    ORGate cORGate(orGate);

                                                                                                                                                                                                                                                                                                                                                        int input2[] = {0, 1, 1};
                                                                                                                                                                                                                                                                                                                                                            orGate = ORGate(3, input2);

                                                                                                                                                                                                                                                                                                                                                                cout << "Result of orGate after resizing: ";
                                                                                                                                                                                                                                                                                                                                                                    orGate.displayResult();

                                                                                                                                                                                                                                                                                                                                                                        cout << "Result of cORGate: ";
                                                                                                                                                                                                                                                                                                                                                                            cORGate.displayResult();

                                                                                                                                                                                                                                                                                                                                                                                return 0;
                                                                                                                                                                                                                                                                                                                                                                                }