package online_school.course.task_for_lecture;

import java.util.Random;

public class Homework implements Comparable<Homework> {
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

    public String getTask() {
        return task;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Homework homework)) {
            return false;
        }
        if (!(this.homeworkId.equals(homework.getHomeworkId()))) {
            return false;
        }
        if (!(this.lectureId.equals(homework.getLectureId()))) {
            return false;
        }
        return this.task.equals(homework.getTask());
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + (int) (homeworkId - (homeworkId >>> 32));
        result = prime * result + (lectureId == null ? 0 : lectureId.hashCode());
        result = prime * result + (task == null ? 0 : task.hashCode());
        return result;
    }

    @Override
    public int compareTo(Homework o) {
        if (this.hashCode() == o.hashCode()) {
            if (this.equals(o)) {
                return 0;
            }
        }
//      sorted by ID
        if (homeworkId < o.getHomeworkId()) {
            return -1;
        } else
            return 1;
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
