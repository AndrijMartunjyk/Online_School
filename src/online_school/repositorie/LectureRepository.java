package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.course.model.Model;
import online_school.generic.SchoolArray;

public class LectureRepository extends Repository {
    private final SchoolArray<Lecture> lectureArray = new SchoolArray<>(new Lecture[3]);

    public int lectureCounter() {
        int result = 0;
        for (Lecture lecture : lectureArray.getArray()) {
            if (lecture == null) {
                break;
            } else {
                result = lecture.getCounter();
            }
        }
        return result;
    }

    public SchoolArray<Lecture> getLecturesArrayObject() {
        return lectureArray;
    }

    public Lecture[] getLectureArray() {
        return lectureArray.getArray();
    }

    public void add(Lecture lecture) {
        lectureArray.add(lecture);
    }

    @Override
    public Model getByldModel(long idLecture, Model[] lectures) {
        return super.getByldModel(idLecture, lectures);
    }

    @Override
    public void deleteModel(long idLecture, Model[] lecture) {
        super.deleteModel(idLecture, lecture);
    }

    public long getLectureID() {
        return lectureArray.getArray()[lectureCounter() - 1].getModelId();
    }

    public void setIdCourseOfLecture(Long ID, String name) {
        lectureArray.getArray()[lectureCounter() - 1].setCourseID(ID);
        lectureArray.getArray()[lectureCounter() - 1].setNameCourse(name);
    }
}
