package online_school.domain.model;

import online_school.exception.EntityNotFoundException;
import online_school.service.MainService;

import java.util.List;

public abstract class Model {
    private String firstPersonName;
    private String lastPersonName;

    public String getFirstPersonName() {
        return firstPersonName;
    }

    public void setFirstPersonName(String firstPersonName) {
        this.firstPersonName = firstPersonName;
    }

    public String getLastPersonName() {
        return lastPersonName;
    }

    public void setLastPersonName(String lastPersonName) {
        this.lastPersonName = lastPersonName;
    }

    public void addPersonToLecture(String namePerson, Long lectureId, Long personId, List<Lecture> lecture, List<Person> person) {
        boolean isPresentLecture = true;
        boolean isPresentTeacher = true;
        for (Lecture value : lecture) {
            if (value.getLectureId().equals(lectureId)) {
                isPresentLecture = false;
                for (Person item : person) {
                    if (item.getPersonId().equals(personId)) {
                        isPresentTeacher = false;
                        value.setPersonId(item.getPersonId());
                        value.setFirstPersonName(item.getFirstPersonName());
                        value.setLastPersonName(item.getLastPersonName());
                        item.setLectureId(value.getLectureId());
                        item.setLectureName(value.getLectureName());
                        System.out.printf("%s з номером ID: \"%d\" присвоєно лекції з номером ID: \"%d\"\n", namePerson, personId, lectureId);
                    }
                }
                if (isPresentTeacher) {
                    throw new EntityNotFoundException("ID " + namePerson + " is not found !!!");
                }
            }
        }
        if (isPresentLecture) {
            throw new EntityNotFoundException(MainService.ID_LECTURE_IS_NOT_FOUND);
        }
    }
}
