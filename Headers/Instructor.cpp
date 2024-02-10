// Instructor.cpp
#include "Instructor.h"

Instructor::Instructor(const std::string& userId, const std::string& userName, const std::string& email)
    : User(userId, userName, email) {}

Instructor::~Instructor() {}

void Instructor::addCourse(const std::string& course) {
    coursesTeaching.push_back(course);
}

void Instructor::displayCourses() const {
    std::cout << "Courses Teaching:\n";
    for (const auto& course : coursesTeaching) {
        std::cout << "- " << course << std::endl;
    }
}
