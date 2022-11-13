package online_school.courses.models;

public class Models {
    private long ID;
    private String name;
    private String lastName;
    private Long courseID;
    private String nameCourse;


    public Models(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Models(long ID, String name, String lastName) {
        this(ID, name);
        this.lastName = lastName;
    }

    public Models() {

    }

    public int getCounter() {
        return 0;
    }

    public long getID() {
        return ID;
    }


    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
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
