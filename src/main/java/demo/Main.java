package demo;


import online_school.domain.model.Role;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import web.service.CourseService;
import web.service.LectureService;
import web.service.StudentService;
import web.utils.MyConfig;



public class Main {
    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

    public static void main(String[] args) {
CourseService courseService=context.getBean(CourseService.class);
        StudentService studentService=context.getBean(StudentService.class);
        LectureService lectureService=context.getBean(LectureService.class);

//studentService.addStudent("jon","io","sdas@fv","23232323", Role.STUDENT,13L);


        System.out.println(lectureService.getLectureListByCourseId(10L));
    }
}
