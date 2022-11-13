package online_school.services;

import online_school.courses.models.Lecture;
import online_school.courses.models.Models;

import java.util.Arrays;


public class LectureService {

    public Lecture lectureCreation(long ID, String nameLecture) {
        return new Lecture(ID, nameLecture);
    }

    public void outId(Models[] lectures) {
                System.out.println("Інформація про лекцію: " + Arrays.toString(lectures));
    }
    public void informLecturesCourse(int idCourse, Models[] lectures) {
        for (Models lecture : lectures) {
            if (lecture == null) {
                break;
            } else if (lecture.getCourseID() == idCourse) {
                System.out.println("Лекції курсу: " + lecture);
            }
        }
    }
}
