package online_school.course.model;

public class Model {
    private long ModelId;
    private String name;
    private String description;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Model(long ModelId, String name) {
        this.ModelId = ModelId;
        this.name = name;
    }

    public Model(long ModelId, String name, String description) {
        this(ModelId, name);
        this.description = description;
    }

    public Model() {
    }

    public int getCounter() {
        return 0;
    }

    public long getModelId() {
        return ModelId;
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
