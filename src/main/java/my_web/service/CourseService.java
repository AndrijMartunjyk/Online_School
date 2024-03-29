package my_web.service;

import online_school.domain.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import my_web.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void addCourse(String name) {
        Course course = new Course(name);
        courseRepository.save(course);
    }

    public List<Course> getCourseList() {
        return courseRepository.findAll();
    }
}
