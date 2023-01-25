package online_school;

import online_school.util.Level;
import online_school.service.*;
import online_school.util.Log;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final MainService mainService = new MainService();

    public static void main(String[] args) {
        String info = "Спочатку введіть \"Курс\", або для виводу іформації про автоматичний курс, введіть\n\"Course data\"";
        String programIsOver = "Програму завершено!!!";
        try (Scanner scanner = new Scanner(System.in)) {
            mainService.setScanner(scanner);
            mainService.showFrontInform();
            boolean isPresent = true;
            while (isPresent) {
                if (mainService.getNameModelAndPerson().equalsIgnoreCase(MainService.COURSE) || mainService.getCourseRepository().counter() > 1
                        || mainService.getNameModelAndPerson().equalsIgnoreCase(MainService.COURSE_DATA)
                        || mainService.getNameModelAndPerson().equalsIgnoreCase(mainService.START)) {
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
                        case "start" -> mainService.startControlWork();
                        case "stop" -> isPresent = false;
                        default -> mainService.creatDefault();
                    }
                } else {
                    System.out.println(info);
                    Log.info(Main.class.getName(), info);
                    mainService.putBorder();
                    mainService.scannerNameModelAndPerson();
                }
            }
        } catch (RuntimeException r) {
            Log.error(Main.class.getName(), "method->\"main\"", Arrays.toString(r.getStackTrace()));
            r.printStackTrace();
        }
        System.out.println(programIsOver);
        Log.info(Main.class.getName(), programIsOver);
        mainService.getReadAndWrite().deleteLogFile();
    }
}

