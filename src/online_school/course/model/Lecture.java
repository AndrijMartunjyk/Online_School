package online_school.course.model;

import online_school.course.task_for_lecture.AdditionalMaterial;
import online_school.course.task_for_lecture.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lecture extends Model implements Comparable<Lecture> {
    private final Long lectureId;
    private final String lectureName;
    private final String description;
    private static int counter;
    private Long personId;
    private final Long courseId;
    private final String nameCourse;

    public Lecture(Long lectureId, String lectureName, String description, Long courseId, String nameCourse) {
        this.lectureId = lectureId + new Random().nextLong(Long.MAX_VALUE);
        this.lectureName = lectureName;
        this.description = description;
        this.courseId = courseId;
        this.nameCourse = nameCourse;
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

    public Long getCourseId() {
        return courseId;
    }

    public String getDescription() {
        return description;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public int getCounter() {
        return counter;
    }

    public Long getLectureId() {
        return lectureId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Lecture lecture)) {
            return false;
        }
        if (!(this.lectureId.equals(lecture.lectureId))) {
            return false;
        }

        if (!(this.lectureName.equals(lecture.getLectureName()))) {
            return false;
        }
        if (!(this.description.equals(lecture.getDescription()))) {
            return false;
        }
        if (!(this.personId.equals(lecture.getPersonId()))) {
            return false;
        }
        if (!(this.courseId.equals(lecture.getCourseId()))) {
            return false;
        }
        return this.nameCourse.equals(lecture.getNameCourse());
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + (int) (lectureId - (lectureId >>> 32));
        result = prime * result + ((this.lectureName == null) ? 0 : this.lectureName.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.personId == null) ? 0 : this.personId.hashCode());
        result = prime * result + ((this.courseId == null) ? 0 : this.courseId.hashCode());
        result = prime * result + ((this.nameCourse == null) ? 0 : this.nameCourse.hashCode());
        return result;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.hashCode() == o.hashCode()) {
            if (this.equals(o)) {
                return 0;
            }
        }
//        sorted by the first letter of the lecture name
        if (String.valueOf(this.lectureName.charAt(0)).hashCode() < String.valueOf(o.getLectureName().charAt(0)).hashCode()) {
            return -1;
        } else
            return 1;
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
                ", courseID=" + courseId +
                ", nameCourse='" + nameCourse + '\'' +
                '}';
    }
}
