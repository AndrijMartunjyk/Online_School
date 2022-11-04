package online_school.courses.repositories;

import online_school.courses.models.Student;

import java.util.Arrays;

public class StudentRepository {
    private Student[] students = new Student[1];

    public void magnificationOfArray() {
        students = Arrays.copyOf(students, (students.length * 3) / 2 + 1);
        System.out.format("Масив студентів збільшено, довжина: %d об'єктів!!!\n", (students.length));
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (Student.counter - 1 == students.length) {
                magnificationOfArray();
            } else if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public Student[] getStudentsArray() {
        return students;
    }

    public long getStudentId() {
        return students[Student.counter - 1].getID();
    }

    public void setIdCourseOfStudent(Long ID, String name) {
        students[Student.counter - 1].setCourseID(ID);
        students[Student.counter - 1].setNameCourse(name);
    }
}

