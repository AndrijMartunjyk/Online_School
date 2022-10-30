package online_school;

import online_school.courses.Course;
import online_school.courses.models.Lecture;
import online_school.courses.models.Student;
import online_school.courses.models.Teacher;
import online_school.courses.repositories.CourseRepository;
import online_school.courses.repositories.LectureRepository;
import online_school.services.CourseService;
import online_school.services.LectureService;
import online_school.services.StudentService;
import online_school.services.TeacherService;

import java.util.Scanner;

public class Main {

    private static int number;
    public static Scanner scanner = new Scanner(System.in);

    public static String message() {
        return "Ви вибрали категорію: ";
    }

    public static void main(String[] args) {
//        Course course=new Course();
//
//        Lecture lecture = new Lecture();
//        lecture.setCourseId(course.getID());
        CourseRepository courseRepository = new CourseRepository();
        LectureRepository lectureRepository = new LectureRepository();
        CourseService courseService=new CourseService();

        System.out.println("Виберіть категорію:\nКурси\nВчителі\nСтуденти\nЛекції");
        System.out.println("========================\nДля завершення програми,\n введіть \"Stop\"\n========================");

        String name = scanner.nextLine();
        boolean trueOrFalse = true;

        while (trueOrFalse) {
            switch (name.toLowerCase()) {
                case "курси":
                    if (Course.counter < 1) {
                        System.out.println(message() + "\"Курси\"");
                        boolean trueFalse = true;
                        while (trueFalse) {
                            System.out.println("Введіть кількість курсів, число більше 0");
                            if (scanner.hasNextInt()) {
                                number = scanner.nextInt();
                                scanner.nextLine();
                                if (number > 0) {
                                    courseRepository.setNumber(number);
                                    trueFalse = false;
                                }
                            } else {
                                System.out.println("Не правильний ввід, введіть число!!!");
                                name = scanner.nextLine();
                            }
                        }
                        System.out.format("Чудово, ви створили масив Курсів довжиною: %d об'єктів !!!", number);
                        System.out.println();
                    }
                    courseRepository.arraysOfObjects(Course.counter);
                    if (Course.counter < 1) {
                        for (int i = 0; i < number; i++) {
                            courseRepository.objects();
                        }
                    } else {
                        courseRepository.objects();
                    }


//                    System.out.println("ID course " + Course.counter);
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
                    if (Lecture.counter < 1) {
                        System.out.println(message() + "\"Лекції\"");
                        boolean trueFalse = true;
                        while (trueFalse) {
                            System.out.println("Введіть кількість лекцій, число більше 0");
                            if (scanner.hasNextInt()) {
                                number = scanner.nextInt();
                                scanner.nextLine();
                                if (number > 0) {
                                    lectureRepository.setNumber(number);
                                    trueFalse = false;
                                }
                            } else {
                                System.out.println("Не правильний ввід, введіть число!!!");
                                name = scanner.nextLine();
                            }
                        }
                        System.out.format("Чудово, ви створили масив Лекцій довжиною: %d об'єктів !!!", number);
                        System.out.println();
                    }
                    lectureRepository.arraysOfObjects(Lecture.counter);
                    if (Lecture.counter < 1) {
                        for (int i = 0; i < number; i++) {
                            lectureRepository.objects();
                        }
                    } else {
                        lectureRepository.objects();
                    }

                    System.out.println("ID course " + Course.counter);
                    System.out.println("ID lecture " + Lecture.counter);
                    System.out.println("ID teacher " + Teacher.counter);
                    System.out.println("ID student " + Student.counter);
                    name = scanner.nextLine();
                    break;
                case "курс id":
                    courseService.outId();
                    name = scanner.nextLine();
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

