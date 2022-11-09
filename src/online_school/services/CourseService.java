package online_school.services;

import online_school.courses.models.Course;

import java.util.Arrays;

public class CourseService {
    private int courseCounter;

    public Course courseCreation(long ID, String name) {
        return new Course(ID, name);
    }

    public int getCourseCounter() {
        return courseCounter;
    }

    public void setCourseCounter(int courseCounter) {
        this.courseCounter = courseCounter;
    }

    public void outId(Course[] course) {
        if (getCourseCounter() < 1) {
            System.out.println("Спочатку створіть Курс!!!");
        } else {
            System.out.println("Інформація про курс: " + Arrays.toString(course));
        }
    }

    public void informCourse(int idCourse, Course[] courses) {
        for (Course course : courses) {
            if (course == null) {
                break;
            } else if (course.getID() == idCourse) {
                System.out.println("===============================================");
                System.out.println("Курс: " + course);
                System.out.println("============================================================================================================");
            }
        }
    }
}


