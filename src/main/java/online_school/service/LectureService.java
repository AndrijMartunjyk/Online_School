package online_school.service;

import online_school.domain.model.Lecture;
import online_school.log.Log;

import java.util.List;
import java.util.Optional;

public class LectureService {

    public Lecture createLecture(Long lectureId, String lectureName, String description, Long courseId, String nameCourse) {
        Log.debug(LectureService.class.getName(), "method-> \"createLecture\"");
        return new Lecture(lectureId, lectureName, description, courseId, nameCourse);
    }

    public void showLectures(Long lectureId, List<Lecture> lectureList) {
        Optional<Long> lectureIdOptional = Optional.ofNullable(lectureId);
        Optional<List<Lecture>> lectureListOptional = Optional.ofNullable(lectureList);
        if (lectureIdOptional.isPresent() && lectureListOptional.isPresent()) {
            for (Lecture lecture : lectureListOptional.get()) {
                if (lecture == null) {
                    break;
                }
                if (lecture.getLectureId().equals(lectureIdOptional.get())) {
                    System.out.println(lecture);
                    Log.info(LectureService.class.getName(), String.valueOf(lecture));
                    return;
                }
            }
            System.out.println(MainService.ID_LECTURE_IS_NOT_FOUND);
        }
        Log.debug(LectureService.class.getName(), "method-> \"showLectures\"");
        Log.warning(LectureService.class.getName(), "EntityNotFoundException", MainService.ID_LECTURE_IS_NOT_FOUND);
    }

    public void showLecturesInCourse(Long idCourse, List<Lecture> lectureList) {
        Optional<Long> idCourseOptional = Optional.ofNullable(idCourse);
        Optional<List<Lecture>> lectureListOptional = Optional.ofNullable(lectureList);
        if (idCourseOptional.isPresent() && lectureListOptional.isPresent()) {
            boolean isPresent = true;
            for (Lecture lecture : lectureListOptional.get()) {
                if (lecture == null) {
                    break;
                } else if (lecture.getCourseId().equals(idCourseOptional.get())) {
                    isPresent = false;
                    System.out.println(lecture);
                    Log.info(LectureService.class.getName(), String.valueOf(lecture));
                }
            }
            if (isPresent) {
                System.out.println(MainService.ID_LECTURE_IS_NOT_FOUND);
                Log.warning(LectureService.class.getName(), "EntityNotFoundException", MainService.ID_LECTURE_IS_NOT_FOUND);
            }
        }
        Log.debug(LectureService.class.getName(), "method-> \"showLecturesInCourse\"");
    }
}

