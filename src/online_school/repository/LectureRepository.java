package online_school.repository;

import online_school.domain.model.Lecture;
import online_school.util.Log;

import java.util.ArrayList;
import java.util.List;

public class LectureRepository implements InterfaceRepository {
    private final List<Lecture> lectureList = new ArrayList<>();

    public List<Lecture> getLectureList() {
        Log.debug(LectureRepository.class.getName(), "method-> \"getLectureList\"");
        return lectureList;
    }

    public long getLectureId(Lecture l) {
        for (Lecture lecture : lectureList) {
            if (lecture.equals(l)) {
                return lecture.getLectureId();
            }
        }
        Log.debug(LectureRepository.class.getName(), "method-> \"getLectureId\"");
        return 0;
    }

    public List<Lecture> creatLectureList(Long courseId) {
        List<Lecture> lectures = new ArrayList<>();
        for (Lecture lecture : lectureList) {
            if (lecture != null && lecture.getCourseId().equals(courseId)) {
                lectures.add(lecture);
            }
        }
        Log.debug(LectureRepository.class.getName(), "method-> \"creatLectureList\"");
        return lectures;
    }

    @Override
    public int counter() {
        int result = 0;
        for (Lecture lecture : lectureList) {
            if (lecture == null) {
                break;
            } else {
                result = lecture.getCounter();
            }
        }
        Log.debug(LectureRepository.class.getName(), "method-> \"counter\"");
        return result;
    }
}
