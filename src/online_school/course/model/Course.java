package online_school.course.model;

import java.util.Random;

public class Course extends Model {
    private final String courseName;
    private final long courseId;
    private static int counter;

    public Course(long courseId, String courseName) {
        this.courseName = courseName;
        this.courseId = courseId + counter++ + new Random().nextInt(Integer.MAX_VALUE);
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

    public long getCourseId() {
        return courseId;
    }
}
