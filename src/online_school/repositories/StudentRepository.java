package online_school.repositories;

import online_school.courses.models.Models;

import java.util.Arrays;

public class StudentRepository extends Repository {
    private Models[] students = new Models[1];

    public int studentCounter() {
        int result = 0;
        for (Models student : students) {
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

    @Override
    public Models[] getAll() {
        return students;
    }

    @Override
    public void add(Models student) {
        for (int i = 0; i < students.length; i++) {
            if (studentCounter() - 1 == students.length) {
                magnificationOfArray();
            } else if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    @Override
    public Models getByld(int idModels, Models[] models) {
        return super.getByld(idModels, models);
    }

    @Override
    public void deleteByld(int idModels, Models[] models) {
        super.deleteByld(idModels, models);
    }

    public long getStudentId() {
        return students[studentCounter() - 1].getID();
    }

    public void setIdCourseOfStudent(Long ID, String name) {
        students[studentCounter() - 1].setCourseID(ID);
        students[studentCounter() - 1].setNameCourse(name);
    }
}

