package online_school.service;

import online_school.repositorie.CourseRepository;
import online_school.repositorie.LectureRepository;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainService {
    private static final String EMAIL_PATTERN = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String PHONE_NUMBER_PATTERN = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    private static final String FIRST_OR_LAST_NAME_PATTERN = "^[А-ЯІЇЄа-яіїєa-z]+$";
    private static final String NAME_PATTERN = "^(\\S+\\s){0,3}\\S+$";
    private static final String DESCRIPTION_PATTERN = "^(\\S+\\s){2,19}\\S+$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern phoneNumberPattern = Pattern.compile(PHONE_NUMBER_PATTERN);
    private static final Pattern firstOrLastNamePattern = Pattern.compile(FIRST_OR_LAST_NAME_PATTERN, Pattern.CASE_INSENSITIVE);
    private static final Pattern descriptionPattern = Pattern.compile(DESCRIPTION_PATTERN, Pattern.CASE_INSENSITIVE);
    private static final Pattern namePattern = Pattern.compile(NAME_PATTERN, Pattern.CASE_INSENSITIVE);
    private final Scanner scanner = new Scanner(System.in);
    private long number;
    private String name;
    private String nameModelAndPerson;
    private String description;
    private String firstname;
    private String lastName;
    private String phone;
    private String email;

    public void autoObject(CourseRepository courseRepository, CourseService courseService, LectureRepository lectureRepository, LectureService lectureService) {
        courseRepository.add(courseService.courseCreation(1, "Auto course"));
        for (int i = 1; i < 4; i++) {
            lectureRepository.add(lectureService.lectureCreation(i, "No name", "No description"));
            lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
        }
        System.out.println("==========================================================================");
        System.out.printf("Створено автоматичний курс з іменем \"Auto course\"\n з ID \"%d\" і з трьома лекціями \"No name\".\n", courseRepository.getAll()[0].getID());
        System.out.println("==========================================================================");
        informCourseAndLecture();
        System.out.println("==========================================================================");

    }

    public void checkNumber(String outName) {
        long test;
        boolean trueOrFalseCourse = true;
        while (trueOrFalseCourse) {
            System.out.printf("Введіть ID %s, число не менше \"0\", i не більше \"%d\":\n", outName, Long.MAX_VALUE - 150);
            if (scanner.hasNextLong()) {
                test = scanner.nextLong();
                scanner.nextLine();
                if (test > 0 && test < Long.MAX_VALUE) {
                    number = test;
                    trueOrFalseCourse = false;
                }
            } else {
                System.out.println("Не правильний ввід, або завелике число.\nВведіть ще раз!!!");
                scannerNameModelAndPerson();
            }
        }
    }

    public void scannerName() {
        boolean trueFalse = true;
        String result;
        while (trueFalse) {
            System.out.println("Введіть від одного до чотирьох слів !!!");
            result = scanner.nextLine();
            if (validate(result, namePattern)) {
                name = result;
                System.out.println("Назву збережено!!!");
                trueFalse = false;
            } else {
                System.out.println("Не коректний формат !!!");
            }
        }
    }

    public void scannerNameModelAndPerson() {
        nameModelAndPerson = scanner.nextLine();
    }

    public void scannerFirstName() {
        firstname = correctInputFirstOrLastName();
    }

    public void scannerLastName() {
        lastName = correctInputFirstOrLastName();
    }

    public void scannerDescription() {
        boolean trueOrFalse = true;
        String testDescription;
        while (trueOrFalse) {
            System.out.printf("Введіть опис лекції, від \"%d\" до \"%d\" символів.\n", 3, 20);
            testDescription = scanner.nextLine();
            if (validate(testDescription, descriptionPattern)) {
                description = testDescription;
                System.out.println("Опис лекції збережено!!!");
                trueOrFalse = false;
            } else {
                System.out.println("Не коректний формат !!!");
            }
        }
    }

    public void scannerPhone() {
        boolean trueFalse = true;
        String format = "«+38(044)555-55-55»";
        String testPhoneNumber;
        while (trueFalse) {
            System.out.printf("Формат номера: %s\n", format);
            testPhoneNumber = scanner.nextLine();
            if (validate(testPhoneNumber, phoneNumberPattern)) {
                phone = testPhoneNumber;
                System.out.println("Номер телефону збережено!!!");
                trueFalse = false;
            } else {
                System.out.println("Не коректний формат !!!");
            }
        }
    }

    public void scannerEmail() {
        boolean trueFalse = true;
        String testEmail;
        while (trueFalse) {
            System.out.println("Формат електронної пошти: «nick@mail.com»");
            testEmail = scanner.nextLine();
            if (validate(testEmail, emailPattern)) {
                email = testEmail;
                System.out.println("Пошту збережено збережено!!!");
                trueFalse = false;
            } else {
                System.out.println("Не коректний формат !!!");
            }
        }
    }

    public static boolean validate(final String hex, Pattern pattern) {
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }


    public String correctInputFirstOrLastName() {
        boolean trueFalse = true;
        String result = "";
        String testFirstOrLastName;
        while (trueFalse) {
            System.out.println("Ведіть одне слово, без цифр пробілів і розділових знаків!!!");
            testFirstOrLastName = scanner.nextLine();
            if (validate(testFirstOrLastName, firstOrLastNamePattern)) {
                result = testFirstOrLastName;
                System.out.println("Збережено!!!");
                trueFalse = false;
            } else {
                System.out.println("Не коректний формат !!!");
            }
        }
        return result;
    }

    public long getNumber() {
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

    public void border() {
        System.out.println("===================================================================================================================================================");
    }

    public void informCourseAndLecture() {
        System.out.println("Для виводу всієї інфрмації про курс, або про лекцію, введіть: \n\"Course data\"\n\"Lecture data\"");
    }

    public void inform() {
        System.out.println("Можете продовжувати створювати студентів, вчителів, лекції.");
        nameModelAndPerson = scanner.nextLine();
    }

    public String message() {
        return "Ви створюєте об'єкт: ";
    }
}

