package online_school.courses.models;

import online_school.courses.Course;

public class Lecture {
    public static int counter;
    private long ID;
    private String nameLecture;
    private String startLecture;
    private String finishLecture;
    public long courseId;

    public Lecture() {
        ID = counter++;
    }

    public Lecture(long ID, String nameLecture, String startLecture, String finishLecture) {
        this.ID = ID + counter++;
        this.nameLecture = nameLecture;
        this.startLecture = startLecture;
        this.finishLecture = finishLecture;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getID() {
        return ID;
    }
}
