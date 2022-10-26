package online_school.services;

import online_school.courses.models.Teacher;

public class TeacherService {
    public Teacher teacherCreation() {
        return new Teacher();
    }

    public Teacher teacherCreation(long ID, String firstName, String lastName, String direction) {
        return new Teacher(ID, firstName, lastName, direction);
    }
}
