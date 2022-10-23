package online_school;

import online_school.courses.Course;
import online_school.courses.models.Lecture;
import online_school.courses.models.Student;
import online_school.courses.models.Teacher;
import online_school.services.CourseService;
import online_school.services.LectureService;
import online_school.services.StudentService;
import online_school.services.TeacherService;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static String message() {
        return "Ви вибрали категорію: ";
    }

    public static void main(String[] args) {

        System.out.println("Виберіть категорію:\nКурси\nВчителі\nСтуденти\nЛекції");
        System.out.println("========================\nДля завершення програми,\n введіть \"Stop\"\n========================");
        String name = scanner.nextLine();
        boolean trueOrFalse = true;

        while (trueOrFalse) {
            switch (name.toLowerCase()) {
                case "курси":
                    CourseService courseService = new CourseService();
                    Course course = courseService.courseCreation();
                    System.out.println(message() + "\"Курси\"");
                    System.out.println("ID course " + Course.getID());
                    System.out.println("ID lecture " + Lecture.getID());
                    System.out.println("ID teacher " + Teacher.getID());
                    System.out.println("ID student " + Student.getID());
                    name = scanner.nextLine();
                    break;
                case "вчителі":
                    TeacherService teacherService = new TeacherService();
                    Teacher teacher = teacherService.teacherCreation();
                    System.out.println(message() + "\"Вчителі\"");
                    System.out.println("ID course " + Course.getID());
                    System.out.println("ID lecture " + Lecture.getID());
                    System.out.println("ID teacher " + Teacher.getID());
                    System.out.println("ID student " + Student.getID());
                    name = scanner.nextLine();
                    break;
                case "студенти":
                    StudentService studentService = new StudentService();
                    Student student = studentService.studentCreation();
                    System.out.println(message() + "\"Студенти\"");
                    System.out.println("ID course " + Course.getID());
                    System.out.println("ID lecture " + Lecture.getID());
                    System.out.println("ID teacher " + Teacher.getID());
                    System.out.println("ID student " + Student.getID());
                    name = scanner.nextLine();
                    break;
                case "лекції":
                    LectureService lectureService = new LectureService();
                    Lecture lecture = lectureService.lectureCreation();
                    System.out.println(message() + "\"Лекції\"");
                    System.out.println("ID course " + Course.getID());
                    System.out.println("ID lecture " + Lecture.getID());
                    System.out.println("ID teacher " + Teacher.getID());
                    System.out.println("ID student " + Student.getID());
                    name = scanner.nextLine();
                    break;
                case "stop":
                    trueOrFalse = false;
                    break;
                default:
                    System.out.println("Не правильний ввід, спробуйте ще раз ");
                    name = scanner.nextLine();
                    break;
            }
        }
        scanner.close();
    }
}
