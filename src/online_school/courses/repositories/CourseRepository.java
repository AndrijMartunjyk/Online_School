package online_school.courses.repositories;

import online_school.courses.Course;

import java.util.Arrays;

public class CourseRepository {
    private Course[] courses = new Course[1];

    public void magnificationOfArray() {
        courses = Arrays.copyOf(courses, (courses.length * 3) / 2 + 1);
        System.out.format("Масив курсу збільшено, довжина: %d об'єктів!!!\n", (courses.length));
    }

    public void addCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (Course.counter - 1 == courses.length) {
                magnificationOfArray();
            } else if (courses[i] == null) {
                courses[i] = course;
                break;
            }
        }
    }

    public Course[] getCoursesArray() {
        return courses;
    }

    public long getCourseID() {
        return courses[Course.counter - 1].getID();
    }
    public String getCourseName() {
        return courses[Course.counter - 1].getNameCourse();
    }
}






