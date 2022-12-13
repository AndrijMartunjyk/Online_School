package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.generic.SchoolArray;
import online_school.my_interface.InterfaceRepository;
import online_school.service.TeacherService;
import online_school.course.model.Person;

public class TeacherRepository implements InterfaceRepository {
    private final SchoolArray<Person> teachersArrayTemplate = new SchoolArray<>(new Person[1]);

    @Override
    public int counter() {
        int result = 0;
        for (Person teacher : getTeacherArray()) {
            if (teacher == null) {
                break;
            } else {
                result = TeacherService.getTeacherCounter();
            }
        }
        return result;
    }

    @Override
    public void showInformPerson(Long courseOrLectureId, Lecture[] lectures, Person[] teacher) {
        InterfaceRepository.super.showInformPerson(courseOrLectureId, lectures, teacher);
    }

    @Override
    public <E> void add(E teacher) {
        teachersArrayTemplate.add((Person) teacher);
    }

    @Override
    public int returnIndex(Long idTeacher) {
        int index = -1;
        for (int i = 0; i < getTeacherArray().length; i++) {
            if (getTeacherArray()[i].getPersonId().equals(idTeacher)) {
                index = i;
            }
        }
        return index;
    }

    public SchoolArray<Person> getTeachersArrayTemplate() {
        return teachersArrayTemplate;
    }

    public Person[] getTeacherArray() {
        return teachersArrayTemplate.findAll();
    }

    public Long getTeacherId() {
        return getTeacherArray()[counter() - 1].getPersonId();
    }
}
