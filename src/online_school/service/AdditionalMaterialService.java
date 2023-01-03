package online_school.service;

import online_school.domain.model.Resource;
import online_school.domain.task_for_lecture.AdditionalMaterial;
import online_school.exception.EntityNotFoundException;

import java.util.List;
import java.util.Map;

public class AdditionalMaterialService {
    public AdditionalMaterial createAdditionalMaterials(Long additionalMaterialId, String recourseName, Long lectureId, Resource resourceType) {
        return new AdditionalMaterial(additionalMaterialId, recourseName, lectureId, resourceType);
    }

    public void showInformAdditionalMaterial(Long lectureId, Map<Long, List<AdditionalMaterial>> resourceListMap) {
        boolean isPresent = true;
        if (resourceListMap.get(lectureId) != null && (!resourceListMap.get(lectureId).isEmpty())) {
            for (AdditionalMaterial material : resourceListMap.get(lectureId)) {
                if (material.getLectureId().equals(lectureId)) {
                    System.out.println(material);
                }
            }
            isPresent = false;
        }
        if (isPresent) {
            throw new EntityNotFoundException("List of the additional material is empty!!!");
        }
    }
}
