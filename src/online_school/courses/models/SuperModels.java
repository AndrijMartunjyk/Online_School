package online_school.courses.models;

public class SuperModels {
    private static int counter;
    private final long ID;
    private String name;
    private String lastName;
    private Long courseID;
    private String nameCourse;

    public SuperModels() {
        ID = counter++;
    }

    public SuperModels(long ID, String name) {
        this.ID = ID + counter++;
        this.name = name;
    }

    public SuperModels(long ID, String name, String lastName) {
        this();
        this.lastName = lastName;
    }

    public int getCounter() {
        return counter;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }
}
