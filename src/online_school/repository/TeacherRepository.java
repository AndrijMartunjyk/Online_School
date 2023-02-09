package online_school.repository;

import online_school.domain.model.Lecture;
import online_school.service.TeacherService;
import online_school.domain.model.Person;
import online_school.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements InterfaceRepository {
    private final List<Person> teacherList = new ArrayList<>();

    public List<Person> getTeacherList() {
        Log.debug(TeacherRepository.class.getName(), "method-> \"getTeacherList\"");
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
        Log.debug(TeacherRepository.class.getName(), "method-> \"counter\"");
        return result;
    }

    @Override
    public void showInformPerson(String personName, Long courseOrLectureId, List<Lecture> lectures, List<Person> teacher) {
        InterfaceRepository.super.showInformPerson(personName, courseOrLectureId, lectures, teacher);
        Log.debug(TeacherRepository.class.getName(), "method-> \"showInformPerson\"");
    }

    public long getTeacherId(Person t) {
        for (Person teacher : teacherList) {
            if (teacher.equals(t)) {
                return teacher.getPersonId();
            }
        }
        Log.debug(TeacherRepository.class.getName(), "method-> \"getTeacherId\"");
        return 0;
    }

    public List<Person> creatTeacherList(List<Lecture> lectureList) {
        List<Person> teachers = new ArrayList<>();
        for (Lecture lecture : lectureList) {
            if (lecture != null) {
                for (Person teacher : teacherList) {
                    if (teacher != null && lecture.getLectureId().equals(teacher.getLectureId())) {
                        teachers.add(teacher);
                    }
                }
            }
        }
        Log.debug(TeacherRepository.class.getName(), "method-> \"creatTeacherList\"");
        return teachers;
    }
}
