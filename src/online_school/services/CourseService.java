package online_school.services;

import online_school.courses.models.Course;
import online_school.courses.models.Models;

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

    public void outId(Models[] course) {
        if (getCourseCounter() < 1) {
            System.out.println("Спочатку створіть Курс!!!");
        } else {
            System.out.println("Інформація про курс: " + Arrays.toString(course));
        }
    }

    public void informCourse(int idCourse, Models[] courses) {
        for (Models models : courses) {
            if (models == null) {
                break;
            } else if (models.getID() == idCourse) {
                System.out.println("===============================================");
                System.out.println("Курс: " + models);
                System.out.println("============================================================================================================");
            }
        }
    }
}


