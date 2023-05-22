package online_school.service;

import org.springframework.beans.factory.annotation.Value;
import web.dao.Driver;

import java.sql.*;
import java.util.Random;

public class CourseService extends Driver {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    private String password;

    private final String SQL = "{call table_name('course')}";
    private long courseId;
    private String courseName;

    public void createCourse(Long id, String name) {
        String query = "INSERT INTO course(course_id, course_name) VALUES(?,?)";
        driver();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            courseId = id + new Random().nextLong(Integer.MAX_VALUE);
            courseName = name;

            statement.setLong(1, courseId);
            statement.setString(2, courseName);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showAllCourses() {
        driver();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             CallableStatement callableStatement = connection.prepareCall(SQL);
             ResultSet resultSet = callableStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("course_id");
                String name = resultSet.getString("course_name");
                System.out.println("ID: " + id + " " + "course name: " + name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showOneCourse(int courseId) {
        driver();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             CallableStatement callableStatement = connection.prepareCall(SQL);
             ResultSet resultSet = callableStatement.executeQuery()) {
            int id;
            while (resultSet.next()) {
                id = resultSet.getInt("course_id");
                if (id == courseId) {
                    System.out.println("ID: " + id + ", " + "Course Name: " + resultSet.getString("course_name"));
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void crateCourseDelete(int courseId) {
        String query = "DELETE FROM course WHERE course_id=?";
        driver();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, courseId);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getCourseId() {
        return (int) courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public void driver() {
        super.driver();
    }
}