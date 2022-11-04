package online_school.services;

import online_school.courses.Course;
import online_school.courses.models.Lecture;

import java.util.Arrays;

public class LectureService {
    public Lecture lectureCreation() {
        return new Lecture();
    }

    public Lecture lectureCreation(long ID, String nameLecture) {
        return new Lecture(ID, nameLecture);
    }

    public void outId(Lecture[] lectures) {
        if (Course.counter < 1) {
            System.out.println("Спочатку створіть Курс!!!");
        } else {
            System.out.println("Інформація про лекцію: " + Arrays.toString(lectures));
        }
    }

    public void informLecturesCourse(int idCourse, Lecture[] lectures) {
        for (int i = 0; i < lectures.length; i++) {
            if (lectures[i] == null) {
                break;
            } else if (lectures[i].getCourseID() == idCourse) {
                System.out.println("Лекції курсу: " + lectures[i]);
            }
        }
    }
}
