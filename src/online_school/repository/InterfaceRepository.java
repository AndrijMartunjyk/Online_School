package online_school.repository;

import online_school.exception.EntityNotFoundException;
import online_school.domain.model.Lecture;
import online_school.domain.model.Person;

import java.util.List;

public interface InterfaceRepository {
    int counter();

    default void showInformPerson(String personName, Long id, List<Lecture> lectures, List<Person> persons) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            for (Person person : persons) {
                if (lecture == null || person == null) {
                    return;
                } else if (lecture.getLectureId().equals(person.getLectureId()) &&
                        (lecture.getCourseId().equals(id) || lecture.getLectureId().equals(id))) {
                    System.out.println(person);
                    isPresent = false;
                }
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id of the " + personName + " is not found!!!");
        }
    }
}
