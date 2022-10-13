package online_school.courses.models;

public class Lecture {
    private static int ID;
    private String nameLecture;
    private String startLecture;
    private String finishLecture;

    public Lecture() {
        ID++;
    }

    public static int getID() {
        return ID;
    }
}
