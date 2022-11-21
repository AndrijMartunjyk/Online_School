package online_school.service;

import online_school.enum_enum.Role;
import online_school.repositorie.CourseRepository;
import online_school.repositorie.LectureRepository;

import java.util.Scanner;

import static online_school.enum_enum.Role.*;


public class MainService {
    private final Scanner scanner = new Scanner(System.in);
    private int number;
    private String name;
    private String lastName;

    public void border() {
        System.out.println("===================================================================================================================================================");
    }

    public void informCourse() {
        System.out.println("Для виводу всієї інфрмації про курс, або про лекцію, введіть: \n\"Course data\"\n\"Lecture data\"");
    }

    public void inform() {
        System.out.println("Можете продовжувати створювати студентів, вчителів, лекції.");
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
        System.out.println("==========================================================================");
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

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public Role lists() {
        return switch (getName().toLowerCase()) {
            case "курс" -> COURSE;
            case "лекція" -> LECTURE;
            case "вчитель" -> TEACHER;
            case "студент" -> STUDENT;
            case "course data" -> COURSE_DATA;
            case "lecture data" -> LECTURE_DATA;
            case "course info" -> COURSE_INFO;
            case "lecture info" -> LECTURE_INFO;
            case "teacher info" -> TEACHER_INFO;
            case "student info" -> STUDENT_INFO;
            case "show course" -> SHOW_COURSE;
            case "show lecture" -> SHOW_LECTURE;
            case "show teacher" -> SHOW_TEACHER;
            case "show student" -> SHOW_STUDENT;
            case "delete course" -> DELETE_COURSE;
            case "delete lecture" -> DELETE_LECTURE;
            case "delete teacher" -> DELETE_TEACHER;
            case "delete student" -> DELETE_STUDENT;
            case "add" -> ADD;
            case "вчитель для лекції" -> TEACHER_FOR_LECTURE;
            case "студент для лекції" -> STUDENT_FOR_LECTURE;
            case "stop" -> STOP;
            default -> ERROR;
        };
    }
}

