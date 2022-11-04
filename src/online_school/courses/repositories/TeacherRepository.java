package online_school.courses.repositories;

import online_school.courses.models.Teacher;

import java.util.Arrays;

public class TeacherRepository {
    public Teacher[] teachers = new Teacher[1];

    public void magnificationOfArray() {
        teachers = Arrays.copyOf(teachers, (teachers.length * 3) / 2 + 1);
        System.out.format("Масив вчителів збільшено, довжина: %d об'єктів!!!\n", (teachers.length));
    }

    public void addTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (Teacher.counter - 1 == teachers.length) {
                magnificationOfArray();
            } else if (teachers[i] == null) {
                teachers[i] = teacher;
                break;
            }
        }
    }

    public Teacher[] getTeachersArray() {
        return teachers;
    }

    public long getTeacherId() {
        return teachers[Teacher.counter - 1].getID();
    }

    public void setIdCourseOfTeacher(Long ID, String name) {
        teachers[Teacher.counter - 1].setCourseID(ID);
        teachers[Teacher.counter - 1].setNameCourse(name);
    }
}
