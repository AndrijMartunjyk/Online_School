package online_school;

import online_school.courses.Course;
import online_school.courses.models.Lecture;
import online_school.courses.models.Student;
import online_school.courses.models.Teacher;
import online_school.courses.repositories.CourseRepository;
import online_school.services.CourseService;
import online_school.services.LectureService;
import online_school.services.StudentService;
import online_school.services.TeacherService;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static int number;
    public static Scanner scanner = new Scanner(System.in);

    public static String message() {
        return "Ви вибрали категорію: ";
    }

    public static void main(String[] args) {
//        Course course=new Course();
        Lecture lecture = new Lecture();
//        lecture.setCourseId(course.getID());
        CourseRepository courseRepository=new CourseRepository();


        System.out.println("Виберіть категорію:\nКурси\nВчителі\nСтуденти\nЛекції");
        System.out.println("========================\nДля завершення програми,\n введіть \"Stop\"\n========================");

        String name = scanner.nextLine();
        boolean trueOrFalse = true;

        while (trueOrFalse) {
            switch (name.toLowerCase()) {
                case "курси":
                    System.out.println(message() + "\"Курси\"");
                    if (Course.counter<1){
                        System.out.println("введіть кількість курсів");
                        number = scanner.nextInt();
                        scanner.nextLine();
                    }
                    System.out.println("перед" + Course.counter);

                    courseRepository.setYes(number);


//
                    System.out.println("ID course " + Course.counter);
//                    System.out.println("ID lecture " + Lecture.counter);
//                    System.out.println("ID teacher " + Teacher.counter);
//                    System.out.println("ID student " + Student.counter);

                    name = scanner.nextLine();
                    break;
                case "вчителі":
                    TeacherService teacherService = new TeacherService();
                    Teacher teacher = teacherService.teacherCreation();
                    System.out.println(message() + "\"Вчителі\"");
                    System.out.println("ID course " + Course.counter);
                    System.out.println("ID lecture " + Lecture.counter);
                    System.out.println("ID teacher " + teacher.getID());
                    System.out.println("ID student " + Student.counter);
                    name = scanner.nextLine();
                    break;
                case "студенти":
                    StudentService studentService = new StudentService();
                    Student student = studentService.studentCreation();
                    System.out.println(message() + "\"Студенти\"");
                    System.out.println("ID course " + Course.counter);
                    System.out.println("ID lecture " + Lecture.counter);
                    System.out.println("ID teacher " + Teacher.counter);
                    System.out.println("ID student " + student.getID());
                    name = scanner.nextLine();
                    break;
                case "лекції":
                    LectureService lectureService = new LectureService();
//                    Lecture lecture = lectureService.lectureCreation();
                    System.out.println(message() + "\"Лекції\"");
                    System.out.println("ID course " + Course.counter);
                    System.out.println("ID lecture " + lecture.getID());
                    System.out.println("ID teacher " + Teacher.counter);
                    System.out.println("ID student " + Student.counter);
                    if (lecture.getID() < 8) {

                        name = scanner.nextLine();
                    } else {
                        name = "stop";
                    }
                    break;
                case "stop":
                    trueOrFalse = false;
                    break;
                default:
                    System.out.println("Не правильний ввід, спробуйте ще раз!!!");
                    name = scanner.nextLine();
                    break;
            }
        }
        scanner.close();
        System.out.println("Програму завершено!!!");
    }
}

