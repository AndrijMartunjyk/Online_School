package online_school.services;

import online_school.repositories.CourseRepository;
import online_school.repositories.LectureRepository;

import java.util.Scanner;

public class MainService {
    private final Scanner scanner = new Scanner(System.in);
    private int number;
    private String name;
    private String lastName;

    public void border() {
        System.out.println("===================================================================================================================================================");
    }

    public void informCourse() {
        System.out.println("Для виводу всієї інфрмації про курс, введіть: \"Course data\" i ID курсу.");
    }

    public void inform() {
        System.out.println("Можете продовжувати створювати студентів, вчителів, лекції або створіть новий курс.");
        name = scanner.nextLine();
    }

    public String message() {
        return "Ви вибрали: ";
    }

    public void numberEntry(String outName) {
        boolean trueOrFalseCourse = true;
        while (trueOrFalseCourse) {
            System.out.println("Введіть ID " + outName + ", число більше 0:");
            if (scanner.hasNextInt()) {
                int number = scannerNumber();
                scanner.nextLine();
                if (number > 0) {
                    trueOrFalseCourse = false;
                }
            } else {
                System.out.println("Не правильний ввід, введіть число!!!");
                scannerName();
            }
        }
    }

    public void autoObject(CourseRepository courseRepository, CourseService courseService, LectureRepository lectureRepository, LectureService lectureService) {
        courseRepository.add(courseService.courseCreation(1, "Auto course"));
        for (int i = 1; i < 4; i++) {
            lectureRepository.add(lectureService.lectureCreation(i, "No name"));
            lectureRepository.setIdCourseOfLecture(courseRepository.getCourseID(), courseRepository.getCourseName());
        }
        System.out.println("==========================================================================");
        System.out.printf("Створено автоматичний курс з іменем \"Auto course\"\n з ID \"%d\" і з трьома лекціями \"No name\".\n", courseRepository.getAll()[0].getID());
        informCourse();
        System.out.println("==========================================================================");

    }

    public void scannerName() {
        name = scanner.nextLine();
    }

    public void scannerLastName() {
        lastName = scanner.nextLine();
    }

    public int scannerNumber() {
        return number = scanner.nextInt();
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
