package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.course.model.Person;
import online_school.generic.SchoolArray;
import online_school.service.StudentService;

public class StudentRepository extends Repository {
    private final SchoolArray<Person> studentsArray = new SchoolArray<>(new Person[1]);

    public int studentCounter() {
        int result = 0;
        for (Person student : studentsArray.getArray()) {
            if (student == null) {
                break;
            } else {
                result = StudentService.getStudentCounter();
            }
        }
        return result;
    }

    public boolean searchStudent(long studentId, long lectureId, Lecture[] lecture) {
        boolean trueOrFalse = true;
        for (Person student : studentsArray.getArray()) {
            if (student != null && student.getPersonId() == studentId) {
                for (Lecture value : lecture) {
                    if (value != null && value.getModelId() == lectureId) {
                        student.setLectureId(value.getModelId());
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

    public SchoolArray<Person> getStudentsArrayObject() {
        return studentsArray;
    }

    public Person[] getStudentArray() {
        return studentsArray.getArray();
    }

    public void add(Person student) {
        studentsArray.add(student);
    }

    public long getStudentId() {
        return this.studentsArray.getArray()[studentCounter() - 1].getPersonId();
    }
}
