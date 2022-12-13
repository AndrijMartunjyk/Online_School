package online_school.repositorie;

import online_school.course.model.Course;
import online_school.generic.SchoolArray;
import online_school.my_interface.InterfaceRepository;

public class CourseRepository implements InterfaceRepository {
    private final SchoolArray<Course> coursesArrayTemplate = new SchoolArray<>(new Course[1]);

    public Course[] getCoursesArray() {
        return coursesArrayTemplate.findAll();
    }

    public void add(Course course) {
        coursesArrayTemplate.add(course);
    }

    public long getCourseID() {
        return getCoursesArray()[counter() - 1].getCourseId();
    }

    public String getCourseName() {
        return getCoursesArray()[counter() - 1].getCourseName();
    }

    @Override
    public int counter() {
        int result = 0;
        for (Course course : getCoursesArray()) {
            if (course == null) {
                break;
            } else {
                result = course.getCounter();
            }
        }
        return result;
    }

    @Override
    public <E> void add(E course) {
        coursesArrayTemplate.add((Course) course);
    }

    @Override
    public int returnIndex(Long idCourse) {
        int index = -1;
        for (int i = 0; i < getCoursesArray().length; i++) {
            if (getCoursesArray()[i].getCourseId().equals(idCourse)) {
                index = i;
            }
        }
        return index;
    }
}






