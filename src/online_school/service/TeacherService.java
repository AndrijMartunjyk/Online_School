package online_school.service;

import online_school.course.model.Model;
import online_school.course.model.Lecture;
import online_school.my_enum.Role;
import online_school.course.model.Person;

import java.util.List;

public class TeacherService extends Model {
    private static int counter;

    public Person createTeacher(Role role, Long personId, String firstName, String lastName, String phone, String email) {
        counter++;
        return new Person(role, personId, firstName, lastName, phone, email);
    }

    public static int getTeacherCounter() {
        return counter;
    }

    @Override
    public void addPersonToLecture(String namePerson, Long lectureId, Long teacherId, List<Lecture> lecture, List<Person> teacher) {
        super.addPersonToLecture(namePerson, lectureId, teacherId, lecture, teacher);
    }
}

