package online_school.courses;

public class Course {
    private static int ID;
    private String nameCourse;
    private String startCourse;
    private String finishCourse;

    public Course() {
        ID++;
    }

    public static int getID() {
        return ID;
    }
}
