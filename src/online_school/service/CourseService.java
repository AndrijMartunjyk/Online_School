package online_school.service;

import online_school.course.model.Course;
import online_school.exception.EntityNotFoundException;

public class CourseService {

    public Course createCourse(long ID, String name) {
        return new Course(ID, name);
    }

    public void showInformCourse(long courseId, Course[] courses) {
        boolean isPresent = true;
        for (Course course : courses) {
            if (course == null) {
                return;
            } else if (course.getCourseId() == courseId) {
                System.out.println("===============================================");
                System.out.println("Курс: " + course);
                System.out.println("============================================================================================================");
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id of the course is not found!!!");
        }
    }
}




