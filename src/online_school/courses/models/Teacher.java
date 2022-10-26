package online_school.courses.models;

public class Teacher {
    public static int counter;
    private long ID;
    private String firstName;
    private String lastName;
    private String direction;

    public Teacher() {
        ID = ++counter;
    }

    public Teacher(long ID, String firstName, String lastName, String direction) {
        this.ID = ID + ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.direction = direction;
    }

    public long getID() {
        return ID;
    }
}
