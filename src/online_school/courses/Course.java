package online_school.courses;

import online_school.courses.models.Lecture;
import online_school.courses.models.Student;
import online_school.courses.models.Teacher;

public class Course {
    public static int counter;
    public long ID;
    private String nameCourse;
    private Lecture lecture;
    private Teacher teacher;
    private Student student;

    public Course() {
        ID = ++counter;
    }

    public Course(long ID, String nameCourse, Lecture lecture, Teacher teacher, Student student) {
        this.ID = ID + ++counter;
        this.nameCourse = nameCourse;
        this.lecture = lecture;
        this.teacher = teacher;
        this.student = student;
    }

    public long getID() {
        return ID;
    }
}
