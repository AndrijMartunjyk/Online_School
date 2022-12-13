package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.course.model.Person;
import online_school.generic.SchoolArray;
import online_school.my_interface.InterfaceRepository;
import online_school.service.StudentService;

public class StudentRepository implements InterfaceRepository {
    private final SchoolArray<Person> studentsArrayTemplate = new SchoolArray<>(new Person[1]);

    @Override
    public int counter() {
        int result = 0;
        for (Person student : getStudentArray()) {
            if (student == null) {
                break;
            } else {
                result = StudentService.getStudentCounter();
            }
        }
        return result;
    }

    @Override
    public void showInformPerson(Long courseOrLectureId, Lecture[] lectures, Person[] student) {
        InterfaceRepository.super.showInformPerson(courseOrLectureId, lectures, student);
    }

    @Override
    public <E> void add(E student) {
        studentsArrayTemplate.add((Person) student);
    }

    @Override
    public int returnIndex(Long idStudent) {
        int index = -1;
        for (int i = 0; i < getStudentArray().length; i++) {
            if (getStudentArray()[i].getPersonId().equals(idStudent)) {
                index = i;
            }
        }
        return index;
    }

    public SchoolArray<Person> getStudentsArrayTemplate() {
        return studentsArrayTemplate;
    }

    public Person[] getStudentArray() {
        return studentsArrayTemplate.findAll();
    }

    public long getStudentId() {
        return getStudentArray()[counter() - 1].getPersonId();
    }
}
