package online_school.domain.model;

import java.util.Random;

public class Course extends Model implements Comparable<Course> {
    private final String courseName;
    private final Long courseId;
    private static int counter;

    public Course(Long courseId, String courseName) {
        this.courseName = courseName;
        this.courseId = courseId + new Random().nextLong(Long.MAX_VALUE);
        counter++;
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
    public boolean equals(Object obj) {
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
        final int prime = 37;
        int result = 17;
        result = prime * result + (int) (courseId - (courseId >>> 32));
        result = prime * result + (courseName == null ? 0 : courseName.hashCode());
        return result;
    }

    @Override
    public int compareTo(Course o) {
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
        return "Course{" +
                "ID=" + courseId +
                ", name='" + courseName + '\'' +
                '}';
    }
}
