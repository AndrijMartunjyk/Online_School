package service_test;

import online_school.domain.model.Lecture;
import online_school.service.LectureService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LectureServiceTest {
    private final Long id = 0L;
    @Mock
    LectureService lectureService;
    @Mock
    List<Lecture> lecturesList;

    @Test
    @DisplayName("Method void showLectures null test")
    void showLecturesTest() {
        doCallRealMethod().when(lectureService).showLectures(any(), any());

        lectureService.showLectures(null, lecturesList);
        lectureService.showLectures(id, null);

        verify(lectureService).showLectures(null, lecturesList);
        verify(lectureService).showLectures(id, null);
    }

    @Test
    @DisplayName("Method void showLecturesInCourse null test")
    void showLecturesInCourseTest() {
        doCallRealMethod().when(lectureService).showLecturesInCourse(any(), any());

        lectureService.showLecturesInCourse(null, lecturesList);
        lectureService.showLecturesInCourse(id, null);

        verify(lectureService).showLecturesInCourse(null, lecturesList);
        verify(lectureService).showLecturesInCourse(id, null);
    }
}
