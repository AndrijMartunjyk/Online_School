package online_school.service;

import web.utils.DatabaseConnection;

import java.sql.*;
import java.util.Random;

public class CourseService {

    private final String SQL = "{call table_name('course')}";
    private long courseId;
    private String courseName;

    public void createCourse(Long id, String name) {
        String query = "INSERT INTO course(course_id, course_name) VALUES(?,?)";
        try (
                Connection connection = DatabaseConnection.getConnection();
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
        try (
                Connection connection = DatabaseConnection.getConnection();
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
        try (
                Connection connection = DatabaseConnection.getConnection();
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


    public static void crateCourseDelete(int courseId) {
        String query = "DELETE FROM course WHERE course_id=?";
        try (
                Connection connection = DatabaseConnection.getConnection();
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
}