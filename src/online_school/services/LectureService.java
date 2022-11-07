package online_school.services;

import online_school.courses.models.Course;
import online_school.courses.models.Lecture;

import java.util.Arrays;


public class LectureService {
    private int courseCounter;
    public Lecture lectureCreation() {
        return new Lecture();
    }

    public Lecture lectureCreation(long ID, String nameLecture) {
        return new Lecture(ID, nameLecture);
    }

    public int getCourseCounter() {
        return courseCounter;
    }

    public void setCourseCounter(int courseCounter) {
        this.courseCounter = courseCounter;
    }

    public void outId(Lecture[] lectures) {
        if (getCourseCounter() < 1) {
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
