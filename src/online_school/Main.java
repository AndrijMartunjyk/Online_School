package online_school;

import online_school.course.model.Models;
import online_school.enum_enum.Role;
import online_school.repositorie.*;
import online_school.service.*;

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
        System.out.println("Для виводу інфрмації про всі об'єкти одного типу, введіть: \n\"Course info\"\n\"Lecture info\"\n\"Teacher info\"\n\"Student info\"");
        System.out.println("=====================================================");
        System.out.println("Для виводу інфрмації про конкретний об'єкт, введіть: \n\"Show course\"\n\"Show lecture\"\n\"Show teacher\"\n\"Show student\"");
        System.out.println("================================");
        System.out.println("Щоб видалити об'єкт введіть:\n\"Delete course\"\n\"Delete lecture\"\n\"Delete teacher\"\n\"Delete student\"");
        System.out.println("=========================================");
        System.out.println("Щоб додати студента або вчителя введіть:\n\"Add\"");
        System.out.println("=========================================");
        System.out.println("Створіть об'єкт курсу, ввівши:\n\"Курс\"");
        System.out.println("================================\nДля завершення програми,\n введіть \"Stop\"\n========================");
        mainService.scannerName();

        boolean trueOrFalse = true;
        while (trueOrFalse) {
            if (mainService.getName().equalsIgnoreCase("курс") || courseRepository.courseCounter() > 1 || mainService.getName().equalsIgnoreCase("Course data")) {
                switch (mainService.lists()) {
                    case COURSE -> {
                        System.out.println(mainService.message() + "\"Курси\"");
                        mainService.numberEntry("курсу");
                        System.out.println("Введіть назву курсу:");
                        mainService.scannerName();
                        courseRepository.add(courseService.courseCreation(mainService.getNumber(), mainService.getName()));
                        System.out.printf("Чудово, ви створили курс з назвою: \"%s\", і номером ID: \"%d\".\n", mainService.getName(), courseRepository.getCourseID());
                        System.out.println("Тепер створіть об'єкти ввівши:\n\"Лекція\".\n\"Студент\".\n\"Вчитель\".");
                        mainService.border();
                        mainService.informCourse();
                        mainService.border();
                        mainService.scannerName();
                    }
                    case LECTURE -> {
                        System.out.println(mainService.message() + "\"Лекції\"");
                        mainService.numberEntry("лекції");
                        System.out.println("Введіть назву лекції:");
                        mainService.scannerName();
                        lectureRepository.add(lectureService.lectureCreation(mainService.getNumber(), mainService.getName()));
                        lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
                        System.out.printf("Чудово, ви створили лекцію з назвою: \"%s\", і номером ID: \"%d\".\n", mainService.getName(), lectureRepository.getLectureID());
                        mainService.border();
                        mainService.informCourse();
                        mainService.border();
                        mainService.inform();
                    }
                    case TEACHER -> {
                        System.out.println(mainService.message() + "\"Вчителі\"");
                        mainService.numberEntry("вчителя");
                        System.out.println("Введіть ім'я вчителя:");
                        mainService.scannerName();
                        System.out.println("Введіть прізвище вчителя:");
                        mainService.scannerLastName();
                        teacherRepository.add(teacherService.teacherCreation(Role.TEACHER, mainService.getNumber(), mainService.getName(), mainService.getLastName()));
                        System.out.printf("Чудово, ви створили об'єкт вчителя з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n", mainService.getName(), mainService.getLastName(), teacherRepository.getTeacherId());
                        mainService.border();
                        mainService.informCourse();
                        mainService.border();
                        mainService.inform();
                    }
                    case STUDENT -> {
                        System.out.println(mainService.message() + "\"Студенти\"");
                        mainService.numberEntry("студента");
                        System.out.println("Введіть ім'я студента:");
                        mainService.scannerName();
                        System.out.println("Введіть прізвище студента:");
                        mainService.scannerLastName();
                        studentRepository.add(studentService.studentCreation(Role.STUDENT, mainService.getNumber(), mainService.getName(), mainService.getLastName()));
                        System.out.printf("Чудово, ви створили об'єкт студента з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n", mainService.getName(), mainService.getLastName(), studentRepository.getStudentId());
                        mainService.border();
                        mainService.informCourse();
                        mainService.border();
                        mainService.inform();
                    }
                    case COURSE_DATA -> {
                        mainService.numberEntry("курсу");
                        courseService.informCourse(mainService.getNumber(), courseRepository.getAll());
                        lectureService.informLecturesCourse(mainService.getNumber(), lectureRepository.getAll());
                        mainService.border();
                        teacherService.informPersonCourse(mainService.getNumber(), lectureRepository.getAll(), teacherRepository.getAll());
                        mainService.border();
                        studentService.informPersonCourse(mainService.getNumber(), lectureRepository.getAll(), studentRepository.getAll());
                        mainService.border();
                        if (courseRepository.courseCounter() > 1) {
                            mainService.inform();
                        } else {
                            System.out.println("Створіть об'єкт курсу, ввівши: \"Курс\"");
                            mainService.scannerName();
                        }
                    }
                    case LECTURE_DATA -> {
                        mainService.numberEntry("Лекції");
                        lectureService.informLectures(mainService.getNumber(), lectureRepository.getAll());
                        mainService.border();
                        teacherService.informPersonLecture(mainService.getNumber(), lectureRepository.getAll(), teacherRepository.getAll());
                        mainService.border();
                        studentService.informPersonLecture(mainService.getNumber(), lectureRepository.getAll(), studentRepository.getAll());
                        mainService.border();
                        mainService.inform();
                    }
                    case COURSE_INFO -> {
                        courseService.outId(courseRepository.getAll());
                        mainService.border();
                        mainService.inform();
                    }
                    case LECTURE_INFO -> {
                        lectureService.outId(lectureRepository.getAll());
                        mainService.border();
                        mainService.inform();
                    }
                    case STUDENT_INFO -> {
                        studentService.outId(studentRepository.getAll());
                        mainService.border();
                        mainService.inform();
                    }
                    case TEACHER_INFO -> {
                        teacherService.outId(teacherRepository.getAll());
                        mainService.border();
                        mainService.inform();
                    }
                    case SHOW_COURSE -> {
                        mainService.numberEntry("Курсу");
                        System.out.println("Inform => " + courseRepository.getByld(mainService.getNumber(), courseRepository.getAll()));
                        mainService.inform();
                    }
                    case SHOW_LECTURE -> {
                        mainService.numberEntry("Лекції");
                        System.out.println("Inform => " + lectureRepository.getByld(mainService.getNumber(), lectureRepository.getAll()));
                        mainService.inform();
                    }
                    case SHOW_TEACHER -> {
                        mainService.numberEntry("Вчителя");
                        System.out.println("Inform => " + teacherRepository.getByld(mainService.getNumber(), teacherRepository.getAll()));
                        mainService.inform();
                    }
                    case SHOW_STUDENT -> {
                        mainService.numberEntry("Студента");
                        System.out.println("Inform => " + studentRepository.getByld(mainService.getNumber(), studentRepository.getAll()));
                        mainService.inform();
                    }
                    case DELETE_COURSE -> {
                        mainService.numberEntry("Курсу");
                        courseRepository.deleteByld(mainService.getNumber(), courseRepository.getAll());
                        mainService.inform();
                    }
                    case DELETE_LECTURE -> {
                        mainService.numberEntry("Лекції");
                        lectureRepository.deleteByld(mainService.getNumber(), lectureRepository.getAll());
                        mainService.inform();
                    }
                    case DELETE_TEACHER -> {
                        mainService.numberEntry("Вчителя");
                        teacherRepository.deleteByld(mainService.getNumber(), teacherRepository.getAll());
                        mainService.inform();
                    }
                    case DELETE_STUDENT -> {
                        mainService.numberEntry("Студента");
                        studentRepository.deleteByld(mainService.getNumber(), studentRepository.getAll());
                        mainService.inform();
                    }
                    case TEACHER_FOR_LECTURE -> {
                        System.out.println("Виберіть лекцію якій хочете присвоїти Вчителя.");
                        mainService.numberEntry("Лекції");
                        int lectureId;
                        Models lecture = lectureRepository.getByld(mainService.getNumber(), lectureRepository.getAll());
                        if (lecture == null) {
                            System.out.println("Немає такої лекції");
                        } else {
                            lectureId = mainService.getNumber();
                            System.out.println("Є така лекція з номером ID " + lecture.getID());
                            mainService.numberEntry("Вчителя");
                            teacherRepository.searchTeacher(mainService.getNumber(), lectureId, lectureRepository.getAll());
                        }
                        mainService.inform();
                    }
                    case STUDENT_FOR_LECTURE -> {
                        System.out.println("Виберіть лекцію якій хочете присвоїти Студента.");
                        mainService.numberEntry("Лекції");
                        int lectureId;
                        Models lecture = lectureRepository.getByld(mainService.getNumber(), lectureRepository.getAll());
                        if (lecture == null) {
                            System.out.println("Немає такої лекції");
                        } else {
                            lectureId = mainService.getNumber();
                            System.out.println("Є така лекція з номером ID " + lecture.getID());
                            mainService.numberEntry("Студента");
                            studentRepository.searchStudent(mainService.getNumber(), lectureId, lectureRepository.getAll());
                        }
                        mainService.inform();
                    }
                    case ADD -> {
                        System.out.println("Введіть кого хочете додати: \n\"Вчитель\"\n\"Студент\"");
                        mainService.scannerName();
                        if (mainService.getName().equalsIgnoreCase("вчитель")) {
                            mainService.setName("вчитель для лекції");
                        } else if (mainService.getName().equalsIgnoreCase("студент")) {
                            mainService.setName("студент для лекції");
                        } else {
                            System.out.println("Не правильне введеняя, введіть \"Add\" ще раз, або");
                            mainService.inform();
                        }
                    }
                    case STOP -> trueOrFalse = false;
                    default -> {
                        System.out.println("Не правильний ввід, спробуйте ще раз!!!");
                        mainService.scannerName();
                    }
                }
            } else {
                System.out.println("Спочатку введіть \"Курс\", або для виводу іформації про автоматичний курс, введіть\n\"Course data\"");
                mainService.border();
                mainService.scannerName();
            }
        }
        System.out.println("Програму завершено!!!");
    }
}

