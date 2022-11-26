package online_school.service;

import online_school.enum_enum.Role;
import online_school.course.model.Person;
import online_school.repositorie.Repository;

public class TeacherService extends Repository {
    private static int counter;

    public Person teacherCreation(Role role, long personId, String firstName, String lastName, String phone, String email) {
        counter++;
        return new Person(role, personId, firstName, lastName, phone, email);
    }

    public static int getTeacherCounter() {
        return counter;
    }
}

