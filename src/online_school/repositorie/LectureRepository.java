package online_school.repositorie;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.course.task_for_lecture.Homework;
import online_school.generic.SchoolArray;
import online_school.my_interface.InterfaceRepository;

public class LectureRepository implements InterfaceRepository {
    private int indexLecture = -1;
    private final SchoolArray<Lecture> lectureArrayTemplate = new SchoolArray<>(new Lecture[3]);

    public void getLecture(Long lectureId, Lecture[] lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture != null && lecture.getLectureId().equals(lectureId)) {
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id lecture is not found!!!");
        }
    }

    public void addHomework(Long lectureId, Homework homework) {
        for (int i = 0; i < getLectureArray().length; i++) {
            if (getLectureArray()[i] != null && getLectureArray()[i].getLectureId().equals(lectureId)) {
                getLectureArray()[i].getHomeWorkArrayTemplate().add(homework);
                System.out.printf("Чудово, ви створили домашнє завдання з номером ID: \"%d\" i присвоїли його лекції з номером ID: \"%d\".\n",
                        homework.getHomeworkId(), lectureId);
                break;
            }
        }
    }

    public Lecture[] getLectureArray() {
        return lectureArrayTemplate.findAll();
    }

    public long getLectureID() {
        return lectureArrayTemplate.findAll()[counter() - 1].getLectureId();
    }

    public int getIndexLecture() {
        return indexLecture;
    }

    public void setIdCourseOfLecture(Long ID, String name) {
        getLectureArray()[counter() - 1].setCourseID(ID);
        getLectureArray()[counter() - 1].setNameCourse(name);
    }

    @Override
    public int counter() {
        int result = 0;
        for (Lecture lecture : getLectureArray()) {
            if (lecture == null) {
                break;
            } else {
                result = lecture.getCounter();
            }
        }
        return result;
    }

    @Override
    public <E> void add(E lecture) {
        lectureArrayTemplate.add((Lecture) lecture);
    }

    @Override
    public int returnIndex(Long idHomework) {
        int indexHomework = -1;
        for (int i = 0; i < getLectureArray().length; i++) {
            for (int j = 0; j < getLectureArray()[i].getHomeWorkArray().length; j++) {
                if (getLectureArray()[i].getHomeWorkArray()[j] != null
                        && getLectureArray()[i].getHomeWorkArray()[j].getHomeworkId().equals(idHomework)) {
                    indexHomework = j;
                    indexLecture = i;
                }
            }
        }
        return indexHomework;
    }
}
