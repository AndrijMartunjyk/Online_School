package online_school.courses.repositories;

import online_school.courses.Course;
import online_school.courses.models.Lecture;
import online_school.services.LectureService;

import java.util.Arrays;

public class LectureRepository {
    private final LectureService lectureService = new LectureService();
    private int number;
    private Lecture[] lectures = new Lecture[Lecture.counter];
    private Lecture[] newLecture = new Lecture[Course.counter];

    public void setNumber(int number) {
        this.number = number;
    }

    public void arraysOfObjects(int counter) {
        if (counter < 1) {
            lectures = new Lecture[number];
        } else if (counter == number) {
            System.out.format("ВИ ПЕРЕВИЩИЛИ КІЛЬКІСТЬ ОБ'ЄКТІВ, МАСИВ ЗБІЛЬШЕНО ДО: %d ОБ'ЄКТІВ", ((lectures.length * 3) / 2 + 1));
            System.out.println();
            newLecture = Arrays.copyOf(lectures, (lectures.length * 3) / 2 + 1);
        } else if (counter == newLecture.length) {
            System.out.format("ВИ ПЕРЕВИЩИЛИ КІЛЬКІСТЬ ОБ'ЄКТІВ, МАСИВ ЗБІЛЬШЕНО ДО: %d ОБ'ЄКТІВ", ((newLecture.length * 3) / 2 + 1));
            System.out.println();
            newLecture = Arrays.copyOf(newLecture, (newLecture.length * 3) / 2 + 1);
        }
    }

    public void objects() {
        if (Lecture.counter < number) {
            lectures[Lecture.counter] = lectureService.lectureCreation();
        } else {
            newLecture[Lecture.counter] = lectureService.lectureCreation();
        }
    }
}
