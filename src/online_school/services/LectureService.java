package online_school.services;

import online_school.courses.models.Lecture;

public class LectureService {
    public Lecture lectureCreation() {
        return new Lecture();
    }

    public Lecture lectureCreation(long ID, String nameLecture, String startLecture, String finishLecture) {
        return new Lecture(ID, nameLecture, startLecture, finishLecture);
    }
}
