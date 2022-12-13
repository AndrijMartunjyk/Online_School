package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;

public class LectureService {

    public Lecture createLecture(Long ID, String nameLecture, String description) {
        return new Lecture(ID, nameLecture, description);
    }

    public void showLectures(Long lectureId, Lecture[] lectures) {
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            }
            if (lecture.getLectureId().equals(lectureId)) {
                System.out.println(lecture);
                return;
            }
        }
        throw new EntityNotFoundException("Id lecture is not found!!!");
    }


    public void showLecturesInCourse(Long idCourse, Lecture[] lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            } else if (lecture.getCourseID().equals(idCourse)) {
                isPresent = false;
                System.out.println(lecture);
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id of the lecture is not found!!!");
        }
    }
}

