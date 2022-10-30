package online_school.courses.repositories;

import online_school.courses.Course;
import online_school.services.CourseService;

import java.util.Arrays;

public class CourseRepository {
    private final CourseService courseService = new CourseService();
    private int number;
    public static Course[] courses = new Course[Course.counter];
    public static Course[] newCourse = new Course[Course.counter];

    public void setNumber(int number) {
        this.number = number;
    }

    public void arraysOfObjects(int counter) {
        if (counter < 1) {
            courses = new Course[number];
        } else if (counter == number) {
            System.out.format("ВИ ПЕРЕВИЩИЛИ КІЛЬКІСТЬ ОБ'ЄКТІВ, МАСИВ ЗБІЛЬШЕНО ДО: %d ОБ'ЄКТІВ", ((courses.length * 3) / 2 + 1));
            System.out.println();
            newCourse = Arrays.copyOf(courses, (courses.length * 3) / 2 + 1);
        } else if (counter == newCourse.length) {
            System.out.format("ВИ ПЕРЕВИЩИЛИ КІЛЬКІСТЬ ОБ'ЄКТІВ, МАСИВ ЗБІЛЬШЕНО ДО: %d ОБ'ЄКТІВ", ((newCourse.length * 3) / 2 + 1));
            System.out.println();
            newCourse = Arrays.copyOf(newCourse, (newCourse.length * 3) / 2 + 1);
        }
    }

    public void objects() {
        if (Course.counter < number) {
            courses[Course.counter] = courseService.courseCreation();
        } else {
            newCourse[Course.counter] = courseService.courseCreation();
        }
    }
}






