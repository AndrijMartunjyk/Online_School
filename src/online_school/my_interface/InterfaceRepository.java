package online_school.my_interface;

import online_school.course.model.Lecture;
import online_school.course.model.Person;

public interface InterfaceRepository {
    int counter();

    void deleteObject(long id);

    <E> void add(E object);

    default void showInformPerson(long id, Lecture[] lectures, Person[] persons) {
        for (Lecture lecture : lectures) {
            for (Person person : persons) {
                if (lecture == null || person == null) {
                    break;
                } else if (lecture.getObjectId() == person.getLectureId() && (lecture.getCourseID() == id || lecture.getObjectId() == id)) {
                    System.out.println(person);
                }
            }
        }
    }
}
