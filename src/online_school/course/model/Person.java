package online_school.course.model;

public class Person extends Model {
    private final long personId;
    private long lectureId;
    private final Role role;
    private String lectureName;

    public Person(Role role, long personId, String firstName, String lastName, String phone, String email) {
        this.role = role;
        this.personId = personId + (int) (Math.random() * 100);
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setPhone(phone);
        super.setEmail(email);
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

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return role + " {" +
                "ID: " + personId +
                ", First name: " + super.getFirstName() +
                ", Last name: " + super.getLastName() +
                ", phone number: " + super.getPhone() +
                ", email address: " + super.getEmail() + ", //" +
                ", lectureId: " + lectureId +
                ", lectureName:'" + lectureName + '\'' +
                '}';
    }
}
