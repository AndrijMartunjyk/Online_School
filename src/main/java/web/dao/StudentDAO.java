package web.dao;

import online_school.domain.model.Course;
import online_school.domain.model.Role;
import online_school.domain.model.Student;
import online_school.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void createStudent(String firstName, String lastName, String email, String phone, Role role, Long courseId) {
        Transaction transaction = null;
        Student student = new Student(firstName, lastName, email, phone, role);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            course.getStudentList().add(student);
            student.setCourse(course);
            session.persist(student);
            session.getTransaction().commit();
        } catch (RuntimeException r) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Student> getStudentListByCourseId(Long courseId) {
        Transaction transaction = null;
        List<Student> studentList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            studentList = course.getStudentList().stream().toList();
        } catch (RuntimeException r) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return studentList;
    }

    public List<Student> showAllStudents() {
        Transaction transaction = null;
        List<Student> studentList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            studentList = session.createQuery("from Student s join fetch s.course", Student.class).list();
        } catch (RuntimeException r) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return studentList;
    }
}