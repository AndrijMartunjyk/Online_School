package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.course.task_for_lecture.Homework;

public class HomeworkService {
    public Homework createHomework(Long id, Long lectureId, String task) {
        return new Homework(id, lectureId, task);
    }

    public void showInformHomework(Long lectureId, Lecture[] lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            }
            for (int j = 0; j < lecture.getHomeWorkArray().length; j++) {
                if (lecture.getHomeWorkArray()[j] != null &&
                        lecture.getHomeWorkArray()[j].getLectureId().equals(lectureId)) {
                    System.out.println(lecture.getHomeWorkArray()[j]);
                    isPresent = false;
                }
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id of the homework is not found!!!");
        }
    }
}