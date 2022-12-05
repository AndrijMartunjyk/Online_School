package online_school;

import online_school.course.model.Role;
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
    private static final HomeworkService homeworkService = new HomeworkService();


    public static void main(String[] args) {


        System.out.println("========================\n\"РЕГІСТР НЕ ВАЖЛИВИЙ !!!\"");
        mainService.autoObject(courseRepository, courseService, lectureRepository, lectureService);
        System.out.println("Для виводу інфрмації про всі об'єкти одного типу, введіть: \n\"Course info\"\n\"Lecture info\"\n\"Teacher info\"\n\"Student info\"\n\"Homework info\"");
        System.out.println("================================");
        System.out.println("Щоб видалити об'єкт введіть:\n\"Delete course\"\n\"Delete lecture\"\n\"Delete teacher\"\n\"Delete student\"\n\"Delete homework\"");
        System.out.println("==================================================");
        System.out.println("Щоб додати студента або вчителя до лекції введіть:\n\"Add\"");
        System.out.println("==================================================");
        System.out.println("Щоб додати домашнє завдання до лекції введіть:\n\"Homework\"");
        System.out.println("==================================================");
        System.out.println("Створіть об'єкт курсу, ввівши:\n\"Курс\"");
        System.out.println("================================\nДля завершення програми,\n введіть \"Stop\"\n========================");
        mainService.scannerNameModelAndPerson();

        boolean isPresent = true;
        while (isPresent) {
            if (mainService.getNameModelAndPerson().equalsIgnoreCase("курс") || courseRepository.counter() > 1 || mainService.getNameModelAndPerson().equalsIgnoreCase("Course data")) {
                switch (mainService.getNameModelAndPerson().toLowerCase()) {
                    case "курс" -> {
                        System.out.println(mainService.showJustMessage() + "\"Курс\"");
                        mainService.checkNumber("курсу");
                        System.out.println("Введіть назву курсу:");
                        mainService.scannerName();
                        courseRepository.add(courseService.createCourse(mainService.getCheckNumber(), mainService.getName()));
                        System.out.printf("Чудово, ви створили курс з назвою: \"%s\", і номером ID: \"%d\".\n", mainService.getName(), courseRepository.getCourseID());
                        System.out.println("Тепер створіть об'єкти ввівши:\n\"Лекція\".\n\"Студент\".\n\"Вчитель\".");
                        mainService.putBorder();
                        mainService.showInformCourseAndLecture();
                        mainService.putBorder();
                        mainService.scannerNameModelAndPerson();
                    }
                    case "лекція" -> {
                        System.out.println(mainService.showJustMessage() + "\"Лекція\"");
                        mainService.checkNumber("лекції");
                        System.out.println("Введіть назву лекції:");
                        mainService.scannerName();
                        mainService.scannerDescription();
                        lectureRepository.add(lectureService.createLecture(mainService.getCheckNumber(), mainService.getName(), mainService.getDescription()));
                        lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
                        System.out.printf("Чудово, ви створили лекцію з назвою: \"%s\", і номером ID: \"%d\".\n", mainService.getName(), lectureRepository.getLectureID());
                        mainService.putBorder();
                        mainService.showInformCourseAndLecture();
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "вчитель" -> {
                        System.out.println(mainService.showJustMessage() + "\"Вчитель\"");
                        mainService.checkNumber("вчителя");
                        System.out.println("Введіть ім'я вчителя:");
                        mainService.scannerFirstName();
                        System.out.println("Введіть прізвище вчителя:");
                        mainService.scannerLastName();
                        System.out.println("Введіть номер телефону вчителя:");
                        mainService.scannerPhone();
                        System.out.println("Введіть Email студента:");
                        mainService.scannerEmail();
                        teacherRepository.add(teacherService.createTeacher(Role.TEACHER, mainService.getCheckNumber(), mainService.getFirstname(), mainService.getLastName(), mainService.getPhone(), mainService.getEmail()));
                        System.out.printf("Чудово, ви створили об'єкт вчителя з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n", mainService.getFirstname(), mainService.getLastName(), teacherRepository.getTeacherId());
                        mainService.putBorder();
                        mainService.showInformCourseAndLecture();
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "студент" -> {
                        System.out.println(mainService.showJustMessage() + "\"Студент\"");
                        mainService.checkNumber("студента");
                        System.out.println("Введіть ім'я студента:");
                        mainService.scannerFirstName();
                        System.out.println("Введіть прізвище студента:");
                        mainService.scannerLastName();
                        System.out.println("Введіть номер телефону студента:");
                        mainService.scannerPhone();
                        System.out.println("Введіть Email студента:");
                        mainService.scannerEmail();
                        studentRepository.add(studentService.createStudent(Role.STUDENT, mainService.getCheckNumber(), mainService.getFirstname(),
                                mainService.getLastName(), mainService.getPhone(), mainService.getEmail()));
                        System.out.printf("Чудово, ви створили об'єкт студента з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n",
                                mainService.getFirstname(), mainService.getLastName(), studentRepository.getStudentId());
                        mainService.putBorder();
                        mainService.showInformCourseAndLecture();
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "homework" -> {
                        System.out.println(mainService.showJustMessage() + "\"Homework\" для лекції");
                        mainService.checkNumber("домашнього завдання");
                        long homeWorkId = mainService.getCheckNumber();
                        mainService.scannerHomeTask();
                        System.out.println("Виберіть лекцію якій хочете присвоїти домашне завдання.");
                        mainService.checkNumber("Лекції");
                        while (lectureRepository.getLecture(mainService.getCheckNumber(), lectureRepository.getLectureArray())) {
                            System.out.println("Немає такої лекції!!!\nВведіть ще раз.");
                            mainService.checkNumber("Лекції");
                        }
                        lectureRepository.addHomework(mainService.getCheckNumber(), homeworkService.createHomework(homeWorkId,
                                mainService.getCheckNumber(), mainService.getTask()));
                        mainService.putBorder();
                        mainService.showInformCourseAndLecture();
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "course data" -> {
                        mainService.checkNumber("курсу");
                        courseService.showInformCourse(mainService.getCheckNumber(), courseRepository.getCourseArray());
                        lectureService.showInformLecturesAndCourse(mainService.getCheckNumber(), lectureRepository.getLectureArray());
                        mainService.putBorder();
                        teacherRepository.showInformPerson(mainService.getCheckNumber(), lectureRepository.getLectureArray(),
                                teacherRepository.getTeacherArray());
                        mainService.putBorder();
                        studentRepository.showInformPerson(mainService.getCheckNumber(), lectureRepository.getLectureArray(),
                                studentRepository.getStudentArray());
                        mainService.putBorder();
                        if (courseRepository.counter() > 1) {
                            mainService.showInformAboutCreation();
                        } else {
                            System.out.println("Створіть об'єкт курсу, ввівши: \"Курс\"");
                            mainService.scannerNameModelAndPerson();
                        }
                    }
                    case "lecture data" -> {
                        mainService.checkNumber("Лекції");
                        lectureService.showInformLectures(mainService.getCheckNumber(), lectureRepository.getLectureArray());
                        mainService.putBorder();
                        teacherRepository.showInformPerson(mainService.getCheckNumber(), lectureRepository.getLectureArray(),
                                teacherRepository.getTeacherArray());
                        mainService.putBorder();
                        studentRepository.showInformPerson(mainService.getCheckNumber(), lectureRepository.getLectureArray(),
                                studentRepository.getStudentArray());
                        homeworkService.showInformHomework(mainService.getCheckNumber(), lectureRepository.getLectureArray());
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "course info" -> {
                        System.out.println("Інформація про всі курси:");
                        courseRepository.getCoursesArrayObject().showAllObject();
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "lecture info" -> {
                        System.out.println("Інформація про всі лекції:");
                        lectureRepository.getLecturesArrayObject().showAllObject();
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "teacher info" -> {
                        System.out.println("Інформація про всіх вчителів:");
                        teacherRepository.getTeachersArrayObject().showAllObject();
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "student info" -> {
                        System.out.println("Інформація про всіх студентів:");
                        studentRepository.getStudentsArrayObject().showAllObject();
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "homework info" -> {
                        System.out.println("Інформація про всі об'єкти Homework:");
                        lectureRepository.showAllHomework();
                        mainService.putBorder();
                        mainService.showInformAboutCreation();
                    }
                    case "delete course" -> {
                        mainService.checkNumber("Курсу");
                        courseRepository.deleteObject(mainService.getCheckNumber());
                        mainService.showInformAboutCreation();
                    }
                    case "delete lecture" -> {
                        mainService.checkNumber("Лекції");
                        lectureRepository.deleteObject(mainService.getCheckNumber());
                        mainService.showInformAboutCreation();
                    }
                    case "delete teacher" -> {
                        mainService.checkNumber("Вчителя");
                        teacherRepository.deleteObject(mainService.getCheckNumber());
                        mainService.showInformAboutCreation();
                    }
                    case "delete student" -> {
                        mainService.checkNumber("Студента");
                        studentRepository.deleteObject(mainService.getCheckNumber());
                        mainService.showInformAboutCreation();
                    }
                    case "delete homework" -> {
                        mainService.checkNumber("Домашнього завдання");
                        lectureRepository.deleteHomework(mainService.getCheckNumber());
                        mainService.showInformAboutCreation();
                    }
                    case "вчитель для лекції" -> {
                        System.out.println("Виберіть лекцію якій хочете присвоїти Вчителя.");
                        mainService.checkNumber("Лекції");
                        long lectureId;
                        if (lectureRepository.getLecture(mainService.getCheckNumber(), lectureRepository.getLectureArray())) {
                            System.out.println("Немає такої лекції");
                        } else {
                            lectureId = mainService.getCheckNumber();
                            System.out.printf("Є така лекція з номером ID \"%d\"\n", lectureId);
                            mainService.checkNumber("Вчителя");
                            while (teacherService.searchTeacher(mainService.getCheckNumber(), lectureId, lectureRepository.getLectureArray(),
                                    teacherRepository.getTeachersArrayObject())) {
                                System.out.println("Не має вчителя з таким ID !!!\nВведіть ще раз.");
                                mainService.checkNumber("Вчителя");
                            }
                        }
                        mainService.showInformCourseAndLecture();
                        mainService.showInformAboutCreation();
                    }
                    case "студент для лекції" -> {
                        System.out.println("Виберіть лекцію якій хочете присвоїти Студента.");
                        mainService.checkNumber("Лекції");
                        long lectureId;
                        if (lectureRepository.getLecture(mainService.getCheckNumber(), lectureRepository.getLectureArray())) {
                            System.out.println("Немає такої лекції");
                        } else {
                            lectureId = mainService.getCheckNumber();
                            System.out.printf("Є така лекція з номером ID \"%d\"\n", lectureId);
                            mainService.checkNumber("Студента");
                            while (studentService.searchStudent(mainService.getCheckNumber(), lectureId, lectureRepository.getLectureArray(),
                                    studentRepository.getStudentsArrayObject())) {
                                System.out.println("Не має студента з таким ID !!!\nВведіть ще раз.");
                                mainService.checkNumber("Студента");
                            }
                        }
                        mainService.showInformCourseAndLecture();
                        mainService.showInformAboutCreation();
                    }
                    case "add" -> {
                        System.out.println("Введіть кого хочете додати до лекції: \n\"Вчитель\"\n\"Студент\"");
                        mainService.scannerNameModelAndPerson();
                        if (mainService.getNameModelAndPerson().equalsIgnoreCase("вчитель")) {
                            mainService.setNameModelAndPerson("вчитель для лекції");
                        } else if (mainService.getNameModelAndPerson().equalsIgnoreCase("студент")) {
                            mainService.setNameModelAndPerson("студент для лекції");
                        } else {
                            System.out.println("Не правильний ввід, введіть \"Add\" ще раз, або");
                            mainService.showInformAboutCreation();
                        }
                    }
                    case "stop" -> isPresent = false;
                    default -> {
                        System.out.println("Не правильний ввід, спробуйте ще раз!!!");
                        mainService.scannerNameModelAndPerson();
                    }
                }
            } else {
                System.out.println("Спочатку введіть \"Курс\", або для виводу іформації про автоматичний курс, введіть\n\"Course data\"");
                mainService.putBorder();
                mainService.scannerNameModelAndPerson();
            }
        }
        mainService.getScanner().close();
        System.out.println("Програму завершено!!!");
    }
}

