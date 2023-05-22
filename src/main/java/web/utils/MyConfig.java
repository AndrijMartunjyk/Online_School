package web.utils;

import online_school.service.CourseService;
import online_school.service.LectureService;
import online_school.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import web.dao.CourseDAO;
import web.dao.Driver;
import web.dao.LectureDAO;
import web.dao.StudentDAO;

@Configuration
@PropertySource("classpath:application.properties")
public class MyConfig {
    @Bean
    public Driver driver() {
        return new Driver();
    }

    @Bean
    public CourseDAO courseDAO() {
        return new CourseDAO();
    }

    @Bean
    public LectureDAO lectureDAO() {
        return new LectureDAO();
    }

    @Bean
    public StudentDAO studentDAO() {
        return new StudentDAO();
    }

    @Bean
    public CourseService courseService() {
        return new CourseService();
    }

    @Bean
    public LectureService lectureService() {
        return new LectureService();
    }

    @Bean
    public StudentService studentService() {
        return new StudentService();
    }
}
