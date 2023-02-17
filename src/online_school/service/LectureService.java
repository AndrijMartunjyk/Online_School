package online_school.service;

import online_school.domain.model.Lecture;
import online_school.log.Log;

import java.util.List;

public class LectureService {

    public Lecture createLecture(Long lectureId, String lectureName, String description, Long courseId, String nameCourse) {
        Log.debug(LectureService.class.getName(), "method-> \"createLecture\"");
        return new Lecture(lectureId, lectureName, description, courseId, nameCourse);
    }

    public void showLectures(Long lectureId, List<Lecture> lectures) {
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            }
            if (lecture.getLectureId().equals(lectureId)) {
                System.out.println(lecture);
                Log.info(LectureService.class.getName(), String.valueOf(lecture));
                return;
            }
        }
        Log.debug(LectureService.class.getName(), "method-> \"showLectures\"");
        Log.warning(LectureService.class.getName(), "EntityNotFoundException", MainService.ID_LECTURE_IS_NOT_FOUND);
        System.out.println(MainService.ID_LECTURE_IS_NOT_FOUND);
    }

    public void showLecturesInCourse(Long idCourse, List<Lecture> lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            } else if (lecture.getCourseId().equals(idCourse)) {
                isPresent = false;
                System.out.println(lecture);
                Log.info(LectureService.class.getName(), String.valueOf(lecture));
            }
        }
        if (isPresent) {
            System.out.println(MainService.ID_LECTURE_IS_NOT_FOUND);
            Log.warning(LectureService.class.getName(), "EntityNotFoundException", MainService.ID_LECTURE_IS_NOT_FOUND);
        }
        Log.debug(LectureService.class.getName(), "method-> \"showLecturesInCourse\"");
    }
}

