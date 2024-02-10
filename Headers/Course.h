// Course.h
#ifndef COURSE_H
#define COURSE_H

#include <iostream>
#include <string>

class Instructor; // Forward declaration

class Course {
public:
    Course(const std::string& courseId, const std::string& courseName, Instructor* instructor);
    ~Course();

    void displayCourseDetails() const;

private:
    std::string courseId;
    std::string courseName;
    Instructor* instructor;
};

#endif // COURSE_H
