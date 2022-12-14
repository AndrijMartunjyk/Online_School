package online_school;

import online_school.service.*;

import java.util.Scanner;

public class Main {
    private static final MainService mainService = new MainService();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            mainService.setScanner(scanner);
            mainService.showFrontInform();
            boolean isPresent = true;
            while (isPresent) {
                if (mainService.getNameModelAndPerson().equalsIgnoreCase(MainService.COURSE) || mainService.getCourseRepository().counter() > 1
                        || mainService.getNameModelAndPerson().equalsIgnoreCase(MainService.COURSE_DATA)) {
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
                        case "stop" -> isPresent = false;
                        default -> mainService.creatDefault();
                    }
                } else {
                    System.out.println("Спочатку введіть \"Курс\", або для виводу іформації про автоматичний курс, введіть\n\"Course data\"");
                    mainService.putBorder();
                    mainService.scannerNameModelAndPerson();
                }
            }
        } catch (RuntimeException r) {
            r.printStackTrace();
        }
        System.out.println("Програму завершено!!!");
    }
}

