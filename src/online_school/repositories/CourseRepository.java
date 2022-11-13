package online_school.repositories;

import online_school.courses.models.Models;

import java.util.Arrays;

public class CourseRepository extends Repository {
    private Models[] courses = new Models[1];

    public int courseCounter() {
        int result = 0;
        for (Models course : courses) {
            if (course == null) {
                break;
            } else {
                result = course.getCounter();
            }
        }
        return result;
    }

    public void magnificationOfArray() {
        courses = Arrays.copyOf(courses, (courses.length * 3) / 2 + 1);
        System.out.format("Масив курсу збільшено, довжина: %d об'єктів!!!\n", (courses.length));
    }

    @Override
    public Models[] getAll() {
        return courses;
    }

    @Override
    public void add(Models course) {
        for (int i = 0; i < courses.length; i++) {
            if (courseCounter() - 1 == courses.length) {
                magnificationOfArray();
            } else if (courses[i] == null) {
                courses[i] = course;
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

    public long getCourseID() {
        return courses[courseCounter() - 1].getID();
    }

    public String getCourseName() {
        return courses[courseCounter() - 1].getName();
    }
}






