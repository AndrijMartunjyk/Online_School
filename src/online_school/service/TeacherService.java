package online_school.service;

import online_school.course.model.Lecture;
import online_school.course.model.Role;
import online_school.course.model.Person;
import online_school.generic.SchoolArray;

public class TeacherService {
    private static int counter;

    public Person createTeacher(Role role, long personId, String firstName, String lastName, String phone, String email) {
        counter++;
        return new Person(role, personId, firstName, lastName, phone, email);
    }

    public boolean searchTeacher(long teacherId, long lectureId, Lecture[] lecture, SchoolArray<Person> teachersArray) {
        boolean isPresent = false;
        for (Person teacher : teachersArray.getArray()) {
            if (teacher != null && teacher.getPersonId() == teacherId) {
                for (Lecture value : lecture) {
                    if (value != null && value.getObjectId() == lectureId) {
                        value.setPersonId(teacherId);
                        value.setFirstPersonName(teacher.getFirstName());
                        value.setLastPersonName(teacher.getLastName());
                        teacher.setLectureId(value.getObjectId());
                        teacher.setLectureName(value.getLectureName());
                        System.out.printf("Вчителя з номером ID: \"%d\" присвоєно лекції з номером ID: \"%d\"\n", teacherId, lectureId);
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

    public static int getTeacherCounter() {
        return counter;
    }
}

