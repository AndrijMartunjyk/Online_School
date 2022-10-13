package online_school.courses.task_for_lectures;

public class Homework {
    private static int ID;
    private String nameBook;
    private String startPageBook;
    private String finishPageBook;

    public Homework() {
        ID++;
    }

    public static int getID() {
        return ID;
    }
}
