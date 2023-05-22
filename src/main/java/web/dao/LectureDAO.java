package web.dao;

import online_school.domain.model.Lecture;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class LectureDAO extends Driver{
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    private String password;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public List<Lecture> showAllLectures() {
        List<Lecture> lectureList = new ArrayList<>();
        driver();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sgl = "SELECT * FROM lecture";
            PreparedStatement preparedStatement = connection.prepareStatement(sgl);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int lectureId = resultSet.getInt("lecture_id");
                String name = resultSet.getString("lecture_name");
                String description = resultSet.getString("description");
                int courseId = resultSet.getInt("course_id");
                LocalDateTime creationDate = LocalDateTime.parse(resultSet.getString("creation_date"), dateTimeFormatter);
                LocalDateTime lectureDate = LocalDateTime.parse(resultSet.getString("lecture_date"), dateTimeFormatter);

                Lecture lecture = new Lecture((long) lectureId, name, description, (long) courseId, creationDate, lectureDate);
                lectureList.add(lecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectureList;
    }

    public List<Lecture> getLectureByCourseId(int courseId) {
        List<Lecture> lectureList = new ArrayList<>();
        driver();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sgl = "SELECT * FROM lecture WHERE course_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sgl);
            preparedStatement.setInt(1, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int lectureId = resultSet.getInt("lecture_id");
                String name = resultSet.getString("lecture_name");
                String description = resultSet.getString("description");
                int courseIdSql = resultSet.getInt("course_id");
                LocalDateTime creationDate = LocalDateTime.parse(resultSet.getString("creation_date"), dateTimeFormatter);
                LocalDateTime lectureDate = LocalDateTime.parse(resultSet.getString("lecture_date"), dateTimeFormatter);
                Lecture lecture = new Lecture((long) lectureId, name, description, (long) courseIdSql, creationDate, lectureDate);
                lectureList.add(lecture);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectureList;
    }

    @Override
    public void driver() {
        super.driver();
    }
}
