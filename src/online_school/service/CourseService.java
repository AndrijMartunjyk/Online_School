package online_school.service;

import online_school.course.model.Course;
import online_school.exception.EntityNotFoundException;

import java.util.List;

public class CourseService {

    public Course createCourse(Long iD, String name) {
        return new Course(iD, name);
    }

    public void showInformCourse(Long courseId, List<Course> courses) {
        for (Course course : courses) {
            if (course == null) {
                break;
            } else if (course.getCourseId().equals(courseId)) {
                System.out.println("===============================================");
                System.out.println("Курс: " + course);
                System.out.println("============================================================================================================");
                return;
            }
        }
        throw new EntityNotFoundException("Id of the course is not found!!!");
    }
}




