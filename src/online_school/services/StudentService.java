package online_school.services;

import online_school.courses.Course;
import online_school.courses.models.Student;

import java.util.Arrays;

public class StudentService {
    public Student studentCreation() {
        return new Student();
    }

    public Student studentCreation(long ID, String firstName, String lastName) {
        return new Student(ID, firstName, lastName);
    }

    public void outId(Student[] student) {
        if (Course.counter < 1) {
            System.out.println("Спочатку створіть Курс!!!");
        } else {
            System.out.println("Інформація про студента: " + Arrays.toString(student));
        }
    }

    public void informStudentsCourse(int idCourse, Student[] students) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                break;
            } else if (students[i].getCourseID() == idCourse) {
                System.out.println("Студенти курсу: " + students[i]);
            }
        }
    }
}
