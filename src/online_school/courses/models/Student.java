package online_school.courses.models;

public class Student extends Models {
    private static int counter;

    public Student(long ID, String firstName, String lastName) {
        super(ID + counter++ + (int) (Math.random() * 100), firstName, lastName);
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + super.getID() +
                ", firstName='" + super.getName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", courseID=" + super.getCourseID() +
                ", nameCourse='" + super.getNameCourse() + '\'' +
                '}';
    }
}
