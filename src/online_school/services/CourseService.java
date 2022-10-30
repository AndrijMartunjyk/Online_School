package online_school.services;

import online_school.courses.Course;
import online_school.courses.models.Lecture;
import online_school.courses.models.Student;
import online_school.courses.models.Teacher;
import online_school.courses.repositories.CourseRepository;

import static online_school.courses.repositories.CourseRepository.courses;
import static online_school.courses.repositories.CourseRepository.newCourse;


public class CourseService {
    //    CourseRepository courseRepository=new CourseRepository();
    public Course courseCreation() {
        return new Course();
    }

    public Course courseCreation(long ID, String name, Lecture lecture, Teacher teacher, Student student) {
        return new Course(ID, name, lecture, teacher, student);
    }

    public void outId() {
        if (courses.length == Course.counter) {
            for (Course course : courses) {
                System.out.println("id курсу " + course.getID());
            }
        } else {
            for (int i = 0; i < Course.counter; i++) {
                System.out.println("id курсу " + newCourse[i].getID());
            }
        }
    }
}


