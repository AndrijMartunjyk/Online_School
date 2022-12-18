package online_school.course.task_for_lecture;

import java.util.Random;

public class Homework {
    private final Long homeworkId;
    private final Long lectureId;
    private final String task;

    public Homework(Long homeworkId, Long lectureId, String task) {
        this.homeworkId = homeworkId + new Random().nextLong(Long.MAX_VALUE);
        this.lectureId = lectureId;
        this.task = task;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "HomeworkId=" + homeworkId +
                ", lectureId=" + lectureId +
                ", task='" + task + '\'' +
                '}';
    }
}
