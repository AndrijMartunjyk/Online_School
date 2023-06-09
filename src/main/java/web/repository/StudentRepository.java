package web.repository;

import online_school.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM student u WHERE u.id_course = ?1", nativeQuery = true)
    List<Student> getStudentListByCourseId(Long courseId);
}
