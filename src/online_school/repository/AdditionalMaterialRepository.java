package online_school.repository;

import online_school.domain.model.Lecture;
import online_school.domain.task_for_lecture.AdditionalMaterial;
import online_school.service.MainService;
import online_school.log.Log;

import java.util.*;
import java.util.function.Consumer;

public class AdditionalMaterialRepository {
    private final Map<Long, List<AdditionalMaterial>> listAdditionalMaterialMap = new HashMap<>();

    public Map<Long, List<AdditionalMaterial>> getListAdditionalMaterialMap() {
        Log.debug(AdditionalMaterialRepository.class.getName(), "method->\"getListAdditionalMaterialMap\"");
        return listAdditionalMaterialMap;
    }

    public void creatNewCollectionAdditionalMaterials(Long lectureIdKey) {
        Log.debug(AdditionalMaterialRepository.class.getName(), "method->\"creatNewCollectionAdditionalMaterials\"");
        listAdditionalMaterialMap.put(lectureIdKey, new ArrayList<>());
    }

    public boolean addAdditionalMaterialToCollection(Long lectureIdKey, AdditionalMaterial additionalMaterial) {
        boolean isPresent = true;
        if (listAdditionalMaterialMap.get(lectureIdKey) != null) {
            listAdditionalMaterialMap.get(lectureIdKey).add(additionalMaterial);
            String INFO_ABOUT_ADDITIONAL_MATERIAL = "AdditionalMaterial з ID: \"%s\" присвоєно лекції з ID: \"%s\"\n";
            System.out.printf(INFO_ABOUT_ADDITIONAL_MATERIAL, additionalMaterial.getResourceId(), lectureIdKey);
            Log.info(AdditionalMaterialRepository.class.getName(), INFO_ABOUT_ADDITIONAL_MATERIAL);
        } else {
            System.out.println(MainService.ID_IS_NOT_FOUND);
            Log.info(AdditionalMaterialRepository.class.getName(), MainService.ID_IS_NOT_FOUND);
            isPresent = false;
        }
        Log.debug(AdditionalMaterialRepository.class.getName(), "method-> \"addAdditionalMaterialToCollection\"");
        return isPresent;
    }

    public List<AdditionalMaterial> creatAdditionalMaterialList(List<Lecture> lectureList) {
        List<AdditionalMaterial> additionalMaterials = new ArrayList<>();
        for (Lecture lecture : lectureList) {
            if (lecture != null) {
                for (int j = 0; j < listAdditionalMaterialMap.size(); j++) {
                    if (listAdditionalMaterialMap.get(lecture.getLectureId()) != null && lecture.getLectureId().equals(listAdditionalMaterialMap.get(lecture.getLectureId()).get(j).getLectureId())) {
                        additionalMaterials.add(listAdditionalMaterialMap.get(lecture.getLectureId()).get(j));
                    }
                }
            }

        }
        Log.debug(AdditionalMaterialRepository.class.getName(), "method-> \"creatAdditionalMaterialList\"");
        return additionalMaterials;
    }

    public boolean listAddMaterialWithLambda(List<Lecture> lectureList) {
        boolean isPresent = true;
        Consumer<List<Lecture>> consumerLectures;
        Consumer<Map<Long, List<AdditionalMaterial>>> consumerAdditionalMaterials;
        Set<Long> keys = listAdditionalMaterialMap.keySet();
        for (Long key : keys) {
            for (int i = 0; i < lectureList.size(); i++) {
                if (key != null && key.equals(lectureList.get(i).getLectureId())) {
                    int index = i;
                    consumerLectures = list -> System.out.print(list.get(index));
                    consumerAdditionalMaterials = addMat -> System.out.println(addMat.get(key));
                    System.out.println();
                    consumerLectures.accept(lectureList);
                    consumerAdditionalMaterials.accept(listAdditionalMaterialMap);
                    isPresent = false;
                    break;
                }
            }
        }
        return isPresent;
    }
}




