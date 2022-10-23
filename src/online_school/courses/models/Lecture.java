package online_school.courses.models;

import online_school.courses.Course;

public class Lecture {
    private static int ID;
    private String nameLecture;
    private String startLecture;
    private String finishLecture;
    public int courseId = Course.getID();

    public Lecture() {
        ID++;
    }

    public Lecture(String nameLecture, String startLecture, String finishLecture) {
        this.nameLecture = nameLecture;
        this.startLecture = startLecture;
        this.finishLecture = finishLecture;
        ID++;
    }

    public static int getID() {
        return ID;
    }
}
