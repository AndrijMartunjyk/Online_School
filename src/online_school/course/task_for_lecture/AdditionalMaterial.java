package online_school.course.task_for_lecture;

import online_school.my_enum.Resource;

import java.util.Random;

public class AdditionalMaterial {
    private final Long Id;
    private final String name;
    private final Long lectureId;
    private final Resource resourceType;

    public AdditionalMaterial(Long id, String name, Long lectureId, Resource resourceType) {
        Id = id + new Random().nextLong(Long.MAX_VALUE);
        this.name = name;
        this.lectureId = lectureId;
        this.resourceType = resourceType;
    }

    public Long getId() {
        return Id;
    }

    public Long getLectureId() {
        return lectureId;
    }

    @Override
    public String toString() {
        return "AdditionalMaterial{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", lectureId=" + lectureId +
                ", resource type=" + resourceType +
                '}';
    }
}




