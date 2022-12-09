package online_school.my_interface;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.course.model.Person;

public interface InterfaceRepository {
    int counter();

    <E> void add(E object);

    default void showInformPerson(long id, Lecture[] lectures, Person[] persons) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            for (Person person : persons) {
                if (lecture == null || person == null) {
                    return;
                } else if (lecture.getLectureId() == person.getLectureId() && (lecture.getCourseID() == id || lecture.getLectureId() == id)) {
                    System.out.println(person);
                    isPresent = false;
                }
            }
            if (isPresent) {
                throw new EntityNotFoundException("Id person is not found!!!");
            }
        }
    }
}