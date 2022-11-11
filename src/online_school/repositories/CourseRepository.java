package online_school.repositories;

import online_school.courses.models.Course;
import online_school.courses.models.Models;

import java.util.Arrays;

public class CourseRepository extends Repository {
    private Course[] courses = new Course[1];

    public int courseCounter() {
        int result = 0;
        for (Course course : courses) {
            if (course == null) {
                break;
            } else {
                result = course.getCounter();
            }
        }
        return result;
    }

    public void magnificationOfArray() {
        courses = Arrays.copyOf(courses, (courses.length * 3) / 2 + 1);
        System.out.format("Масив курсу збільшено, довжина: %d об'єктів!!!\n", (courses.length));
    }

    public void addCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (courseCounter() - 1 == courses.length) {
                magnificationOfArray();
            } else if (courses[i] == null) {
                courses[i] = course;
                break;
            }
        }
    }

    @Override
    public Models[] getAll() {
        return courses;
    }

    public long getCourseID() {
        return courses[courseCounter() - 1].getID();
    }

    public String getCourseName() {
        return courses[courseCounter() - 1].getName();
    }
}






