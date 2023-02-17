package online_school.domain.model;

import online_school.exception.EntityNotFoundException;
import online_school.service.MainService;
import online_school.log.Log;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public abstract class Model implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;
    private String firstPersonName;
    private String lastPersonName;

    public String getFirstPersonName() {
        Log.debug(Model.class.getName(), "method->\"getFirstPersonName\"");
        return firstPersonName;
    }

    public void setFirstPersonName(String firstPersonName) {
        this.firstPersonName = firstPersonName;
        Log.debug(Model.class.getName(), "method->\"setFirstPersonName\"");
    }

    public String getLastPersonName() {
        Log.debug(Model.class.getName(), "method->\"getLastPersonName\"");
        return lastPersonName;
    }

    public void setLastPersonName(String lastPersonName) {
        this.lastPersonName = lastPersonName;
        Log.debug(Model.class.getName(), "method->\"setLastPersonName\"");
    }

    public void addPersonToLecture(String namePerson, Long lectureId, Long personId, List<Lecture> lecture, List<Person> person) {
        String massage = "%s з номером ID: \"%d\" присвоєно лекції з номером ID: \"%d\"\n";
        String stacktrace = "ID " + namePerson + " is not found !!!";
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
                        System.out.printf(massage, namePerson, personId, lectureId);
                        Log.info(Model.class.getName(), massage);
                    }
                }
                if (isPresentTeacher) {
                    Log.warning(Model.class.getName(), "EntityNotFoundException", stacktrace);
                    throw new EntityNotFoundException(stacktrace);
                }
            }
        }
        if (isPresentLecture) {
            Log.warning(Model.class.getName(), "EntityNotFoundException", MainService.ID_LECTURE_IS_NOT_FOUND);
            throw new EntityNotFoundException(MainService.ID_LECTURE_IS_NOT_FOUND);
        }
        Log.debug(Model.class.getName(), "method->\"addPersonToLecture\"");
    }
}
