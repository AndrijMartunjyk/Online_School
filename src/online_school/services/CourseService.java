package online_school.services;

import online_school.courses.models.Course;
import online_school.courses.models.Models;

import java.util.Arrays;

public class CourseService {

    public Course courseCreation(long ID, String name) {
        return new Course(ID, name);
    }

    public void outId(Models[] course) {
        System.out.println("Інформація про курс: " + Arrays.toString(course));
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


