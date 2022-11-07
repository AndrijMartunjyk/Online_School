package online_school.courses.models;

public class Student {
    private static int counter;
    private final long ID;
    private String firstName;
    private String lastName;
    private Long courseID;
    private String nameCourse;

    public Student() {
        ID = counter++;
    }

    public Student(long ID, String firstName,String lastName) {
        this.ID = ID + counter++;
        this.firstName = firstName;
        this.lastName=lastName;
    }

    public int getCounter() {
        return counter;
    }

    public long getID() {
        return ID;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseID=" + courseID +
                ", nameCourse='" + nameCourse + '\'' +
                '}';
    }
}
