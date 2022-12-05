package online_school.course.model;

public class Person extends Model {
    private final long personId;
    private long lectureId;
    private String lectureName;
    private final Role role;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;

    public Person(Role role, long personId, String firstName, String lastName, String phone, String email) {
        this.personId = personId + (int) (Math.random() * 100);
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public long getLectureId() {
        return lectureId;
    }

    public void setLectureId(long lectureId) {
        this.lectureId = lectureId;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public long getPersonId() {
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

    @Override
    public long getObjectId() {
        return personId;
    }
}
