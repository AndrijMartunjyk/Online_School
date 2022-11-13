package online_school.repositories;

import online_school.courses.models.Models;

import java.util.Arrays;

public class TeacherRepository extends Repository {
    public Models[] teachers = new Models[1];

    public int teacherCounter() {
        int result = 0;
        for (Models teacher : teachers) {
            if (teacher == null) {
                break;
            } else {
                result = teacher.getCounter();
            }
        }
        return result;
    }

    public void magnificationOfArray() {
        teachers = Arrays.copyOf(teachers, (teachers.length * 3) / 2 + 1);
        System.out.format("Масив вчителів збільшено, довжина: %d об'єктів!!!\n", (teachers.length));
    }

    @Override
    public Models[] getAll() {
        return teachers;
    }

    @Override
    public void add(Models teacher) {
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

    @Override
    public void deleteByld(int idModels, Models[] models) {
        super.deleteByld(idModels, models);
    }

    public long getTeacherId() {
        return teachers[teacherCounter() - 1].getID();
    }

    public void setIdCourseOfTeacher(Long ID, String name) {
        teachers[teacherCounter() - 1].setCourseID(ID);
        teachers[teacherCounter() - 1].setNameCourse(name);
    }
}
