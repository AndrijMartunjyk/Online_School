package online_school.domain.model;

import online_school.log.Log;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class Lecture extends Model implements Comparable<Lecture>, Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private final Long lectureId;
    private final String lectureName;
    private final String description;
    private static int counter;
    private Long personId;
    private final Long courseId;
    private final String nameCourse;
    private String lectureDateFormat;
    private final LocalDateTime creationDate = LocalDateTime.now();
    private LocalDateTime lectureDate;

    public Lecture(Long lectureId, String lectureName, String description, Long courseId, String nameCourse) {
        this.lectureId = lectureId + new Random().nextLong(Long.MAX_VALUE);
        this.lectureName = lectureName;
        this.description = description;
        this.courseId = courseId;
        this.nameCourse = nameCourse;
        counter++;
    }

    public String getLectureName() {
        Log.debug(Lecture.class.getName(), "method->\"getLectureName\"");
        return lectureName;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
        Log.debug(Lecture.class.getName(), "method->\"setPersonId\"");
    }

    public Long getCourseId() {
        Log.debug(Lecture.class.getName(), "method->\"getCourseId\"");
        return courseId;
    }

    public String getDescription() {
        Log.debug(Lecture.class.getName(), "method->\"getDescription\"");
        return description;
    }

    public Long getPersonId() {
        Log.debug(Lecture.class.getName(), "method->\"getPersonId\"");
        return personId;
    }

    public String getNameCourse() {
        Log.debug(Lecture.class.getName(), "method->\"getNameCourse\"");
        return nameCourse;
    }

    public int getCounter() {
        Log.debug(Lecture.class.getName(), "method->\"getCounter\"");
        return counter;
    }

    public Long getLectureId() {
        Log.debug(Lecture.class.getName(), "method->\"getLectureId\"");
        return lectureId;
    }

    public LocalDateTime getCreationDate() {
        Log.debug(Lecture.class.getName(), "method->\"getCreationDate\"");
        return creationDate;
    }

    public LocalDateTime getLectureDate() {
        Log.debug(Lecture.class.getName(), "method->\"getLectureDate\"");
        return lectureDate;
    }

    public void setLectureDate(LocalDateTime lectureDate) {
        Log.debug(Lecture.class.getName(), "method->\"setLectureDate\"");
        this.lectureDate = lectureDate;
    }

    public String getCreationDateFormat() {
        Log.debug(Lecture.class.getName(), "method->\"getCreationDateFormat\"");
        return creationDate.format(DateTimeFormatter.ofPattern("MMM dd,E HH:mm:ss", Locale.US));
    }

    public String getLectureDateFormat() {
        if (lectureDate != null) {
            lectureDateFormat = lectureDate.format(DateTimeFormatter.ofPattern("MMM dd,E HH:mm:ss", Locale.US));
        }
        Log.debug(Lecture.class.getName(), "method->\"getLectureDateFormat\"");
        return lectureDateFormat;
    }

    @Override
    public boolean equals(Object obj) {
        Log.debug(Lecture.class.getName(), "method->\"equals\"");
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
        Log.debug(Lecture.class.getName(), "method->\"hashCode\"");
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
        Log.debug(Lecture.class.getName(), "method->\"compareTo\"");
        int result = 1;
        if (this.hashCode() == o.hashCode() && this.equals(o)) {
            result = 0;
        } else
//        sorted by the first letter of the lecture name
            if (String.valueOf(this.lectureName.charAt(0)).hashCode() < String.valueOf(o.getLectureName().charAt(0)).hashCode()) {
                result = -1;
            }
        return result;
    }

    @Override
    public String toString() {
        Log.debug(Lecture.class.getName(), "method->\"toString\"");
        return "LECTURE {" +
                "ID=" + lectureId +
                ", nameLecture='" + lectureName + '\'' +
                ", description='" + description + '\'' +
                ", teacherId=" + personId +
                ", teacherName='" + super.getFirstPersonName() + '\'' +
                ", teacherLastName='" + super.getLastPersonName() + '\'' +
                ", courseID=" + courseId +
                ", nameCourse='" + nameCourse + '\'' +
                ", creationDate='" + getCreationDateFormat() + '\'' +
                ", lectureDate='" + getLectureDateFormat() + '\'' +
                "}\n";
    }
}
