package online_school;

import online_school.log.Level;
import online_school.service.*;
import online_school.log.Log;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final MainService mainService = new MainService();
    private static boolean isPresent = true;

    public static void main(String[] args) {
        System.out.print("""
                Для роботи з обєктами введіть "1"
                Для запуску сервера введіть "2"
                Для запуску контрольної роботи введіть "3"
                """);
        String number;
        try {
            Scanner scanner = new Scanner(System.in);
            mainService.setScanner(scanner);
            number = scanner.nextLine();
            if (number.equals("2")) {
                mainService.startServer();
            } else {
                while (isPresent) {
                    switch (number) {
                        case "1" -> objectMenu(scanner);
                        case "3" -> {
                            mainService.creatControlWork();
                            if (mainService.getNameModelAndPerson().equals("start")) {
                                mainService.startControlWork();
                                isPresent = false;
                            }
                        }
                        case "stop" -> isPresent = false;
                        default -> mainService.creatDefault();
                    }
                }
                System.out.println("Програму завершено!!!");
                scanner.close();
            }
        } catch (RuntimeException r) {
            Log.error(Main.class.getName(), "method->\"main\"", Arrays.toString(r.getStackTrace()));
            r.printStackTrace();
        }
    }

    public static void objectMenu(Scanner scanner) {
        {
            mainService.creatFile();
            mainService.setScanner(scanner);
            mainService.showFrontInform();
            while (isPresent) {
                switch (mainService.getNameModelAndPerson().toLowerCase()) {
                    case "курс" -> mainService.creatCourse();
                    case "лекція" -> mainService.creatLecture();
                    case "вчитель" -> mainService.creatTeacher();
                    case "студент" -> mainService.creatStudent();
                    case "add homework" -> mainService.creatHomework();
                    case "add additional material" -> mainService.createResourceType();
                    case "course data" -> mainService.creatCourseData();
                    case "lecture data" -> mainService.creatLectureData();
                    case "course info" -> mainService.creatCourseInfo();
                    case "lecture info" -> mainService.createLectureInfo();
                    case "teacher info" -> mainService.creatTeacherInfo();
                    case "student info" -> mainService.creatStudentInfo();
                    case "homework info" -> mainService.creatHomeworkInfo();
                    case "additional material info" -> mainService.creatAdditionalMaterialInfo();
                    case "delete course" -> mainService.creatDeleteCourse();
                    case "delete lecture" -> mainService.creatDeleteLecture();
                    case "delete teacher" -> mainService.creatDeleteTeacher();
                    case "delete student" -> mainService.creatDeleteStudent();
                    case "delete homework" -> mainService.creatDeleteHomework();
                    case "delete additional material" -> mainService.creatDeleteAdditionalMaterial();
                    case "вчитель для лекції" -> mainService.creatTeacherForLecture();
                    case "студент для лекції" -> mainService.creatStudentForLecture();
                    case "add someone" -> mainService.creatAddPersonForLecture();
                    case "debug" -> mainService.logInfo(Level.DEBUG);
                    case "info" -> mainService.logInfo(Level.INFO);
                    case "warn" -> mainService.logInfo(Level.WARNING);
                    case "error" -> mainService.logInfo(Level.ERROR);
                    case "control" -> mainService.creatControlWork();
                    case "start" -> mainService.startControlWork();
                    case "save" -> mainService.creatSaveObjects();
                    case "out" -> mainService.creatPrintSavedObjects();
                    case "before" -> mainService.beforeDate();
                    case "after" -> mainService.afterDate();
                    case "between" -> mainService.betweenDates();
                    case "group" -> mainService.creatAddMaterialListWithLecture();
                    case "letter" -> mainService.showListOfTeacherToLetter();
                    case "filter" -> mainService.filterFile();
                    case "first lecture" -> mainService.showSortedLectures();
                    case "show info" -> mainService.showNumberLogInfo();
                    case "group lectures" -> mainService.groupLectures();
                    case "group additional materials" -> mainService.groupAdditionalMaterials();
                    case "show map emails" -> mainService.showMapEmails();
                    case "show email in file" -> mainService.showEmailInFile();
                    case "stop" -> isPresent = false;
                    default -> mainService.creatDefault();
                }
            }
        }
    }
}

