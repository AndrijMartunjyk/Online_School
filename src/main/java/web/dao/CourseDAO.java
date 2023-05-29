package web.dao;

import java.util.List;

import online_school.domain.model.Course;
import online_school.util.HibernateUtil;
import org.hibernate.Session;

public class CourseDAO {
    public void createCourse(String name) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Course course = new Course(name);
            session.persist(course);
        }
    }


    public List<Course> courseList() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            return session.createQuery("from Course", Course.class).list();
        }
    }
}