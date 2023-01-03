package online_school.repository;

import online_school.domain.task_for_lecture.Homework;
import online_school.service.MainService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkRepository {
    private final Map<Long, List<Homework>> listHomeworkMap = new HashMap<>();

    public Map<Long, List<Homework>> getListHomeworkMap() {
        return listHomeworkMap;
    }

    public void creatNewCollectionHomeworks(Long lectureIdKey) {
        listHomeworkMap.put(lectureIdKey, new ArrayList<>());
    }

    public boolean addHomeworkToCollection(Long lectureIdKey, Homework homework) {
        boolean isPresent = true;
        if (listHomeworkMap.get(lectureIdKey) != null) {
            listHomeworkMap.get(lectureIdKey).add(homework);
            System.out.printf("Homework з ID: \"%s\" присвоєно лекції з ID: \"%s\"\n", homework.getHomeworkId(), lectureIdKey);
        } else {
            System.out.println(MainService.ID_IS_NOT_FOUND);
            isPresent = false;
        }
        return isPresent;
    }
}
