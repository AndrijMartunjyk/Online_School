package online_school.service;

import online_school.course.model.Model;
import online_school.course.model.Lecture;
import online_school.my_enum.Role;
import online_school.course.model.Person;

import java.util.List;

public class TeacherService extends Model {
    private static int counter;

    public Person createTeacher(Role role, Long teacherId, String firstTeacherName, String lastTeacherName, String phone, String email) {
        counter++;
        return new Person(role, teacherId, firstTeacherName, lastTeacherName, phone, email);
    }

    public static int getTeacherCounter() {
        return counter;
    }

    @Override
    public void addPersonToLecture(String namePerson, Long lectureId, Long teacherId, List<Lecture> lecture, List<Person> teacher) {
        super.addPersonToLecture(namePerson, lectureId, teacherId, lecture, teacher);
    }
}

