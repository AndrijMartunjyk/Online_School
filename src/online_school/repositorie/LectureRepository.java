package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.course.model.Model;

import java.util.Arrays;

public class LectureRepository extends Repository {

    private Lecture[] lectures = new Lecture[3];

    public int lectureCounter() {
        int result = 0;
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            } else {
                result = lecture.getCounter();
            }
        }
        return result;
    }

    public void magnificationOfArray() {
        lectures = Arrays.copyOf(lectures, (lectures.length * 3) / 2 + 1);
        System.out.format("Масив лекцій збільшено, довжина: %d об'єктів!!!\n", lectures.length);
    }


    @Override
    public Lecture[] getAll() {
        return lectures;
    }


    public void add(Lecture lecture) {
        for (int i = 0; i < lectures.length; i++) {
            if (lectureCounter() - 1 == lectures.length) {
                magnificationOfArray();
            } else if (lectures[i] == null) {
                lectures[i] = lecture;
                break;
            }
        }
    }

    @Override
    public Model getByldModel(long idModels, Model[] models) {
        return super.getByldModel(idModels, models);
    }

    @Override
    public void deleteByldModel(long idModels, Model[] models) {
        super.deleteByldModel(idModels, models);
    }

    public long getLectureID() {
        return lectures[lectureCounter() - 1].getID();
    }

    public void setIdCourseOfLecture(Long ID, String name) {
        lectures[lectureCounter() - 1].setCourseID(ID);
        lectures[lectureCounter() - 1].setNameCourse(name);
    }
}
