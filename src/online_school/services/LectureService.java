package online_school.services;

import online_school.courses.models.Lecture;

import java.util.Arrays;


public class LectureService {
    private int courseCounter;

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
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            } else if (lecture.getCourseID() == idCourse) {
                System.out.println("Лекції курсу: " + lecture);
            }
        }
    }
}
