package online_school.service;

import online_school.course.model.Lecture;
import online_school.course.task_for_lecture.HomeWork;

public class HomeworkService {
    public HomeWork createHomework(long id, long lectureId, String task) {
        return new HomeWork(id, lectureId, task);
    }

    public void showInformHomework(long lectureId, Lecture[] lectures) {
        for (Lecture lecture : lectures) {
            if (lecture != null) {
                for (int j = 0; j < lecture.getHomeWorkArray().getArray().length; j++) {
                    if (lecture.getHomeWorkArray().getArray()[j] != null && lecture.getHomeWorkArray().getArray()[j].getLectureId() == lectureId) {
                        System.out.println(lecture.getHomeWorkArray().getArray()[j]);
                    }
                }
            }
        }
    }
}
