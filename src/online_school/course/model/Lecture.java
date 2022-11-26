package online_school.course.model;

public class Lecture extends Model {
    private static int counter;
    private long personId;
    private Long courseID;
    private String nameCourse;

    public Lecture(long ID, String nameLecture, String description) {
        super(ID + counter++ + (int) (Math.random() * 100), nameLecture, description);
    }

    public void setPersonId(long personId) {
        this.personId = personId;
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

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "LECTURE {" +
                "ID=" + super.getID() +
                ", nameLecture='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", teacherId=" + personId +
                ", teacherName='" + super.getFirstName() + '\'' +
                ", teacherLastName='" + super.getLastName() + '\'' +
                ", courseID=" + getCourseID() +
                ", nameCourse='" + getNameCourse() + '\'' +
                '}';
    }
}
