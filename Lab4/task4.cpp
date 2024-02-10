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
                                                                                                                                                                                                                    // Test Plan
                                                                                                                                                                                                                        int input1[] = {0, 1};
                                                                                                                                                                                                                            ORGate orGate(2, input1); // Parameterized constructor

                                                                                                                                                                                                                                // Display the result of orGate
                                                                                                                                                                                                                                    cout << "Result of orGate: ";
                                                                                                                                                                                                                                        orGate.displayResult();

                                                                                                                                                                                                                                            ORGate cORGate(orGate); // Copy constructor

                                                                                                                                                                                                                                                int input2[] = {0, 1, 1};
                                                                                                                                                                                                                                                    orGate = ORGate(3, input2); // Resize with parameterized constructor

                                                                                                                                                                                                                                                        // Display the result of orGate after resizing
                                                                                                                                                                                                                                                            cout << "Result of orGate after resizing: ";
                                                                                                                                                                                                                                                                orGate.displayResult();

                                                                                                                                                                                                                                                                    // Display the result of cORGate
                                                                                                                                                                                                                                                                        cout << "Result of cORGate: ";
                                                                                                                                                                                                                                                                            cORGate.displayResult();

                                                                                                                                                                                                                                                                                return 0;
                                                                                                                                                                                                                                                                                }