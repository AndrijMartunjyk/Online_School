package web.service;

import online_school.domain.model.Course;
import online_school.domain.model.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.CourseRepository;
import web.repository.LectureRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository, CourseRepository courseRepository) {
        this.lectureRepository = lectureRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void addLecture(String lectureName, String description, Long courseId, LocalDateTime dateLecture) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("MMM dd,E HH:mm:ss", Locale.US));
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        Course course;
        Lecture lecture = new Lecture(lectureName, description, localDateTime, dateLecture);
        if (optionalCourse.isPresent()) {
            course = optionalCourse.get();
            course.getLectureList().add(lecture);
            lecture.setCourse(course);
            lectureRepository.save(lecture);
            lectureRepository.flush();
        }
    }

    public List<Lecture> getLectureList() {
        return lectureRepository.findAll();
    }

    public List<Lecture> getLectureListByCourseId(Long courseId) {
        return lectureRepository.getLectureListByCourseId(courseId);
    }
}
