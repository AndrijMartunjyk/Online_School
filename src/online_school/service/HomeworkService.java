package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.course.model.Lecture;
import online_school.course.task_for_lecture.Homework;

import java.util.List;

public class HomeworkService {
    public Homework createHomework(Long homeworkId, Long lectureId, String task) {
        return new Homework(homeworkId, lectureId, task);
    }

    public void showInformHomework(Long lectureId, List<Lecture> lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            }
            for (int j = 0; j < lecture.getHomeworkList().size(); j++) {
                if (lecture.getHomeworkList().get(j) != null &&
                        lecture.getHomeworkList().get(j).getLectureId().equals(lectureId)) {
                    System.out.println(lecture.getHomeworkList().get(j));
                    isPresent = false;
                }
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id of the homework is not found!!!");
        }
    }
}