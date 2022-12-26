package online_school.util;

import online_school.course.task_for_lecture.AdditionalMaterial;

import java.util.Comparator;

public class AdditionalMaterialSortLectureId implements Comparator<AdditionalMaterial> {


    @Override
    public int compare(AdditionalMaterial o1, AdditionalMaterial o2) {
        if (o1.hashCode() == o2.hashCode()) {
            if (o1.equals(o2)) {
                return 0;
            }
        }
        //        sorted by ID
        if (o1.getLectureId() < o2.getLectureId()) {
            return -1;
        } else
            return 1;
    }
}
