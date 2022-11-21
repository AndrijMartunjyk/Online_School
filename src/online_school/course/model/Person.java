package online_school.course.model;

import online_school.enum_enum.Role;

public class Person extends Models {
    private final long personId;
    private long lectureId;
    private final Role role;
    private String lectureName;

    public Person(Role role, long personId, String name, String lastName) {
        this.role = role;
        this.personId = personId + (int) (Math.random() * 100);
        super.setName(name);
        super.setLastName(lastName);
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
                "ID=" + personId +
                ", Name=" + getName() +
                ", Last name=" + getLastName() + ", //" +
                " lectureId=" + lectureId +
                ", lectureName='" + lectureName + '\'' +
                '}';
    }
}
