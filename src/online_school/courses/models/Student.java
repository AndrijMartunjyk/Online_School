package online_school.courses.models;

public class Student {
    private static int ID;
    private String firstName;
    private String lastName;
    private String nameCourse;
    private String nameLecture;

    public Student() {
        ID++;
    }

    public Student(String firstName, String lastName, String nameCourse, String nameLecture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameCourse = nameCourse;
        this.nameLecture = nameLecture;
        ID++;
    }

    public static int getID() {
        return ID;
    }
}
