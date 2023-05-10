package online_school.service;

import online_school.domain.model.Model;
import online_school.domain.model.Lecture;
import online_school.domain.model.Role;
import online_school.domain.model.Person;
import online_school.log.Log;
import web.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class StudentService extends Model {

    private static int counter;
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Role role;
    private Long lectureId;
    private Long courseId;

    public void createStudent(Long studentId, String firstName, String lastName, String email, String phone, Role role, Long lectureId, Long courseId) {
        String query = "INSERT INTO student(student_id,first_name,last_name,email,phone_number,role,lecture_id,course_id) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            this.studentId = studentId + new Random().nextLong(Integer.MAX_VALUE);
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.role = role;
            this.lectureId = lectureId;
            this.courseId = courseId;

            statement.setLong(1, this.studentId);
            statement.setString(2, this.firstName);
            statement.setString(3, this.lastName);
            statement.setString(4, this.email);
            statement.setString(5, this.phone);
            statement.setString(6, String.valueOf(this.role));
            statement.setLong(7, this.lectureId);
            statement.setLong(8, this.courseId);
            statement.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static int getStudentCounter() {
        Log.debug(StudentService.class.getName(), "method-> \"getStudentCounter\"");
        return counter;
    }

    @Override
    public void addPersonToLecture(String namePerson, Long lectureId, Long studentId, List<Lecture> lecture, List<Person> student) {
        super.addPersonToLecture(namePerson, lectureId, studentId, lecture, student);
        Log.debug(StudentService.class.getName(), "method-> \"addPersonToLecture\"");
    }
}