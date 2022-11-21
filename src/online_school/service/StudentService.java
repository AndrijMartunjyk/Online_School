package online_school.service;

import online_school.enum_enum.Role;
import online_school.course.model.Models;
import online_school.course.model.Person;
import online_school.repositorie.Repository;


import java.util.Arrays;

public class StudentService extends Repository {
    private static int counter;

    public Person studentCreation(Role role, long personId, String name, String lastName) {
        counter++;
        return new Person(role, personId, name, lastName);
    }

    public static int getStudentCounter() {
        return counter;
    }

    public void outId(Models[] student) {
        System.out.println("Інформація про студента: " + Arrays.toString(student));
    }
}