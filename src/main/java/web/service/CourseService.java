package web.service;

import online_school.domain.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getCourseList() {
        return courseRepository.findAll();
    }
}
