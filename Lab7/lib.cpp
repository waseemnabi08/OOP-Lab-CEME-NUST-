#include <iostream>
#include <string>

using namespace std;

const int MAX_BORROWED_BOOKS = 10;

class LibraryBook {
private:
    string title;
    string author;
    string isbn;
    string genre;
    bool available;

public:
    LibraryBook(const string& _title, const string& _author, const string& _isbn, const string& _genre)
        : title(_title), author(_author), isbn(_isbn), genre(_genre), available(true) {}

    bool isAvailable() {
        return available;
    }

    void checkOut() {
        if (available) {
            available = false;
        } else {
            cout << "This book is already checked out." << endl;
        }
    }

    void checkIn() {
        if (!available) {
            available = true;
        } else {
            cout << "This book is already checked in." << endl;
        }
    }

    void displayInfo() {
        cout << "Title: " << title << endl;
        cout << "Author: " << author << endl;
        cout << "ISBN: " << isbn << endl;
        cout << "Genre: " << genre << endl;
        cout << "Availability: " << (available ? "Available" : "Checked Out") << endl;
    }

    friend class Borrower;
};

class Borrower {
private:
    string name;
    int libraryCardNumber;
    LibraryBook* borrowedBooks[MAX_BORROWED_BOOKS]; // Array to store borrowed books
    int numBorrowedBooks;

public:
    Borrower(const string& _name, int _libraryCardNumber)
        : name(_name), libraryCardNumber(_libraryCardNumber), numBorrowedBooks(0) {}

    void borrowBook(LibraryBook* book) {
        if (book->isAvailable() && numBorrowedBooks < MAX_BORROWED_BOOKS) {
            borrowedBooks[numBorrowedBooks++] = book;
            book->checkOut();
        } else if (numBorrowedBooks >= MAX_BORROWED_BOOKS) {
            cout << "You have reached the maximum number of borrowed books." << endl;
        } else {
            cout << "Sorry, this book is already checked out." << endl;
        }
    }

    void returnBook(LibraryBook* book) {
        for (int i = 0; i < numBorrowedBooks; ++i) {
            if (borrowedBooks[i] == book) {
                borrowedBooks[i] = borrowedBooks[numBorrowedBooks - 1];
                --numBorrowedBooks;
                book->checkIn();
                return;
            }
        }
        cout << "You can't return a book you haven't borrowed." << endl;
    }

    void listBorrowedBooks() {
        cout << "Books currently borrowed by " << name << ":" << endl;
        for (int i = 0; i < numBorrowedBooks; ++i) {
            borrowedBooks[i]->displayInfo();
        }
    }

    void displayInfo() {
        cout << "Name: " << name << endl;
        cout << "Library Card Number: " << libraryCardNumber << endl;
    }

};

int main() {
    LibraryBook book1("ABC...", "XYZ", "9780316769174", "Fiction");
    LibraryBook book2("Kill ", "Lee", "9780061120084", "Fiction");

    Borrower borrower("Wasee", 12345);

    borrower.borrowBook(&book1);
    borrower.borrowBook(&book2);
    borrower.listBorrowedBooks();

    borrower.returnBook(&book1);
    borrower.listBorrowedBooks();

    return 0;
}