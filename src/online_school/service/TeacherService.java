package online_school.service;

import online_school.course.model.Role;
import online_school.course.model.Person;
import online_school.repositorie.Repository;

public class TeacherService extends Repository {
    private static int counter;

    public Person createTeacher(Role role, long personId, String firstName, String lastName, String phone, String email) {
        counter++;
        return new Person(role, personId, firstName, lastName, phone, email);
    }

    public static int getTeacherCounter() {
        return counter;
    }
}

