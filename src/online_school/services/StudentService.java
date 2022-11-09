package online_school.services;

import online_school.courses.models.Student;

import java.util.Arrays;

public class StudentService {
    private int courseCounter;

    public Student studentCreation(long ID, String firstName, String lastName) {
        return new Student(ID, firstName, lastName);
    }

    public int getCourseCounter() {
        return courseCounter;
    }

    public void setCourseCounter(int courseCounter) {
        this.courseCounter = courseCounter;
    }

    public void outId(Student[] student) {
        if (getCourseCounter() < 1) {
            System.out.println("Спочатку створіть Курс!!!");
        } else {
            System.out.println("Інформація про студента: " + Arrays.toString(student));
        }
    }

    public void informStudentsCourse(int idCourse, Student[] students) {
        for (Student student : students) {
            if (student == null) {
                break;
            } else if (student.getCourseID() == idCourse) {
                System.out.println("Студенти курсу: " + student);
            }
        }
    }
}
