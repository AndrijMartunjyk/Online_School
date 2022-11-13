package online_school.repositories;

import online_school.courses.models.Models;

import java.util.Arrays;

public class LectureRepository extends Repository {

    private Models[] lectures = new Models[3];

    public int lectureCounter() {
        int result = 0;
        for (Models lecture : lectures) {
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
    public Models[] getAll() {
        return lectures;
    }

    @Override
    public void add(Models lecture) {
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
    public Models getByld(int idModels, Models[] models) {
        return super.getByld(idModels, models);
    }

    @Override
    public void deleteByld(int idModels, Models[] models) {
        super.deleteByld(idModels, models);
    }

    public long getLectureID() {
        return lectures[lectureCounter() - 1].getID();
    }

    public void setIdCourseOfLecture(Long ID, String name) {
        lectures[lectureCounter() - 1].setCourseID(ID);
        lectures[lectureCounter() - 1].setNameCourse(name);
    }
}
