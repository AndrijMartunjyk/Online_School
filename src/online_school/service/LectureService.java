package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;

import java.util.List;

public class LectureService {

    public Lecture createLecture(Long lectureId, String lectureName, String description, Long courseId, String nameCourse) {
        return new Lecture(lectureId, lectureName, description, courseId, nameCourse);
    }

    public void showLectures(Long lectureId, List<Lecture> lectures) {
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            }
            if (lecture.getLectureId().equals(lectureId)) {
                System.out.println(lecture);
                return;
            }
        }
        throw new EntityNotFoundException(MainService.ID_LECTURE_IS_NOT_FOUND);
    }

    public void showLecturesInCourse(Long idCourse, List<Lecture> lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            } else if (lecture.getCourseId().equals(idCourse)) {
                isPresent = false;
                System.out.println(lecture);
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException(MainService.ID_LECTURE_IS_NOT_FOUND);
        }
    }
}

