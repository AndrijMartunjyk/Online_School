package online_school.repositorie;

import online_school.course.model.Course;
import online_school.course.model.Model;
import online_school.generic.SchoolArray;

public class CourseRepository extends Repository {
    private final SchoolArray<Course> coursesArray = new SchoolArray<>(new Course[1]);

    public int courseCounter() {
        int result = 0;
        for (Model course : coursesArray.getArray()) {
            if (course == null) {
                break;
            } else {
                result = course.getCounter();
            }
        }
        return result;
    }

    public SchoolArray<Course> getCoursesArrayObject() {
        return coursesArray;
    }

    public Model[] getCourseArray() {
        return coursesArray.getArray();
    }


    public void add(Course course) {
        coursesArray.add(course);
    }

    @Override
    public Model getByldModel(long idCourse, Model[] courses) {
        return super.getByldModel(idCourse, courses);
    }

    @Override
    public void deleteModel(long idCourse, Model[] course) {
        super.deleteModel(idCourse, course);
    }

    public long getCourseID() {
        return coursesArray.getArray()[courseCounter() - 1].getModelId();
    }

    public String getCourseName() {
        return coursesArray.getArray()[courseCounter() - 1].getName();
    }
}






