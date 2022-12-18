package online_school.course.model;

import online_school.course.task_for_lecture.AdditionalMaterial;
import online_school.course.task_for_lecture.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lecture extends Model {
    private final Long lectureId;
    private final String lectureName;
    private final String description;
    private static int counter;
    private Long personId;
    private Long courseID;
    private String nameCourse;

    public Lecture(Long lectureId, String lectureName, String description) {
        this.lectureId = lectureId + new Random().nextLong(Long.MAX_VALUE);
        this.lectureName = lectureName;
        this.description = description;
        counter++;
    }

    private final List<Homework> homeworkList = new ArrayList<>();
    private final List<AdditionalMaterial> additionalMaterialList = new ArrayList<>();

    public List<Homework> getHomeworkList() {
        return homeworkList;
    }

    public List<AdditionalMaterial> getAdditionalMaterialList() {
        return additionalMaterialList;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setPersonId(Long personId) {
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

    public Long getLectureId() {
        return lectureId;
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
}
