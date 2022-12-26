package online_school.repository;

import online_school.course.model.Lecture;
import online_school.my_interface.InterfaceRepository;
import online_school.service.TeacherService;
import online_school.course.model.Person;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements InterfaceRepository {
    private final List<Person> teacherList = new ArrayList<>();

    public List<Person> getTeacherList() {
        return teacherList;
    }

    @Override
    public int counter() {
        int result = 0;
        for (Person teacher : teacherList) {
            if (teacher == null) {
                break;
            } else {
                result = TeacherService.getTeacherCounter();
            }
        }
        return result;
    }

    @Override
    public void showInformPerson(String personName, Long courseOrLectureId, List<Lecture> lectures, List<Person> teacher) {
        InterfaceRepository.super.showInformPerson(personName, courseOrLectureId, lectures, teacher);
    }

    public long getTeacherId(Person t) {
        for (Person teacher : teacherList) {
            if (teacher.equals(t)) {
                return teacher.getPersonId();
            }
        }
        return 0;
    }
}
