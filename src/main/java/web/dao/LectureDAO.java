package web.dao;

import online_school.domain.model.Course;
import online_school.domain.model.Lecture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import online_school.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LectureDAO {
    public void createLecture(String lectureName, String description, Long courseId, LocalDateTime dateLecture) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("MMM dd,E HH:mm:ss", Locale.US));
        Lecture lecture = new Lecture(lectureName, description, dateLecture, localDateTime);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Course> courseQuery = session.createQuery("from Course where id=:courseId", Course.class);
            Course course = courseQuery.setParameter("courseId", courseId).getSingleResult();
            course.getLectureList().add(lecture);
            lecture.setCourse(course);
            session.persist(lecture);
            session.getTransaction().commit();
        }
    }

    public List<Lecture> showAllLectures() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            return session.createQuery("from Lecture", Lecture.class).list();
        }
    }

    public List<Lecture> getLectureListByCourseId(Long courseId) {
        List<Lecture> lectureList;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query<Course> courseQuery = session.createQuery("from Course where id=:courseId", Course.class);
            Course course = courseQuery.setParameter("courseId", courseId).getSingleResult();
            lectureList = course.getLectureList().stream().toList();
        }
        return lectureList;
    }
}
