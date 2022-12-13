package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.course.model.Role;
import online_school.course.model.Person;
import online_school.generic.SchoolArray;

public class TeacherService {
    private static int counter;

    public Person createTeacher(Role role, Long personId, String firstName, String lastName, String phone, String email) {
        return new Person(role, personId + counter++, firstName, lastName, phone, email);
    }

    public void searchTeacher(Long teacherId, Long lectureId, Lecture[] lecture, SchoolArray<Person> teachersArray) {
        boolean isPresent = true;
        for (Person teacher : teachersArray.findAll()) {
            if (teacher != null && teacher.getPersonId().equals(teacherId)) {
                for (Lecture value : lecture) {
                    if (value != null && value.getLectureId().equals(lectureId)) {
                        value.setPersonId(teacherId);
                        value.setFirstPersonName(teacher.getFirstName());
                        value.setLastPersonName(teacher.getLastName());
                        teacher.setLectureId(value.getLectureId());
                        teacher.setLectureName(value.getLectureName());
                        System.out.printf("Вчителя з номером ID: \"%d\" присвоєно лекції з номером ID: \"%d\"\n", teacherId, lectureId);
                        isPresent = false;
                        break;
                    }
                }
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id teacher is not found!!!");
        }
    }

    public static int getTeacherCounter() {
        return counter;
    }
}

