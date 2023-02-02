package online_school.service;

import online_school.domain.model.Model;
import online_school.domain.model.Lecture;
import online_school.domain.model.Role;
import online_school.domain.model.Person;
import online_school.util.Log;

import java.util.List;

public class StudentService extends Model {

    private static int counter;

    public Person createStudent(Role role, Long personId, String firstName, String lastName, String phone, String email) {
        counter++;
        Log.debug(StudentService.class.getName(), "method-> \"createStudent\"");
        return new Person(role, personId, firstName, lastName, phone, email);
    }

    public static int getStudentCounter() {
        Log.debug(StudentService.class.getName(), "method-> \"getStudentCounter\"");
        return counter;
    }

    @Override
    public void addPersonToLecture(String namePerson, Long lectureId, Long studentId, List<Lecture> lecture, List<Person> student) {
        super.addPersonToLecture(namePerson, lectureId, studentId, lecture, student);
        Log.debug(StudentService.class.getName(), "method-> \"addPersonToLecture\"");
    }
}