package online_school.service;

import online_school.domain.model.Course;
import online_school.exception.EntityNotFoundException;
import online_school.util.Log;

import java.util.List;

public class CourseService {
    private final String BORDER = "===============================================";
    private final String COURSE = "Курс: ";
    private final String BIG_BORDER = "============================================================================================================";

    public Course createCourse(Long id, String name) {
        return new Course(id, name);
    }

    public void showInformCourse(Long courseId, List<Course> courses) {
        Log.debug(CourseService.class.getName(), "method->\"showInformCourse\"");
        for (Course course : courses) {
            if (course == null) {
                break;
            } else if (course.getCourseId().equals(courseId)) {
                System.out.println(BORDER);
                Log.info(CourseService.class.getName(), BORDER);
                System.out.println(COURSE + course);
                Log.info(CourseService.class.getName(), COURSE + course);
                System.out.println(BIG_BORDER);
                Log.info(CourseService.class.getName(), BIG_BORDER);
                return;
            }
        }
        throw new EntityNotFoundException("Id of the course is not found!!!");
    }
}




