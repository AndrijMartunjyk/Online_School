package web.dao;

import online_school.domain.model.Role;
import online_school.domain.model.Student;
import online_school.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {
    public void createStudent(String firstName, String lastName, String email, String phone, Role role, Long lectureId, Long courseId) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Student student = new Student(firstName, lastName, email, phone, role, lectureId, courseId);
            session.persist(student);
        }
    }

    public List<Student> getStudentByCourseId(int courseId) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query<Student> studentQuery = session.createQuery("from Student where courseId=:student_id", Student.class);
            return studentQuery.setParameter("student_id", courseId).list();
        }
    }

    public List<Student> showAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            return session.createQuery("from Student", Student.class).list();
        }
    }
}