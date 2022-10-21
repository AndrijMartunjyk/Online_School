package online_school;

import online_school.courses.Course;
import online_school.courses.models.Lecture;
import online_school.services.LectureService;

public class Main {
    public static void main(String[] args) {
        LectureService lectureService = new LectureService();

        Course java = new Course();
        Lecture firstLecture = lectureService.lectureCreation("introduction with Java", "19.30", "21.00");
        Lecture secondLecture = lectureService.lectureCreation("variables", "19.30", "21.00");
        Lecture thirdLecture = lectureService.lectureCreation("data type", "19.30", "21.00");
        Lecture fourthLecture = lectureService.lectureCreation("introduction with Git", "19.30", "21.00");
        Lecture fifthLecture = lectureService.lectureCreation("Git", "19.30", "21.00");
        Lecture sixthLecture = lectureService.lectureCreation("methods", "19.30", "21.00");

        System.out.format("ID курсу 6-ї лекції: %s\nКількість лекцій: %s", sixthLecture.courseId, Lecture.getID());
    }
}
