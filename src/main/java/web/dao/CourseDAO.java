package web.dao;

import java.util.ArrayList;
import java.util.List;

import online_school.domain.model.Course;
import online_school.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDAO {
    public void createCourse(String name) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Course course = new Course(name);
            session.persist(course);
            session.getTransaction().commit();
        } catch (RuntimeException r) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public List<Course> courseList() {
        Transaction transaction = null;
        List<Course> courseList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            courseList = session.createQuery("from Course", Course.class).list();
        } catch (RuntimeException r) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return courseList;
    }
}