package online_school.courses.models;

public class Teacher {
    private static int ID;
    private String firstName;
    private String lastName;
    private String direction;

    public Teacher() {
        ID++;
    }

    public Teacher(String firstName, String lastName, String direction) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.direction = direction;
        ID++;
    }

    public static int getID() {
        return ID;
    }
}
