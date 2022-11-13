package online_school.services;

import online_school.courses.models.Models;
import online_school.courses.models.Teacher;

import java.util.Arrays;

public class TeacherService {

    public Teacher teacherCreation(long ID, String firstName, String lastName) {
        return new Teacher(ID, firstName, lastName);
    }

    public void outId(Models[] teacher) {
        System.out.println("Інформація про вчителя: " + Arrays.toString(teacher));
    }

    public void informTeachersCourse(int idCourse, Models[] teachers) {
        for (Models teacher : teachers) {
            if (teacher == null) {
                break;
            } else if (teacher.getCourseID() == idCourse) {
                System.out.println("Вчителі курсу: " + teacher);
            }
        }
    }
}
