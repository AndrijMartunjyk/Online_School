package service_test;

import online_school.domain.control_work.Student;
import online_school.service.ControlWorkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControlWorkServiceTest {
    @Mock
    ControlWorkService controlWorkService;

    @Test
    @DisplayName("Method createStudentsArray array's length")
    void createStudentsArrayTest() {
        doCallRealMethod().when(controlWorkService).createStudentsArray();
        Assertions.assertEquals(10, controlWorkService.createStudentsArray().length);
    }

    @Test
    @DisplayName("Method void creatNumberTaskForStudent null test")
    void creatNumberTaskForStudentTest() {
        doCallRealMethod().when(controlWorkService).creatNumberTaskForStudent(any());
        controlWorkService.creatNumberTaskForStudent(null);
        verify(controlWorkService).creatNumberTaskForStudent(null);
    }

    @Test
    @DisplayName("Method void startControlWork null test")
    void startControlWorkTest() throws InterruptedException {
        List<Student> listStudents = mock(List.class);
        doCallRealMethod().when(controlWorkService).startControlWork(any(), any());
        doCallRealMethod().when(controlWorkService).createStudentsArray();

        controlWorkService.startControlWork(listStudents, null);
        controlWorkService.startControlWork(null, controlWorkService.createStudentsArray());

        verify(controlWorkService).startControlWork(listStudents, null);
        verify(controlWorkService).startControlWork(null, controlWorkService.createStudentsArray());
    }
}
