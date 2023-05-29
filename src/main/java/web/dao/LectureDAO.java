package web.dao;

import online_school.domain.model.Lecture;

import java.time.LocalDateTime;
import java.util.List;

import online_school.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LectureDAO {
    public void createLecture(String lectureName, String description, Long courseId, LocalDateTime dateLecture) {
        LocalDateTime localDateTime = LocalDateTime.now();
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Lecture lecture = new Lecture(lectureName, description, courseId, localDateTime, dateLecture);
            session.persist(lecture);
        }
    }

    public List<Lecture> showAllLectures() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            return session.createQuery("from Lecture", Lecture.class).list();
        }
    }

    public List<Lecture> getLectureByCourseId(int courseId) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query<Lecture> lectureQuery = session.createQuery("from Lecture where courseId=:course_id", Lecture.class);
            return lectureQuery.setParameter("course_id", courseId).list();
        }
    }
}
