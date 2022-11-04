package online_school.courses.models;


public class Lecture {
    public static int counter;
    private final long ID;
    private String nameLecture;

    private Long courseID;
    private String nameCourse;

    public Lecture() {
        ID = counter++;
    }

    public Lecture(long ID, String nameLecture) {
        this.ID = ID + counter++;
        this.nameLecture = nameLecture;
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
        return "Lecture{" +
                "ID=" + ID +
                ", nameLecture='" + nameLecture + '\'' +
                ", courseID=" + courseID +
                ", nameCourse='" + nameCourse + '\'' +
                '}';
    }
}
