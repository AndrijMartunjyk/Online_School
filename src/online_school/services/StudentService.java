package online_school.services;

import online_school.courses.models.Student;

public class StudentService {
    public Student studentCreation() {
        return new Student();
    }

    public Student studentCreation(String firstName, String lastName, String nameCourse, String nameLecture) {
        return new Student(firstName, lastName, nameCourse, nameLecture);
    }
}
