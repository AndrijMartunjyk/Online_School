package online_school.repository;

import online_school.course.task_for_lecture.AdditionalMaterial;
import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.course.task_for_lecture.Homework;
import online_school.my_interface.InterfaceRepository;
import online_school.service.MainService;

import java.util.ArrayList;
import java.util.List;

public class LectureRepository implements InterfaceRepository {
    private final List<Lecture> lectureList = new ArrayList<>();

    public void addHomework(Long lectureId, Homework homework) {
        for (Lecture lecture : lectureList) {
            if (lecture != null && lecture.getLectureId().equals(lectureId)) {
                lecture.getHomeworkList().add(homework);
                System.out.printf("Чудово, ви створили домашнє завдання з номером ID: \"%d\" i присвоїли його лекції з номером ID: \"%d\".\n",
                        homework.getHomeworkId(), lectureId);
                return;
            }
        }
        throw new EntityNotFoundException(MainService.ID_LECTURE_IS_NOT_FOUND);
    }

    public void addAdditionalMaterials(Long lectureId, AdditionalMaterial additionalMaterial) {
        for (Lecture lecture : lectureList) {
            if (lecture != null && lecture.getLectureId().equals(lectureId)) {
                lecture.getAdditionalMaterialList().add(additionalMaterial);
                System.out.printf("Чудово, ви створили додаткові матеріали з номером ID: \"%d\" i присвоїли їх лекції з номером ID: \"%d\".\n",
                        additionalMaterial.getId(), lectureId);
                return;
            }
        }
        throw new EntityNotFoundException(MainService.ID_LECTURE_IS_NOT_FOUND);
    }

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public long getLectureID() {
        return lectureList.get(counter() - 1).getLectureId();
    }

    public void setIdCourseOfLecture(Long ID, String name) {
        lectureList.get(counter() - 1).setCourseID(ID);
        lectureList.get(counter() - 1).setNameCourse(name);
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
