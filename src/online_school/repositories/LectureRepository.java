package online_school.repositories;

import online_school.courses.models.Lecture;

import java.util.Arrays;

public class LectureRepository {

    private Lecture[] lectures = new Lecture[3];

    public int lectureCounter() {
        int result = 0;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            } else {
                result = lecture.getCounter();
            }
        }
        return result;
    }

    public void magnificationOfArray() {
        lectures = Arrays.copyOf(lectures, (lectures.length * 3) / 2 + 1);
        System.out.format("Масив лекцій збільшено, довжина: %d об'єктів!!!\n", lectures.length);
    }

    public void addLecture(Lecture lecture) {
        for (int i = 0; i < lectures.length; i++) {
            if (lectureCounter() - 1 == lectures.length) {
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
        return lectures[lectureCounter() - 1].getID();
    }

    public void setIdCourseOfLecture(Long ID, String name) {
        lectures[lectureCounter() - 1].setCourseID(ID);
        lectures[lectureCounter() - 1].setNameCourse(name);
    }
}
