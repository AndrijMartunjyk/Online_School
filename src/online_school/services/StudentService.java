package online_school.services;

import online_school.courses.models.Student;

public class StudentService {
    public Student studentCreation() {
        return new Student();
    }

    public Student studentCreation(long ID, String firstName, String lastName, String nameCourse, String nameLecture) {
        return new Student(ID, firstName, lastName, nameCourse, nameLecture);
    }
}
