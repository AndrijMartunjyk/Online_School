package online_school.service;

import online_school.domain.model.Lecture;
import online_school.log.Log;
import org.springframework.beans.factory.annotation.Value;
import web.utils.Driver;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class LectureService extends Driver {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    private String password;
    private Long lectureId;
    private String lectureName;
    private String description;
    private Long courseId;
    private String creationDate;
    private LocalDateTime dateLecture;

    public void createLecture(Long lectureId, String lectureName, String description, Long courseId, LocalDateTime dateLecture) {
        String query = "INSERT INTO lecture(lecture_id,lecture_name,description,creation_date,lecture_date) VALUES(?,?,?,?,?,?)";
        driver();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            this.lectureId = lectureId + new Random().nextLong(Integer.MAX_VALUE);
            this.lectureName = lectureName;
            this.description = description;
            this.courseId = courseId;
            creationDate = String.valueOf(LocalDateTime.now());
            this.dateLecture = dateLecture;

            statement.setLong(1, this.lectureId);
            statement.setString(2, this.lectureName);
            statement.setString(3, this.description);
            statement.setLong(4, this.courseId);
            statement.setString(5, creationDate);
            statement.setString(6, String.valueOf(this.dateLecture));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void showLectures(Long lectureId, List<Lecture> lectureList) {
        Optional<Long> lectureIdOptional = Optional.ofNullable(lectureId);
        Optional<List<Lecture>> lectureListOptional = Optional.ofNullable(lectureList);
        if (lectureIdOptional.isPresent() && lectureListOptional.isPresent()) {
            for (Lecture lecture : lectureListOptional.get()) {
                if (lecture == null) {
                    break;
                }
                if (lecture.getLectureId().equals(lectureIdOptional.get())) {
                    System.out.println(lecture);
                    Log.info(LectureService.class.getName(), String.valueOf(lecture));
                    return;
                }
            }
            System.out.println(MainService.ID_LECTURE_IS_NOT_FOUND);
        }
        Log.debug(LectureService.class.getName(), "method-> \"showLectures\"");
        Log.warning(LectureService.class.getName(), "EntityNotFoundException", MainService.ID_LECTURE_IS_NOT_FOUND);
    }

    public void showLecturesInCourse(Long idCourse, List<Lecture> lectureList) {
        Optional<Long> idCourseOptional = Optional.ofNullable(idCourse);
        Optional<List<Lecture>> lectureListOptional = Optional.ofNullable(lectureList);
        if (idCourseOptional.isPresent() && lectureListOptional.isPresent()) {
            boolean isPresent = true;
            for (Lecture lecture : lectureListOptional.get()) {
                if (lecture == null) {
                    break;
                } else if (lecture.getCourseId().equals(idCourseOptional.get())) {
                    isPresent = false;
                    System.out.println(lecture);
                    Log.info(LectureService.class.getName(), String.valueOf(lecture));
                }
            }
            if (isPresent) {
                System.out.println(MainService.ID_LECTURE_IS_NOT_FOUND);
                Log.warning(LectureService.class.getName(), "EntityNotFoundException", MainService.ID_LECTURE_IS_NOT_FOUND);
            }
        }
        Log.debug(LectureService.class.getName(), "method-> \"showLecturesInCourse\"");
    }
}

