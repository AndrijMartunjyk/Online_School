package online_school.courses.repositories;

import online_school.courses.Course;

import java.util.Arrays;

public class CourseRepository {
    private int yes;


    public int getYes() {
        return yes;
    }
    private int newLengthArray;
    Course[] courses;
    Course[] newCourse;

    public void setYes(int yes) {
        this.yes = yes;
        if (Course.counter < yes) {
            if (Course.counter < 1) {

                courses = new Course[getYes()];
            }
            courses[Course.counter] = new Course();
        } else {
            if (Course.counter == yes) {
                newLengthArray = (getYes() * 3) / 2 + 1;
                newCourse = Arrays.copyOf(courses, newLengthArray);
            } if (Course.counter<newCourse.length){
                newCourse[Course.counter] = new Course();
                System.out.println("йооооооой");
                System.out.println("=> " + newCourse.length);
            }else {
               setYes(Course.counter);
            }


            }

        }


        }






