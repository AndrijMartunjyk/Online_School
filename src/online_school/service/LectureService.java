package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;

public class LectureService {

    public Lecture createLecture(long ID, String nameLecture, String description) {
        return new Lecture(ID, nameLecture, description);
    }

    public void showLectures(long lectureId, Lecture[] lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
               return;
            }
            if (lecture.getLectureId() == lectureId) {
                System.out.println(lecture);
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id lecture is not found!!!");
        }
    }


    public void showLecturesInCourse(long idCourse, Lecture[] lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                return;
            }else if (lecture.getCourseID() == idCourse) {
                isPresent = false;
                System.out.println(lecture);
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id of the lecture is not found!!!");
        }
    }
}

