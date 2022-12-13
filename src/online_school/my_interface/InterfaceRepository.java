package online_school.my_interface;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.course.model.Person;

public interface InterfaceRepository {
    int counter();

    <E> void add(E object);

    int returnIndex(Long id);

    default void showInformPerson(Long id, Lecture[] lectures, Person[] persons) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            for (Person person : persons) {
                if (lecture == null || person == null) {
                    return;
                } else if (lecture.getLectureId().equals(person.getLectureId()) &&
                        (lecture.getCourseID().equals(id) || lecture.getLectureId().equals(id))) {
                    System.out.println(person);
                    isPresent = false;
                }
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id person is not found!!!");
        }
    }
}
