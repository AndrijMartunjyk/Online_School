package service_test;

import online_school.domain.model.Course;
import online_school.service.CourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
    @Mock
    CourseService courseService;

    @Test
    @DisplayName("Method void showInformCourse null test")
    void showInformCourseTest() {
        List<Course> courseList = mock(List.class);
        Long courseId = 0L;
        doCallRealMethod().when(courseService).showInformCourse(any(), any());

        courseService.showInformCourse(courseId, null);
        courseService.showInformCourse(null, courseList);

        verify(courseService).showInformCourse(courseId, null);
        verify(courseService).showInformCourse(null, courseList);
    }
}
