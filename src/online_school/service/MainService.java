package online_school.service;

import online_school.util.AdditionalMaterialSortLectureId;
import online_school.course.model.Course;
import online_school.course.model.Lecture;
import online_school.course.model.Person;
import online_school.course.task_for_lecture.AdditionalMaterial;
import online_school.course.task_for_lecture.Homework;
import online_school.my_enum.Resource;
import online_school.exception.EntityNotFoundException;
import online_school.my_enum.Role;
import online_school.repository.CourseRepository;
import online_school.repository.LectureRepository;
import online_school.repository.StudentRepository;
import online_school.repository.TeacherRepository;
import online_school.util.AdditionalMaterialSortType;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static online_school.util.RegularExpression.*;

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
    private static final AdditionalMaterialService additionalMaterialService = new AdditionalMaterialService();
    private static final TreeSet<Course> courseTreeSet = new TreeSet<>();
    private static final TreeSet<Lecture> lectureTreeSet = new TreeSet<>();
    private static final TreeSet<Person> teacherTreeSet = new TreeSet<>();
    private static final TreeSet<Person> studentTreeSet = new TreeSet<>();
    private static final java.util.List<Homework> allHomework = new ArrayList<>();
    private static final TreeSet<Homework> homeworkTreeSet = new TreeSet<>();
    private static final java.util.List<AdditionalMaterial> allAdditionalMaterials = new ArrayList<>();
    private static final TreeSet<AdditionalMaterial> additionalMaterialTreeSet = new TreeSet<>();

    private Long number;
    private String name;
    private String nameModelAndPerson;
    private String description;
    private String firstname;
    private String lastName;
    private String phone;
    private String email;
    private String task;
    private boolean isPresent;
    private Resource resourceType;
    private long courseId;
    private long lectureId;
    private String courseName;

    public static final String OF_COURSE = "курсу";
    public static final String OF_LECTURE = "лекції";
    public static final String OF_STUDENT = "студента";
    public static final String OF_TEACHER = "вчителя";
    public static final String COURSE = "Курс";
    public static final String LECTURE = "Лекція";
    public static final String STUDENT = "Студент";
    public static final String TEACHER = "Вчитель";
    public static final String TEACHER_ENG = "teacher";
    public static final String STUDENT_ENG = "student";
    public static final String HOMEWORK = "Домашнього завдання";
    public static final String ADDITIONAL_MATERIAL = "Додаткового матеріалу";
    public static final String STRING_IS_INCORRECT = "String is incorrect!!!";
    public static final String OBJECT_IS_DELETE = "Об'єкт %s ВИДАЛЕНО!!!\n";
    public static final String ID_IS_NOT_FOUND = "ID is not found !!!";
    public static final String ID_LECTURE_IS_NOT_FOUND = "Id of the lecture is not found!!!";
    public static final String SYMBOL_IS_INCORRECT = "Symbol is incorrect !!!";
    public static final String YOU_CREATING_AN_OBJECT = "Ви створюєте об'єкт: ";
    public static final String COURSE_DATA = "Course data";
    public static final String IS_EMPTY = "Is empty.";

    public void showFrontInform() {
        System.out.print("""
                ========================
                "РЕГІСТР НЕ ВАЖЛИВИЙ !!!"
                """);
        autoObject(courseRepository, courseService, lectureRepository, lectureService);
        System.out.print("""
                Для виводу інфрмації про всі об'єкти одного типу, введіть:
                "Course info"
                "Lecture info"
                "Teacher info"
                "Student info"
                "Homework info"
                "Additional material info"
                ================================
                 Щоб видалити об'єкт введіть:
                "Delete course"
                "Delete lecture"
                "Delete teacher"
                "Delete student"
                "Delete homework"
                "Delete additional material"
                ==================================================
                Щоб додати студента або вчителя до лекції введіть:
                "Add someone"
                ==================================================
                Щоб додати домашнє завдання до лекції введіть:
                "Add homework"
                ==================================================
                Щоб додати Додаткові матеріали до лекції введіть:
                "Add resource"
                ==================================================
                Створіть об'єкт курсу, ввівши:
                "Курс"
                ==================================
                Для завершення програми, введіть:
                "Stop"
                =======
                """);
        scannerNameModelAndPerson();
    }

    public void creatCourse() {
        Course course;
        System.out.println(YOU_CREATING_AN_OBJECT + COURSE);
        checkNumber(OF_COURSE);
        System.out.println("Введіть назву курсу:");
        scannerName();
        course = courseService.createCourse(getCheckNumber(), getName());
        courseRepository.getCourseList().add(course);
        System.out.printf("Чудово, ви створили курс з назвою: \"%s\", і номером ID: \"%d\".\n", getName(), courseRepository.getCourseID(course));
        System.out.println("Тепер створіть об'єкти ввівши:\n" + LECTURE + ".\n" + STUDENT + ".\n" + TEACHER + ".");
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        scannerNameModelAndPerson();
    }

    public void creatLecture() {
        isPresent = true;
        Lecture lecture;
        System.out.println(YOU_CREATING_AN_OBJECT + LECTURE);
        checkNumber(OF_LECTURE);
        lectureId = getCheckNumber();
        System.out.println("Введіть назву лекції:");
        scannerName();
        scannerDescription();
        System.out.println("Виберіть ID курсу якому хочете присвоїти лекцію:");
        putBorder();
        findCourse();
        lecture = lectureService.createLecture(lectureId, getName(), getDescription(), courseId, courseName);
        lectureRepository.getLectureList().add(lecture);
        System.out.printf("Чудово, ви створили лекцію з назвою: \"%s\", і номером ID: \"%d\" і присвоїли її курсу з ID: \"%d\".\n",
                getName(), lectureRepository.getLectureId(lecture), courseId);
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
    }

    public void creatStudent() {
        Person student;
        System.out.println(YOU_CREATING_AN_OBJECT + STUDENT);
        checkNumber(OF_STUDENT);
        System.out.println("Введіть ім'я студента:");
        scannerFirstName();
        System.out.println("Введіть прізвище студента:");
        scannerLastName();
        System.out.println("Введіть номер телефону студента:");
        scannerPhone();
        System.out.println("Введіть Email студента:");
        scannerEmail();
        student = studentService.createStudent(Role.STUDENT, getCheckNumber(), getFirstname(),
                getLastName(), getPhone(), getEmail());
        studentRepository.getStudentList().add(student);
        System.out.printf("Чудово, ви створили об'єкт студента з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n",
                getFirstname(), getLastName(), studentRepository.getStudentId(student));
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
    }

    public void creatTeacher() {
        Person teacher;
        System.out.println(YOU_CREATING_AN_OBJECT + TEACHER);
        checkNumber(OF_TEACHER);
        System.out.println("Введіть ім'я вчителя:");
        scannerFirstName();
        System.out.println("Введіть прізвище вчителя:");
        scannerLastName();
        System.out.println("Введіть номер телефону вчителя:");
        scannerPhone();
        System.out.println("Введіть Email вчителя:");
        scannerEmail();
        teacher = teacherService.createTeacher(Role.TEACHER, getCheckNumber(), getFirstname(), getLastName(),
                getPhone(), getEmail());
        teacherRepository.getTeacherList().add(teacher);
        System.out.printf("Чудово, ви створили об'єкт вчителя з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n", getFirstname(),
                getLastName(), teacherRepository.getTeacherId(teacher));
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
    }

    public void creatHomework() {
        System.out.println(YOU_CREATING_AN_OBJECT + "\"Homework\" для лекції");
        checkNumber(HOMEWORK);
        long homeworkId = getCheckNumber();
        scannerHomeTask();
        String homeTask = getTask();
        System.out.println("Виберіть лекцію якій хочете присвоїти домашне завдання.");
        printAllLecture();
        checkNumber(OF_LECTURE);
        lectureId = getCheckNumber();
        try {
            lectureRepository.addHomework(lectureId, homeworkService.createHomework(homeworkId, lectureId, homeTask));
        } catch (NullPointerException n) {
            n.printStackTrace();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            putBorder();
            showInformCourseAndLecture();
            putBorder();
            showInformAboutCreation();
        }
    }

    public void createResourceType() {
        System.out.println(YOU_CREATING_AN_OBJECT + "\"додаткові матеріали\" для лекції");
        String resource = "Додаткових матеріалів";
        checkNumber(resource);
        long additionalMaterialId = getCheckNumber();
        System.out.println("Введіть назву для об'єкта додаткові матеріали:");
        scannerName();
        String resourceName = getName();
        printResourceTypeInfo();
        try {
            Resource resourceType = getResource();
            System.out.printf("Виберіть лекцію якій хочете присвоїти %s.\n", resourceType);
            printAllLecture();
            checkNumber(OF_LECTURE);
            long lectureId = getCheckNumber();
            lectureRepository.addAdditionalMaterials(lectureId,
                    additionalMaterialService.createAdditionalMaterials(additionalMaterialId, resourceName, lectureId, resourceType));
        } catch (NullPointerException n) {
            n.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
            putBorder();
            showInformCourseAndLecture();
            putBorder();
            showInformAboutCreation();
        }
    }

    public void creatCourseData() {
        System.out.println("Виберіть курс про який хочете вивести інформацію:");
        printAllCourse();
        checkNumber(OF_COURSE);
        courseId = getCheckNumber();
        try {
            creatCourseDataExceptionLogic();
        } catch (NullPointerException n) {
            n.printStackTrace();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            putBorder();
            if (courseRepository.counter() > 1) {
                showInformAboutCreation();
            } else {
                System.out.println("Створіть об'єкт курсу, ввівши: " + COURSE);
                scannerNameModelAndPerson();
            }
        }
    }

    public void creatLectureData() {
        System.out.println("Виберіть лекцію про яку хочете вивести інформацію:");
        printAllLecture();
        checkNumber(OF_LECTURE);
        lectureId = getCheckNumber();
        try {
            creatLectureDataExceptionLogic();
        } catch (NullPointerException n) {
            n.printStackTrace();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            putBorder();
            showInformAboutCreation();
        }
    }

    public void creatCourseInfo() {
        try {
            if (!(courseRepository.getCourseList().isEmpty())) {
                System.out.println("Інформацію про всі курси відсортовано по назві:");
                putBorder();
                if (courseTreeSet.isEmpty()) {
                    courseTreeSet.addAll(courseRepository.getCourseList());
                } else {
                    courseTreeSet.retainAll(courseRepository.getCourseList());
                }
                for (Course course : courseTreeSet) {
                    System.out.println(course);
                }
            } else System.out.println(IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
        } finally {
            putBorder();
            showInformAboutCreation();
        }
    }

    public void createLectureInfo() {
        try {
            if (!(lectureRepository.getLectureList().isEmpty())) {
                System.out.println("Інформацію про всі лекції відсортовано по назві:");
                putBorder();
                if (lectureTreeSet.isEmpty()) {
                    lectureTreeSet.addAll(lectureRepository.getLectureList());
                } else {
                    lectureTreeSet.retainAll(lectureRepository.getLectureList());
                }
                for (Lecture lecture : lectureTreeSet) {
                    System.out.println(lecture);
                }
            } else System.out.println(IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
        } finally {
            putBorder();
            showInformAboutCreation();
        }
    }

    public void creatTeacherInfo() {
        try {
            if (!(teacherRepository.getTeacherList().isEmpty())) {
                System.out.println("Інформацію про всіх вчителів відсортовано по прізвищу:");
                putBorder();
                if (teacherTreeSet.isEmpty()) {
                    teacherTreeSet.addAll(teacherRepository.getTeacherList());
                } else {
                    teacherTreeSet.retainAll(teacherRepository.getTeacherList());
                }
                for (Person teacher : teacherTreeSet) {
                    System.out.println(teacher);
                }
            } else System.out.println(IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
        } finally {
            putBorder();
            showInformAboutCreation();
        }
    }

    public void creatStudentInfo() {
        try {
            if (!(studentRepository.getStudentList().isEmpty())) {
                System.out.println("Інформацію про всіх студентів відсортовано по прізвищу:");
                putBorder();
                if (studentTreeSet.isEmpty()) {
                    studentTreeSet.addAll(studentRepository.getStudentList());
                } else {
                    studentTreeSet.retainAll(studentRepository.getStudentList());
                }
                for (Person student : studentTreeSet) {
                    System.out.println(student);
                }
            } else System.out.println(IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
        } finally {
            putBorder();
            showInformAboutCreation();
        }
    }

    public void creatHomeworkInfo() {
        isPresent = false;
        for (Lecture l : lectureRepository.getLectureList()) {
            if (!(l.getHomeworkList().isEmpty())) {
                isPresent = true;
                break;
            }
        }
        try {
            if (isPresent) {
                System.out.println("Інформацію про всі об'єкти Homework відсортовано по ID:");
                putBorder();
                allHomework.clear();
                for (int i = 0; i < lectureRepository.getLectureList().size(); i++) {
                    allHomework.addAll(lectureRepository.getLectureList().get(i).getHomeworkList());
                }
                if (homeworkTreeSet.isEmpty()) {
                    homeworkTreeSet.addAll(allHomework);
                } else {
                    homeworkTreeSet.retainAll(allHomework);
                }
                for (Homework homework : homeworkTreeSet) {
                    System.out.println(homework);
                }
            } else System.out.println(IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
        } finally {
            putBorder();
            showInformAboutCreation();
        }
    }

    public void creatAdditionalMaterialInfo() {
        isPresent = false;
        for (Lecture l : lectureRepository.getLectureList()) {
            if (!(l.getAdditionalMaterialList().isEmpty())) {
                isPresent = true;
                break;
            }
        }
        try {
            if (isPresent) {
                System.out.println("Інформацію про всі об'єкти Additional Material відсортовано по ID (за замовчуванням):");
                putBorder();
                allAdditionalMaterials.clear();
                for (int i = 0; i < lectureRepository.getLectureList().size(); i++) {
                    allAdditionalMaterials.addAll(lectureRepository.getLectureList().get(i).getAdditionalMaterialList());
                }
                if (additionalMaterialTreeSet.isEmpty()) {
                    additionalMaterialTreeSet.addAll(allAdditionalMaterials);
                } else {
                    additionalMaterialTreeSet.retainAll(allAdditionalMaterials);
                }
                for (AdditionalMaterial additionalMaterial : additionalMaterialTreeSet) {
                    System.out.println(additionalMaterial);
                }
                additionalMaterialSort();
            } else System.out.println(IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
        } finally {
            putBorder();
            showInformAboutCreation();
        }
    }

    public void creatDeleteCourse() {
        isPresent = true;
        System.out.println("Виберіть курс який хочете видалити:");
        printAllCourse();
        checkNumber(OF_COURSE);
        long courseId = getCheckNumber();
        for (int i = 0; i < courseRepository.getCourseList().size(); i++) {
            if (courseRepository.getCourseList().get(i).getCourseId().equals(courseId)) {
                System.out.printf(OBJECT_IS_DELETE, courseRepository.getCourseList().remove(i));

                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
    }

    public void creatDeleteLecture() {
        isPresent = true;
        System.out.println("Виберіть лекцію яку хочете видалити:");
        printAllLecture();
        checkNumber(OF_LECTURE);
        long lectureId = getCheckNumber();
        for (int i = 0; i < lectureRepository.getLectureList().size(); i++) {
            if (lectureRepository.getLectureList().get(i).getLectureId().equals(lectureId)) {
                System.out.printf(OBJECT_IS_DELETE, lectureRepository.getLectureList().remove(i));
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
    }

    public void creatDeleteTeacher() {
        isPresent = true;
        System.out.println("Виберіть вчителя якого хочете видалити:");
        printAllTeacher();
        checkNumber(OF_TEACHER);
        long teacherId = getCheckNumber();
        for (int i = 0; i < teacherRepository.getTeacherList().size(); i++) {
            if (teacherRepository.getTeacherList().get(i).getPersonId().equals(teacherId)) {
                System.out.printf(OBJECT_IS_DELETE, teacherRepository.getTeacherList().remove(i));
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
    }

    public void creatDeleteStudent() {
        isPresent = true;
        System.out.println("Виберіть учня якого хочете видалити:");
        printAllStudent();
        checkNumber(OF_STUDENT);
        long studentId = getCheckNumber();
        for (int i = 0; i < studentRepository.getStudentList().size(); i++) {
            if (studentRepository.getStudentList().get(i).getPersonId().equals(studentId)) {
                System.out.printf(OBJECT_IS_DELETE, studentRepository.getStudentList().remove(i));
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
    }

    public void creatDeleteHomework() {
        isPresent = true;
        System.out.println("Виберіть homework який хочете видалити:");
        printAllHomework();
        checkNumber(HOMEWORK);
        long homeworkId = getCheckNumber();
        for (int i = 0; i < lectureRepository.getLectureList().size(); i++) {
            for (int j = 0; j < lectureRepository.getLectureList().get(i).getHomeworkList().size(); j++) {
                if (lectureRepository.getLectureList().get(i).getHomeworkList().get(j).getHomeworkId().equals(homeworkId)) {
                    System.out.printf(OBJECT_IS_DELETE, lectureRepository.getLectureList().get(i).getHomeworkList().remove(j));
                    isPresent = false;
                    break;
                }
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
    }

    public void creatDeleteAdditionalMaterial() {
        isPresent = true;
        System.out.println("Виберіть ресурс який хочете видалити:");
        printAllAdditionalMaterial();
        checkNumber(ADDITIONAL_MATERIAL);
        long additionalMaterialId = getCheckNumber();
        for (int i = 0; i < lectureRepository.getLectureList().size(); i++) {
            for (int j = 0; j < lectureRepository.getLectureList().get(i).getAdditionalMaterialList().size(); j++) {
                if (lectureRepository.getLectureList().get(i).getAdditionalMaterialList().get(j).getId().equals(additionalMaterialId)) {
                    System.out.printf(OBJECT_IS_DELETE, lectureRepository.getLectureList().get(i).getAdditionalMaterialList().remove(j));
                    isPresent = false;
                    break;
                }
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
    }


    public void creatTeacherForLecture() {
        System.out.println("Виберіть лекцію якій хочете присвоїти вчителя.");
        printAllLecture();
        checkNumber(OF_LECTURE);
        long lectureId = getCheckNumber();
        System.out.println("Виберіть вчителя.");
        printAllTeacher();
        checkNumber(OF_TEACHER);
        long teacherId = getCheckNumber();
        try {
            teacherService.addPersonToLecture(OF_TEACHER, lectureId, teacherId, lectureRepository.getLectureList(), teacherRepository.getTeacherList());
        } catch (NullPointerException n) {
            n.printStackTrace();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            showInformCourseAndLecture();
            showInformAboutCreation();
        }
    }

    public void creatStudentForLecture() {
        System.out.println("Виберіть лекцію якій хочете присвоїти студента.");
        printAllLecture();
        checkNumber(OF_LECTURE);
        long lectureId = getCheckNumber();
        System.out.println("Виберіть студента.");
        printAllStudent();
        checkNumber(OF_STUDENT);
        long studentId = getCheckNumber();
        try {
            studentService.addPersonToLecture(OF_STUDENT, lectureId, studentId, lectureRepository.getLectureList(), studentRepository.getStudentList());
        } catch (NullPointerException n) {
            n.printStackTrace();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            showInformCourseAndLecture();
            showInformAboutCreation();
        }
    }

    public void creatAddPersonForLecture() {
        System.out.println("Введіть кого хочете додати до лекції: \n" + TEACHER + "\n" + STUDENT);
        scannerNameModelAndPerson();
        if (getNameModelAndPerson().equalsIgnoreCase(TEACHER)) {
            setNameModelAndPerson("вчитель для лекції");
        } else if (getNameModelAndPerson().equalsIgnoreCase(STUDENT)) {
            setNameModelAndPerson("студент для лекції");
        } else {
            System.out.println("Не правильний ввід, введіть \"Add someone\" ще раз, або");
            showInformAboutCreation();
        }
    }

    public void creatDefault() {
        try {
            throw new IllegalArgumentException(SYMBOL_IS_INCORRECT);
        } catch (IllegalArgumentException il) {
            System.err.println(il.getMessage());
        } finally {
            System.out.println("Спробуйте ще раз.");
            scannerNameModelAndPerson();
        }
    }

    public void checkNumber(String outName) {
        long test;
        isPresent = true;
        while (isPresent) {
            System.out.printf("Введіть ID %s, число більше \"0\":\n", outName);
            if (scanner.hasNextLong()) {
                test = scanner.nextLong();
                scanner.nextLine();
                if (test > 0 && test < Long.MAX_VALUE) {
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
        isPresent = true;
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
                    throw new EntityNotFoundException(STRING_IS_INCORRECT, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scannerDescription() {
        isPresent = true;
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
                    throw new EntityNotFoundException(STRING_IS_INCORRECT, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scannerHomeTask() {
        isPresent = true;
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
                    throw new EntityNotFoundException(STRING_IS_INCORRECT, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scannerPhone() {
        isPresent = true;
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
        isPresent = true;
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
        isPresent = true;
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
                    throw new EntityNotFoundException(STRING_IS_INCORRECT, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public Resource getResource() {
        if (scanner.hasNextLine()) {
            String type = scanner.nextLine();
            switch (type.toLowerCase()) {
                case "url" -> resourceType = Resource.URL;
                case "video" -> resourceType = Resource.VIDEO;
                case "book" -> resourceType = Resource.BOOk;
                default -> throw new IllegalArgumentException(SYMBOL_IS_INCORRECT);
            }
        } else {
            System.out.println("Введіть буквений символ!!!");
        }
        return resourceType;
    }

    public void findCourse() {
        isPresent = true;
        for (Course c : courseRepository.getCourseList()) {
            System.out.println(c);
        }
        putBorder();
        while (isPresent) {
            checkNumber(OF_COURSE);
            for (Course c : courseRepository.getCourseList()) {
                if (c.getCourseId().equals(getCheckNumber())) {
                    courseId = getCheckNumber();
                    courseName = c.getCourseName();
                    isPresent = false;
                    break;
                }
            }
            if (isPresent) {
                System.out.println("Не правильний ID!!!");
            }
        }
    }

    public void printResourceTypeInfo() {
        System.out.println("""
                Виберіть які додаткові матеріли ви хочете додати до лекції:
                "Url адреса"
                "Відео матеріали"
                "Книжка"
                Ввівши відповідно:
                "Url"
                "Video"
                "Book\"""");
    }

    public void additionalMaterialSort() {
        isPresent = true;
        while (isPresent) {
            putBorder();
            System.out.print("""
                    Виберіть варіант сортування і введіть ключове слово:
                    По ID лекцій --> "lectureID"
                    За видом додаткових матеріалів --> "type"
                    ============================================
                    Для виходу з сортування введіть будь що інше.
                    """);
            scannerNameModelAndPerson();
            if (getNameModelAndPerson().equalsIgnoreCase("lectureID")) {
                putBorder();
                System.out.println("Додаткві матеріали вдсортовано по ID лецій.");
                AdditionalMaterialSortLectureId materialSortLectureId = new AdditionalMaterialSortLectureId();
                Set<AdditionalMaterial> materialSet = new TreeSet<>(materialSortLectureId);
                materialSet.addAll(allAdditionalMaterials);
                for (AdditionalMaterial material : materialSet) {
                    System.out.println(material);
                }
            } else if (getNameModelAndPerson().equalsIgnoreCase("type")) {
                putBorder();
                System.out.println("Додаткві матеріали вдсортовано по типу.");
                AdditionalMaterialSortType materialSortType = new AdditionalMaterialSortType();
                Set<AdditionalMaterial> materialSet = new TreeSet<>(materialSortType);
                materialSet.addAll(allAdditionalMaterials);
                for (AdditionalMaterial material : materialSet) {
                    System.out.println(material);
                }
            } else {
                isPresent = false;
            }
        }
    }

    public void printAllLecture() {
        putBorder();
        for (Lecture l : lectureRepository.getLectureList()) {
            System.out.println(l);
        }
        putBorder();
    }

    public void printAllCourse() {
        putBorder();
        for (Course c : courseRepository.getCourseList()) {
            System.out.println(c);
        }
        putBorder();
    }

    public void printAllTeacher() {
        putBorder();
        for (Person t : teacherRepository.getTeacherList()) {
            System.out.println(t);
        }
        putBorder();
    }

    public void printAllStudent() {
        putBorder();
        for (Person s : studentRepository.getStudentList()) {
            System.out.println(s);
        }
        putBorder();
    }

    public void printAllHomework() {
        putBorder();
        for (Lecture lecture : lectureRepository.getLectureList()) {
            for (Homework h : lecture.getHomeworkList())
                System.out.println(h);
        }
        putBorder();
    }

    public void printAllAdditionalMaterial() {
        putBorder();
        for (Lecture lecture : lectureRepository.getLectureList()) {
            for (AdditionalMaterial a : lecture.getAdditionalMaterialList())
                System.out.println(a);
        }
        putBorder();
    }

    public void creatLectureDataExceptionLogic() {
        lectureService.showLectures(getCheckNumber(), lectureRepository.getLectureList());
        putBorder();
        try {
            teacherRepository.showInformPerson(TEACHER_ENG, lectureId, lectureRepository.getLectureList(), teacherRepository.getTeacherList());
            putBorder();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                studentRepository.showInformPerson(STUDENT_ENG, lectureId, lectureRepository.getLectureList(), studentRepository.getStudentList());
                putBorder();
            } catch (EntityNotFoundException e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    homeworkService.showInformHomework(getCheckNumber(), lectureRepository.getLectureList());
                    putBorder();
                } catch (EntityNotFoundException e) {
                    System.err.println(e.getMessage());
                } finally {
                    additionalMaterialService.showInformAdditionalMaterial(lectureId, lectureRepository.getLectureList());
                }
            }
        }
    }

    public void creatCourseDataExceptionLogic() {
        courseService.showInformCourse(courseId, courseRepository.getCourseList());
        lectureService.showLecturesInCourse(courseId, lectureRepository.getLectureList());
        putBorder();
        try {
            teacherRepository.showInformPerson(TEACHER_ENG, courseId, lectureRepository.getLectureList(), teacherRepository.getTeacherList());
            putBorder();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            studentRepository.showInformPerson(STUDENT_ENG, courseId, lectureRepository.getLectureList(), studentRepository.getStudentList());
        }
    }

    public void autoObject(CourseRepository courseRepository, CourseService courseService, LectureRepository lectureRepository,
                           LectureService lectureService) {
        int indexCourse = 0;
        courseRepository.getCourseList().add(courseService.createCourse(1L, "Auto course"));
        courseId = courseRepository.getCourseList().get(indexCourse).getCourseId();
        courseName = courseRepository.getCourseList().get(indexCourse).getCourseName();
        for (long i = 0; i < 3; i++) {
            lectureRepository.getLectureList().add(lectureService.createLecture(i, "No name", "No description", courseId, courseName));
        }
        System.out.println("==========================================================================");
        System.out.printf("Створено автоматичний курс з іменем \"Auto course\"\n з ID \"%d\" і з трьома лекціями \"No name\".\n",
                courseRepository.getCourseList().get(indexCourse).getCourseId());
        System.out.println("==========================================================================");
        System.out.println("Для виводу всієї інфрмації про курс, введіть: \n\"" + COURSE_DATA + "\"");
        System.out.println("==========================================================================");
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

    public Long getCheckNumber() {
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
        System.out.println("Для виводу всієї інфрмації про курс, або про лекцію, введіть: \n\"" + COURSE_DATA + "\"\n\"Lecture data\"");
    }

    public void showInformAboutCreation() {
        System.out.println("Можете продовжувати створювати студентів, вчителів, лекції.");
        nameModelAndPerson = scanner.nextLine();
    }
}

