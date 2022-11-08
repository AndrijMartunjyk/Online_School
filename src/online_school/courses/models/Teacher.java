package online_school.courses.models;

public class Teacher extends SuperModels {
    private static int counter;

    public Teacher() {
        super.setID(getID() + counter++);
    }

    public Teacher(long ID, String name, String lastName) {
        super(ID + counter++, name, lastName);
    }

    public int getCounter() {
        return counter;
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

