package online_school.course.model;

public class Course extends Models {
    private static int counter;

    public Course(long id, String name) {
        super(id + counter++ + (int) (Math.random() * 100), name);
    }

    @Override
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
