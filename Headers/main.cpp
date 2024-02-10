// main.cpp
#include "User.h"
#include "Student.h"
#include "Instructor.h"
#include "Course.h"

int main() {
    Student student("STU02", "Muhammad Ali", "ali@example.com");
    Instructor instructor("INS01", "Dr. Furqan", "furqan12@example.com");
    Course course("C001", "Data Structures", &instructor);

    student.enrollCourse("C++ Programming");
    instructor.addCourse("Advanced Algorithms");

    student.displayProfile();
    student.displayCourses();

    instructor.displayProfile();
    instructor.displayCourses();

    course.displayCourseDetails();

    return 0;
}
