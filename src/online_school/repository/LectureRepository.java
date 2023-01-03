package online_school.repository;

import online_school.domain.model.Lecture;

import java.util.ArrayList;
import java.util.List;

public class LectureRepository implements InterfaceRepository {
    private final List<Lecture> lectureList = new ArrayList<>();

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public long getLectureId(Lecture l) {
        for (Lecture lecture : lectureList) {
            if (lecture.equals(l)) {
                return lecture.getLectureId();
            }
        }
        return 0;
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
        return result;
    }
}
