package online_school.domain.task_for_lecture;

import online_school.domain.model.Resource;
import online_school.log.Log;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

public class AdditionalMaterial implements Comparable<AdditionalMaterial>, Serializable {
    @Serial
    private static final long serialVersionUID = 6L;
    private final Long resourceId;
    private final String name;
    private final Long lectureId;
    private final Resource resourceType;

    public AdditionalMaterial(Long resourceId, String name, Long lectureId, Resource resourceType) {
        this.resourceId = resourceId + new Random().nextLong(Long.MAX_VALUE);
        this.name = name;
        this.lectureId = lectureId;
        this.resourceType = resourceType;
    }

    public Long getResourceId() {
        Log.debug(AdditionalMaterial.class.getName(), "method->\"getResourceId\"");
        return resourceId;
    }

    public String getName() {
        Log.debug(AdditionalMaterial.class.getName(), "method->\"getName\"");
        return name;
    }

    public Long getLectureId() {
        Log.debug(AdditionalMaterial.class.getName(), "method->\"getLectureId\"");
        return lectureId;
    }

    public Resource getResourceType() {
        Log.debug(AdditionalMaterial.class.getName(), "method->\"getResourceType\"");
        return resourceType;
    }

    @Override
    public boolean equals(Object obj) {
        Log.debug(AdditionalMaterial.class.getName(), "method->\"equals\"");
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdditionalMaterial additionalMaterial)) {
            return false;
        }
        if (!(this.resourceId.equals(additionalMaterial.getResourceId()))) {
            return false;
        }
        if (!(this.name.equals(additionalMaterial.getName()))) {
            return false;
        }
        if (!(this.lectureId.equals(additionalMaterial.getLectureId()))) {
            return false;
        }
        return this.resourceType.equals(additionalMaterial.getResourceType());
    }

    @Override
    public int hashCode() {
        Log.debug(AdditionalMaterial.class.getName(), "method->\"hashCode\"");
        final int prime = 37;
        int result = 17;
        result = prime * result + (int) (resourceId - (resourceId >>> 32));
        result = prime * result + ((this.name == null) ? 0 : name.hashCode());
        result = prime * result + ((this.resourceType == null) ? 0 : this.resourceType.hashCode());
        result = prime * result + ((this.lectureId == null) ? 0 : this.lectureId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        Log.debug(AdditionalMaterial.class.getName(), "method->\"toString\"");
        return "AdditionalMaterial{" +
                "Id=" + resourceId +
                ", name='" + name + '\'' +
                ", lectureId=" + lectureId +
                ", resource type=" + resourceType +
                '}';
    }

    @Override
    public int compareTo(AdditionalMaterial o) {
        Log.debug(AdditionalMaterial.class.getName(), "method->\"compareTo\"");
        int result = 1;
        if (this.hashCode() == o.hashCode() && this.equals(o)) {
            result = 0;
        } else
//        sorted by ID
            if (resourceId < o.getResourceId()) {
                result = -1;
            }
        return result;
    }
}




