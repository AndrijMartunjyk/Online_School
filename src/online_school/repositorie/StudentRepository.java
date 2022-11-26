package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.course.model.Person;
import online_school.service.StudentService;

import java.util.Arrays;

public class StudentRepository extends Repository {
    private Person[] students = new Person[1];

    public int studentCounter() {
        int result = 0;
        for (Person student : students) {
            if (student == null) {
                break;
            } else {
                result = StudentService.getStudentCounter();
            }
        }
        return result;
    }

    public void magnificationOfArray() {
        students = Arrays.copyOf(students, (students.length * 3) / 2 + 1);
        System.out.format("Масив студентів збільшено, довжина: %d об'єктів!!!\n", (students.length));
    }

    public boolean searchStudent(long studentId, long lectureId, Lecture[] lecture) {
        boolean trueOrFalse = true;
        for (Person student : students) {
            if (student != null && student.getPersonId() == studentId) {
                for (Lecture value : lecture) {
                    if (value != null && value.getID() == lectureId) {
                        student.setLectureId(value.getID());
                        student.setLectureName(value.getName());
                        System.out.printf("Студента з номером ID: \"%d\" присвоєно лекції з ID: \"%d\"\n", studentId, lectureId);
                        trueOrFalse = true;
                        break;
                    }
                }
            } else {
                trueOrFalse = false;
            }
        }
        return trueOrFalse;
    }

    @Override
    public Person[] getAll() {
        return students;
    }

    public void add(Person student) {
        for (int i = 0; i < students.length; i++) {
            if (studentCounter() - 1 == students.length) {
                magnificationOfArray();
            } else if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public long getStudentId() {
        return this.students[studentCounter() - 1].getPersonId();
    }
}
