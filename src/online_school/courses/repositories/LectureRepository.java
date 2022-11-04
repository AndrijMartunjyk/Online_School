package online_school.courses.repositories;

import online_school.courses.models.Lecture;

import java.util.Arrays;

public class LectureRepository {

    private Lecture[] lectures = new Lecture[3];

    public void magnificationOfArray() {
        lectures = Arrays.copyOf(lectures, (lectures.length * 3) / 2 + 1);
        System.out.format("Масив лекцій збільшено, довжина: %d об'єктів!!!\n", lectures.length);
    }

    public void addLecture(Lecture lecture) {
        for (int i = 0; i < lectures.length; i++) {
            if (Lecture.counter - 1 == lectures.length) {
                magnificationOfArray();
            } else if (lectures[i] == null) {
                lectures[i] = lecture;
                break;
            }
        }
    }

    public Lecture[] getLecturesArray() {
        return lectures;
    }

    public long getLectureID() {
        return lectures[Lecture.counter - 1].getID();
    }

    public void setIdCourseOfLecture(Long ID, String name) {
        lectures[Lecture.counter - 1].setCourseID(ID);
        lectures[Lecture.counter - 1].setNameCourse(name);
    }
}
