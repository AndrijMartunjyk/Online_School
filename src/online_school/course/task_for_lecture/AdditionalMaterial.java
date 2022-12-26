package online_school.course.task_for_lecture;

import online_school.my_enum.Resource;

import java.util.Random;

public class AdditionalMaterial implements Comparable<AdditionalMaterial> {
    private final Long id;
    private final String name;
    private final Long lectureId;
    private final Resource resourceType;

    public AdditionalMaterial(Long id, String name, Long lectureId, Resource resourceType) {
        this.id = id + new Random().nextLong(Long.MAX_VALUE);
        this.name = name;
        this.lectureId = lectureId;
        this.resourceType = resourceType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public Resource getResourceType() {
        return resourceType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdditionalMaterial additionalMaterial)) {
            return false;
        }
        if (!(this.id.equals(additionalMaterial.getId()))) {
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
        final int prime = 37;
        int result = 17;
        result = prime * result + (int) (id - (id >>> 32));
        result = prime * result + ((this.name == null) ? 0 : name.hashCode());
        result = prime * result + ((this.resourceType == null) ? 0 : this.resourceType.hashCode());
        result = prime * result + ((this.lectureId == null) ? 0 : this.lectureId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AdditionalMaterial{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", lectureId=" + lectureId +
                ", resource type=" + resourceType +
                '}';
    }

    @Override
    public int compareTo(AdditionalMaterial o) {
        if (this.hashCode() == o.hashCode()) {
            if (this.equals(o)) {
                return 0;
            }
        }
//        sorted by ID
        if (id < o.getId()) {
            return -1;
        } else
            return 1;
    }
}




