package online_school.service;

import online_school.enum_enum.Role;
import online_school.course.model.Models;
import online_school.course.model.Person;
import online_school.repositorie.Repository;

import java.util.Arrays;

public class TeacherService extends Repository {
    private static int counter;

    public Person teacherCreation(Role role, long personId, String name, String lastName) {
        counter++;
        return new Person(role, personId, name, lastName);
    }

    public static int getTeacherCounter() {
        return counter;
    }

    public void outId(Models[] teacher) {
        System.out.println("Інформація про вчителя: " + Arrays.toString(teacher));
    }
}

