package online_school.service;

import online_school.repositorie.CourseRepository;
import online_school.repositorie.LectureRepository;

import java.util.Scanner;

import static online_school.course.model.RegularExpression.*;

public class MainService {
    private final Scanner scanner = new Scanner(System.in);
    private long number;
    private String name;
    private String nameModelAndPerson;
    private String description;
    private String firstname;
    private String lastName;
    private String phone;
    private String email;
    private String task;

    public void autoObject(CourseRepository courseRepository, CourseService courseService, LectureRepository lectureRepository, LectureService lectureService) {
        courseRepository.add(courseService.createCourse(1, "Auto course"));
        for (int i = 1; i < 4; i++) {
            lectureRepository.add(lectureService.createLecture(i, "No name", "No description"));
            lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
        }
        System.out.println("==========================================================================");
        System.out.printf("Створено автоматичний курс з іменем \"Auto course\"\n з ID \"%d\" і з трьома лекціями \"No name\".\n", courseRepository.getCourseArray()[0].getObjectId());
        System.out.println("==========================================================================");
        showInformCourseAndLecture();
        System.out.println("==========================================================================");

    }

    public void checkNumber(String outName) {
        long test;
        boolean isPresent = true;
        while (isPresent) {
            System.out.printf("Введіть ID %s, число не менше \"0\", i не більше \"%d\":\n", outName, Long.MAX_VALUE - 150);
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
        boolean isPresent = true;
        String result;
        while (isPresent) {
            System.out.println("Введіть від одного до чотирьох слів !!!");
            result = scanner.nextLine();
            if (makeValidate(result, namePattern)) {
                name = result;
                System.out.println("Назву збережено!!!");
                isPresent = false;
            } else {
                System.out.println("Не коректний формат !!!");
            }
        }
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

    public void scannerDescription() {
        boolean isPresent = true;
        String testDescription;
        while (isPresent) {
            System.out.printf("Введіть опис лекції, від \"%d\" до \"%d\" символів.\n", 3, 20);
            testDescription = scanner.nextLine();
            if (makeValidate(testDescription, descriptionPattern)) {
                description = testDescription;
                System.out.println("Опис лекції збережено!!!");
                isPresent = false;
            } else {
                System.out.println("Не коректний формат !!!");
            }
        }
    }

    public void scannerHomeTask() {
        boolean isPresent = true;
        String task;
        while (isPresent) {
            System.out.printf("Запишіть домашнє завдання, від \"%d\" до \"%d\" символів.\n", 3, 20);
            task = scanner.nextLine();
            if (makeValidate(task, descriptionPattern)) {
                this.task = task;
                System.out.println("Домашнє завдання збережено!!!");
                isPresent = false;
            } else {
                System.out.println("Не коректний формат !!!");
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
            if (makeValidate(testPhoneNumber, phoneNumberPattern)) {
                phone = testPhoneNumber;
                System.out.println("Номер телефону збережено!!!");
                isPresent = false;
            } else {
                System.out.println("Не коректний формат !!!");
            }
        }
    }

    public void scannerEmail() {
        boolean isPresent = true;
        String testEmail;
        while (isPresent) {
            System.out.println("Формат електронної пошти: «nick@mail.com»");
            testEmail = scanner.nextLine();
            if (makeValidate(testEmail, emailPattern)) {
                email = testEmail;
                System.out.println("Пошту збережено збережено!!!");
                isPresent = false;
            } else {
                System.out.println("Не коректний формат !!!");
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
            if (makeValidate(testFirstOrLastName, firstOrLastNamePattern)) {
                result = testFirstOrLastName;
                System.out.println("Збережено!!!");
                isPresent = false;
            } else {
                System.out.println("Не коректний формат !!!");
            }
        }
        return result;
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

