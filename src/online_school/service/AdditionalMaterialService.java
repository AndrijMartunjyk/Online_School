package online_school.service;

import online_school.course.model.Lecture;
import online_school.my_enum.Resource;
import online_school.course.task_for_lecture.AdditionalMaterial;
import online_school.exception.EntityNotFoundException;

import java.util.List;

public class AdditionalMaterialService {
    public AdditionalMaterial createAdditionalMaterials(Long additionalMaterialId, String recourseName, Long lectureId, Resource resourceType) {
        return new AdditionalMaterial(additionalMaterialId, recourseName, lectureId, resourceType);
    }

    public void showInformAdditionalMaterial(Long lectureId, List<Lecture> lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            }
            for (int i = 0; i < lecture.getAdditionalMaterialList().size(); i++) {
                if (lecture.getAdditionalMaterialList().get(i) != null && lecture.getAdditionalMaterialList().get(i).getLectureId().equals(lectureId)) {
                    System.out.println(lecture.getAdditionalMaterialList().get(i));
                    isPresent = false;
                }
            }
        }
        if (isPresent) {
            throw new EntityNotFoundException("Id of the additional material is not found!!!");
        }
    }
}
