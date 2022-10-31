package online_school.services;

import online_school.courses.Course;
import online_school.courses.models.Lecture;
import online_school.courses.repositories.LectureRepository;

public class LectureService {
    public Lecture lectureCreation() {
        return new Lecture();
    }

    public Lecture lectureCreation(long ID, String nameLecture) {
        return new Lecture(ID, nameLecture);
    }

    public void outId() {
        if (Course.counter < 1) {
            System.out.println("Спочатку створіть Курс!!!");
        } else {
            for (int i = 0; i < Lecture.counter; i++) {
                System.out.printf("Обєкт лекції з назвою: \"%s\", і номером ID: \"%d.\"\n", LectureRepository.lectures[i].getNameLecture(), LectureRepository.lectures[i].getID());
            }
        }
    }
}
