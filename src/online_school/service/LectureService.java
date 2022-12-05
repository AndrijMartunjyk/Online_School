package online_school.service;

import online_school.course.model.Lecture;

public class LectureService {

    public Lecture createLecture(long ID, String nameLecture, String description) {
        return new Lecture(ID, nameLecture, description);
    }

    public void showInformLectures(long lectureId, Lecture[] lectures) {
        boolean isPresent = true;
        for (Lecture lecture : lectures) {
            if (lecture != null && lecture.getObjectId() == lectureId) {
                System.out.println(lecture);
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.out.println("Немає такої лекції !!!");
        }
    }

    public void showInformLecturesAndCourse(long idCourse, Lecture[] lectures) {
        for (Lecture lecture : lectures) {
            if (lecture == null) {
                break;
            } else if (lecture.getCourseID() == idCourse) {
                System.out.println(lecture);
            }
        }
    }
}
