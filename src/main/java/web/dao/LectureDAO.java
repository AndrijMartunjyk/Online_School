package web.dao;

import online_school.domain.model.Course;
import online_school.domain.model.Lecture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import online_school.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LectureDAO {
    public void createLecture(String lectureName, String description, Long courseId, LocalDateTime dateLecture) {
        Transaction transaction = null;
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("MMM dd,E HH:mm:ss", Locale.US));
        Lecture lecture = new Lecture(lectureName, description, dateLecture, localDateTime);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            course.getLectureList().add(lecture);
            lecture.setCourse(course);
            session.persist(lecture);
            session.getTransaction().commit();
        } catch (RuntimeException r) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Lecture> showAllLectures() {
        Transaction transaction = null;
        List<Lecture> lectureList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            lectureList = session.createQuery("from Lecture l join fetch l.course", Lecture.class).list();
        } catch (RuntimeException r) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lectureList;
    }

    public List<Lecture> getLectureListByCourseId(Long courseId) {
        Transaction transaction = null;
        List<Lecture> lectureList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            lectureList = course.getLectureList().stream().toList();
        } catch (RuntimeException r) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lectureList;
    }
}
