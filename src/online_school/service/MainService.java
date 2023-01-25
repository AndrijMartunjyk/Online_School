package online_school.service;

import online_school.domain.model.Student;
import online_school.domain.model.*;
import online_school.util.Level;
import online_school.util.Log;
import online_school.util.ReadAndWrite;
import online_school.repository.*;
import online_school.util.AdditionalMaterialSortLectureId;
import online_school.domain.task_for_lecture.AdditionalMaterial;
import online_school.domain.task_for_lecture.Homework;
import online_school.exception.EntityNotFoundException;
import online_school.util.AdditionalMaterialSortType;

import java.util.*;

import static online_school.util.RegularExpression.*;

public class MainService {

    private final CourseRepository courseRepository = new CourseRepository();
    private final CourseService courseService = new CourseService();
    private final LectureRepository lectureRepository = new LectureRepository();
    private final LectureService lectureService = new LectureService();
    private final StudentRepository studentRepository = new StudentRepository();
    private final StudentService studentService = new StudentService();
    private final TeacherRepository teacherRepository = new TeacherRepository();
    private final TeacherService teacherService = new TeacherService();
    private final HomeworkService homeworkService = new HomeworkService();
    private final AdditionalMaterialService additionalMaterialService = new AdditionalMaterialService();
    private final TreeSet<Course> courseTreeSet = new TreeSet<>();
    private final TreeSet<Lecture> lectureTreeSet = new TreeSet<>();
    private final TreeSet<Person> teacherTreeSet = new TreeSet<>();
    private final TreeSet<Person> studentTreeSet = new TreeSet<>();
    private final java.util.List<Homework> allHomework = new ArrayList<>();
    private final TreeSet<Homework> homeworkTreeSet = new TreeSet<>();
    private final java.util.List<AdditionalMaterial> allAdditionalMaterials = new ArrayList<>();
    private final TreeSet<AdditionalMaterial> additionalMaterialTreeSet = new TreeSet<>();
    private final HomeworkRepository homeworkRepository = new HomeworkRepository();
    private final AdditionalMaterialRepository additionalMaterialRepository = new AdditionalMaterialRepository();
    private final Log log = new Log();
    private final ReadAndWrite readAndWrite = new ReadAndWrite();
    private final ControlWorkService controlWork = new ControlWorkService();
    private final List<Student> listOfStudentsForThread = new ArrayList<>();

    private Scanner scanner;
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
    private long homeworkId;
    private String homeTask;
    private String courseName;
    private long additionalMaterialId;
    private String resourceName;
    private Student[] studentsArray;


    private final String MAIN_SERVICE = MainService.class.getName();
    private static final String CASE_NOT_IMPORTANT = """
            ========================
            "РЕГІСТР НЕ ВАЖЛИВИЙ !!!"
            """;
    private static final String START_INFO = """
            Для виводу інфрмації про всі об'єкти одного типу, введіть:
            "Course info"
            "Lecture info"
            "Teacher info"
            "Student info"
            "Homework info"
            "Additional material info"
            %s
             Щоб видалити об'єкт введіть:
            "Delete course"
            "Delete lecture"
            "Delete teacher"
            "Delete student"
            %s
            Щоб додати студента або вчителя до лекції введіть:
            "Add someone"
            %s
            Створіть об'єкт курсу, ввівши:
            "Курс"
            %s
            Для завершення програми, введіть:
            "Stop"
            =============================================
            """;
    private static final String INFO_ABOUT_LOGS = """
            Для виведення логів, введіть:
            "debug" -> виводяться всі логи.
            "info"  -> тільки "INFO" i всі знизу.
            "warn"  -> тільки "WARNING" i "ERROR".
            "error" -> тільки "ERROR".""";
    public final String AUTO_COURSE = "Створено автоматичний курс з іменем \"Auto course\"\n з ID \"%d\" і з трьома лекціями \"No name\".\n";
    public final String ALL_INFO = "Для виводу всієї інфрмації про курс, введіть: \n\"" + COURSE_DATA + "\"";
    public final String START = "START";
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
    public static final String HOMEWORK_FOR_LECTURE = "\"Homework\" для лекції";
    public static final String HOMEWORK_IS_SAVED = "Домашнє завдання збережено!";
    public static final String ADDITIONAL_MATERIAL = "Додаткового матеріалу";
    public static final String ADDITIONAL_MATERIAL_FOR_LECTURE = "\"додаткові матеріали\" для лекції";
    public static final String ADDITIONAL_MATERIAL_SORTED = "Додаткові матеріали відсортовано по ID лецій.";
    public static final String ADDITIONAL_MATERIAL_SORTED1 = "Додаткві матеріали вдсортовано по типу.";
    public static final String STRING_IS_INCORRECT = "String is incorrect!!!";
    public static final String OBJECT_IS_DELETE = "Об'єкт %s ВИДАЛЕНО!!!\n";
    public static final String OBJECT_IS_DELETE1 = "Об'єкт ВИДАЛЕНО!!!";
    public static final String ID_IS_NOT_FOUND = "ID is not found !!!";
    public static final String ID_LECTURE_IS_NOT_FOUND = "Id of the lecture is not found!!!";
    public static final String SYMBOL_IS_INCORRECT = "Symbol is incorrect !!!";
    public static final String YOU_CREATING_AN_OBJECT = "Ви створюєте об'єкт: ";
    public static final String COURSE_DATA = "Course data";
    public static final String LECTURE_DATA = "Lecture data";
    public static final String IS_EMPTY = "Is empty.";
    public static final String YOU_CREAT_COURSE = "Чудово, ви створили курс з назвою: \"%s\", і номером ID: \"%d\".\n";
    public static final String CREAT_OBJECT_OF_COURSE = "Створіть об'єкт курсу, ввівши: " + COURSE;
    public static final String YOU_CREAT_LECTURE = "Чудово, ви створили лекцію з назвою: \"%s\", і номером ID: \"%d\" і присвоїли її курсу з ID: \"%d\".\n";
    public static final String YOU_CREAT_STUDENT = "Чудово, ви створили об'єкт студента з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n";
    public static final String YOU_CREAT_TEACHER = "Чудово, ви створили об'єкт вчителя з іменем: \"%s\", прізвищем: \"%s\" і номером ID: \"%d\".\n";
    public static final String NOW_CREAT_OBJECT = "Тепер створіть об'єкти ввівши:\n" + LECTURE + ".\n" + STUDENT + ".\n" + TEACHER + ".";
    public static final String METHOD_SHOW_FRONT_INFORM = "method-> \"showFrontInform\"";
    public static final String METHOD_HOMEWORK = "method-> \"homework\"";
    public static final String METHOD_CREAT_COURSE_DATA = "method-> \"creatCourseData\"";
    public static final String METHOD_CREAT_RESOURCE_TYPE = "method-> \"createResourceType\"";
    public static final String METHOD_CREAT_LECTURE_DATA = "method-> \"creatLectureData\"";
    public static final String METHOD_CREAT_COURSE_INFO = "method-> \"creatCourseInfo\"";
    public static final String METHOD_CREAT_LECTURE_INFO = "method-> \"createLectureInfo\"";
    public static final String METHOD_CREAT_TEACHER_INFO = "method-> \"creatTeacherInfo\"";
    public static final String METHOD_CREAT_STUDENT_INFO = "method-> \"creatStudentInfo\"";
    public static final String METHOD_CREAT_HOMEWORK_INFO = "method-> \"creatHomeworkInfo\"";
    public static final String METHOD_CREAT_ADDITIONAL_MATERIAL_INFO = "method-> \"creatAdditionalMaterialInfo\"";
    public static final String METHOD_CREAT_DELETE_COURSE = "method-> \"creatDeleteCourse\"";
    public static final String METHOD_CREAT_DELETE_LECTURE = "method-> \"creatDeleteLecture\"";
    public static final String METHOD_CREAT_DELETE_TEACHER = "method-> \"creatDeleteTeacher\"";
    public static final String METHOD_CREAT_DELETE_STUDENT = "method-> \"creatDeleteStudent\"";
    public static final String METHOD_CREAT_DELETE_HOMEWORK = "method-> \"creatDeleteHomework\"";
    public static final String METHOD_CREAT_DELETE_ADDITIONAL_MATERIAL = "method-> \"creatDeleteAdditionalMaterial\"";
    public static final String METHOD_CREAT_TEACHER_FOR_LECTURE = "method-> \"creatTeacherForLecture\"";
    public static final String METHOD_CREAT_STUDENT_FOR_LECTURE = "method-> \"creatStudentForLecture\"";
    public static final String METHOD_CREAT_ADD_PERSON_FOR_LECTURE = "method-> \"creatAddPersonForLecture\"";
    public static final String METHOD_CREAT_DEFAULT = "method-> \"creatDefault\"";
    public static final String METHOD_CHECK_NUMBER = "method-> \"checkNumber\"";
    public static final String METHOD_SCANNER_NAME = "method-> \"scannerName\"";
    public static final String METHOD_SCANNER_DESCRIPTION = "method-> \"scannerDescription\"";
    public static final String METHOD_SCANNER_HOME_TASK = "method-> \"scannerHomeTask\"";
    public static final String METHOD_SCANNER_PHONE = "method-> \"scannerPhone\"";
    public static final String METHOD_SCANNER_EMAIL = "method-> \"scannerEmail\"";
    public static final String METHOD_CHECK_NAME = "method-> \"checkFirstAndLastName\"";
    public static final String METHOD_GET_RESOURCE = "method-> \"getResource\"";
    public static final String METHOD_FOUND_COURSE = "method-> \"foundCourse\"";
    public static final String METHOD_PRINT_RESOURCE = "method-> \"printResourceTypeInfo\"";
    public static final String METHOD_ADDITIONAL_MATERIAL_SORT = "method-> \"additionalMaterialSort\"";
    public static final String METHOD_ADDITIONAL_MATERIAL_SORT_DEFAULT = "method-> \"additionalMaterialSortDefault\"";
    public static final String METHOD_PRINT_ALL_LECTURE = "method-> \"printAllLecture\"";
    public static final String METHOD_PRINT_ALL_COURSE = "method-> \"printAllCourse\"";
    public static final String METHOD_PRINT_ALL_TEACHER = "method-> \"printAllTeacher\"";
    public static final String METHOD_PRINT_ALL_STUDENT = "method-> \"printAllStudent\"";
    public static final String METHOD_PRINT_ALL_HOMEWORK = "method-> \"printAllHomework\"";
    public static final String METHOD_PRINT_ALL_ADDITIONAL_MATERIAL = "method-> \"printAllAdditionalMaterial\"";
    public static final String METHOD_CREAT_LECTURE_DATA_LOGIC = "method-> \"creatLectureDataLogic\"";
    public static final String METHOD_CREAT_COURSE_DATA_LOGIC = "method-> \"creatCourseDataLogic\"";
    public static final String METHOD_AUTO_OBJECT = "method-> \"autoObject\"";
    public static final String METHOD_FOUND_LECTURE = "method-> \"foundLecture\"";
    public static final String METHOD_SORTED_HOME = "method-> \"sortedHomework\"";
    public static final String METHOD_CREAT_HOME_LOGIC = "method-> \"creatHomeworkLogic\"";
    public static final String METHOD_CREATE_RESOURCE_TYPE_LOGIC = "method-> \"createResourceTypeLogic\"";
    public static final String METHOD_LOGIC = "method-> \"logInfo\"";
    public static final String METHOD_SCANNER_NAME_MODEL = "method-> \"scannerNameModelAndPerson\"";
    public static final String METHOD_SHOW_INFORM_ABOUT_CREATION = "method-> \"showInformAboutCreation\"";
    public static final String CONTINUE_INFO = "Можете продовжувати створювати студентів, вчителів, лекції.";
    public static final String METHOD_SHOW_INFORM = "method-> \"showInformCourseAndLecture\"";
    public static final String ALL_INFORM = "Для виводу всієї інфрмації про курс, або про лекцію, введіть: \n\"" + COURSE_DATA + "\"\n\"" + LECTURE_DATA + "\"";
    public static final String SO_LONG_BORDER = "================================================================================================================================================================";
    public static final String ENTER_NAME_OF_COURSE = "Введіть назву курсу:";
    public static final String ENTER_NAME_OF_LECTURE = "Введіть назву лекції:";
    public static final String ENTER_DESCRIPTION_OF_LECTURE = "Введіть опис лекції, від \"%d\" до \"%d\" слів.\n";
    public static final String SELECT_ID_OF_COURSE = "Виберіть ID курсу якому хочете присвоїти лекцію:";
    public static final String SELECT_A_LECTURE = "Виберіть лекцію якій хочете присвоїти домашне завдання.";
    public static final String SELECT_A_LECTURE1 = "Виберіть лекцію якій хочете присвоїти %s.\n";
    public static final String SELECT_A_LECTURE2 = "Виберіть лекцію про яку хочете вивести інформацію:";
    public static final String SELECT_A_COURSE = "Виберіть курс про який хочете вивести інформацію:";
    public static final String SELECT_OF_A_TEACHER = "Виберіть вчителя.";
    public static final String SELECT_OF_A_STUDENT = "Виберіть студента.";
    public static final String SAVED = "Збережено!!!";
    public static final String ENTER_NAME = "Введіть ім'я:";
    public static final String ENTER_LAST_NAME = "Введіть прізвище:";
    public static final String ENTER_PHONE = "Введіть номер телефону:";
    public static final String ENTER_EMAIL = "Введіть Email:";
    public static final String ENTER_ADD_FOR_LECTURE = "Введіть кого хочете додати до лекції: \n" + TEACHER + "\n" + STUDENT;
    public static final String ENTER_NUMBER = "Введіть ID %s, число більше \"0\":\n";
    public static final String ENTER_WORDS = "Введіть від одного до чотирьох слів !!!";
    public static final String ENTER_ONE_WORD = "Ведіть одне слово, без цифр пробілів і розділових знаків!!!";
    public static final String ENTER_LETTER = "Введіть буквений символ!!!";
    public static final String COURSE_FOR_DELETE = "Виберіть курс який хочете видалити:";
    public static final String LECTURE_FOR_DELETE = "Виберіть лекцію яку хочете видалити:";
    public static final String LECTURE_FOR_TEACHER = "Виберіть лекцію якій хочете присвоїти вчителя.";
    public static final String LECTURE_FOR_STUDENT = "Виберіть лекцію якій хочете присвоїти студента.";
    public static final String TEACHER_FOR_DELETE = "Виберіть вчителя якого хочете видалити:";
    public static final String STUDENT_FOR_DELETE = "Виберіть учня якого хочете видалити:";
    public static final String HOMEWORK_FOR_DELETE = "Виберіть homework який хочете видалити:";
    public static final String RESOURCE_FOR_DELETE = "Виберіть ресурс який хочете видалити:";
    public static final String REPAID_AGAIN = "Спробуйте ще раз.";
    public static final String NULL_POINTER_EXCEPTION = " NullPointerException.";
    public static final String NAME_FOR_ADDITIONAL_MATERIALS = "Введіть назву для об'єкта додаткові матеріали:";
    public static final String NAME_SAVED = "Назву збережено!!!";
    public static final String NUMBER_SAVED = "Номер телефону збережено!!!";
    public static final String EMAIL_SAVED = "Пошту збережено збережено!!!";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION = " IllegalArgumentException.";
    public static final String INFORM_ABOUT_COURSE_SORTED = "Інформацію про всі курси відсортовано по назві:";
    public static final String INFORM_ABOUT_TEACHER_SORTED = "Інформацію про всіх вчителів відсортовано по прізвищу:";
    public static final String INFORM_ABOUT_LECTURE_SORTED = "Інформацію про всі лекції відсортовано по назві:";
    public static final String INFORM_ABOUT_STUDENT_SORTED = "Інформацію про всіх студентів відсортовано по прізвищу:";
    public static final String INFORM_ABOUT_HOMEWORK_SORTED = "Інформацію про всі об'єкти Homework відсортовано по ID:";
    public static final String INFORM_ABOUT_ADDITIONAL_MATERIAL = "Інформацію про всі об'єкти Additional Material відсортовано по ID (за замовчуванням):";
    public static final String ENTITY_NOT_FOUND_EXCEPTION = " EntityNotFoundException.";
    public static final String WRONG_ENTER = "Не правильний ввід, введіть \"Add someone\" ще раз, або";
    public static final String WRONG_ENTER1 = "Не правильний ввід, або завелике число.\nВведіть ще раз!!!";
    public static final String WRONG_ID = "Не правильний ID!!!";
    public static final String WRITE_HOMEWORK = "Запишіть домашнє завдання, від \"%d\" до \"%d\" слів.\n";
    public static final String DESCRIPTION_OF_LECTURE_SAVED = "Опис лекції збережено!!!";
    public static final String PATTERN_OF_NUMBER = "Формат номера: «+38(044)555-55-55»";
    public static final String PATTERN_OF_EMAIL = "Формат електронної пошти: «nick@mail.com»";
    public static final String BORDER_SHORT = "=================================";
    public static final String BORDER_LONG = "==================================================";
    public static final String BORDER_VERY_LONG = "==========================================================================";
    public static final String ENTER_SORTING_OPTION = """
            Виберіть варіант сортування і введіть ключове слово:
            По ID лекцій --> "lectureID"
            За видом додаткових матеріалів --> "type"
            ============================================
            Для виходу з сортування введіть будь що інше.
            """;
    public static final String INFO_ABOUT_ADDITIONAL_MATERIAL = """
            Виберіть які додаткові матеріли ви хочете додати до лекції:
            "Url адреса"
            "Відео матеріали"
            "Книжка"
            Ввівши відповідно:
            "Url"
            "Video"
            "Book"
            """;
    public static final String INFORM_FOR_LECTURE = """
            =======================================================================
            Щоб створити домашнє завдання або додаткові матеріали для лекції введіть:
            "Add homework"
            "Add additional material"
            =======================================================================
            Щоб видалити, введіть:
            "Delete homework"
            "Delete additional material"
            =======================================================================""";


    public void showFrontInform() {
        System.out.print(CASE_NOT_IMPORTANT);
        Log.info(MAIN_SERVICE, CASE_NOT_IMPORTANT);
        autoObject(courseRepository, courseService, lectureRepository, lectureService);
        System.out.printf(START_INFO, BORDER_SHORT, BORDER_LONG, INFORM_FOR_LECTURE, BORDER_SHORT);
        Log.info(MAIN_SERVICE, START_INFO);
        System.out.println(INFO_ABOUT_LOGS);
        putBorder();
        System.out.println("""
                Контрольна робота.
                ===================""");
        takeRandomTask();
        putBorder();
        System.out.printf("Для початку введіть: \"%s\"\n", START);
        scannerNameModelAndPerson();
        while (!nameModelAndPerson.equalsIgnoreCase(START)) {
            System.out.println("Something wrong, try again!!!");
            scannerNameModelAndPerson();
        }
        Log.debug(MAIN_SERVICE, METHOD_SHOW_FRONT_INFORM);
    }

    public void creatCourse() {
        Course course;
        System.out.println(YOU_CREATING_AN_OBJECT + COURSE);
        Log.info(MAIN_SERVICE, YOU_CREATING_AN_OBJECT + COURSE);
        checkNumber(OF_COURSE);
        System.out.println(ENTER_NAME_OF_COURSE);
        Log.info(MAIN_SERVICE, ENTER_NAME_OF_COURSE);
        scannerName();
        course = courseService.createCourse(getCheckNumber(), getName());
        courseRepository.getCourseList().add(course);
        System.out.printf(YOU_CREAT_COURSE, getName(), courseRepository.getCourseID(course));
        System.out.println(NOW_CREAT_OBJECT);
        Log.info(MAIN_SERVICE, YOU_CREAT_COURSE + NOW_CREAT_OBJECT);
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        scannerNameModelAndPerson();
        Log.debug(MAIN_SERVICE, "method -> \"creatCourse\"");
    }

    public void creatLecture() {
        Lecture lecture;
        System.out.println(YOU_CREATING_AN_OBJECT + LECTURE);
        Log.info(MAIN_SERVICE, YOU_CREATING_AN_OBJECT + LECTURE);
        checkNumber(OF_LECTURE);
        lectureId = getCheckNumber();
        System.out.println(ENTER_NAME_OF_LECTURE);
        Log.info(MAIN_SERVICE, ENTER_NAME_OF_LECTURE);
        scannerName();
        scannerDescription();
        System.out.println(SELECT_ID_OF_COURSE);
        Log.info(MAIN_SERVICE, SELECT_ID_OF_COURSE);
        putBorder();
        foundCourse();
        lecture = lectureService.createLecture(lectureId, getName(), getDescription(), courseId, courseName);
        lectureRepository.getLectureList().add(lecture);
        System.out.printf(YOU_CREAT_LECTURE,
                getName(), lectureRepository.getLectureId(lecture), courseId);
        Log.info(MAIN_SERVICE, YOU_CREAT_LECTURE);
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
        Log.debug(MAIN_SERVICE, "method -> \"creatLecture\"");
    }

    public void creatStudent() {
        Person student;
        System.out.println(YOU_CREATING_AN_OBJECT + STUDENT);
        Log.info(MAIN_SERVICE, YOU_CREATING_AN_OBJECT + STUDENT);
        checkNumber(OF_STUDENT);
        System.out.println(ENTER_NAME);
        Log.info(MAIN_SERVICE, ENTER_NAME);
        scannerFirstName();
        System.out.println(ENTER_LAST_NAME);
        Log.info(MAIN_SERVICE, ENTER_LAST_NAME);
        scannerLastName();
        System.out.println(ENTER_PHONE);
        Log.info(MAIN_SERVICE, ENTER_PHONE);
        scannerPhone();
        System.out.println(ENTER_EMAIL);
        Log.info(MAIN_SERVICE, ENTER_EMAIL);
        scannerEmail();
        student = studentService.createStudent(Role.STUDENT, getCheckNumber(), getFirstname(),
                getLastName(), getPhone(), getEmail());
        studentRepository.getStudentList().add(student);
        System.out.printf(YOU_CREAT_STUDENT,
                getFirstname(), getLastName(), studentRepository.getStudentId(student));
        Log.info(MAIN_SERVICE, YOU_CREAT_STUDENT);
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
        Log.debug(MAIN_SERVICE, "method -> \"creatStudent\"");
    }

    public void creatTeacher() {
        Person teacher;
        System.out.println(YOU_CREATING_AN_OBJECT + TEACHER);
        Log.info(MAIN_SERVICE, YOU_CREATING_AN_OBJECT + TEACHER);
        checkNumber(OF_TEACHER);
        System.out.println(ENTER_NAME);
        Log.info(MAIN_SERVICE, ENTER_NAME);
        scannerFirstName();
        System.out.println(ENTER_LAST_NAME);
        Log.info(MAIN_SERVICE, ENTER_LAST_NAME);
        scannerLastName();
        System.out.println(ENTER_PHONE);
        Log.info(MAIN_SERVICE, ENTER_PHONE);
        scannerPhone();
        System.out.println(ENTER_EMAIL);
        Log.info(MAIN_SERVICE, ENTER_EMAIL);
        scannerEmail();
        teacher = teacherService.createTeacher(Role.TEACHER, getCheckNumber(), getFirstname(), getLastName(),
                getPhone(), getEmail());
        teacherRepository.getTeacherList().add(teacher);
        System.out.printf(YOU_CREAT_TEACHER, getFirstname(),
                getLastName(), teacherRepository.getTeacherId(teacher));
        Log.info(MAIN_SERVICE, YOU_CREAT_TEACHER);
        putBorder();
        showInformCourseAndLecture();
        putBorder();
        showInformAboutCreation();
        Log.debug(MAIN_SERVICE, "method -> \"creatTeacher\"");
    }

    public void creatHomework() {
        System.out.println(YOU_CREATING_AN_OBJECT + HOMEWORK_FOR_LECTURE);
        Log.info(MAIN_SERVICE, YOU_CREATING_AN_OBJECT + HOMEWORK_FOR_LECTURE);
        checkNumber(HOMEWORK);
        homeworkId = getCheckNumber();
        System.out.println(SELECT_A_LECTURE);
        Log.info(MAIN_SERVICE, SELECT_A_LECTURE);
        printAllLecture();
        try {
            creatHomeworkLogic();
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_HOMEWORK + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            Log.warning(MAIN_SERVICE, METHOD_HOMEWORK + ENTITY_NOT_FOUND_EXCEPTION, e.getMessage());
        } finally {
            putBorder();
            showInformCourseAndLecture();
            putBorder();
            showInformAboutCreation();
            Log.debug(MAIN_SERVICE, METHOD_HOMEWORK);
        }
    }

    public void createResourceType() {
        try {
            System.out.println(YOU_CREATING_AN_OBJECT + ADDITIONAL_MATERIAL_FOR_LECTURE);
            Log.info(MAIN_SERVICE, ADDITIONAL_MATERIAL_FOR_LECTURE);
            checkNumber("Додаткових матеріалів");
            additionalMaterialId = getCheckNumber();
            System.out.println(NAME_FOR_ADDITIONAL_MATERIALS);
            Log.info(MAIN_SERVICE, NAME_FOR_ADDITIONAL_MATERIALS);
            scannerName();
            resourceName = getName();
            printResourceTypeInfo();
            Resource resourceType = getResource();
            System.out.printf(SELECT_A_LECTURE1, resourceType);
            Log.info(MAIN_SERVICE, SELECT_A_LECTURE1);
            printAllLecture();
            createResourceTypeLogic();
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_RESOURCE_TYPE + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            Log.warning(MAIN_SERVICE, METHOD_CREAT_RESOURCE_TYPE + ILLEGAL_ARGUMENT_EXCEPTION, e.getMessage());
        } finally {
            putBorder();
            showInformCourseAndLecture();
            putBorder();
            showInformAboutCreation();
            Log.debug(MAIN_SERVICE, METHOD_CREAT_RESOURCE_TYPE);
        }
    }

    public void creatCourseData() {
        System.out.println(SELECT_A_COURSE);
        Log.info(MAIN_SERVICE, SELECT_A_COURSE);
        printAllCourse();
        try {
            creatCourseDataLogic();
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_COURSE_DATA + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            Log.warning(MAIN_SERVICE, METHOD_CREAT_COURSE_DATA + ENTITY_NOT_FOUND_EXCEPTION, e.getMessage());
        } finally {
            putBorder();
            if (courseRepository.counter() > 1) {
                showInformAboutCreation();
            } else {
                System.out.println(CREAT_OBJECT_OF_COURSE + COURSE);
                Log.info(MAIN_SERVICE, CREAT_OBJECT_OF_COURSE);
                scannerNameModelAndPerson();
                Log.debug(MAIN_SERVICE, METHOD_CREAT_COURSE_DATA);
            }
        }
    }

    public void creatLectureData() {
        System.out.println(SELECT_A_LECTURE2);
        Log.info(MAIN_SERVICE, SELECT_A_LECTURE2);
        printAllLecture();
        try {
            creatLectureDataLogic();
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_LECTURE_DATA + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            Log.warning(MAIN_SERVICE, METHOD_CREAT_LECTURE_DATA + ENTITY_NOT_FOUND_EXCEPTION, e.getMessage());
        } finally {
            System.out.println(INFORM_FOR_LECTURE);
            Log.info(MAIN_SERVICE, INFORM_FOR_LECTURE);
            showInformAboutCreation();
            Log.debug(MAIN_SERVICE, METHOD_CREAT_LECTURE_DATA);
        }
    }

    public void creatCourseInfo() {
        try {
            if (!(courseRepository.getCourseList().isEmpty())) {
                System.out.println(INFORM_ABOUT_COURSE_SORTED);
                Log.info(MAIN_SERVICE, INFORM_ABOUT_COURSE_SORTED);
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
            Log.info(MAIN_SERVICE, IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_COURSE_INFO + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } finally {
            putBorder();
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_COURSE_INFO);
    }

    public void createLectureInfo() {
        try {
            if (!(lectureRepository.getLectureList().isEmpty())) {
                System.out.println(INFORM_ABOUT_LECTURE_SORTED);
                Log.info(MAIN_SERVICE, INFORM_ABOUT_LECTURE_SORTED);
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
            Log.info(MAIN_SERVICE, IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_LECTURE_INFO + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } finally {
            putBorder();
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_LECTURE_INFO);
    }

    public void creatTeacherInfo() {
        try {
            if (!(teacherRepository.getTeacherList().isEmpty())) {
                System.out.println(INFORM_ABOUT_TEACHER_SORTED);
                Log.info(MAIN_SERVICE, INFORM_ABOUT_TEACHER_SORTED);
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
            Log.info(MAIN_SERVICE, IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_TEACHER_INFO + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } finally {
            putBorder();
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_TEACHER_INFO);
    }

    public void creatStudentInfo() {
        try {
            if (!(studentRepository.getStudentList().isEmpty())) {
                System.out.println(INFORM_ABOUT_STUDENT_SORTED);
                Log.info(MAIN_SERVICE, INFORM_ABOUT_STUDENT_SORTED);
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
            Log.info(MAIN_SERVICE, IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_STUDENT_INFO + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } finally {
            putBorder();
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_STUDENT_INFO);
    }

    public void creatHomeworkInfo() {
        isPresent = false;
        for (List<Homework> listHomework : homeworkRepository.getListHomeworkMap().values()) {
            if (!(listHomework.isEmpty())) {
                isPresent = true;
                break;
            }
        }
        try {
            if (isPresent) {
                sortedHomework();
            } else System.out.println(IS_EMPTY);
            Log.info(MAIN_SERVICE, IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_HOMEWORK_INFO + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } finally {
            putBorder();
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_HOMEWORK_INFO);
    }

    public void creatAdditionalMaterialInfo() {
        isPresent = false;
        for (List<AdditionalMaterial> listMaterials : additionalMaterialRepository.getListAdditionalMaterialMap().values()) {
            if (!(listMaterials.isEmpty())) {
                isPresent = true;
                break;
            }
        }
        try {
            if (isPresent) {
                additionalMaterialSortDefault();
                additionalMaterialSort();
            } else System.out.println(IS_EMPTY);
            Log.info(MAIN_SERVICE, IS_EMPTY);
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_ADDITIONAL_MATERIAL_INFO + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } finally {
            putBorder();
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_ADDITIONAL_MATERIAL_INFO);
    }

    public void creatDeleteCourse() {
        System.out.println(COURSE_FOR_DELETE);
        Log.info(MAIN_SERVICE, COURSE_FOR_DELETE);
        printAllCourse();
        checkNumber(OF_COURSE);
        long courseId = getCheckNumber();
        isPresent = true;
        for (int i = 0; i < courseRepository.getCourseList().size(); i++) {
            if (courseRepository.getCourseList().get(i).getCourseId().equals(courseId)) {
                System.out.printf(OBJECT_IS_DELETE, courseRepository.getCourseList().remove(i));
                Log.info(MAIN_SERVICE, OBJECT_IS_DELETE);
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
            Log.info(MAIN_SERVICE, ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
        Log.debug(MAIN_SERVICE, METHOD_CREAT_DELETE_COURSE);
    }

    public void creatDeleteLecture() {
        System.out.println(LECTURE_FOR_DELETE);
        Log.info(MAIN_SERVICE, LECTURE_FOR_DELETE);
        printAllLecture();
        checkNumber(OF_LECTURE);
        long lectureId = getCheckNumber();
        isPresent = true;
        for (int i = 0; i < lectureRepository.getLectureList().size(); i++) {
            if (lectureRepository.getLectureList().get(i).getLectureId().equals(lectureId)) {
                System.out.printf(OBJECT_IS_DELETE, lectureRepository.getLectureList().remove(i));
                Log.info(MAIN_SERVICE, OBJECT_IS_DELETE);
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
            Log.info(MAIN_SERVICE, ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
        Log.debug(MAIN_SERVICE, METHOD_CREAT_DELETE_LECTURE);
    }

    public void creatDeleteTeacher() {
        System.out.println(TEACHER_FOR_DELETE);
        Log.info(MAIN_SERVICE, TEACHER_FOR_DELETE);
        printAllTeacher();
        checkNumber(OF_TEACHER);
        long teacherId = getCheckNumber();
        isPresent = true;
        for (int i = 0; i < teacherRepository.getTeacherList().size(); i++) {
            if (teacherRepository.getTeacherList().get(i).getPersonId().equals(teacherId)) {
                System.out.printf(OBJECT_IS_DELETE, teacherRepository.getTeacherList().remove(i));
                Log.info(MAIN_SERVICE, OBJECT_IS_DELETE);
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
            Log.info(MAIN_SERVICE, ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
        Log.debug(MAIN_SERVICE, METHOD_CREAT_DELETE_TEACHER);
    }

    public void creatDeleteStudent() {
        System.out.println(STUDENT_FOR_DELETE);
        Log.info(MAIN_SERVICE, STUDENT_FOR_DELETE);
        printAllStudent();
        checkNumber(OF_STUDENT);
        long studentId = getCheckNumber();
        isPresent = true;
        for (int i = 0; i < studentRepository.getStudentList().size(); i++) {
            if (studentRepository.getStudentList().get(i).getPersonId().equals(studentId)) {
                System.out.printf(OBJECT_IS_DELETE, studentRepository.getStudentList().remove(i));
                Log.info(MAIN_SERVICE, OBJECT_IS_DELETE);
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.err.println(ID_IS_NOT_FOUND);
            Log.info(MAIN_SERVICE, ID_IS_NOT_FOUND);
        }
        showInformAboutCreation();
        Log.debug(MAIN_SERVICE, METHOD_CREAT_DELETE_STUDENT);
    }

    public void creatDeleteHomework() {
        System.out.println(HOMEWORK_FOR_DELETE);
        Log.info(MAIN_SERVICE, HOMEWORK_FOR_DELETE);
        printAllHomework();
        checkNumber(HOMEWORK);
        long homeworkId = getCheckNumber();
        try {
            isPresent = true;
            for (List<Homework> homeworkMap : homeworkRepository.getListHomeworkMap().values()) {
                if (homeworkMap.removeIf(homework -> homework.getHomeworkId().equals(homeworkId))) {
                    System.out.println(OBJECT_IS_DELETE1);
                    Log.info(MAIN_SERVICE, OBJECT_IS_DELETE1);
                    isPresent = false;
                }
            }
            if (isPresent) {
                System.out.println(IS_EMPTY);
                Log.info(MAIN_SERVICE, IS_EMPTY);
            }
        } catch (NullPointerException n) {
            System.err.println(ID_IS_NOT_FOUND);
            Log.error(MAIN_SERVICE, METHOD_CREAT_DELETE_HOMEWORK + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } finally {
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_DELETE_HOMEWORK);
    }

    public void creatDeleteAdditionalMaterial() {
        System.out.println(RESOURCE_FOR_DELETE);
        Log.info(MAIN_SERVICE, RESOURCE_FOR_DELETE);
        printAllAdditionalMaterial();
        checkNumber(ADDITIONAL_MATERIAL);
        long additionalMaterialId = getCheckNumber();
        try {
            isPresent = true;
            for (List<AdditionalMaterial> materialMap : additionalMaterialRepository.getListAdditionalMaterialMap().values()) {
                if (materialMap.removeIf(material -> material.getResourceId().equals(additionalMaterialId))) {
                    System.out.println(OBJECT_IS_DELETE1);
                    Log.info(MAIN_SERVICE, OBJECT_IS_DELETE1);
                    isPresent = false;
                }
            }
            if (isPresent) {
                System.out.println(IS_EMPTY);
                Log.info(MAIN_SERVICE, IS_EMPTY);
            }
        } catch (NullPointerException n) {
            System.err.println(ID_IS_NOT_FOUND);
            Log.error(MAIN_SERVICE, METHOD_CREAT_DELETE_ADDITIONAL_MATERIAL + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } finally {
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_DELETE_ADDITIONAL_MATERIAL);
    }


    public void creatTeacherForLecture() {
        System.out.println(LECTURE_FOR_TEACHER);
        Log.info(MAIN_SERVICE, LECTURE_FOR_TEACHER);
        printAllLecture();
        checkNumber(OF_LECTURE);
        long lectureId = getCheckNumber();
        System.out.println(SELECT_OF_A_TEACHER);
        Log.info(MAIN_SERVICE, SELECT_OF_A_TEACHER);
        printAllTeacher();
        checkNumber(OF_TEACHER);
        long teacherId = getCheckNumber();
        try {
            teacherService.addPersonToLecture(OF_TEACHER, lectureId, teacherId, lectureRepository.getLectureList(), teacherRepository.getTeacherList());
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_TEACHER_FOR_LECTURE + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            Log.warning(MAIN_SERVICE, METHOD_CREAT_TEACHER_FOR_LECTURE + ENTITY_NOT_FOUND_EXCEPTION, e.getMessage());
        } finally {
            showInformCourseAndLecture();
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_TEACHER_FOR_LECTURE);
    }

    public void creatStudentForLecture() {
        System.out.println(LECTURE_FOR_STUDENT);
        Log.info(MAIN_SERVICE, LECTURE_FOR_STUDENT);
        printAllLecture();
        checkNumber(OF_LECTURE);
        long lectureId = getCheckNumber();
        System.out.println(SELECT_OF_A_STUDENT);
        Log.info(MAIN_SERVICE, SELECT_OF_A_STUDENT);
        printAllStudent();
        checkNumber(OF_STUDENT);
        long studentId = getCheckNumber();
        try {
            studentService.addPersonToLecture(OF_STUDENT, lectureId, studentId, lectureRepository.getLectureList(), studentRepository.getStudentList());
        } catch (NullPointerException n) {
            n.printStackTrace();
            Log.error(MAIN_SERVICE, METHOD_CREAT_STUDENT_FOR_LECTURE + NULL_POINTER_EXCEPTION, Arrays.toString(n.getStackTrace()));
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            Log.warning(MAIN_SERVICE, METHOD_CREAT_STUDENT_FOR_LECTURE + ENTITY_NOT_FOUND_EXCEPTION, e.getMessage());
        } finally {
            showInformCourseAndLecture();
            showInformAboutCreation();
        }
        Log.info(MAIN_SERVICE, METHOD_CREAT_STUDENT_FOR_LECTURE);
    }

    public void creatAddPersonForLecture() {
        System.out.println(ENTER_ADD_FOR_LECTURE);
        Log.info(MAIN_SERVICE, ENTER_ADD_FOR_LECTURE);
        scannerNameModelAndPerson();
        if (getNameModelAndPerson().equalsIgnoreCase(TEACHER)) {
            setNameModelAndPerson("вчитель для лекції");
        } else if (getNameModelAndPerson().equalsIgnoreCase(STUDENT)) {
            setNameModelAndPerson("студент для лекції");
        } else {
            System.out.println(WRONG_ENTER);
            Log.info(MAIN_SERVICE, WRONG_ENTER);
            showInformAboutCreation();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_ADD_PERSON_FOR_LECTURE);
    }

    public void creatDefault() {
        try {
            throw new IllegalArgumentException(SYMBOL_IS_INCORRECT);
        } catch (IllegalArgumentException il) {
            System.err.println(il.getMessage());
            Log.warning(MAIN_SERVICE, METHOD_CREAT_DEFAULT + ILLEGAL_ARGUMENT_EXCEPTION, il.getMessage());
        } finally {
            System.out.println(REPAID_AGAIN);
            Log.info(MAIN_SERVICE, REPAID_AGAIN);
            scannerNameModelAndPerson();
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_DEFAULT);
    }

    public void checkNumber(String outName) {
        long test;
        isPresent = true;
        while (isPresent) {
            System.out.printf(ENTER_NUMBER, outName);
            Log.info(MAIN_SERVICE, ENTER_NUMBER);
            if (scanner.hasNextLong()) {
                test = scanner.nextLong();
                scanner.nextLine();
                if (test > 0 && test < Long.MAX_VALUE) {
                    number = test;
                    isPresent = false;
                }
            } else {
                System.out.println(WRONG_ENTER1);
                Log.info(MAIN_SERVICE, WRONG_ENTER1);
                scannerNameModelAndPerson();
            }
        }
        Log.debug(MAIN_SERVICE, METHOD_CHECK_NUMBER);
    }

    public void scannerName() {
        isPresent = true;
        String result;
        while (isPresent) {
            System.out.println(ENTER_WORDS);
            Log.info(MAIN_SERVICE, ENTER_WORDS);
            result = scanner.nextLine();
            try {
                if (!(makeValidate(result, namePattern))) {
                    throw new IllegalArgumentException(result);
                } else {
                    name = result;
                    System.out.println(NAME_SAVED);
                    Log.info(MAIN_SERVICE, NAME_SAVED);
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                Log.warning(MAIN_SERVICE, METHOD_SCANNER_NAME + ILLEGAL_ARGUMENT_EXCEPTION, i.getMessage());
                try {
                    throw new EntityNotFoundException(STRING_IS_INCORRECT, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                    Log.error(MAIN_SERVICE, METHOD_SCANNER_NAME + ENTITY_NOT_FOUND_EXCEPTION, Arrays.toString(e.getStackTrace()));
                }
            }
        }
        Log.debug(MAIN_SERVICE, METHOD_SCANNER_NAME);
    }

    public void scannerDescription() {
        isPresent = true;
        String testDescription;
        while (isPresent) {
            System.out.printf(ENTER_DESCRIPTION_OF_LECTURE, 3, 20);
            Log.info(MAIN_SERVICE, ENTER_DESCRIPTION_OF_LECTURE);
            testDescription = scanner.nextLine();
            try {
                if (!(makeValidate(testDescription, descriptionPattern))) {
                    throw new IllegalArgumentException(testDescription);
                } else {
                    description = testDescription;
                    System.out.println(DESCRIPTION_OF_LECTURE_SAVED);
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                Log.warning(MAIN_SERVICE, METHOD_SCANNER_DESCRIPTION + ILLEGAL_ARGUMENT_EXCEPTION, i.getMessage());
                try {
                    throw new EntityNotFoundException(STRING_IS_INCORRECT, i);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                    Log.error(MAIN_SERVICE, METHOD_SCANNER_DESCRIPTION + ENTITY_NOT_FOUND_EXCEPTION, Arrays.toString(e.getStackTrace()));
                }
            }
        }
        Log.debug(MAIN_SERVICE, METHOD_SCANNER_DESCRIPTION);
    }

    public void scannerHomeTask() {
        isPresent = true;
        String task;
        while (isPresent) {
            System.out.printf(WRITE_HOMEWORK, 3, 20);
            Log.info(MAIN_SERVICE, WRITE_HOMEWORK);
            task = scanner.nextLine();
            try {
                if (!(makeValidate(task, descriptionPattern))) {
                    throw new IllegalArgumentException(task);
                } else {
                    this.task = task;
                    System.out.println(HOMEWORK_IS_SAVED);
                    Log.info(MAIN_SERVICE, HOMEWORK_IS_SAVED);
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                Log.warning(MAIN_SERVICE, METHOD_SCANNER_HOME_TASK + ILLEGAL_ARGUMENT_EXCEPTION, i.getMessage());
                try {
                    throw new EntityNotFoundException(STRING_IS_INCORRECT, i);
                } catch (EntityNotFoundException e) {
                    Log.error(MAIN_SERVICE, METHOD_SCANNER_HOME_TASK + ENTITY_NOT_FOUND_EXCEPTION, Arrays.toString(e.getStackTrace()));
                    e.printStackTrace();
                }
            }
        }
        Log.debug(MAIN_SERVICE, METHOD_SCANNER_HOME_TASK);
    }

    public void scannerPhone() {
        isPresent = true;
        String testPhoneNumber;
        while (isPresent) {
            System.out.println(PATTERN_OF_NUMBER);
            testPhoneNumber = scanner.nextLine();
            Log.info(MAIN_SERVICE, PATTERN_OF_NUMBER);
            try {
                if (!(makeValidate(testPhoneNumber, phoneNumberPattern))) {
                    throw new IllegalArgumentException(testPhoneNumber);
                } else {
                    phone = testPhoneNumber;
                    System.out.println(NUMBER_SAVED);
                    Log.info(MAIN_SERVICE, NUMBER_SAVED);
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                Log.warning(MAIN_SERVICE, METHOD_SCANNER_PHONE + ILLEGAL_ARGUMENT_EXCEPTION, i.getMessage());
                try {
                    throw new EntityNotFoundException("Number is incorrect!!!", i);
                } catch (EntityNotFoundException e) {
                    Log.error(MAIN_SERVICE, METHOD_SCANNER_PHONE + ENTITY_NOT_FOUND_EXCEPTION, Arrays.toString(e.getStackTrace()));
                    e.printStackTrace();
                }
            }
        }
        Log.debug(MAIN_SERVICE, METHOD_SCANNER_PHONE);
    }


    public void scannerEmail() {
        isPresent = true;
        String testEmail;
        while (isPresent) {
            System.out.println(PATTERN_OF_EMAIL);
            Log.info(MAIN_SERVICE, PATTERN_OF_EMAIL);
            testEmail = scanner.nextLine();
            try {
                if (!(makeValidate(testEmail, emailPattern))) {
                    throw new IllegalArgumentException(testEmail);
                } else {
                    email = testEmail;
                    System.out.println(EMAIL_SAVED);
                    Log.info(MAIN_SERVICE, EMAIL_SAVED);
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                Log.warning(MAIN_SERVICE, METHOD_SCANNER_EMAIL + ILLEGAL_ARGUMENT_EXCEPTION, i.getMessage());
                try {
                    throw new EntityNotFoundException("Email is incorrect!!!", i);
                } catch (EntityNotFoundException e) {
                    Log.error(MAIN_SERVICE, METHOD_SCANNER_EMAIL + ENTITY_NOT_FOUND_EXCEPTION, Arrays.toString(e.getStackTrace()));
                    e.printStackTrace();
                }
            }
        }
        Log.debug(MAIN_SERVICE, METHOD_SCANNER_EMAIL);
    }


    public String checkFirstAndLastName() {
        isPresent = true;
        String result = "";
        String testFirstOrLastName;
        while (isPresent) {
            System.out.println(ENTER_ONE_WORD);
            Log.info(MAIN_SERVICE, ENTER_ONE_WORD);
            testFirstOrLastName = scanner.nextLine();
            try {
                if (!(makeValidate(testFirstOrLastName, firstOrLastNamePattern))) {
                    throw new IllegalArgumentException(testFirstOrLastName);
                } else {
                    result = testFirstOrLastName;
                    System.out.println(SAVED);
                    Log.info(MAIN_SERVICE, SAVED);
                    isPresent = false;
                }
            } catch (IllegalArgumentException i) {
                Log.warning(MAIN_SERVICE, METHOD_CHECK_NAME + ILLEGAL_ARGUMENT_EXCEPTION, i.getMessage());
                try {
                    throw new EntityNotFoundException(STRING_IS_INCORRECT, i);
                } catch (EntityNotFoundException e) {
                    Log.error(MAIN_SERVICE, METHOD_CHECK_NAME + ENTITY_NOT_FOUND_EXCEPTION, Arrays.toString(e.getStackTrace()));
                    e.printStackTrace();
                }
            }
        }
        Log.info(MAIN_SERVICE, METHOD_CHECK_NAME);
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
            System.out.println(ENTER_LETTER);
            Log.info(MAIN_SERVICE, ENTER_LETTER);
        }
        Log.debug(MAIN_SERVICE, METHOD_GET_RESOURCE);
        return resourceType;
    }

    public void foundCourse() {
        for (Course c : courseRepository.getCourseList()) {
            System.out.println(c);
            Log.info(MAIN_SERVICE, String.valueOf(c));
        }
        putBorder();
        isPresent = true;
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
                System.out.println(WRONG_ID);
                Log.info(MAIN_SERVICE, WRONG_ID);
            }
        }
        Log.info(MAIN_SERVICE, METHOD_FOUND_COURSE);
    }

    public void printResourceTypeInfo() {
        System.out.println(INFO_ABOUT_ADDITIONAL_MATERIAL);
        Log.info(MAIN_SERVICE, INFO_ABOUT_ADDITIONAL_MATERIAL);
        Log.debug(MAIN_SERVICE, METHOD_PRINT_RESOURCE);
    }

    public void additionalMaterialSort() {
        isPresent = true;
        while (isPresent) {
            putBorder();
            System.out.print(ENTER_SORTING_OPTION);
            Log.info(MAIN_SERVICE, ENTER_SORTING_OPTION);
            scannerNameModelAndPerson();
            if (getNameModelAndPerson().equalsIgnoreCase("lectureID")) {
                putBorder();
                System.out.println(ADDITIONAL_MATERIAL_SORTED);
                Log.info(MAIN_SERVICE, ADDITIONAL_MATERIAL_SORTED);
                AdditionalMaterialSortLectureId materialSortLectureIdComparator = new AdditionalMaterialSortLectureId();
                Set<AdditionalMaterial> materialSet = new TreeSet<>(materialSortLectureIdComparator);
                materialSet.addAll(allAdditionalMaterials);
                for (AdditionalMaterial material : materialSet) {
                    System.out.println(material);
                    Log.info(MAIN_SERVICE, String.valueOf(material));
                }
            } else if (getNameModelAndPerson().equalsIgnoreCase("type")) {
                putBorder();
                System.out.println(ADDITIONAL_MATERIAL_SORTED1);
                Log.info(MAIN_SERVICE, ADDITIONAL_MATERIAL_SORTED1);
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
        Log.debug(MAIN_SERVICE, METHOD_ADDITIONAL_MATERIAL_SORT);
    }

    public void printAllLecture() {
        putBorder();
        for (Lecture l : lectureRepository.getLectureList()) {
            System.out.println(l);
            Log.info(MAIN_SERVICE, String.valueOf(l));
        }
        putBorder();
        Log.debug(MAIN_SERVICE, METHOD_PRINT_ALL_LECTURE);
    }

    public void printAllCourse() {
        putBorder();
        for (Course c : courseRepository.getCourseList()) {
            System.out.println(c);
            Log.info(MAIN_SERVICE, String.valueOf(c));
        }
        putBorder();
        Log.debug(MAIN_SERVICE, METHOD_PRINT_ALL_COURSE);
    }

    public void printAllTeacher() {
        putBorder();
        for (Person t : teacherRepository.getTeacherList()) {
            System.out.println(t);
            Log.info(MAIN_SERVICE, String.valueOf(t));
        }
        putBorder();
        Log.debug(MAIN_SERVICE, METHOD_PRINT_ALL_TEACHER);
    }

    public void printAllStudent() {
        putBorder();
        for (Person s : studentRepository.getStudentList()) {
            System.out.println(s);
            Log.info(MAIN_SERVICE, String.valueOf(s));
        }
        putBorder();
        Log.debug(MAIN_SERVICE, METHOD_PRINT_ALL_STUDENT);
    }

    public void printAllHomework() {
        putBorder();
        for (List<Homework> homeworkList : homeworkRepository.getListHomeworkMap().values()) {
            for (Homework h : homeworkList) {
                System.out.println(h);
                Log.info(MAIN_SERVICE, String.valueOf(h));
            }
        }
        putBorder();
        Log.debug(MAIN_SERVICE, METHOD_PRINT_ALL_HOMEWORK);
    }

    public void printAllAdditionalMaterial() {
        putBorder();
        for (List<AdditionalMaterial> mapMaterials : additionalMaterialRepository.getListAdditionalMaterialMap().values()) {
            for (AdditionalMaterial a : mapMaterials) {
                System.out.println(a);
                Log.info(MAIN_SERVICE, String.valueOf(a));
            }
        }
        putBorder();
        Log.debug(MAIN_SERVICE, METHOD_PRINT_ALL_ADDITIONAL_MATERIAL);
    }

    public void creatLectureDataLogic() {
        checkNumber(OF_LECTURE);
        lectureId = getCheckNumber();
        lectureService.showLectures(lectureId, lectureRepository.getLectureList());
        putBorder();
        try {
            teacherRepository.showInformPerson(TEACHER_ENG, lectureId, lectureRepository.getLectureList(), teacherRepository.getTeacherList());
            putBorder();
        } catch (EntityNotFoundException e) {
            Log.warning(MAIN_SERVICE, METHOD_CREAT_LECTURE_DATA_LOGIC + ENTITY_NOT_FOUND_EXCEPTION, e.getMessage());
            System.err.println(e.getMessage());
        } finally {
            try {
                studentRepository.showInformPerson(STUDENT_ENG, lectureId, lectureRepository.getLectureList(), studentRepository.getStudentList());
                putBorder();
            } catch (EntityNotFoundException e) {
                Log.warning(MAIN_SERVICE, METHOD_CREAT_LECTURE_DATA_LOGIC + ENTITY_NOT_FOUND_EXCEPTION, e.getMessage());
                System.err.println(e.getMessage());
            } finally {
                try {
                    homeworkService.showInformHomework(lectureId, homeworkRepository.getListHomeworkMap());
                    putBorder();
                } catch (EntityNotFoundException e) {
                    Log.warning(MAIN_SERVICE, METHOD_CREAT_LECTURE_DATA_LOGIC + ENTITY_NOT_FOUND_EXCEPTION, e.getMessage());
                    System.err.println(e.getMessage());
                } finally {
                    additionalMaterialService.showInformAdditionalMaterial(lectureId, additionalMaterialRepository.getListAdditionalMaterialMap());
                }
            }
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_LECTURE_DATA_LOGIC);
    }

    public void creatCourseDataLogic() {
        checkNumber(OF_COURSE);
        courseId = getCheckNumber();
        courseService.showInformCourse(courseId, courseRepository.getCourseList());
        lectureService.showLecturesInCourse(courseId, lectureRepository.getLectureList());
        putBorder();
        try {
            teacherRepository.showInformPerson(TEACHER_ENG, courseId, lectureRepository.getLectureList(), teacherRepository.getTeacherList());
            putBorder();
        } catch (EntityNotFoundException e) {
            Log.warning(MAIN_SERVICE, METHOD_CREAT_COURSE_DATA_LOGIC + ENTITY_NOT_FOUND_EXCEPTION, e.getMessage());
            System.err.println(e.getMessage());
        } finally {
            studentRepository.showInformPerson(STUDENT_ENG, courseId, lectureRepository.getLectureList(), studentRepository.getStudentList());
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_COURSE_DATA_LOGIC);
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
        System.out.println(BORDER_VERY_LONG);
        Log.info(MAIN_SERVICE, BORDER_VERY_LONG);
        System.out.printf(AUTO_COURSE,
                courseRepository.getCourseList().get(indexCourse).getCourseId());
        Log.info(MAIN_SERVICE, AUTO_COURSE);
        System.out.println(BORDER_LONG);
        Log.info(MAIN_SERVICE, BORDER_LONG);
        System.out.println(ALL_INFO);
        Log.info(MAIN_SERVICE, ALL_INFO);
        System.out.println(BORDER_VERY_LONG);
        Log.info(MAIN_SERVICE, BORDER_VERY_LONG);
        Log.debug(MAIN_SERVICE, METHOD_AUTO_OBJECT);
    }

    public boolean foundLecture(Long lectureId) {
        Log.debug(MAIN_SERVICE, METHOD_FOUND_LECTURE);
        for (Lecture lecture : lectureRepository.getLectureList()) {
            if (lecture.getLectureId().equals(lectureId)) {
                return true;
            }
        }
        return false;
    }

    public void sortedHomework() {
        System.out.println(INFORM_ABOUT_HOMEWORK_SORTED);
        Log.info(MAIN_SERVICE, INFORM_ABOUT_HOMEWORK_SORTED);
        putBorder();
        allHomework.clear();
        for (List<Homework> homeworkList : homeworkRepository.getListHomeworkMap().values()) {
            allHomework.addAll(homeworkList);
        }
        if (homeworkTreeSet.isEmpty()) {
            homeworkTreeSet.addAll(allHomework);
        } else {
            homeworkTreeSet.retainAll(allHomework);
        }
        for (Homework homework : homeworkTreeSet) {
            System.out.println(homework);
        }
        Log.debug(MAIN_SERVICE, METHOD_SORTED_HOME);
    }

    public void creatHomeworkLogic() {
        isPresent = false;
        while (!isPresent) {
            checkNumber(OF_LECTURE);
            lectureId = getCheckNumber();
            if ((!(homeworkRepository.getListHomeworkMap().containsKey(lectureId))) && foundLecture(lectureId)) {
                homeworkRepository.creatNewCollectionHomeworks(lectureId);
            }
            if (foundLecture(lectureId)) {
                scannerHomeTask();
                homeTask = getTask();
            }
            isPresent = homeworkRepository.addHomeworkToCollection(lectureId, homeworkService.createHomework(homeworkId, lectureId, homeTask));
        }
        Log.debug(MAIN_SERVICE, METHOD_CREAT_HOME_LOGIC);
    }

    public void createResourceTypeLogic() {
        isPresent = false;
        while (!isPresent) {
            checkNumber(OF_LECTURE);
            lectureId = getCheckNumber();
            if ((!(additionalMaterialRepository.getListAdditionalMaterialMap().containsKey(lectureId))) && foundLecture(lectureId)) {
                additionalMaterialRepository.creatNewCollectionAdditionalMaterials(lectureId);
            }
            isPresent = additionalMaterialRepository.addAdditionalMaterialToCollection(lectureId,
                    additionalMaterialService.createAdditionalMaterials(additionalMaterialId, resourceName, lectureId, resourceType));
        }
        Log.debug(MAIN_SERVICE, METHOD_CREATE_RESOURCE_TYPE_LOGIC);
    }

    public void additionalMaterialSortDefault() {
        System.out.println(INFORM_ABOUT_ADDITIONAL_MATERIAL);
        Log.info(MAIN_SERVICE, INFORM_ABOUT_ADDITIONAL_MATERIAL);
        putBorder();
        allAdditionalMaterials.clear();
        for (List<AdditionalMaterial> listMaterials : additionalMaterialRepository.getListAdditionalMaterialMap().values()) {
            allAdditionalMaterials.addAll(listMaterials);
        }
        if (additionalMaterialTreeSet.isEmpty()) {
            additionalMaterialTreeSet.addAll(allAdditionalMaterials);
        } else {
            additionalMaterialTreeSet.retainAll(allAdditionalMaterials);
        }
        for (AdditionalMaterial additionalMaterial : additionalMaterialTreeSet) {
            System.out.println(additionalMaterial);
        }
        Log.debug(MAIN_SERVICE, METHOD_ADDITIONAL_MATERIAL_SORT_DEFAULT);
    }

    public void logInfo(Level logName) {
        readAndWrite.info(logName, log.getLogArray());
        putBorder();
        showInformAboutCreation();
        Log.debug(MAIN_SERVICE, METHOD_LOGIC);
    }

    public void scannerNameModelAndPerson() {
        nameModelAndPerson = scanner.nextLine();
        Log.debug(MAIN_SERVICE, METHOD_SCANNER_NAME_MODEL);
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

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getTask() {
        return task;
    }

    public ReadAndWrite getReadAndWrite() {
        return readAndWrite;
    }

    public void putBorder() {
        System.out.println(SO_LONG_BORDER);
        Log.info(MAIN_SERVICE, SO_LONG_BORDER);
    }

    public void showInformCourseAndLecture() {
        System.out.println(ALL_INFORM);
        Log.info(MAIN_SERVICE, ALL_INFORM);
        Log.debug(MAIN_SERVICE, METHOD_SHOW_INFORM);
    }

    public void showInformAboutCreation() {
        System.out.println(CONTINUE_INFO);
        Log.info(MAIN_SERVICE, CONTINUE_INFO);
        nameModelAndPerson = scanner.nextLine();
        Log.debug(MAIN_SERVICE, METHOD_SHOW_INFORM_ABOUT_CREATION);
    }

    public void takeRandomTask() {
        studentsArray = controlWork.createStudentsArray();
        controlWork.creatTaskForStudent(studentsArray);
        for (int i = 0; i < studentsArray.length; i++) {
            studentsArray[i].setStudentNumber(i + 1);
            listOfStudentsForThread.add(studentsArray[i]);
            System.out.println(listOfStudentsForThread.get(i));
        }
    }

    public void startControlWork() {
        try {
            controlWork.controlWorkStart(listOfStudentsForThread, studentsArray);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        studentRepository.getStudentList().addAll(listOfStudentsForThread);
        putBorder();
        System.out.println("Тепер створіть об'єкт курсу, ввівши: \"Курс\"");
        scannerNameModelAndPerson();
    }
}






