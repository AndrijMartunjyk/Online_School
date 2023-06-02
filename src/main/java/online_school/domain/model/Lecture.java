package online_school.domain.model;

import jakarta.persistence.*;
import online_school.log.Log;
import online_school.service.MainService;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

@Entity

public class Lecture extends Model implements Comparable<Lecture>, Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long lectureId;
    @Column(name = "lecture_name")
    private String lectureName;
    @Column(name = "description")
    private String description;
    @Transient
    private static int counter;
    @Transient
    private Long personId;
    @Transient
    private Long courseId;
    @Transient
    private String nameCourse;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "lecture_date")
    private LocalDateTime lectureDate;
    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    public Lecture(Long lectureId, String lectureName, String description, Long courseId, String nameCourse) {
        this.lectureId = lectureId + new Random().nextLong(Long.MAX_VALUE);
        this.lectureName = lectureName;
        this.description = description;
        this.courseId = courseId;
        this.nameCourse = nameCourse;
        this.creationDate = LocalDateTime.now();
        counter++;
    }

    public Lecture(String lectureName, String description, LocalDateTime creationDate, LocalDateTime lectureDate) {
        this.lectureName = lectureName;
        this.description = description;
        this.creationDate = creationDate;
        this.lectureDate = lectureDate;
    }

    public Lecture() {
    }

    public String getLectureName() {
        Optional<String> lectureNameOptional = Optional.ofNullable(lectureName);
        Log.debug(Lecture.class.getName(), "method->\"getLectureName\"");
        return lectureNameOptional.orElse(MainService.IS_EMPTY);
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
        Log.debug(Lecture.class.getName(), "method->\"setPersonId\"");
    }

    public Long getCourseId() {
        Optional<Long> courseIdOptional = Optional.ofNullable(courseId);
        Log.debug(Lecture.class.getName(), "method->\"getCourseId\"");
        return courseIdOptional.orElse(0L);
    }

    public String getDescription() {
        Optional<String> descriptionOptional = Optional.ofNullable(description);
        Log.debug(Lecture.class.getName(), "method->\"getDescription\"");
        return descriptionOptional.orElse(MainService.IS_EMPTY);
    }

    public Long getPersonId() {
        Optional<Long> personIdOptional = Optional.ofNullable(personId);
        Log.debug(Lecture.class.getName(), "method->\"getPersonId\"");
        return personIdOptional.orElse(0L);
    }

    public String getNameCourse() {
        Optional<String> nameCourseOptional = Optional.ofNullable(nameCourse);
        Log.debug(Lecture.class.getName(), "method->\"getNameCourse\"");
        return nameCourseOptional.orElse(MainService.IS_EMPTY);
    }

    public int getCounter() {
        Log.debug(Lecture.class.getName(), "method->\"getCounter\"");
        return counter;
    }

    public Long getLectureId() {
        Optional<Long> lectureIdOptional = Optional.ofNullable(lectureId);
        Log.debug(Lecture.class.getName(), "method->\"getLectureId\"");
        return lectureIdOptional.orElse(0L);
    }

    public LocalDateTime getCreationDate() {
        Optional<LocalDateTime> lectureCreationDateOptional = Optional.ofNullable(creationDate);
        Log.debug(Lecture.class.getName(), "method->\"getCreationDate\"");
        return lectureCreationDateOptional.orElse(LocalDateTime.of(1, 1, 1, 0, 0));
    }

    public LocalDateTime getLectureDate() {
        Optional<LocalDateTime> lectureDateOptional = Optional.ofNullable(lectureDate);
        Log.debug(Lecture.class.getName(), "method->\"getLectureDate\"");
        return lectureDateOptional.orElse(LocalDateTime.of(1, 1, 1, 0, 0));
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
        Optional<String> lectureDateFormatOptional = Optional.empty();
        if (lectureDate != null) {
            lectureDateFormatOptional = Optional.of(lectureDate.format(DateTimeFormatter.ofPattern("MMM dd,E HH:mm:ss", Locale.US)));
        }
        Log.debug(Lecture.class.getName(), "method->\"getLectureDateFormat\"");
        return lectureDateFormatOptional.orElse(MainService.IS_EMPTY);
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
                "ID=" + getLectureId() +
                ", nameLecture='" + getLectureName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", teacherId=" + getPersonId() +
                ", teacherName='" + super.getFirstPersonName() + '\'' +
                ", teacherLastName='" + super.getLastPersonName() + '\'' +
                ", courseID=" + getCourseId() +
                ", nameCourse='" + getNameCourse() + '\'' +
                ", creationDate='" + getCreationDateFormat() + '\'' +
                ", lectureDate='" + getLectureDateFormat() + '\'' +
                "}\n";
    }
}
