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
        LectureService lectureService = new LectureService();
        CourseService courseService = new CourseService();

        System.out.println("Виберіть категорію:\nКурс\nВчитель\nСтудент\nЛекція");
        System.out.println("========================\nДля завершення програми,\n введіть \"Stop\"\n========================");

        String name = scanner.nextLine();
        boolean trueOrFalse = true;

        while (trueOrFalse) {
            if (name.equalsIgnoreCase("курс")) {
                switch (name.toLowerCase()) {
                    case "курс":
                        if (Course.counter < 1) {
                            System.out.println(message() + "\"Курси\"");
                        }
                        boolean trueFalse = true;
                        while (trueFalse) {
                            System.out.println("Введіть ID, число більше 0:");
                            if (scanner.hasNextInt()) {
                                number = scanner.nextInt();
                                scanner.nextLine();
                                if (number > 0) {
                                    trueFalse = false;
                                }
                            } else {
                                System.out.println("Не правильний ввід, введіть число!!!");
                                name = scanner.nextLine();
                            }
                        }

                        System.out.println("Введіть ім'я курсу:");
                        name = scanner.nextLine();
                        courseRepository.arraysOfObjects();
                        CourseRepository.course[Course.counter] = courseService.courseCreation(number, name);
                        System.out.println("виберіть лекцію");
                        name=scanner.nextLine();
                        System.out.printf("Чудово, ви створили курс з назвою: \"%s\", і номером ID: \"%d\".\n", name, number);
                        System.out.println("Для виводу інфрмації про об'єкт введіть: \"Курс ID\"");

                        name = scanner.nextLine();
                        break;

                    case "вчитель":
                        TeacherService teacherService = new TeacherService();
                        Teacher teacher = teacherService.teacherCreation();
                        System.out.println(message() + "\"Вчителі\"");
                        System.out.println("ID course " + Course.counter);
                        System.out.println("ID lecture " + Lecture.counter);
                        System.out.println("ID teacher " + teacher.getID());
                        System.out.println("ID student " + Student.counter);
                        name = scanner.nextLine();
                        break;
                    case "студент":
                        StudentService studentService = new StudentService();
                        Student student = studentService.studentCreation();
                        System.out.println(message() + "\"Студенти\"");
                        System.out.println("ID course " + Course.counter);
                        System.out.println("ID lecture " + Lecture.counter);
                        System.out.println("ID teacher " + Teacher.counter);
                        System.out.println("ID student " + student.getID());
                        name = scanner.nextLine();
                        break;
                    case "лекція":
                        if (Lecture.counter < 1) {
                            System.out.println(message() + "\"Лекції\"");
                        }
                        boolean trueFalseLecture = true;
                        while (trueFalseLecture) {
                            System.out.println("Введіть ID, число більше 0:");
                            if (scanner.hasNextInt()) {
                                number = scanner.nextInt();
                                scanner.nextLine();
                                if (number > 0) {
                                    trueFalseLecture = false;
                                }
                            } else {
                                System.out.println("Не правильний ввід, введіть число!!!");
                                name = scanner.nextLine();
                            }
                        }

                        System.out.println("Введіть ім'я курсу:");
                        name = scanner.nextLine();
                        lectureRepository.arraysOfObjects();
                        LectureRepository.lectures[Lecture.counter] = lectureService.lectureCreation(number, name);
                        System.out.printf("Чудово, ви створили лекцію з назвою: \"%s\", і номером ID: \"%d\".\n", name, number);
                        System.out.println("Для виводу інфрмації про об'єкт введіть: \"Лекція ID\"");

                        name = scanner.nextLine();
                        break;
                    case "курс id":
                        courseService.outId();
                        name = scanner.nextLine();
                        break;
                    case "лекція id":
                        lectureService.outId();
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
            } else {
                System.out.println("Спочатку виберіть курс");
                name = scanner.nextLine();
            }

        }
        scanner.close();
        System.out.println("Програму завершено!!!");
    }
}

