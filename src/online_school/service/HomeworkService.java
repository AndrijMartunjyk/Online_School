package online_school.service;

import online_school.exception.EntityNotFoundException;
import online_school.domain.task_for_lecture.Homework;
import online_school.util.Log;

import java.util.List;
import java.util.Map;

public class HomeworkService {
    public Homework createHomework(Long homeworkId, Long lectureId, String task) {
        Log.debug(HomeworkService.class.getName(), "method-> \"createHomework\"");
        return new Homework(homeworkId, lectureId, task);
    }

    public void showInformHomework(Long lectureId, Map<Long, List<Homework>> homeworkMap) {
        String stacktrace = "List of the homework is empty!!!";
        boolean isPresent = true;
        if (homeworkMap.get(lectureId) != null && (!homeworkMap.get(lectureId).isEmpty())) {
            for (Homework homework : homeworkMap.get(lectureId)) {
                System.out.println(homework);
                Log.info(HomeworkService.class.getName(), String.valueOf(homework));
            }
            isPresent = false;
        }
        if (isPresent) {
            Log.warning(HomeworkService.class.getName(), "EntityNotFoundException", stacktrace);
            throw new EntityNotFoundException(stacktrace);
        }
        Log.debug(HomeworkService.class.getName(), "method-> \"showInformHomework\"");
    }
}