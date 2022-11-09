package online_school.courses.models;

public class Course extends Models {
    private static int counter;

    public Course(long id, String name) {
        super(id + counter++, name);
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + super.getID() +
                ", name='" + super.getName() + '\'' +
                '}';
    }
}
