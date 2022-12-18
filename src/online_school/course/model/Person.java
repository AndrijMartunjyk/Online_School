package online_school.course.model;

import online_school.my_enum.Role;

import java.util.Random;

public class Person extends Model {
    private final Long personId;
    private Long lectureId;
    private String lectureName;
    private final Role role;
    private final String phone;
    private final String email;

    public Person(Role role, Long personId, String firstPersonName, String lastPersonName, String phone, String email) {
        this.personId = personId + new Random().nextLong(Long.MAX_VALUE);
        this.role = role;
        super.setFirstPersonName(firstPersonName);
        super.setLastPersonName(lastPersonName);
        this.phone = phone;
        this.email = email;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public Long getPersonId() {
        return personId;
    }

    @Override
    public String toString() {
        return role + " {" +
                "ID: " + personId +
                ", First name: " + getFirstPersonName() +
                ", Last name: " + getLastPersonName() +
                ", phone number: " + phone +
                ", email address: " + email + ", //" +
                ", lectureId: " + lectureId +
                ", lectureName:'" + lectureName + '\'' +
                '}';
    }
}
