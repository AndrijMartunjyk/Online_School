package online_school.course.model;

import online_school.course.task_for_lecture.HomeWork;
import online_school.generic.SchoolArray;

import java.util.Random;

public class Lecture extends Model {
    private final long lectureId;
    private final String lectureName;
    private final String description;
    private static int counter;
    private long personId;
    private Long courseID;
    private String nameCourse;

    public Lecture(long lectureId, String lectureName, String description) {
        this.lectureId = lectureId + counter++ + new Random().nextInt(Integer.MAX_VALUE);
        this.lectureName = lectureName;
        this.description = description;
    }

    private final SchoolArray<HomeWork> homeWorkArray = new SchoolArray<>(new HomeWork[1]);

    public SchoolArray<HomeWork> getHomeWorkArray() {
        return homeWorkArray;
    }

    public String getLectureName() {
        return lectureName;
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


    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "LECTURE {" +
                "ID=" + lectureId +
                ", nameLecture='" + lectureName + '\'' +
                ", description='" + description + '\'' +
                ", teacherId=" + personId +
                ", teacherName='" + super.getFirstPersonName() + '\'' +
                ", teacherLastName='" + super.getLastPersonName() + '\'' +
                ", courseID=" + courseID +
                ", nameCourse='" + nameCourse + '\'' +
                '}';
    }

    public long getLectureId() {
        return lectureId;
    }
}
