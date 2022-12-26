package online_school.util;

import online_school.course.task_for_lecture.AdditionalMaterial;

import java.util.Comparator;

public class AdditionalMaterialSortType implements Comparator<AdditionalMaterial> {
    @Override
    public int compare(AdditionalMaterial o1, AdditionalMaterial o2) {
        if (o1.hashCode() == o2.hashCode()) {
            if (o1.equals(o2)) {
                return 0;
            }
        }
        //        sorted by type
        if (o1.getResourceType().hashCode() < o2.getResourceType().hashCode()) {
            return -1;
        } else
            return 1;
    }
}
