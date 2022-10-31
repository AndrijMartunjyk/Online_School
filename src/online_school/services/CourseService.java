package online_school.services;

import online_school.courses.Course;
import online_school.courses.repositories.CourseRepository;

public class CourseService {


    public Course courseCreation() {
        return new Course();
    }

    public Course courseCreation(long ID, String name) {
        return new Course(ID, name);
    }

    public void outId() {
        if (Course.counter < 1) {
            System.out.println("Спочатку створіть Курс!!!");
        } else {
            for (int i = 0; i < Course.counter; i++) {
                System.out.printf("Обєкт курсу з назвою: \"%s\", і номером ID: \"%d.\"\n", CourseRepository.course[i].getNameCourse(), CourseRepository.course[i].getID());
            }
        }
    }
}


