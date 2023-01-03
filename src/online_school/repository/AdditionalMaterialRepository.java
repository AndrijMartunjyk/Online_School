package online_school.repository;

import online_school.domain.task_for_lecture.AdditionalMaterial;
import online_school.service.MainService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdditionalMaterialRepository {
    private final Map<Long, List<AdditionalMaterial>> listAdditionalMaterialMap = new HashMap<>();

    public Map<Long, List<AdditionalMaterial>> getListAdditionalMaterialMap() {
        return listAdditionalMaterialMap;
    }

    public void creatNewCollectionAdditionalMaterials(Long lectureIdKey) {
        listAdditionalMaterialMap.put(lectureIdKey, new ArrayList<>());
    }

    public boolean addAdditionalMaterialToCollection(Long lectureIdKey, AdditionalMaterial additionalMaterial) {
        boolean isPresent = true;
        if (listAdditionalMaterialMap.get(lectureIdKey) != null) {
            listAdditionalMaterialMap.get(lectureIdKey).add(additionalMaterial);
            System.out.printf("AdditionalMaterial з ID: \"%s\" присвоєно лекції з ID: \"%s\"\n", additionalMaterial.getResourceId(), lectureIdKey);
        } else {
            System.out.println(MainService.ID_IS_NOT_FOUND);
            isPresent = false;
        }
        return isPresent;
    }
}
