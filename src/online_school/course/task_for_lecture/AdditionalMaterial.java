package online_school.course.task_for_lecture;

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
