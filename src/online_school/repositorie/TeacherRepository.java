package online_school.repositorie;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.generic.SchoolArray;
import online_school.my_interface.InterfaceRepository;
import online_school.service.TeacherService;
import online_school.course.model.Person;

public class TeacherRepository implements InterfaceRepository {
    private final SchoolArray<Person> teachersArray = new SchoolArray<>(new Person[1]);

    @Override
    public int counter() {
        int result = 0;
        for (Person teacher : teachersArray.getArray()) {
            if (teacher == null) {
                break;
            } else {
                result = TeacherService.getTeacherCounter();
            }
        }
        return result;
    }

    public void deleteTeacher(long teacherId) {
        boolean isPresent = true;
        for (int i = 0; i < teachersArray.getArray().length; i++) {
            if (teachersArray.getArray()[i] == null) {
              return;
            } else if (teachersArray.getArray()[i].getPersonId() == teacherId) {
                teachersArray.getArray()[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", teacherId);
                for (int j = 0; j < teachersArray.getArray().length - 1; j++) {
                    if (teachersArray.getArray()[j] == null) {
                        teachersArray.getArray()[j] = teachersArray.getArray()[j + 1];
                        teachersArray.getArray()[j + 1] = null;
                    }
                }
                isPresent = false;
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id teacher is not found!!!");
        }
    }

    @Override
    public void showInformPerson(long courseOrLectureId, Lecture[] lectures, Person[] teacher) {
        InterfaceRepository.super.showInformPerson(courseOrLectureId, lectures, teacher);
    }

    @Override
    public <E> void add(E teacher) {
        teachersArray.add((Person) teacher);
    }

    public SchoolArray<Person> getTeachersArrayObject() {
        return teachersArray;
    }

    public Person[] getTeacherArray() {
        return teachersArray.getArray();
    }

    public long getTeacherId() {
        return teachersArray.getArray()[counter() - 1].getPersonId();
    }
}
