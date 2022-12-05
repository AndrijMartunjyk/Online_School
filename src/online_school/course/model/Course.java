package online_school.course.model;

public class Course extends Model {
    private final String courseName;
    private final long courseId;
    private static int counter;

    public Course(long courseId, String courseName) {
        this.courseName = courseName;
        this.courseId = courseId + counter++ + (int) (Math.random() * 100);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + courseId +
                ", name='" + courseName + '\'' +
                '}';
    }

    @Override
    public long getObjectId() {
        return courseId;
    }
}
