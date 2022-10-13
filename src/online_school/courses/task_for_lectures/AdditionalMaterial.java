package online_school.courses.task_for_lectures;

public class AdditionalMaterial {
    private static int ID;
    private String nameBook;
    private String nameSite;

    public AdditionalMaterial() {
        ID++;
    }

    public static int getID() {
        return ID;
    }
}
