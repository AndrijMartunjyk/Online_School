package online_school.domain.model;

import online_school.util.Log;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

public class Course extends Model implements Comparable<Course>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String courseName;
    private final Long courseId;
    private static int counter;

    public Course(Long courseId, String courseName) {
        this.courseName = courseName;
        this.courseId = courseId + new Random().nextLong(Long.MAX_VALUE);
        counter++;
    }

    public String getCourseName() {
        Log.debug(Course.class.getName(), "method->\"getCourseName\"");
        return courseName;
    }

    public int getCounter() {
        Log.debug(Course.class.getName(), "method->\"getCounter\"");
        return counter;
    }

    public Long getCourseId() {
        Log.debug(Course.class.getName(), "method->\"getCourseId\"");
        return courseId;
    }

    @Override
    public boolean equals(Object obj) {
        Log.debug(Course.class.getName(), "method->\"equals\"");
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Course course)) {
            return false;
        }
        if (!(this.courseId.equals(course.getCourseId()))) {
            return false;
        }
        return this.courseName.equals(course.getCourseName());
    }

    @Override
    public int hashCode() {
        Log.debug(Course.class.getName(), "method->\"hashCode\"");
        final int prime = 37;
        int result = 17;
        result = prime * result + (int) (courseId - (courseId >>> 32));
        result = prime * result + (courseName == null ? 0 : courseName.hashCode());
        return result;
    }

    @Override
    public int compareTo(Course o) {
        Log.debug(Course.class.getName(), "method->\"compareTo\"");
        int result = 1;
        if (this.hashCode() == o.hashCode() && this.equals(o)) {
            result = 0;
        } else
//      sorted by the first letter of the course name
            if (String.valueOf(this.courseName.charAt(0)).hashCode() < String.valueOf(o.getCourseName().charAt(0)).hashCode()) {
                result = -1;
            }
        return result;
    }

    @Override
    public String toString() {
        Log.debug(Course.class.getName(), "method->\"toString\"");
        return "Course{" +
                "ID=" + courseId +
                ", name='" + courseName + '\'' +
                '}';
    }
}
