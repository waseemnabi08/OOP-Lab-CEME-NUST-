// Course.cpp
#include "Course.h"
#include "Instructor.h"

Course::Course(const std::string& courseId, const std::string& courseName, Instructor* instructor)
    : courseId(courseId), courseName(courseName), instructor(instructor) {}

Course::~Course() {}

void Course::displayCourseDetails() const {
    std::cout << "Course ID: " << courseId << "\nCourse Name: " << courseName
              << "\nInstructor: ";
     instructor->displayProfile() ;
     std :: cout << std::endl;
}
