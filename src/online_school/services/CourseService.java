package online_school.services;

import online_school.courses.Course;
import online_school.courses.models.Lecture;
import online_school.courses.models.Student;
import online_school.courses.models.Teacher;

public class CourseService {
    public Course courseCreation() {
        return new Course();
    }

    public Course courseCreation(long ID, String name, Lecture lecture, Teacher teacher, Student student) {
        return new Course(ID, name, lecture, teacher, student);
    }
}
