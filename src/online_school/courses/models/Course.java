package online_school.courses.models;

public class Course extends SuperModels {
    public Course() {
    }

    public Course(long id, String name) {
        super(id, name);
    }
    public int getCounter() {
        return super.getCounter();
    }
    @Override
    public String toString() {
        return "Course{" +
                "ID=" + super.getID() +
                ", name='" + super.getName() + '\'' +
                '}';
    }
}
