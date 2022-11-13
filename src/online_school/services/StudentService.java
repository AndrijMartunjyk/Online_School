package online_school.services;

import online_school.courses.models.Models;
import online_school.courses.models.Student;

import java.util.Arrays;

public class StudentService {

    public Student studentCreation(long ID, String firstName, String lastName) {
        return new Student(ID, firstName, lastName);
    }

    public void outId(Models[] student) {
        System.out.println("Інформація про студента: " + Arrays.toString(student));
    }

    public void informStudentsCourse(int idCourse, Models[] students) {
        for (Models student : students) {
            if (student == null) {
                break;
            } else if (student.getCourseID() == idCourse) {
                System.out.println("Студенти курсу: " + student);
            }
        }
    }
}
