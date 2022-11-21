package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.service.TeacherService;
import online_school.course.model.Models;
import online_school.course.model.Person;

import java.util.Arrays;

public class TeacherRepository extends Repository {
    private Person[] teachers = new Person[1];

    public int teacherCounter() {
        int result = 0;
        for (Person teacher : teachers) {
            if (teacher == null) {
                break;
            } else {
                result = TeacherService.getTeacherCounter();
            }
        }
        return result;
    }

    public void magnificationOfArray() {
        teachers = Arrays.copyOf(teachers, (teachers.length * 3) / 2 + 1);
        System.out.format("Масив вчителів збільшено, довжина: %d об'єктів!!!\n", (teachers.length));
    }

    public void searchTeacher(long teacherId, long lectureId, Lecture[] lecture) {
        boolean trueOrFalse = true;
        for (Person teacher : teachers) {
            if (teacher != null && teacher.getPersonId() == teacherId) {
                for (Lecture value : lecture) {
                    if (value != null && value.getID() == lectureId) {
                        value.setPersonId(teacherId);
                        value.setPersonName(teacher.getName());
                        value.setPersonLastName(teacher.getLastName());
                        teacher.setLectureId(value.getID());
                        teacher.setLectureName(value.getName());
                        System.out.printf("Вчителя з номером ID: \"%d\" присвоєно лекції з номером ID: \"%d\"\n", teacherId, lectureId);
                        trueOrFalse = false;
                        break;
                    }
                }
            }
        }
        if (trueOrFalse) {
            System.out.println("Не має вчителя з таким ID !!!");
        }
    }

    @Override
    public Person[] getAll() {
        return teachers;
    }

    public void add(Person teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (teacherCounter() - 1 == teachers.length) {
                magnificationOfArray();
            } else if (teachers[i] == null) {
                teachers[i] = teacher;
                break;
            }
        }
    }

    @Override
    public Models getByld(int idModels, Models[] models) {
        return super.getByld(idModels, models);
    }

    public void deleteByld(int idTeachers, Person[] teachers) {
        boolean trueOrFalse = true;
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                break;
            } else if (teachers[i].getPersonId() == idTeachers) {
                teachers[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", idTeachers);
                for (int j = 0; j < teachers.length - 1; j++) {
                    if (teachers[j] == null) {
                        teachers[j] = teachers[j + 1];
                        teachers[j + 1] = null;
                    }
                }
                trueOrFalse = false;
                break;
            }
        }
        if (trueOrFalse) {
            System.out.println("Не має об'єкта з таким ID, спробуйте ще раз!!!");
        }
    }

    public long getTeacherId() {
        return teachers[teacherCounter() - 1].getPersonId();
    }
}
