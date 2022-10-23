package online_school.services;

import online_school.courses.Course;

public class CourseService {
    public Course courseCreation() {
        return new Course();
    }

    public Course courseCreation(String name, String startCourse, String finishCourse) {
        return new Course(name, startCourse, finishCourse);
    }
}
