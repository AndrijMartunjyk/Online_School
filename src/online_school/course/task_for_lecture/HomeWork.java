package online_school.course.task_for_lecture;

public class HomeWork {
    private final long homeworkId;
    private final long lectureId;
    private final String task;
    private static int counter;

    public HomeWork(long homeworkId, long lectureId, String task) {
        this.homeworkId = homeworkId + counter++ + (int) (Math.random() * 100);
        this.lectureId = lectureId;
        this.task = task;
    }

    public long getLectureId() {
        return lectureId;
    }

    public long getHomeworkId() {
        return homeworkId;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "Id=" + homeworkId +
                ", lectureId=" + lectureId +
                ", task='" + task + '\'' +
                '}';
    }
}
