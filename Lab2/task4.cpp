#include<iostream>
#include<string>
using namespace std;

class Student{
    string name, reg, Father_name, deg, dep;
public:
    Student getstudent(){
        Student stud;
        cout << "Enter Name: ";
        cin >> stud.name;
        cout << "Enter Registration Number: ";
        cin >> stud.reg;

        cout << "Enter Father's name: ";
        cin >> stud.Father_name;

        cout << "Enter Department: ";
        cin >> stud.dep;

         cout << "Enter Degree: ";
         cin >> stud.deg;


        return stud;
    }

    void displaystudent(Student s){
        cout << "Name: " << s.name << endl;
        cout << "Father's name: " << s.Father_name << endl;
        cout << "Registration Number: " << s.reg  << endl;
        cout << "Degree: "<< s.deg << endl;
        cout << "Department: " << s.dep << endl;
    }
};


int main(){
    Student s;
    s = s.getstudent();
    s.displaystudent(s);
}