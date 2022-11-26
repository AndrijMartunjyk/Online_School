package online_school.service;

import online_school.course.model.Lecture;
import online_school.repositorie.Repository;

public class LectureService extends Repository {

    public Lecture lectureCreation(long ID, String nameLecture, String description) {
        return new Lecture(ID, nameLecture, description);
    }

    public void informLecturesCourse(long idCourse, Lecture[] lectures) {
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            } else if (lecture.getCourseID() == idCourse) {
                System.out.println(lecture);
            }
        }
    }

    public void informLectures(long lectureId, Lecture[] lectures) {
        boolean trueOrFalse = true;
        for (Lecture lecture : lectures) {
            if (lecture != null && lecture.getID() == lectureId) {
                System.out.println(lecture);
                trueOrFalse = false;
                break;
            }
        }
        if (trueOrFalse) {
            System.out.println("Немає такої лекції !!!");
        }
    }
}
