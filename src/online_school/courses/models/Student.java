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

    public static int getID() {
        return ID;
    }
}
