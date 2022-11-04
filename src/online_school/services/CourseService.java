package online_school.services;

import online_school.courses.Course;

import java.util.Arrays;

public class CourseService {

    public Course courseCreation() {
        return new Course();
    }

    public Course courseCreation(long ID, String name) {
        return new Course(ID, name);
    }

    public void outId(Course[] course) {
        if (Course.counter < 1) {
            System.out.println("Спочатку створіть Курс!!!");
        } else {
            System.out.println("Інформація про курс: " + Arrays.toString(course));
        }
    }

    public void informCourse(int idCourse, Course[] courses) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                break;
            } else if (courses[i].getID() == idCourse) {
                System.out.println("===============================================");
                System.out.println("Курс: " + courses[i]);
                System.out.println("============================================================================================================");
            }
        }
    }
}


