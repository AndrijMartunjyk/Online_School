package online_school.repositorie;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.course.task_for_lecture.HomeWork;
import online_school.generic.SchoolArray;
import online_school.my_interface.InterfaceRepository;

public class LectureRepository implements InterfaceRepository {
    private boolean isPresent;
    private final SchoolArray<Lecture> lectureArray = new SchoolArray<>(new Lecture[3]);

    public void getLecture(long lectureId, Lecture[] lectures) {
        isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture != null && lecture.getLectureId() == lectureId) {
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id lecture is not found!!!");
        }
    }

    public void addHomework(long lectureId, HomeWork homework) {
        for (int i = 0; i < lectureArray.getArray().length; i++) {
            if (lectureArray.getArray()[i] != null && lectureArray.getArray()[i].getLectureId() == lectureId) {
                lectureArray.getArray()[i].getHomeWorkArray().add(homework);
                System.out.printf("Чудово, ви створили домашнє завдання з номером ID: \"%d\" i присвоїли його лекції з номером ID: \"%d\".\n",
                        homework.getHomeworkId(), lectureId);
                break;
            }
        }
    }

    public void showAllHomework() {
        for (int i = 0; i < lectureArray.getArray().length; i++) {
            if (lectureArray.getArray()[i] != null) {
                for (int j = 0; j < lectureArray.getArray()[i].getHomeWorkArray().getArray().length; j++) {
                    if (lectureArray.getArray()[i].getHomeWorkArray().getArray()[j] != null) {
                        System.out.println(lectureArray.getArray()[i].getHomeWorkArray().getArray()[j]);
                    }
                }
            }
        }
    }

    public void deleteHomework(long homeworkId) {
        isPresent = true;
        for (int i = 0; i < lectureArray.getArray().length; i++) {
            if (lectureArray.getArray()[i] != null) {
                for (int j = 0; j < lectureArray.getArray()[i].getHomeWorkArray().getArray().length; j++) {
                    if (lectureArray.getArray()[i].getHomeWorkArray().getArray()[j] != null && lectureArray.getArray()[i].getHomeWorkArray().getArray()[j]
                            .getHomeworkId() == homeworkId) {
                        lectureArray.getArray()[i].getHomeWorkArray().getArray()[j] = null;
                        System.out.printf("Об'єктт з номером ID:\"%d\"видалено !!!\n", homeworkId);
                        isPresent = false;
                        for (int k = 0; k < lectureArray.getArray()[i].getHomeWorkArray().getArray().length - 1; k++) {
                            if (lectureArray.getArray()[i].getHomeWorkArray().getArray()[k] == null) {
                                lectureArray.getArray()[i].getHomeWorkArray().getArray()[k] = lectureArray.getArray()[i].getHomeWorkArray()
                                        .getArray()[k + 1];
                                lectureArray.getArray()[i].getHomeWorkArray().getArray()[k + 1] = null;
                            }
                        }
                    }
                }
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id homework is not found!!!");
        }
    }

    public SchoolArray<Lecture> getLecturesArrayObject() {
        return lectureArray;
    }

    public Lecture[] getLectureArray() {
        return lectureArray.getArray();
    }

    public long getLectureID() {
        return lectureArray.getArray()[counter() - 1].getLectureId();
    }

    public void setIdCourseOfLecture(Long ID, String name) {
        lectureArray.getArray()[counter() - 1].setCourseID(ID);
        lectureArray.getArray()[counter() - 1].setNameCourse(name);
    }

    @Override
    public int counter() {
        int result = 0;
        for (Lecture lecture : lectureArray.getArray()) {
            if (lecture == null) {
                break;
            } else {
                result = lecture.getCounter();
            }
        }
        return result;
    }

    public void deleteLecture(long lectureId) {
        isPresent = true;
        for (int i = 0; i < lectureArray.getArray().length; i++) {
            if (lectureArray.getArray()[i] == null) {
                return;
            } else if (lectureArray.getArray()[i].getLectureId() == lectureId) {
                lectureArray.getArray()[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", lectureId);
                for (int j = 0; j < lectureArray.getArray().length - 1; j++) {
                    if (lectureArray.getArray()[j] == null) {
                        lectureArray.getArray()[j] = lectureArray.getArray()[j + 1];
                        lectureArray.getArray()[j + 1] = null;
                    }
                }
                isPresent = false;
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id lecture is not found!!!");
        }
    }

    @Override
    public <E> void add(E lecture) {
        lectureArray.add((Lecture) lecture);
    }
}
