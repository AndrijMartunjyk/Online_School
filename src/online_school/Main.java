package online_school;

import online_school.repositories.*;
import online_school.services.*;

public class Main {
    private static final CourseRepository courseRepository = new CourseRepository();
    private static final CourseService courseService = new CourseService();
    private static final LectureRepository lectureRepository = new LectureRepository();
    private static final LectureService lectureService = new LectureService();
    private static final StudentRepository studentRepository = new StudentRepository();
    private static final StudentService studentService = new StudentService();
    private static final TeacherRepository teacherRepository = new TeacherRepository();
    private static final TeacherService teacherService = new TeacherService();
    private static final MainService mainService = new MainService();

    public static void main(String[] args) {


        System.out.println("========================\n\"РЕГІСТР НЕ ВАЖЛИВИЙ !!!\"");
        mainService.autoObject(courseRepository, courseService, lectureRepository, lectureService);
        System.out.println("Для виводу інфрмації про всі об'єкти одного типу, введіть: \n\"Course info\"\n\"Lecture info\"\n\"Student info\"\n\"Teacher info\"");
        System.out.println("=====================================================");
        System.out.println("Для виводу інфрмації про конкретний об'єкт, введіть: \n\"Show course\"\n\"Show lecture\"\n\"Show teacher\"\n\"Show student\"");
        System.out.println("================================");
        System.out.println("Щоб видалити об'єкт введіть:\n\"Delete course\"\n\"Delete lecture\"\n\"Delete teacher\"\n\"Delete student\"");
        System.out.println("================================");
        System.out.println("Створіть об'єкт курсу, ввівши:\n\"Курс\"");
        System.out.println("================================\nДля завершення програми,\n введіть \"Stop\"\n========================");
        mainService.scannerName();

        boolean trueOrFalse = true;
        while (trueOrFalse) {
            if (mainService.getName().equalsIgnoreCase("курс") || courseRepository.courseCounter() > 1 || mainService.getName().equalsIgnoreCase("Course data")) {
                switch (mainService.getName().toLowerCase()) {
                    case "курс" -> {
                        System.out.println(mainService.message() + "\"Курси\"");
                        mainService.numberEntry("курсу");
                        System.out.println("Введіть назву курсу:");
                        mainService.scannerName();
                        courseRepository.add(courseService.courseCreation(mainService.getNumber(), mainService.getName()));
                        System.out.printf("Чудово, ви створили курс з назвою: \"%s\", і номером ID: \"%d\".\n", mainService.getName(), courseRepository.getCourseID());
                        System.out.println("Тепер створіть об'єкти ввівши:\n\"Лекція\".\n\"Студент\".\n\"Вчитель\".");
                        mainService.informCourse();
                        mainService.scannerName();
                    }
                    case "вчитель" -> {
                        System.out.println(mainService.message() + "\"Вчителі\"");
                        mainService.numberEntry("вчителя");
                        System.out.println("Введіть ім'я вчителя:");
                        mainService.scannerName();
                        System.out.println("Введіть прізвище вчителя:");
                        mainService.scannerLastName();
                        teacherRepository.add(teacherService.teacherCreation(mainService.getNumber(), mainService.getName(), mainService.getLastName()));
                        teacherRepository.setIdCourseOfTeacher(courseRepository.getCourseID(), courseRepository.getCourseName());
                        System.out.printf("Чудово, ви створили об'єкт вчителя з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n", mainService.getName(), mainService.getLastName(), teacherRepository.getTeacherId());
                        mainService.informCourse();
                        mainService.inform();
                    }
                    case "студент" -> {
                        System.out.println(mainService.message() + "\"Студенти\"");
                        mainService.numberEntry("студента");
                        System.out.println("Введіть ім'я студента:");
                        mainService.scannerName();
                        System.out.println("Введіть прізвище студента:");
                        mainService.scannerLastName();
                        studentRepository.add(studentService.studentCreation(mainService.getNumber(), mainService.getName(), mainService.getLastName()));
                        studentRepository.setIdCourseOfStudent(courseRepository.getCourseID(), courseRepository.getCourseName());
                        System.out.printf("Чудово, ви створили об'єкт студента з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n", mainService.getName(), mainService.getLastName(), studentRepository.getStudentId());
                        mainService.informCourse();
                        mainService.inform();
                    }
                    case "лекція" -> {
                        System.out.println(mainService.message() + "\"Лекції\"");
                        mainService.numberEntry("лекції");
                        System.out.println("Введіть назву лекції:");
                        mainService.scannerName();
                        lectureRepository.add(lectureService.lectureCreation(mainService.getNumber(), mainService.getName()));
                        lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
                        System.out.printf("Чудово, ви створили лекцію з назвою: \"%s\", і номером ID: \"%d\".\n", mainService.getName(), lectureRepository.getLectureID());
                        mainService.informCourse();
                        mainService.inform();
                    }
                    case "course data" -> {
                        mainService.numberEntry("курсу");
                        courseService.informCourse(mainService.getNumber(), courseRepository.getAll());
                        lectureService.informLecturesCourse(mainService.getNumber(), lectureRepository.getAll());
                        studentService.informStudentsCourse(mainService.getNumber(), studentRepository.getAll());
                        teacherService.informTeachersCourse(mainService.getNumber(), teacherRepository.getAll());
                        mainService.border();
                        if (courseRepository.courseCounter() > 1) {
                            mainService.inform();
                        } else {
                            System.out.println("Створіть об'єкт курсу, ввівши: \"Курс\"");
                            mainService.scannerName();
                        }

                    }
                    case "course info" -> {
                        courseService.outId(courseRepository.getAll());
                        mainService.border();
                        mainService.inform();
                    }
                    case "lecture info" -> {
                        lectureService.outId(lectureRepository.getAll());
                        mainService.border();
                        mainService.inform();
                    }
                    case "student info" -> {
                        studentService.outId(studentRepository.getAll());
                        mainService.border();
                        mainService.inform();
                    }
                    case "teacher info" -> {
                        teacherService.outId(teacherRepository.getAll());
                        mainService.border();
                        mainService.inform();
                    }
                    case "show course" -> {
                        mainService.numberEntry("Курсу");
                        System.out.println("Inform => " + courseRepository.getByld(mainService.getNumber(), courseRepository.getAll()));
                        mainService.inform();
                    }
                    case "show lecture" -> {
                        mainService.numberEntry("Лекції");
                        System.out.println("Inform => " + lectureRepository.getByld(mainService.getNumber(), lectureRepository.getAll()));
                        mainService.inform();
                    }
                    case "show teacher" -> {
                        mainService.numberEntry("Вчителя");
                        System.out.println("Inform => " + teacherRepository.getByld(mainService.getNumber(), teacherRepository.getAll()));
                        mainService.inform();
                    }
                    case "show student" -> {
                        mainService.numberEntry("Студента");
                        System.out.println("Inform => " + studentRepository.getByld(mainService.getNumber(), studentRepository.getAll()));
                        mainService.inform();
                    }
                    case "delete course" -> {
                        mainService.numberEntry("Курсу");
                        courseRepository.deleteByld(mainService.getNumber(), courseRepository.getAll());
                        mainService.inform();
                    }
                    case "delete lecture" -> {
                        mainService.numberEntry("Лекції");
                        lectureRepository.deleteByld(mainService.getNumber(), lectureRepository.getAll());
                        mainService.inform();
                    }
                    case "delete teacher" -> {
                        mainService.numberEntry("Вчителя");
                        teacherRepository.deleteByld(mainService.getNumber(), courseRepository.getAll());
                        mainService.inform();
                    }
                    case "delete student" -> {
                        mainService.numberEntry("Студента");
                        studentRepository.deleteByld(mainService.getNumber(), teacherRepository.getAll());
                        mainService.inform();
                    }
                    case "stop" -> trueOrFalse = false;
                    default -> {
                        System.out.println("Не правильний ввід, спробуйте ще раз!!!");
                        mainService.scannerName();
                    }
                }
            } else {
                System.out.println("Спочатку введіть \"Курс\", або:");
                mainService.informCourse();
                mainService.scannerName();
            }
        }
        System.out.println("Програму завершено!!!");
    }
}

