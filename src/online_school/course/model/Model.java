package online_school.course.model;

public class Model {
    private long ID;
    private String name;
    private String description;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;


    public Model(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Model(long ID, String name, String description) {
        this(ID, name);
        this.description = description;
    }

    public Model() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
