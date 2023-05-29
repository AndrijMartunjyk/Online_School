package web.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import web.dao.CourseDAO;
import web.dao.LectureDAO;
import web.dao.StudentDAO;

@Configuration
@PropertySource("classpath:application.properties")
public class MyConfig {

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
}
