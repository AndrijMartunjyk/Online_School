package online_school.repository;

import online_school.domain.model.Lecture;
import online_school.domain.model.Person;
import online_school.service.StudentService;
import online_school.log.Log;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements InterfaceRepository {
    private final List<Person> studentList = new ArrayList<>();

    public List<Person> getStudentList() {
        Log.debug(StudentRepository.class.getName(), "method-> \"getStudentList\"");
        return studentList;
    }

    @Override
    public void showInformPerson(String personName, Long courseOrLectureId, List<Lecture> lectures, List<Person> student) {
        InterfaceRepository.super.showInformPerson(personName, courseOrLectureId, lectures, student);
        Log.debug(StudentRepository.class.getName(), "method-> \"showInformPerson\"");
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
        Log.debug(StudentRepository.class.getName(), "method-> \"counter\"");
        return result;
    }

    public long getStudentId(Person s) {
        for (Person student : studentList) {
            if (student.equals(s)) {
                return student.getPersonId();
            }
        }
        Log.debug(StudentRepository.class.getName(), "method-> \"getStudentId\"");
        return 0;
    }

    public List<Person> creatStudentList(List<Lecture> lectureList) {
        List<Person> students = new ArrayList<>();
        for (Lecture lecture : lectureList) {
            if (lecture != null) {
                for (Person student : studentList) {
                    if (student != null && lecture.getLectureId().equals(student.getLectureId())) {
                        students.add(student);
                    }
                }
            }
        }
        Log.debug(StudentRepository.class.getName(), "method-> \"creatStudentList\"");
        return students;
    }
}
