package online_school.service;

import online_school.course.model.Course;

public class CourseService {

    public Course createCourse(long ID, String name) {
        return new Course(ID, name);
    }

    public void showInformCourse(long courseId, Course[] courses) {
        boolean isPresent = true;
        for (Course course : courses) {
            if (course == null) {
                break;
            } else if (course.getObjectId() == courseId) {
                System.out.println("===============================================");
                System.out.println("Курс: " + course);
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


