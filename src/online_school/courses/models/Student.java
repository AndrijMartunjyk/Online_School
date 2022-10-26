package online_school.courses.models;

public class Student {
    public static int counter;
    private long ID;
    private String firstName;
    private String lastName;
    private String nameCourse;
    private String nameLecture;

    public Student() {
        ID = ++counter;
    }

    public Student(long ID, String firstName, String lastName, String nameCourse, String nameLecture) {
        this.ID = ID + ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameCourse = nameCourse;
        this.nameLecture = nameLecture;
    }

    public long getID() {
        return ID;
    }
}
