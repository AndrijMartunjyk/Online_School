package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.domain.task_for_lecture.Homework;

import java.util.List;
import java.util.Map;

public class HomeworkService {
    public Homework createHomework(Long homeworkId, Long lectureId, String task) {
        return new Homework(homeworkId, lectureId, task);
    }

    public void showInformHomework(Long lectureId, Map<Long, List<Homework>> homeworkMap) {
        boolean isPresent = true;
        if (homeworkMap.get(lectureId) != null && (!homeworkMap.get(lectureId).isEmpty())) {
            for (Homework homework : homeworkMap.get(lectureId)) {
                System.out.println(homework);
            }
            isPresent = false;
        }
        if (isPresent) {
            throw new EntityNotFoundException("List of the homework is empty!!!");
        }
    }
}