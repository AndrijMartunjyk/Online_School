package online_school.service;

import java.sql.*;
import java.util.Random;

public class CourseService {
    private static final String URL = "jdbc:mysql://localhost/online_school";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private final String query = "SELECT course_id,course_name FROM course";
    private int courseId;
    private String courseName;

    public void createCourse(Long id, String name) {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery(query)) {

            resultSet.moveToInsertRow();
            resultSet.updateString("course_name", name);
            resultSet.updateLong("course_id", id + new Random().nextLong(Integer.MAX_VALUE));
            resultSet.insertRow();
            resultSet.refreshRow();

            courseId = resultSet.getInt("course_id");
            courseName = resultSet.getString("course_name");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showAllCourses() {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery(query)) {
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
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery(query)) {
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
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery(query)) {
            int id;
            while (resultSet.next()) {
                id = resultSet.getInt("course_id");
                if (id == courseId) {
                    resultSet.deleteRow();
                    System.out.println("Course with Id: " + id + " was deleted !!!");
                    resultSet.refreshRow();
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}