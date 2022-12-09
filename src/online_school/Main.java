package online_school;

import online_school.service.*;

public class Main {
    private static final MainService mainService = new MainService();

    public static void main(String[] args) {
        mainService.showInform();
        boolean isPresent = true;
        while (isPresent) {
            if (mainService.getNameModelAndPerson().equalsIgnoreCase("курс") || mainService.getCourseRepository().counter() > 1
                    || mainService.getNameModelAndPerson().equalsIgnoreCase("Course data")) {
                switch (mainService.getNameModelAndPerson().toLowerCase()) {
                    case "курс" -> mainService.creatCourse();
                    case "лекція" -> mainService.creatLecture();
                    case "вчитель" -> mainService.creatTeacher();
                    case "студент" -> mainService.creatStudent();
                    case "homework" -> mainService.creatHomework();
                    case "course data" -> mainService.creatCourseData();
                    case "lecture data" -> mainService.creatLectureData();
                    case "course info" -> mainService.creatCourseInfo();
                    case "lecture info" -> mainService.createLectureInfo();
                    case "teacher info" -> mainService.creatTeacherInfo();
                    case "student info" -> mainService.creatStudentInfo();
                    case "homework info" -> mainService.creatHomeworkInfo();
                    case "delete course" -> mainService.creatDeleteCourse();
                    case "delete lecture" -> mainService.creatDeleteLecture();
                    case "delete teacher" -> mainService.creatDeleteTeacher();
                    case "delete student" -> mainService.creatDeleteStudent();
                    case "delete homework" -> mainService.creatDeleteHomework();
                    case "вчитель для лекції" -> mainService.creatTeacherForLecture();
                    case "студент для лекції" -> mainService.creatStudentForLecture();
                    case "add" -> mainService.creatAddPersonForLecture();
                    case "stop" -> isPresent = false;
                    default -> mainService.creatDefault();
                }
            } else {
                System.out.println("Спочатку введіть \"Курс\", або для виводу іформації про автоматичний курс, введіть\n\"Course data\"");
                mainService.putBorder();
                mainService.scannerNameModelAndPerson();
            }
        }
        try {
            mainService.getScanner().close();
        } catch (Exception e) {
            System.err.println("Помилка закриття файлу !!!");
            e.printStackTrace();
        } finally {
            System.out.println("Програму завершено!!!");
        }
    }
}

