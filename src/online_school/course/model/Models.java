package online_school.course.model;

public class Models {
    private long ID;
    private String name;
    private String lastName;

    public Models(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Models(long ID, String name, String lastName) {
        this(ID, name);
        this.lastName = lastName;
    }

    public Models() {

    }

    public int getCounter() {
        return 0;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
