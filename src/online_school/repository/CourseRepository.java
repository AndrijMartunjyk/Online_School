package online_school.repository;

import online_school.course.model.Course;
import online_school.my_interface.InterfaceRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements InterfaceRepository {
    public static List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public long getCourseID(Course c) {
        for (Course course : courseList) {
            if (course.equals(c)) {
                return course.getCourseId();
            }
        }
        return 0;
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
        return result;
    }
}






