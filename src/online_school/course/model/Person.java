package online_school.course.model;

import java.util.Random;

public class Person extends Model {
    private final Long personId;
    private Long lectureId;
    private String lectureName;
    private final Role role;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;

    public Person(Role role, Long personId, String firstName, String lastName, String phone, String email) {
        this.personId = personId + new Random().nextLong(Long.MAX_VALUE);
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return role + " {" +
                "ID: " + personId +
                ", First name: " + firstName +
                ", Last name: " + lastName +
                ", phone number: " + phone +
                ", email address: " + email + ", //" +
                ", lectureId: " + lectureId +
                ", lectureName:'" + lectureName + '\'' +
                '}';
    }
}
