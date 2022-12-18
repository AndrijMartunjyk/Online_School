package online_school.repository;

import online_school.course.model.Course;
import online_school.my_interface.InterfaceRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements InterfaceRepository {
    private final List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public long getCourseID() {
        return courseList.get(counter() - 1).getCourseId();
    }

    public String getCourseName() {
        return courseList.get(counter() - 1).getCourseName();
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






