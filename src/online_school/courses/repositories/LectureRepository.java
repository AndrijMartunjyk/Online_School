package online_school.courses.repositories;

import online_school.courses.Course;
import online_school.courses.models.Lecture;
import online_school.services.LectureService;

import java.util.Arrays;

public class LectureRepository {
    public static Lecture[] lectures = new Lecture[Lecture.counter];

    public void arraysOfObjects() {
        if (Lecture.counter == lectures.length) {
            lectures = Arrays.copyOf(lectures, (lectures.length * 3) / 2 + 1);
        }
    }
}
