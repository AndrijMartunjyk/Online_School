package online_school.repository;

import online_school.domain.model.Lecture;
import online_school.domain.task_for_lecture.Homework;
import online_school.service.MainService;
import online_school.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkRepository {
    private final Map<Long, List<Homework>> listHomeworkMap = new HashMap<>();

    public Map<Long, List<Homework>> getListHomeworkMap() {
        Log.debug(HomeworkRepository.class.getName(), "method->\"getListHomeworkMap\"");
        return listHomeworkMap;
    }

    public void creatNewCollectionHomeworks(Long lectureIdKey) {
        listHomeworkMap.put(lectureIdKey, new ArrayList<>());
        Log.debug(HomeworkRepository.class.getName(), "method->\"creatNewCollectionHomeworks\"");
    }

    public boolean addHomeworkToCollection(Long lectureIdKey, Homework homework, String deadLineFormat) {
        boolean isPresent = true;
        if (listHomeworkMap.get(lectureIdKey) != null) {
            listHomeworkMap.get(lectureIdKey).add(homework);
            String INFO_ABOUT_HOMEWORK = """
                    Homework з ID: "%s" присвоєно лекції з ID: "%s"
                    DeadLine to: %s.
                    """;
            System.out.printf(INFO_ABOUT_HOMEWORK, homework.getHomeworkId(), lectureIdKey, deadLineFormat);
            Log.info(HomeworkRepository.class.getName(), INFO_ABOUT_HOMEWORK);
        } else {
            System.out.println(MainService.ID_IS_NOT_FOUND);
            Log.info(HomeworkRepository.class.getName(), MainService.ID_IS_NOT_FOUND);
            isPresent = false;
        }
        Log.debug(HomeworkRepository.class.getName(), "method->\"addHomeworkToCollection\"");
        return isPresent;
    }

    public List<Homework> creatHomeworkList(List<Lecture> lectureList) {
        List<Homework> homework = new ArrayList<>();
        for (Lecture lecture : lectureList) {
            if (lecture != null) {
                for (int j = 0; j < listHomeworkMap.size(); j++) {
                    if (listHomeworkMap.get(lecture.getLectureId()) != null && lecture.getLectureId().equals(listHomeworkMap.get(lecture.getLectureId()).get(j).getLectureId())) {
                        homework.add(listHomeworkMap.get(lecture.getLectureId()).get(j));
                    }
                }
            }
        }
        Log.debug(HomeworkRepository.class.getName(), "method->\"creatHomeworkList\"");
        return homework;
    }
}
