package web.service;

import online_school.domain.model.Course;
import online_school.domain.model.Role;
import online_school.domain.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.CourseRepository;
import web.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void addStudent(String firstName, String lastName, String email, String phone, Role role, Long courseId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        Course course;
        Student student = new Student(firstName, lastName, email, phone, role);
        if (optionalCourse.isPresent()) {
            course = optionalCourse.get();
            course.getStudentList().add(student);
            student.setCourse(course);
            studentRepository.save(student);
        }
    }

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentListByCourseId(Long courseId) {
        return studentRepository.getStudentListByCourseId(courseId);
    }
}
