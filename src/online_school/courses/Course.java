package online_school.courses;

public class Course {
    public static int counter;
    private final long ID;
    private String nameCourse;


    public Course() {
        ID = counter++;
    }

    public Course(long ID, String nameCourse) {
        this.ID = ID + counter++;
        this.nameCourse = nameCourse;
    }

    public long getID() {
        return ID;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + ID +
                ", nameCourse='" + nameCourse + '\'' +
                '}';
    }
}
