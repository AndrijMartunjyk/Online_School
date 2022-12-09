package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Role;
import online_school.repositorie.CourseRepository;
import online_school.repositorie.LectureRepository;
import online_school.repositorie.StudentRepository;
import online_school.repositorie.TeacherRepository;

import java.util.Scanner;

import static online_school.course.model.RegularExpression.*;

public class MainService {
    private final Scanner scanner = new Scanner(System.in);
    private static final CourseRepository courseRepository = new CourseRepository();
    private static final CourseService courseService = new CourseService();
    private static final LectureRepository lectureRepository = new LectureRepository();
    private static final LectureService lectureService = new LectureService();
    private static final StudentRepository studentRepository = new StudentRepository();
    private static final StudentService studentService = new StudentService();
    private static final TeacherRepository teacherRepository = new TeacherRepository();
    private static final TeacherService teacherService = new TeacherService();
    private static final HomeworkService homeworkService = new HomeworkService();

    private long number;
    private String name;
    private String nameModelAndPerson;
    private String description;
    private String firstname;
    private String lastName;
    private String phone;
    private String email;
    private String task;
    private final String course = "курсу";
    private final String lecture = "лекції";
    private final String student = "студента";
    private final String teacher = "вчителя";
    private final String homework = "Домашнього завдання";
    private final String stringIncorrect = "String is incorrect!!!";

    public void autoObject(CourseRepository courseRepository, CourseService courseService, LectureRepository lectureRepository,
                           LectureService lectureService) {
        courseRepository.add(courseService.createCourse(1, "Auto course"));
        for (int i = 1; i < 4; i++) {
            lectureRepository.add(lectureService.createLecture(i, "No name", "No description"));
            lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
        }
        System.out.println("==========================================================================");
        System.out.printf("Створено автоматичний курс з іменем \"Auto course\"\n з ID \"%d\" і з трьома лекціями \"No name\".\n",
                courseRepository.getCourseArray()[0].getCourseId());
        System.out.println("==========================================================================");
        System.out.println("Для виводу всієї інфрмації про курс, введіть: \n\"Course data\"");
        System.out.println("==========================================================================");
    }

    public void showInform() {
        System.out.println("========================\n\"РЕГІСТР НЕ ВАЖЛИВИЙ !!!\"");
        autoObject(courseRepository, courseService, lectureRepository, lectureService);
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
        scannerNameModelAndPerson();
    }

    public void creatCourse() {
        System.out.println(showJustMessage() + "\"Курс\"");
        checkNumber(course);
        System.out.println("Введіть назву курсу:");
        scannerName();
        courseRepository.add(courseService.createCourse(getCheckNumber(), getName()));
        System.out.printf("Чудово, ви створили курс з назвою: \"%s\", і номером ID: \"%d\".\n", getName(), courseRepository.getCourseID());
        System.out.println("Тепер створіть об'єкти ввівши:\n\"Лекція\".\n\"Студент\".\n\"Вчитель\".");
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        scannerNameModelAndPerson();
    }

    public void creatLecture() {
        System.out.println(showJustMessage() + "\"Лекція\"");
        checkNumber(lecture);
        System.out.println("Введіть назву лекції:");
        scannerName();
        scannerDescription();
        lectureRepository.add(lectureService.createLecture(getCheckNumber(), getName(), getDescription()));
        lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
        System.out.printf("Чудово, ви створили лекцію з назвою: \"%s\", і номером ID: \"%d\".\n", getName(), lectureRepository.getLectureID());
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
    }

    public void creatStudent() {
        System.out.println(showJustMessage() + "\"Студент\"");
        checkNumber(student);
        System.out.println("Введіть ім'я студента:");
        scannerFirstName();
        System.out.println("Введіть прізвище студента:");
        scannerLastName();
        System.out.println("Введіть номер телефону студента:");
        scannerPhone();
        System.out.println("Введіть Email студента:");
        scannerEmail();
        studentRepository.add(studentService.createStudent(Role.STUDENT, getCheckNumber(), getFirstname(),
                getLastName(), getPhone(), getEmail()));
        System.out.printf("Чудово, ви створили об'єкт студента з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n",
                getFirstname(), getLastName(), studentRepository.getStudentId());
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
    }

    public void creatTeacher() {
        System.out.println(showJustMessage() + "\"Вчитель\"");
        checkNumber(teacher);
        System.out.println("Введіть ім'я вчителя:");
        scannerFirstName();
        System.out.println("Введіть прізвище вчителя:");
        scannerLastName();
        System.out.println("Введіть номер телефону вчителя:");
        scannerPhone();
        System.out.println("Введіть Email вчителя:");
        scannerEmail();
        teacherRepository.add(teacherService.createTeacher(Role.TEACHER, getCheckNumber(), getFirstname(), getLastName(), getPhone(), getEmail()));
        System.out.printf("Чудово, ви створили об'єкт вчителя з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n", getFirstname(),
                getLastName(), teacherRepository.getTeacherId());
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
    }

    public void creatHomework() {
        System.out.println(showJustMessage() + "\"Homework\" для лекції");
        checkNumber(homework);
        long homeWorkId = getCheckNumber();
        scannerHomeTask();
        System.out.println("Виберіть лекцію якій хочете присвоїти домашне завдання.");
        checkNumber(lecture);
        lectureRepository.getLecture(getCheckNumber(), lectureRepository.getLectureArray());
        checkNumber(lecture);
        lectureRepository.addHomework(getCheckNumber(), homeworkService.createHomework(homeWorkId,
                getCheckNumber(), getTask()));
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
    }

    public void creatCourseData() {
        checkNumber(course);
        try {
            courseService.showInformCourse(getCheckNumber(), courseRepository.getCourseArray());
            lectureService.showLecturesInCourse(getCheckNumber(), lectureRepository.getLectureArray());
            putBorder();
            teacherRepository.showInformPerson(getCheckNumber(), lectureRepository.getLectureArray(),
                    teacherRepository.getTeacherArray());
            putBorder();
            studentRepository.showInformPerson(getCheckNumber(), lectureRepository.getLectureArray(),
                    studentRepository.getStudentArray());
        } catch (NullPointerException | EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            putBorder();
            if (courseRepository.counter() > 1) {
                showInformAboutCreation();
            } else {
                System.out.println("Створіть об'єкт курсу, ввівши: \"Курс\"");
                scannerNameModelAndPerson();
            }
        }
    }

    public void creatLectureData() {
        checkNumber(lecture);
        try {
            lectureService.showLectures(getCheckNumber(), lectureRepository.getLectureArray());
            putBorder();
            teacherRepository.showInformPerson(getCheckNumber(), lectureRepository.getLectureArray(),
                    teacherRepository.getTeacherArray());
            putBorder();
            studentRepository.showInformPerson(getCheckNumber(), lectureRepository.getLectureArray(),
                    studentRepository.getStudentArray());
            homeworkService.showInformHomework(getCheckNumber(), lectureRepository.getLectureArray());
        } catch (NullPointerException | EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            putBorder();
            showInformAboutCreation();
        }
    }

    public void creatCourseInfo() {
        System.out.println("Інформація про всі курси:");
        courseRepository.getCoursesArrayObject().showAllObject();
        putBorder();
        showInformAboutCreation();
    }

    public void createLectureInfo() {
        System.out.println("Інформація про всі лекції:");
        lectureRepository.getLecturesArrayObject().showAllObject();
        putBorder();
        showInformAboutCreation();
    }

    public void creatTeacherInfo() {
        System.out.println("Інформація про всіх вчителів:");
        teacherRepository.getTeachersArrayObject().showAllObject();
        putBorder();
        showInformAboutCreation();
    }

    public void creatStudentInfo() {
        System.out.println("Інформація про всіх студентів:");
        studentRepository.getStudentsArrayObject().showAllObject();
        putBorder();
        showInformAboutCreation();
    }

    public void creatHomeworkInfo() {
        System.out.println("Інформація про всі об'єкти Homework:");
        lectureRepository.showAllHomework();
        putBorder();
        showInformAboutCreation();
    }

    public void creatDeleteCourse() {
        checkNumber(course);
        try {
            courseRepository.deleteCourse(getCheckNumber());
        } catch (NullPointerException | EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            showInformAboutCreation();
        }
    }

    public void creatDeleteLecture() {
        checkNumber(lecture);
        try {
            lectureRepository.deleteLecture(getCheckNumber());
        } catch (NullPointerException | EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            showInformAboutCreation();
        }
    }

    public void creatDeleteTeacher() {
        checkNumber(teacher);
        try {
            teacherRepository.deleteTeacher(getCheckNumber());
        } catch (NullPointerException | EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            showInformAboutCreation();
        }
    }

    public void creatDeleteStudent() {
        checkNumber(student);
        try {
            studentRepository.deleteStudent(getCheckNumber());
        } catch (NullPointerException | EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            showInformAboutCreation();
        }
    }

    public void creatDeleteHomework() {
        checkNumber(homework);
        try {
            lectureRepository.deleteHomework(getCheckNumber());
        } catch (NullPointerException | EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            showInformAboutCreation();
        }
    }

    public void creatTeacherForLecture() {
        System.out.println("Виберіть лекцію якій хочете присвоїти Вчителя.");
        checkNumber(lecture);
        long lectureId;
        try {
            lectureRepository.getLecture(getCheckNumber(), lectureRepository.getLectureArray());
            lectureId = getCheckNumber();
            System.out.printf("Є така лекція з номером ID \"%d\"\n", lectureId);
            checkNumber(teacher);
            teacherService.searchTeacher(getCheckNumber(), lectureId, lectureRepository.getLectureArray(),
                    teacherRepository.getTeachersArrayObject());

        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            showInformCourseAndLecture();
            showInformAboutCreation();
        }
    }

    public void creatStudentForLecture() {
        System.out.println("Виберіть лекцію якій хочете присвоїти Студента.");
        checkNumber(lecture);
        long lectureId;
        try {
            lectureRepository.getLecture(getCheckNumber(), lectureRepository.getLectureArray());
            lectureId = getCheckNumber();
            System.out.printf("Є така лекція з номером ID \"%d\"\n", lectureId);
            checkNumber(student);
            studentService.searchStudent(getCheckNumber(), lectureId, lectureRepository.getLectureArray(),
                    studentRepository.getStudentsArrayObject());
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            showInformCourseAndLecture();
            showInformAboutCreation();
        }
    }

    public void creatAddPersonForLecture() {
        System.out.println("Введіть кого хочете додати до лекції: \n\"Вчитель\"\n\"Студент\"");
        scannerNameModelAndPerson();
        if (getNameModelAndPerson().equalsIgnoreCase("вчитель")) {
            setNameModelAndPerson("вчитель для лекції");
        } else if (getNameModelAndPerson().equalsIgnoreCase("студент")) {
            setNameModelAndPerson("студент для лекції");
        } else {
            System.out.println("Не правильний ввід, введіть \"Add\" ще раз, або");
            showInformAboutCreation();
        }
    }

    public void creatDefault() {
        try {
            throw new IllegalArgumentException("Symbol is incorrect !!!");
        } catch (IllegalArgumentException il) {
            il.printStackTrace();
        } finally {
            System.out.println("Спробуйте ще раз.");
            scannerNameModelAndPerson();
        }
    }

    public void checkNumber(String outName) {
        long test;
        boolean isPresent = true;
        while (isPresent) {
            System.out.printf("Введіть ID %s, число не менше \"0\", i не більше \"%d\":\n", outName, Integer.MAX_VALUE);
            if (scanner.hasNextLong()) {
                test = scanner.nextLong();
                scanner.nextLine();
                if (test > 0 && test < Integer.MAX_VALUE) {
                    number = test;
                    isPresent = false;
                }
            } else {
                System.out.println("Не правильний ввід, або завелике число.\nВведіть ще раз!!!");
                scannerNameModelAndPerson();
            }
        }
    }

    public void scannerName() {
        boolean isPresent = true;
        String result;
        while (isPresent) {
            System.out.println("Введіть від одного до чотирьох слів !!!");
            result = scanner.nextLine();
            try {
                if (!(makeValidate(result, namePattern))) {
                    throw new IllegalArgumentException(result);
                } else {
                    name = result;
                    System.out.println("Назву збережено!!!");
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                try {
                    throw new EntityNotFoundException(stringIncorrect, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scannerDescription() {
        boolean isPresent = true;
        String testDescription;
        while (isPresent) {
            System.out.printf("Введіть опис лекції, від \"%d\" до \"%d\" символів.\n", 3, 20);
            testDescription = scanner.nextLine();
            try {
                if (!(makeValidate(testDescription, descriptionPattern))) {
                    throw new IllegalArgumentException(testDescription);
                } else {
                    description = testDescription;
                    System.out.println("Опис лекції збережено!!!");
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                try {
                    throw new EntityNotFoundException(stringIncorrect, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scannerHomeTask() {
        boolean isPresent = true;
        String task;
        while (isPresent) {
            System.out.printf("Запишіть домашнє завдання, від \"%d\" до \"%d\" символів.\n", 3, 20);
            task = scanner.nextLine();
            try {
                if (!(makeValidate(task, descriptionPattern))) {
                    throw new IllegalArgumentException(task);
                } else {
                    this.task = task;
                    System.out.println("Домашнє завдання збережено!");
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                try {
                    throw new EntityNotFoundException(stringIncorrect, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scannerPhone() {
        boolean isPresent = true;
        String format = "«+38(044)555-55-55»";
        String testPhoneNumber;
        while (isPresent) {
            System.out.printf("Формат номера: %s\n", format);
            testPhoneNumber = scanner.nextLine();
            try {
                if (!(makeValidate(testPhoneNumber, phoneNumberPattern))) {
                    throw new IllegalArgumentException(testPhoneNumber);
                } else {
                    phone = testPhoneNumber;
                    System.out.println("Номер телефону збережено!!!");
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                try {
                    throw new EntityNotFoundException("Number is incorrect!!!", i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }


        }
    }


    public void scannerEmail() {
        boolean isPresent = true;
        String testEmail;
        while (isPresent) {
            System.out.println("Формат електронної пошти: «nick@mail.com»");
            testEmail = scanner.nextLine();
            try {
                if (!(makeValidate(testEmail, emailPattern))) {
                    throw new IllegalArgumentException(testEmail);
                } else {
                    email = testEmail;
                    System.out.println("Пошту збережено збережено!!!");
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                try {
                    throw new EntityNotFoundException("Email is incorrect!!!", i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public String checkFirstAndLastName() {
        boolean isPresent = true;
        String result = "";
        String testFirstOrLastName;
        while (isPresent) {
            System.out.println("Ведіть одне слово, без цифр пробілів і розділових знаків!!!");
            testFirstOrLastName = scanner.nextLine();
            try {
                if (!(makeValidate(testFirstOrLastName, firstOrLastNamePattern))) {
                    throw new IllegalArgumentException(testFirstOrLastName);
                } else {
                    result = testFirstOrLastName;
                    System.out.println("Збережено!!!");
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                try {
                    throw new EntityNotFoundException(stringIncorrect, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public void scannerNameModelAndPerson() {
        nameModelAndPerson = scanner.nextLine();
    }

    public void scannerFirstName() {
        firstname = checkFirstAndLastName();
    }

    public void scannerLastName() {
        lastName = checkFirstAndLastName();
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public long getCheckNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getNameModelAndPerson() {
        return nameModelAndPerson;
    }

    public void setNameModelAndPerson(String nameModelAndPerson) {
        this.nameModelAndPerson = nameModelAndPerson;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public String getTask() {
        return task;
    }

    public void putBorder() {
        System.out.println("================================================================================================================================================================");
    }

    public void showInformCourseAndLecture() {
        System.out.println("Для виводу всієї інфрмації про курс, або про лекцію, введіть: \n\"Course data\"\n\"Lecture data\"");
    }

    public void showInformAboutCreation() {
        System.out.println("Можете продовжувати створювати студентів, вчителів, лекції.");
        nameModelAndPerson = scanner.nextLine();
    }

    public String showJustMessage() {
        return "Ви створюєте об'єкт: ";
    }
}

