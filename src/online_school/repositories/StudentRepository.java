package online_school.repositories;

import online_school.courses.models.Student;

import java.util.Arrays;

public class StudentRepository {
    private Student[] students = new Student[1];

    public int studentCounter() {
        int result = 0;
        for (Student student : students) {
            if (student == null) {
                break;
            } else {
                result = student.getCounter();
            }
        }
        return result;
    }

    public void magnificationOfArray() {
        students = Arrays.copyOf(students, (students.length * 3) / 2 + 1);
        System.out.format("Масив студентів збільшено, довжина: %d об'єктів!!!\n", (students.length));
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (studentCounter() - 1 == students.length) {
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
        return students[studentCounter() - 1].getID();
    }

    public void setIdCourseOfStudent(Long ID, String name) {
        students[studentCounter() - 1].setCourseID(ID);
        students[studentCounter() - 1].setNameCourse(name);
    }
}

