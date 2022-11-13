package online_school.courses.models;

public class Lecture extends Models {
    private static int counter;

    public Lecture(long ID, String nameLecture) {
        super(ID + counter++ + (int) (Math.random() * 100), nameLecture);
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "ID=" + super.getID() +
                ", nameLecture='" + super.getName() + '\'' +
                ", courseID=" + super.getCourseID() +
                ", nameCourse='" + super.getNameCourse() + '\'' +
                '}';
    }
}
