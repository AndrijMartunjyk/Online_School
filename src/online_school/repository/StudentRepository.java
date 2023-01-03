package online_school.repository;

import online_school.domain.model.Lecture;
import online_school.domain.model.Person;
import online_school.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements InterfaceRepository {
    private final List<Person> studentList = new ArrayList<>();

    public List<Person> getStudentList() {
        return studentList;
    }

    @Override
    public void showInformPerson(String personName, Long courseOrLectureId, List<Lecture> lectures, List<Person> student) {
        InterfaceRepository.super.showInformPerson(personName, courseOrLectureId, lectures, student);
    }

    @Override
    public int counter() {
        int result = 0;
        for (Person student : studentList) {
            if (student == null) {
                break;
            } else {
                result = StudentService.getStudentCounter();
            }
        }
        return result;
    }

    public long getStudentId(Person s) {
        for (Person student : studentList) {
            if (student.equals(s)) {
                return student.getPersonId();
            }
        }
        return 0;
    }
}
