package web.dao;

import online_school.domain.model.Person;
import online_school.domain.model.Role;
import web.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Person> getStudentByCourseId(int courseId) {
        List<Person> studentList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sgl = "SELECT * FROM student WHERE course_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sgl);
            preparedStatement.setInt(1, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                Role role = Role.valueOf(resultSet.getString("role"));
                int lectureId = resultSet.getInt("lecture_id");
                int courseIdSql = resultSet.getInt("course_id");

                Person student = new Person(role, (long) studentId, firstName, lastName, phoneNumber, email, (long) courseIdSql, (long) lectureId);
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public List<Person> showAllStudents() {
        List<Person> studentList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sgl = "SELECT * FROM student";
            PreparedStatement preparedStatement = connection.prepareStatement(sgl);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long studentId = resultSet.getLong("student_id");
                String name = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");
                Role role = Role.valueOf(resultSet.getString("role"));
                Long lectureId = resultSet.getLong("lecture_id");
                Long courseId = resultSet.getLong("course_id");

                Person student = new Person(role, studentId, name, lastName, phone, email, courseId, lectureId);
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
