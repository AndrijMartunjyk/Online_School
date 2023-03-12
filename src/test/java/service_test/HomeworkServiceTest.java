package service_test;

import online_school.domain.task_for_lecture.Homework;
import online_school.service.HomeworkService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HomeworkServiceTest {
    @Mock
    HomeworkService homeworkService;
    @Mock
    Map<Long, List<Homework>> homeworkMap;

    @Test
    @DisplayName("Method void showInformHomework null test")
    void showInformHomeworkTest() {
        Long lectureId = 0L;
        doCallRealMethod().when(homeworkService).showInformHomework(any(), any());

        homeworkService.showInformHomework(null, homeworkMap);
        homeworkService.showInformHomework(lectureId, null);

        verify(homeworkService).showInformHomework(null, homeworkMap);
        verify(homeworkService).showInformHomework(lectureId, null);
    }
}
