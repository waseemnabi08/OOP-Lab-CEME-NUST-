#include <iostream>

template <typename T>
class MyVector {
private:
    T* data;
    size_t currentSize;
    size_t currentCapacity;

public:
    // Constructors
    MyVector() : data(nullptr), currentSize(0), currentCapacity(0) {}

    MyVector(size_t size, const T& value = T()) : currentSize(size), currentCapacity(size) {
        data = new T[currentCapacity];
        for (size_t i = 0; i < currentSize; i++) {
            data[i] = value;
        }
    }

    // Destructor
    ~MyVector() {
        delete[] data;
    }

    // Copy Constructor
    MyVector(const MyVector& other) : currentSize(other.currentSize), currentCapacity(other.currentCapacity) {
        data = new T[currentCapacity];
        for (size_t i = 0; i < currentSize; i++) {
            data[i] = other.data[i];
        }
    }

    // Assignment Operator Overload
    MyVector& operator=(const MyVector& other) {
        if (this != &other) {
            MyVector temp(other);
            swap(temp);
        }
        return *this;
    }

    // Size Management Functions
    size_t size() const {
        return currentSize;
    }

    size_t capacity() const {
        return currentCapacity;
    }

    bool empty() const {
        return currentSize == 0;
    }

    // Element Access Functions
    T& at(size_t index) {
        if (index < currentSize) {
            return data[index];
        }
        throw std::out_of_range("Index out of bounds");
    }

    T& operator[](size_t index) {
        return data[index];
    }

    T& front() {
        if (currentSize > 0) {
            return data[0];
        }
        throw std::out_of_range("Vector is empty");
    }

    T& back() {
        if (currentSize > 0) {
            return data[currentSize - 1];
        }
        throw std::out_of_range("Vector is empty");
    }

    // Modification Functions
    void push_back(const T& value) {
        if (currentSize == currentCapacity) {
            reserve(currentCapacity * 2 + 1);
        }
        data[currentSize] = value;
        currentSize++;
    }

    void pop_back() {
        if (currentSize > 0) {
            currentSize--;
        }
    }

    void clear() {
        currentSize = 0;
    }

    // Resizing and Reallocation Functions
    void resize(size_t new_size, const T& value = T()) {
        if (new_size < currentSize) {
            currentSize = new_size;
        }
        else if (new_size > currentSize) {
            if (new_size > currentCapacity) {
                reserve(std::max(new_size, currentCapacity * 2));
            }
            for (size_t i = currentSize; i < new_size; i++) {
                data[i] = value;
            }
            currentSize = new_size;
        }
    }

    void reserve(size_t new_capacity) {
        if (new_capacity > currentCapacity) {
            T* new_data = new T[new_capacity];
            for (size_t i = 0; i < currentSize; i++) {
                new_data[i] = data[i];
            }
            delete[] data;
            data = new_data;
            currentCapacity = new_capacity;
        }
    }

    // Utility Functions
    void swap(MyVector& other) {
        T* tempData = data;
        size_t tempSize = currentSize;
        size_t tempCapacity = currentCapacity;

        data = other.data;
        currentSize = other.currentSize;
        currentCapacity = other.currentCapacity;

        other.data = tempData;
        other.currentSize = tempSize;
        other.currentCapacity = tempCapacity;
    }
};

int main() {
    MyVector<int> myVec1;

    MyVector<double> myVec2(5, 3.14);

    myVec1.push_back(10);
    myVec1.push_back(20);
    myVec1.push_back(30);

    std::cout << "Element at index 1: " << myVec1[1] << std::endl;

    myVec1[0] = 100;

    std::cout << "Vector size: " << myVec1.size() << std::endl;
    std::cout << "Vector capacity: " << myVec1.capacity() << std::endl;

    myVec1.resize(5, 50);

    try {
        std::cout << "Element at index 6: " << myVec1.at(6) << std::endl;
    }
    catch (const std::out_of_range& e) {
        std::cerr << "Exception: " << e.what() << std::endl;
    }

    myVec1.clear();

    std::cout << "Is myVec1 empty? " << (myVec1.empty() ? "Yes" : "No") << std::endl;

    return 0;
}
