package online_school;

import online_school.repositories.*;
import online_school.services.*;


import java.util.Scanner;

public class Main {
    private static String name;

    private static int number;
    public static Scanner scanner = new Scanner(System.in);
    private static final CourseRepository courseRepository = new CourseRepository();
    private static final CourseService courseService = new CourseService();
    private static final LectureRepository lectureRepository = new LectureRepository();
    private static final LectureService lectureService = new LectureService();
    private static final StudentRepository studentRepository = new StudentRepository();
    private static final StudentService studentService = new StudentService();
    private static final TeacherRepository teacherRepository = new TeacherRepository();
    private static final TeacherService teacherService = new TeacherService();

    public static void main(String[] args) {
        String lastName;

        System.out.println("========================\n\"РЕГІСТР НЕ ВАЖЛИВИЙ !!!\"");
        autoObject();
        System.out.println("Для виводу інфрмації про об'єкти окремо, введіть: \n\"Course info\"\n\"Lecture info\"\n\"Student info\"\n\"Teacher info\"");
        System.out.println("================================");
        System.out.println("Створіть об'єкт курсу, ввівши:\n\"Курс\"");
        System.out.println("================================\nДля завершення програми,\n введіть \"Stop\"\n========================");
        name = scanner.nextLine();

        boolean trueOrFalse = true;
        while (trueOrFalse) {
            if (name.equalsIgnoreCase("курс") || courseRepository.courseCounter() > 1 || name.equalsIgnoreCase("Course data")) {
                switch (name.toLowerCase()) {
                    case "курс" -> {
                        System.out.println(message() + "\"Курси\"");
                        numberEntry("курсу");
                        System.out.println("Введіть назву курсу:");
                        name = scanner.nextLine();
                        courseRepository.addCourse(courseService.courseCreation(number, name));
                        System.out.printf("Чудово, ви створили курс з назвою: \"%s\", і номером ID: \"%d\".\n", name, courseRepository.getCourseID());
                        System.out.println("Тепер створіть об'єкти ввівши:\n\"Лекція\".\n\"Студент\".\n\"Вчитель\".");
                        informCourse();
                        name = scanner.nextLine();
                    }
                    case "вчитель" -> {
                        System.out.println(message() + "\"Вчителі\"");
                        numberEntry("вчителя");
                        System.out.println("Введіть ім'я вчителя:");
                        name = scanner.nextLine();
                        System.out.println("Введіть прізвище вчителя:");
                        lastName = scanner.nextLine();
                        teacherService.setCourseCounter(courseRepository.courseCounter());
                        teacherRepository.addTeacher(teacherService.teacherCreation(number, name, lastName));
                        teacherRepository.setIdCourseOfTeacher(courseRepository.getCourseID(), courseRepository.getCourseName());
                        System.out.printf("Чудово, ви створили об'єкт вчителя з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n", name, lastName, teacherRepository.getTeacherId());
                        inform();
                        informCourse();
                        name = scanner.nextLine();
                    }
                    case "студент" -> {
                        System.out.println(message() + "\"Студенти\"");
                        numberEntry("студента");
                        System.out.println("Введіть ім'я студента:");
                        name = scanner.nextLine();
                        System.out.println("Введіть прізвище студента:");
                        lastName = scanner.nextLine();
                        studentService.setCourseCounter(courseRepository.courseCounter());
                        studentRepository.addStudent(studentService.studentCreation(number, name, lastName));
                        studentRepository.setIdCourseOfStudent(courseRepository.getCourseID(), courseRepository.getCourseName());
                        System.out.printf("Чудово, ви створили об'єкт студента з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n", name, lastName, studentRepository.getStudentId());
                        inform();
                        informCourse();
                        name = scanner.nextLine();
                    }
                    case "лекція" -> {
                        System.out.println(message() + "\"Лекції\"");
                        numberEntry("лекції");
                        System.out.println("Введіть назву лекції:");
                        name = scanner.nextLine();
                        lectureService.setCourseCounter(courseRepository.courseCounter());
                        lectureRepository.addLecture(lectureService.lectureCreation(number, name));
                        lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
                        System.out.printf("Чудово, ви створили лекцію з назвою: \"%s\", і номером ID: \"%d\".\n", name, lectureRepository.getLectureID());
                        inform();
                        informCourse();
                        name = scanner.nextLine();
                    }
                    case "course data" -> {
                        numberEntry("курсу");
                        courseService.informCourse(number, courseRepository.getCoursesArray());
                        lectureService.informLecturesCourse(number, lectureRepository.getLecturesArray());
                        studentService.informStudentsCourse(number, studentRepository.getStudentsArray());
                        teacherService.informTeachersCourse(number, teacherRepository.getTeachersArray());
                        border();
                        if (courseRepository.courseCounter() > 1) {
                            inform();
                        } else {
                            System.out.println("Створіть об'єкт курсу, ввівши: \"Курс\"");
                        }
                        name = scanner.nextLine();
                    }
                    case "course info" -> {
                        courseService.outId(courseRepository.getCoursesArray());
                        border();
                        inform();
                        name = scanner.nextLine();
                    }
                    case "lecture info" -> {
                        lectureService.outId(lectureRepository.getLecturesArray());
                        border();
                        inform();
                        name = scanner.nextLine();
                    }
                    case "student info" -> {
                        studentService.outId(studentRepository.getStudentsArray());
                        border();
                        inform();
                        name = scanner.nextLine();
                    }
                    case "teacher info" -> {
                        teacherService.outId(teacherRepository.getTeachersArray());
                        border();
                        inform();
                        name = scanner.nextLine();
                    }
                    case "stop" -> trueOrFalse = false;
                    default -> {
                        System.out.println("Не правильний ввід, спробуйте ще раз!!!");
                        name = scanner.nextLine();
                    }
                }
            } else {
                System.out.println("Спочатку введіть \"Курс\", або:");
                informCourse();
                name = scanner.nextLine();
            }
        }
        scanner.close();
        System.out.println("Програму завершено!!!");
    }

    public static void border() {
        System.out.println("===================================================================================================================================================");
    }

    public static void informCourse() {
        System.out.println("Для виводу всієї інфрмації про курс, введіть: \"Course data\" i ID курсу.");
    }

    public static void inform() {
        System.out.println("Можете продовжувати створювати студентів, вчителів, лекції або створіть новий курс.");
    }

    public static String message() {
        return "Ви вибрали: ";
    }

    public static void numberEntry(String outName) {
        boolean trueOrFalseCourse = true;
        while (trueOrFalseCourse) {
            System.out.println("Введіть ID " + outName + ", число більше 0:");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                if (number > 0) {
                    trueOrFalseCourse = false;
                }
            } else {
                System.out.println("Не правильний ввід, введіть число!!!");
                name = scanner.nextLine();
            }
        }
    }

    public static void autoObject() {
        courseRepository.addCourse(courseService.courseCreation(100, "Auto course"));
        for (int i = 1; i < 4; i++) {
            lectureRepository.addLecture(lectureService.lectureCreation(i, "No name"));
            lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
        }
        System.out.println("==========================================================================");
        System.out.println("Створено автоматичний курс з іменем \"Auto course\"\n з ID \"100\" і з трьома лекціями \"No name\".");
        informCourse();
        System.out.println("==========================================================================");

    }
}

