package online_school.util;

import online_school.domain.task_for_lecture.AdditionalMaterial;
import online_school.log.Log;

import java.util.Comparator;

public class AdditionalMaterialSortLectureId implements Comparator<AdditionalMaterial> {
    @Override
    public int compare(AdditionalMaterial o1, AdditionalMaterial o2) {
        Log.debug(AdditionalMaterialSortLectureId.class.getName(), "method-> \"compare\"");
        int result = 1;
        if (o1.hashCode() == o2.hashCode() && o1.equals(o2)) {
            result = 0;
        } else
            //        sorted by ID
            if (o1.getLectureId() < o2.getLectureId()) {
                result = -1;
            }
        return result;
    }
}
