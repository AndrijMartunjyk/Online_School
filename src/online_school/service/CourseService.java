package online_school.service;

import online_school.domain.model.Course;
import online_school.log.Log;

import java.util.List;

public class CourseService {

    public Course createCourse(Long id, String name) {
        Log.debug(CourseService.class.getName(), "method->\"createCourse\"");
        return new Course(id, name);
    }

    public void showInformCourse(Long courseId, List<Course> courses) {
        String stacktrace = "Id of the course is not found!!!";
        Log.debug(CourseService.class.getName(), "method->\"showInformCourse\"");
        for (Course course : courses) {
            if (course == null) {
                break;
            } else if (course.getCourseId().equals(courseId)) {
                String BORDER = "===============================================";
                System.out.println(BORDER);
                Log.info(CourseService.class.getName(), BORDER);
                String COURSE = "Курс: ";
                System.out.println(COURSE + course);
                Log.info(CourseService.class.getName(), COURSE + course);
                String BIG_BORDER = "============================================================================================================";
                System.out.println(BIG_BORDER);
                Log.info(CourseService.class.getName(), BIG_BORDER);
                return;
            }
        }
        System.out.println(stacktrace);
        Log.warning(LectureService.class.getName(), "EntityNotFoundException", stacktrace);

    }
}




