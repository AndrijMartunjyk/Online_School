package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.course.model.Role;
import online_school.course.model.Person;
import online_school.generic.SchoolArray;

public class StudentService {

    private static int counter;

    public Person createStudent(Role role, Long personId, String firstName, String lastName, String phone, String email) {
        return new Person(role, personId + counter++, firstName, lastName, phone, email);
    }

    public void searchStudent(long studentId, Long lectureId, Lecture[] lecture, SchoolArray<Person> studentsArray) {
        boolean isPresent = true;
        for (Person student : studentsArray.findAll()) {
            if (student != null && student.getPersonId() == studentId) {
                for (Lecture value : lecture) {
                    if (value != null && value.getLectureId().equals(lectureId)) {
                        student.setLectureId(value.getLectureId());
                        student.setLectureName(value.getLectureName());
                        System.out.printf("Студента з номером ID: \"%d\" присвоєно лекції з ID: \"%d\"\n", studentId, lectureId);
                        isPresent = false;
                        break;
                    }
                }
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id student is not found!!!");
        }
    }

    public static int getStudentCounter() {
        return counter;
    }
}