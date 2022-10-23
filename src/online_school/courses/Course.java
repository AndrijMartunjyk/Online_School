package online_school.courses;

import online_school.courses.models.Lecture;
import online_school.courses.models.Student;
import online_school.courses.models.Teacher;
import online_school.services.LectureService;
import online_school.services.StudentService;
import online_school.services.TeacherService;

public class Course {
    private static int ID;
    private String nameCourse;
    private String startCourse;
    private String finishCourse;

    public Course() {
        ID++;
    }

    public Course(String nameCourse, String startCourse, String finishCourse) {
        this.nameCourse = nameCourse;
        this.startCourse = startCourse;
        this.finishCourse = finishCourse;
        ID++;
    }

    public static int getID() {
        return ID;
    }

    TeacherService teacherService = new TeacherService();
    LectureService lectureService = new LectureService();
    StudentService studentsService = new StudentService();

    Teacher teacher = teacherService.teacherCreation();
    Lecture lecture = lectureService.lectureCreation();
    Student student = studentsService.studentCreation();
}
