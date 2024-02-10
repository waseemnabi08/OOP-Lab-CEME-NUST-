// Student.h
#ifndef STUDENT_H
#define STUDENT_H

#include "User.h"
#include <vector>

class Student : public User {
public:
    Student(const std::string& userId, const std::string& userName, const std::string& email);
    ~Student();

    void enrollCourse(const std::string& course);
    void displayCourses() const;

private:
    std::vector<std::string> coursesEnrolled;
};

#endif // STUDENT_H
