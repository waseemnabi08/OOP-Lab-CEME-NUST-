// Instructor.h
#ifndef INSTRUCTOR_H
#define INSTRUCTOR_H

#include "User.h"
#include <vector>

class Instructor : public User {
public:
    Instructor(const std::string& userId, const std::string& userName, const std::string& email);
    ~Instructor();

    void addCourse(const std::string& course);
    void displayCourses() const;

private:
    std::vector<std::string> coursesTeaching;
};

#endif // INSTRUCTOR_H
