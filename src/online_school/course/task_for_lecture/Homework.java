package online_school.course.task_for_lecture;

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
