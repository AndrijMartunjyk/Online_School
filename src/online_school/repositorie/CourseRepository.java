package online_school.repositorie;

import online_school.course.model.Course;
import online_school.exception.EntityNotFoundException;
import online_school.generic.SchoolArray;
import online_school.my_interface.InterfaceRepository;

public class CourseRepository implements InterfaceRepository {
    private final SchoolArray<Course> coursesArray = new SchoolArray<>(new Course[1]);

    public SchoolArray<Course> getCoursesArrayObject() {
        return coursesArray;
    }

    public Course[] getCourseArray() {
        return coursesArray.getArray();
    }


    public void add(Course course) {
        coursesArray.add(course);
    }

    public long getCourseID() {
        return coursesArray.getArray()[counter() - 1].getCourseId();
    }

    public String getCourseName() {
        return coursesArray.getArray()[counter() - 1].getCourseName();
    }

    @Override
    public int counter() {
        int result = 0;
        for (Course course : coursesArray.getArray()) {
            if (course == null) {
                break;
            } else {
                result = course.getCounter();
            }
        }
        return result;
    }

    public void deleteCourse(long courseId) {
        boolean isPresent = true;
        for (int i = 0; i < coursesArray.getArray().length; i++) {
            if (coursesArray.getArray()[i] == null) {
                return;
            } else if (coursesArray.getArray()[i].getCourseId() == courseId) {
                coursesArray.getArray()[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", courseId);
                for (int j = 0; j < coursesArray.getArray().length - 1; j++) {
                    if (coursesArray.getArray()[j] == null) {
                        coursesArray.getArray()[j] = coursesArray.getArray()[j + 1];
                        coursesArray.getArray()[j + 1] = null;
                    }
                }
                isPresent = false;
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException(("Id course is not found!!!"));
        }
    }

    @Override
    public <E> void add(E course) {
        coursesArray.add((Course) course);
    }
}






