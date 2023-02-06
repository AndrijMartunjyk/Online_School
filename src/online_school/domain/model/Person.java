package online_school.domain.model;

import online_school.util.Log;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

public class Person extends Model implements Comparable<Person>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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

    public Long getPersonId() {
        Log.debug(Person.class.getName(), "method->\"getPersonId\"");
        return personId;
    }

    public Long getLectureId() {
        Log.debug(Person.class.getName(), "method->\"getLectureId\"");
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        Log.debug(Person.class.getName(), "method->\"setLectureId\"");
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        Log.debug(Person.class.getName(), "method->\"getLectureName\"");
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        Log.debug(Person.class.getName(), "method->\"setLectureName\"");
        this.lectureName = lectureName;
    }

    public Role getRole() {
        Log.debug(Person.class.getName(), "method->\"getRole\"");
        return role;
    }

    public String getPhone() {
        Log.debug(Person.class.getName(), "method->\"getPhone\"");
        return phone;
    }

    public String getEmail() {
        Log.debug(Person.class.getName(), "method->\"getEmail\"");
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        Log.debug(Person.class.getName(), "method->\"equals\"");
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person person)) {
            return false;
        }
        if (!(this.personId.equals(person.getPersonId()))) {
            return false;
        }
        if (!(super.getFirstPersonName().equals(person.getFirstPersonName()))) {
            return false;
        }
        if (!(super.getLastPersonName().equals(person.getLastPersonName()))) {
            return false;
        }
        if (!(this.role.equals(person.getRole()))) {
            return false;
        }
        if (!(this.lectureId.equals(person.getLectureId()))) {
            return false;
        }
        if (!(this.lectureName.equals(person.getLectureName()))) {
            return false;
        }
        if (!(this.phone.equals(person.getPhone()))) {
            return false;
        }
        return this.email.equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        Log.debug(Person.class.getName(), "method->\"hashCode\"");
        final int prime = 37;
        int result = 17;
        result = prime * result + (int) (personId - (personId >>> 32));
        result = prime * result + ((super.getFirstPersonName() == null) ? 0 : super.getFirstPersonName().hashCode());
        result = prime * result + ((super.getLastPersonName() == null) ? 0 : super.getLastPersonName().hashCode());
        result = prime * result + ((this.role == null) ? 0 : this.role.hashCode());
        result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.lectureId == null) ? 0 : this.lectureId.hashCode());
        result = prime * result + ((this.lectureName == null) ? 0 : this.lectureName.hashCode());
        return result;
    }

    @Override
    public int compareTo(Person o) {
        Log.debug(Person.class.getName(), "method->\"compareTo\"");
        int result = 1;
        if (this.hashCode() == o.hashCode() && this.equals(o)) {
            result = 0;
        } else
//        sorted by the first letter of the last name of the teacher and student
            if (String.valueOf(super.getLastPersonName().charAt(0)).hashCode() < String.valueOf(o.getLastPersonName().charAt(0)).hashCode()) {
                result = -1;
            }
        return result;
    }

    @Override
    public String toString() {
        Log.debug(Person.class.getName(), "method->\"toString\"");
        return role + " {" +
                "ID: " + personId +
                ", First name: " + super.getFirstPersonName() +
                ", Last name: " + super.getLastPersonName() +
                ", phone number: " + phone +
                ", email address: " + email + ", //" +
                ", lectureId: " + lectureId +
                ", lectureName:'" + lectureName + '\'' +
                '}';
    }
}

