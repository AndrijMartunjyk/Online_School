package online_school.services;

import online_school.courses.models.Teacher;

public class TeacherService {
    public Teacher teacherCreation() {
        return new Teacher();
    }

    public Teacher teacherCreation(String firstName, String lastName, String direction) {
        return new Teacher(firstName, lastName, direction);
    }
}
