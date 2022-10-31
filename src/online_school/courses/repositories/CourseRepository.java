package online_school.courses.repositories;

import online_school.courses.Course;

import java.util.Arrays;

public class CourseRepository {
    public static Course[] course = new Course[Course.counter];

    public void arraysOfObjects() {
        if (Course.counter == course.length) {
            course = Arrays.copyOf(course, (course.length * 3) / 2 + 1);
        }
    }
}






