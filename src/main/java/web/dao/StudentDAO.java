package web.dao;

import online_school.domain.model.Course;
import online_school.domain.model.Role;
import online_school.domain.model.Student;
import online_school.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {
    public void createStudent(String firstName, String lastName, String email, String phone, Role role, Long courseId) {
        Student student = new Student(firstName, lastName, email, phone, role);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Course> courseQuery = session.createQuery("from Course where id=:courseId", Course.class);
            Course course = courseQuery.setParameter("courseId", courseId).getSingleResult();
            course.getStudentList().add(student);
            student.setCourse(course);
            session.persist(student);
            session.getTransaction().commit();
        }
    }

    public List<Student> getStudentListByCourseId(Long courseId) {
        List<Student> studentList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Course> courseQuery = session.createQuery("from Course where id=:courseId", Course.class);
            Course course = courseQuery.setParameter("courseId", courseId).getSingleResult();
            studentList = course.getStudentList().stream().toList();
        }
        return studentList;
    }

    public List<Student> showAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            return session.createQuery("from Student", Student.class).list();
        }
    }
}