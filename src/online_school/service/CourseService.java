package online_school.service;

import online_school.course.model.Course;
import online_school.course.model.Model;

public class CourseService {

    public Course courseCreation(long ID, String name) {
        return new Course(ID, name);
    }

    public void informCourse(long idCourse, Model[] courses) {
        boolean trueOrFalse = true;
        for (Model models : courses) {
            if (models == null) {
                break;
            } else if (models.getID() == idCourse) {
                System.out.println("===============================================");
                System.out.println("Курс: " + models);
                System.out.println("============================================================================================================");
                trueOrFalse = false;
                break;
            }
        }
        if (trueOrFalse) {
            System.out.println("Не має об'єкта з таким ID, спробуйте ще раз!!!");
        }
    }
}


