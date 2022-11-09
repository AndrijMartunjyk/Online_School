package online_school.services;

import online_school.courses.models.Teacher;

import java.util.Arrays;

public class TeacherService {
    private int courseCounter;

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
        for (Teacher teacher : teachers) {
            if (teacher == null) {
                break;
            } else if (teacher.getCourseID() == idCourse) {
                System.out.println("Вчителі курсу: " + teacher);
            }
        }
    }
}
