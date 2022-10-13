package online_school;

import online_school.courses.models.Lecture;

public class Main {
    public static void main(String[] args) {
        Lecture numberOne = new Lecture();
        Lecture numberTwo = new Lecture();
        Lecture numberThree = new Lecture();

        System.out.println(Lecture.getID());
    }
}
