package online_school.course.model;

import java.util.Random;

public class Course extends Model {
    private final String courseName;
    private final Long courseId;
    private static int counter;

    public Course(Long courseId, String courseName) {
        this.courseName = courseName;
        this.courseId = courseId + counter++ + new Random().nextLong(Long.MAX_VALUE);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCounter() {
        return counter;
    }

    public Long getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + courseId +
                ", name='" + courseName + '\'' +
                '}';
    }
}
