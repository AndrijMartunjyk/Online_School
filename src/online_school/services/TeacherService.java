package online_school.services;

import online_school.courses.models.Course;
import online_school.courses.models.Teacher;

import java.util.Arrays;

public class TeacherService {
    private int courseCounter;
    public Teacher teacherCreation() {
        return new Teacher();
    }

    public Teacher teacherCreation(long ID, String firstName, String lastName) {
        return new Teacher(ID, firstName, lastName);
    }

    public int getCourseCounter() {
        return courseCounter;
    }

    public void setCourseCounter(int courseCounter) {
        this.courseCounter = courseCounter;
    }

    public void outId(Teacher[] teacher) {
        if (getCourseCounter() < 1) {
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
