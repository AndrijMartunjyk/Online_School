package online_school.domain.task_for_lecture;

import online_school.log.Log;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

public class Homework implements Comparable<Homework>, Serializable {
    @Serial
    private static final long serialVersionUID = 7L;
    private final Long homeworkId;
    private final Long lectureId;
    private final String task;
    private String deadLine;

    public Homework(Long homeworkId, Long lectureId, String task) {
        this.homeworkId = homeworkId + new Random().nextLong(Long.MAX_VALUE);
        this.lectureId = lectureId;
        this.task = task;
    }

    public Long getLectureId() {
        Log.debug(Homework.class.getName(), "method->\"getLectureId\"");
        return lectureId;
    }

    public Long getHomeworkId() {
        Log.debug(Homework.class.getName(), "method->\"getHomeworkId\"");
        return homeworkId;
    }

    public String getTask() {
        Log.debug(Homework.class.getName(), "method->\"getTask\"");
        return task;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
        Log.debug(Homework.class.getName(), "method->\"setDeadLine\"");
    }

    @Override
    public boolean equals(Object obj) {
        Log.debug(Homework.class.getName(), "method->\"equals\"");
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
        Log.debug(Homework.class.getName(), "method->\"hashCode\"");
        final int prime = 37;
        int result = 17;
        result = prime * result + (int) (homeworkId - (homeworkId >>> 32));
        result = prime * result + (lectureId == null ? 0 : lectureId.hashCode());
        result = prime * result + (task == null ? 0 : task.hashCode());
        return result;
    }

    @Override
    public int compareTo(Homework o) {
        Log.debug(Homework.class.getName(), "method->\"compareTo\"");
        int result = 1;
        if (this.hashCode() == o.hashCode() && this.equals(o)) {
            result = 0;
        } else
//      sorted by ID
            if (homeworkId < o.getHomeworkId()) {
                result = -1;
            }
        return result;
    }

    @Override
    public String toString() {
        Log.debug(Homework.class.getName(), "method->\"toString\"");
        return "Homework{" +
                "HomeworkId=" + homeworkId +
                ", lectureId=" + lectureId +
                ", task='" + task + '\'' +
                ", deadLine='" + deadLine + '\'' +
                '}';
    }
}
