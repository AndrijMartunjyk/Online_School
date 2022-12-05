package online_school.service;

import online_school.course.model.Lecture;
import online_school.course.model.Role;
import online_school.course.model.Person;
import online_school.generic.SchoolArray;

public class StudentService {

    private static int counter;

    public Person createStudent(Role role, long personId, String firstName, String lastName, String phone, String email) {
        counter++;
        return new Person(role, personId, firstName, lastName, phone, email);
    }

    public boolean searchStudent(long studentId, long lectureId, Lecture[] lecture, SchoolArray<Person> studentsArray) {
        boolean isPresent = false;
        for (Person student : studentsArray.getArray()) {
            if (student != null && student.getPersonId() == studentId) {
                for (Lecture value : lecture) {
                    if (value != null && value.getObjectId() == lectureId) {
                        student.setLectureId(value.getObjectId());
                        student.setLectureName(value.getLectureName());
                        System.out.printf("Студента з номером ID: \"%d\" присвоєно лекції з ID: \"%d\"\n", studentId, lectureId);
                        isPresent = true;
                        break;
                    }
                }
            }
            if (isPresent) {
                break;
            }
        }
        return !isPresent;
    }

    public static int getStudentCounter() {
        return counter;
    }
}