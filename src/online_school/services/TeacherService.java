package online_school.services;

import online_school.courses.Course;
import online_school.courses.models.Teacher;

import java.util.Arrays;

public class TeacherService {
    public Teacher teacherCreation() {
        return new Teacher();
    }

    public Teacher teacherCreation(long ID, String firstName, String lastName) {
        return new Teacher(ID, firstName, lastName);
    }

    public void outId(Teacher[] teacher) {
        if (Course.counter < 1) {
            System.out.println("Спочатку створіть Курс!!!");
        } else {
            System.out.println("Інформація про вчителя: " + Arrays.toString(teacher));
        }
    }

    public void informTeachersCourse(int idCourse, Teacher[] teachers) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                break;
            } else if (teachers[i].getCourseID() == idCourse) {
                System.out.println("Вчителі курсу: " + teachers[i]);
            }
        }
    }
}
