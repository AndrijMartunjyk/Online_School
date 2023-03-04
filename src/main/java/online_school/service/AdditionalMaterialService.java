package online_school.service;

import online_school.domain.model.Resource;
import online_school.domain.task_for_lecture.AdditionalMaterial;
import online_school.log.Log;

import java.util.List;
import java.util.Map;

public class AdditionalMaterialService {
    public AdditionalMaterial createAdditionalMaterials(Long additionalMaterialId, String recourseName, Long lectureId, Resource resourceType) {
        Log.debug(AdditionalMaterialService.class.getName(), "method->\"createAdditionalMaterials\"");
        return new AdditionalMaterial(additionalMaterialId, recourseName, lectureId, resourceType);
    }

    public void showInformAdditionalMaterial(Long lectureId, Map<Long, List<AdditionalMaterial>> resourceListMap) {
        String stacktrace = "List of the additional material is empty!!!";
        boolean isPresent = true;
        if (resourceListMap.get(lectureId) != null && (!resourceListMap.get(lectureId).isEmpty())) {
            for (AdditionalMaterial material : resourceListMap.get(lectureId)) {
                if (material.getLectureId().equals(lectureId)) {
                    System.out.println(material);
                    Log.info(AdditionalMaterialService.class.getName(), String.valueOf(material));
                }
            }
            isPresent = false;
        }
        Log.debug(AdditionalMaterialService.class.getName(), "method->\"showInformAdditionalMaterial\"");
        if (isPresent) {
            System.out.println(stacktrace);
            Log.warning(AdditionalMaterialService.class.getName(), "EntityNotFoundException", stacktrace);
        }
    }
}
