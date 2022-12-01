package online_school.service;

import online_school.course.model.Course;
import online_school.course.model.Model;

public class CourseService {

    public Course createCourse(long ID, String name) {
        return new Course(ID, name);
    }

    public void showInformCourse(long idCourse, Model[] courses) {
        boolean isPresent = true;
        for (Model models : courses) {
            if (models == null) {
                break;
            } else if (models.getModelId() == idCourse) {
                System.out.println("===============================================");
                System.out.println("Курс: " + models);
                System.out.println("============================================================================================================");
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.out.println("Не має об'єкта з таким ID, спробуйте ще раз!!!");
        }
    }
}


