package service_test;

import online_school.domain.model.Lecture;
import online_school.domain.model.Person;
import online_school.domain.model.Resource;
import online_school.repository.LectureRepository;
import online_school.service.MainService;
import online_school.util.RegularExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static online_school.service.MainService.SYMBOL_IS_INCORRECT;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MainServiceTest {
    @Mock
    MainService mainService;
    @Mock
    List<Person> anyList;
    @Mock
    Lecture lecture;

    @BeforeEach
    void createFakeScanner() {
        mainService.scanner = mock(Scanner.class);
    }

    @Test
    @DisplayName("Method void checkId parameters test")
    void checkIdTest() {
        doCallRealMethod().when(mainService).checkId(any());

        when(mainService.scanner.hasNextLong()).thenReturn(false, true);
        when(mainService.scanner.nextLong()).thenReturn(0L, 1L);
        when(mainService.scanner.nextLine()).thenReturn("");

        mainService.checkId("name");
        mainService.checkId(null);

        verify(mainService).checkId("name");
        verify(mainService).checkId(null);
    }

    @Test
    @DisplayName("Method void scannerEmail parameters test")
    void scannerEmailTestNull() {
        doCallRealMethod().when(mainService).scannerEmail(any(), any());
        try (MockedStatic<RegularExpression> utilities = Mockito.mockStatic(RegularExpression.class)) {
            utilities.when(() -> RegularExpression.makeValidate(anyString(), any())).thenReturn(false, true);
            when(mainService.scanner.nextLine()).thenReturn("");
            mainService.scannerEmail(anyList, anyList);
            mainService.scannerEmail(null, anyList);
            mainService.scannerEmail(anyList, null);
        }
        verify(mainService).scannerEmail(anyList, anyList);
        verify(mainService).scannerEmail(null, anyList);
        verify(mainService).scannerEmail(anyList, null);
    }

    @Test
    @DisplayName("Method checkFirstAndLastName english name test")
    void checkFirstAndLastNameTest() {
        when(mainService.scanner.nextLine()).thenReturn("ім'я", "name");
        doCallRealMethod().when(mainService).checkFirstAndLastName();
        Assertions.assertNotEquals("ім'я", mainService.checkFirstAndLastName());
        Assertions.assertEquals("name", mainService.checkFirstAndLastName());
        verify(mainService, times(2)).checkFirstAndLastName();
    }

    @Test
    @DisplayName("Method getResource return test")
    void getResourceTest() {
        when(mainService.scanner.hasNextLine()).thenReturn(false, true);
        when(mainService.scanner.nextLine()).thenReturn("url", "video", "book", "fake");

        doCallRealMethod().when(mainService).getResource();
        Assertions.assertNull(mainService.getResource());
        Assertions.assertEquals(Resource.URL, mainService.getResource());
        Assertions.assertEquals(Resource.VIDEO, mainService.getResource());
        Assertions.assertEquals(Resource.BOOk, mainService.getResource());

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> mainService.getResource(), SYMBOL_IS_INCORRECT);
        Assertions.assertEquals(SYMBOL_IS_INCORRECT, illegalArgumentException.getMessage());

        verify(mainService, times(5)).getResource();
    }

    @Test
    @DisplayName("Method foundLecture return test")
    void foundLectureTest() {
        mainService.lectureRepository = spy(LectureRepository.class);

        mainService.lectureRepository.getLectureList().add(lecture);
        mainService.lectureRepository.getLectureList().add(lecture);
        mainService.lectureRepository.getLectureList().add(lecture);

        when(lecture.getLectureId()).thenReturn(1L);

        doCallRealMethod().when(mainService).foundLecture(any());
        Assertions.assertTrue(mainService.foundLecture(1L));
        Assertions.assertFalse(mainService.foundLecture(2L));
        Assertions.assertFalse(mainService.foundLecture(null));

        verify(mainService, times(3)).foundLecture(any());
    }

    @Test
    @DisplayName("Method creatLectureDate return test")
    void creatLectureDateTest() {
        LocalDateTime localDateTimeExpected = LocalDateTime.of(2023, 3, 12, 12, 0, 0);
        LocalDateTime localDateTimeNowFake = LocalDateTime.of(2023, 3, 12, 12, 0, 0);
        LocalDateTime localDateTimePassedFake = LocalDateTime.of(2023, 4, 12, 12, 0, 0);

        when(mainService.checkNumberMonth()).thenReturn((byte) 3);
        when(mainService.checkNumberDay()).thenReturn((byte) 12);
        when(mainService.checkNumberHour()).thenReturn((byte) 12);
        when(mainService.checkNumberMinute()).thenReturn((byte) 0);
        when(lecture.getCreationDate()).thenReturn(localDateTimePassedFake, localDateTimeNowFake);

        doCallRealMethod().when(mainService).creatLectureDate(any());

        Assertions.assertNull(mainService.creatLectureDate(lecture));
        Assertions.assertEquals(localDateTimeExpected, mainService.creatLectureDate(lecture));
        Assertions.assertNull(mainService.creatLectureDate(null));

        verify(mainService, times(2)).creatLectureDate(lecture);
        verify(mainService).creatLectureDate(null);
    }

    @Test
    @DisplayName("Method checkNumberMonth return test")
    void checkNumberMonthTest() {
        when(mainService.scanner.hasNextByte()).thenReturn(false, true);
        when(mainService.scanner.nextByte()).thenReturn((byte) 0, (byte) 4);
        when(mainService.scanner.nextLine()).thenReturn("");

        doCallRealMethod().when(mainService).checkNumberMonth();

        Assertions.assertEquals((byte) 4, mainService.checkNumberMonth());
        verify(mainService).checkNumberMonth();
    }

    @Test
    @DisplayName("Method checkNumberDay return test")
    void checkNumberDayTest() {
        when(mainService.scanner.hasNextByte()).thenReturn(false, true);
        when(mainService.scanner.nextByte()).thenReturn((byte) 0, (byte) 4);
        when(mainService.scanner.nextLine()).thenReturn("");

        doCallRealMethod().when(mainService).checkNumberDay();

        Assertions.assertEquals((byte) 4, mainService.checkNumberDay());
        verify(mainService).checkNumberDay();
    }

    @Test
    @DisplayName("Method checkNumberHour return test")
    void checkNumberHourTest() {
        when(mainService.scanner.hasNextByte()).thenReturn(false, true);
        when(mainService.scanner.nextByte()).thenReturn((byte) 24, (byte) 0, (byte) 4);
        when(mainService.scanner.nextLine()).thenReturn("");

        doCallRealMethod().when(mainService).checkNumberHour();

        Assertions.assertEquals((byte) 0, mainService.checkNumberHour());
        Assertions.assertEquals((byte) 4, mainService.checkNumberHour());
        verify(mainService, times(2)).checkNumberHour();
    }

    @Test
    @DisplayName("Method checkNumberMinute return test")
    void checkNumberMinuteTest() {
        when(mainService.scanner.hasNextByte()).thenReturn(false, true);
        when(mainService.scanner.nextByte()).thenReturn((byte) 60, (byte) 0, (byte) 4);
        when(mainService.scanner.nextLine()).thenReturn("");

        doCallRealMethod().when(mainService).checkNumberMinute();

        Assertions.assertEquals((byte) 0, mainService.checkNumberMinute());
        Assertions.assertEquals((byte) 4, mainService.checkNumberMinute());
        verify(mainService, times(2)).checkNumberMinute();
    }

    @Test
    @DisplayName("Method creatDeadLineForHomework return test")
    void creatDeadLineForHomeworkTest() {
        mainService.lectureRepository = spy(LectureRepository.class);
        mainService.lectureRepository.getLectureList().add(lecture);
        mainService.lectureRepository.getLectureList().add(lecture);

        when(lecture.getLectureId()).thenReturn(1L);
        when(lecture.getLectureDate()).thenReturn(LocalDateTime.of(0, 1, 1, 0, 0, 0));

        doCallRealMethod().when(mainService).creatDeadLineForHomework(any());
        Assertions.assertEquals("Jan 02, 12:00", mainService.creatDeadLineForHomework(1L));
        Assertions.assertNull(mainService.creatDeadLineForHomework(2L));
        Assertions.assertNull(mainService.creatDeadLineForHomework(null));

        verify(mainService, times(3)).creatDeadLineForHomework(any());
    }

    @Test
    @DisplayName("Method localDateTimeAfter return test")
    void localDateTimeAfterTest() {
        LocalDateTime localDateTimeFake = LocalDateTime.of(2023, 1, 1, 0, 0, 0);

        when(mainService.checkNumberMonth()).thenReturn((byte) 1);
        when(mainService.checkNumberDay()).thenReturn((byte) 1);
        when(mainService.checkNumberHour()).thenReturn((byte) 0);
        when(mainService.checkNumberMinute()).thenReturn((byte) 0);

        doCallRealMethod().when(mainService).localDateTimeAfter();
        Assertions.assertEquals(localDateTimeFake, mainService.localDateTimeAfter());
        verify(mainService).localDateTimeAfter();
    }

    @Test
    @DisplayName("Method localDateTimeBefore return test")
    void localDateTimeBeforeTest() {
        LocalDateTime localDateTimeFake = LocalDateTime.of(2023, 1, 1, 0, 0, 0);

        when(mainService.checkNumberMonth()).thenReturn((byte) 1);
        when(mainService.checkNumberDay()).thenReturn((byte) 1);
        when(mainService.checkNumberHour()).thenReturn((byte) 0);
        when(mainService.checkNumberMinute()).thenReturn((byte) 0);

        doCallRealMethod().when(mainService).localDateTimeBefore();
        Assertions.assertEquals(localDateTimeFake, mainService.localDateTimeBefore());
        verify(mainService).localDateTimeBefore();
    }
}
