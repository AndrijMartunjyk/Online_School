package online_school.courses.models;

public class Teacher extends SuperModels {

    public Teacher() {
    }

    public Teacher(long ID, String name, String lastName) {
        super(ID, name, lastName);
    }

    public int getCounter() {
        return super.getCounter();
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "ID=" + super.getID() +
                ", firstName='" + super.getName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", courseID=" + super.getCourseID() +
                ", nameCourse='" + super.getNameCourse() + '\'' +
                '}';
    }
}

