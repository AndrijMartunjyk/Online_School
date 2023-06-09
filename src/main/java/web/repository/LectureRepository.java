package web.repository;

import online_school.domain.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    @Query(value = "SELECT * FROM lecture u WHERE u.id_course = ?1", nativeQuery = true)
    List<Lecture> getLectureListByCourseId(Long courseId);
}
