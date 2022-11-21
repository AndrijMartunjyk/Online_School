package online_school.course.model;

public class Lecture extends Models {
    private static int counter;
    private long personId;
    private String personName;
    private String personLastName;
    private Long courseID;
    private String nameCourse;

    public Lecture(long ID, String nameLecture) {
        super(ID + counter++ + (int) (Math.random() * 100), nameLecture);
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
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
                ", teacherId=" + personId +
                ", teacherName='" + personName + '\'' +
                ", teacherLastName='" + personLastName + '\'' +
                ", courseID=" + getCourseID() +
                ", nameCourse='" + getNameCourse() + '\'' +
                '}';
    }
}
