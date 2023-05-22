package web.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import online_school.domain.model.Course;
import org.springframework.beans.factory.annotation.Value;

public class CourseDAO extends Driver {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    private String password;

    public List<Course> courseList() {
        List<Course> courseList = new ArrayList<>();
        driver();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM course";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                Course course = new Course((long) courseId, courseName);
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public void driver() {
        super.driver();
    }
}