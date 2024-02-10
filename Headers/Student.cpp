// Student.cpp
#include "Student.h"

Student::Student(const std::string& userId, const std::string& userName, const std::string& email)
    : User(userId, userName, email) {}

Student::~Student() {}

void Student::enrollCourse(const std::string& course) {
    coursesEnrolled.push_back(course);
}

void Student::displayCourses() const {
    std::cout << "Courses Enrolled:\n";
    for (const auto& course : coursesEnrolled) {
        std::cout << "- " << course << std::endl;
    }
}
