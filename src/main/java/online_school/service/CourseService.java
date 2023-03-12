package online_school.service;

import online_school.domain.model.Course;
import online_school.log.Log;

import java.util.List;
import java.util.Optional;

public class CourseService {

    public Course createCourse(Long id, String name) {
        Log.debug(CourseService.class.getName(), "method->\"createCourse\"");
        return new Course(id, name);
    }

    public void showInformCourse(Long courseId, List<Course> courseList) {
        Optional<List<Course>> courseListOptional = Optional.ofNullable(courseList);
        Optional<Long> courseIdOptional = Optional.ofNullable(courseId);
        String stacktrace = "Id of the course is not found!!!";
        if (courseListOptional.isPresent() && courseIdOptional.isPresent()) {
            Log.debug(CourseService.class.getName(), "method->\"showInformCourse\"");
            for (Course course : courseListOptional.get()) {
                if (course == null) {
                    break;
                } else if (course.getCourseId().equals(courseIdOptional.get())) {
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
        }
        Log.warning(LectureService.class.getName(), "EntityNotFoundException", stacktrace);
    }
}




