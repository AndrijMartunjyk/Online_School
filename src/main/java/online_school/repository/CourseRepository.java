package online_school.repository;

import online_school.domain.model.Course;
import online_school.log.Log;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements InterfaceRepository {
    private final List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        Log.debug(CourseRepository.class.getName(), "method->\"getCourseList\"");
        return courseList;
    }

    public Course objectOfCourse(Long idOfCourse) {
        Course course = null;
        for (Course c : courseList) {
            if (c.getCourseId().equals(idOfCourse)) {
                course = c;
                break;
            }
        }
        return course;
    }

    @Override
    public int counter() {
        int result = 0;
        for (Course course : courseList) {
            if (course == null) {
                break;
            } else {
                result = course.getCounter();
            }
        }
        Log.debug(CourseRepository.class.getName(), "method->\"counter\"");
        return result;
    }
}


