package online_school.repository;

import online_school.exception.EntityNotFoundException;
import online_school.domain.model.Lecture;
import online_school.domain.model.Person;
import online_school.log.Log;

import java.util.List;

public interface InterfaceRepository {
    int counter();

    default void showInformPerson(String personName, Long id, List<Lecture> lectures, List<Person> persons) {
        String stacktrace = "Id of the " + personName + " is not found!!!";
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            for (Person person : persons) {
                if (lecture == null || person == null) {
                    return;
                } else if (lecture.getLectureId().equals(person.getLectureId()) &&
                        (lecture.getCourseId().equals(id) || lecture.getLectureId().equals(id))) {
                    System.out.println(person);
                    Log.info(InterfaceRepository.class.getName(), String.valueOf(person));
                    isPresent = false;
                }
            }
        }
        Log.debug(InterfaceRepository.class.getName(), "method->\"showInformPerson\"");
        if (isPresent) {
            Log.warning(InterfaceRepository.class.getName(), "EntityNotFoundException", stacktrace);
            throw new EntityNotFoundException(stacktrace);
        }
    }
}
