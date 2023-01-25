package online_school.service;

import online_school.domain.model.Role;
import online_school.domain.model.Student;

import java.util.List;

public class ControlWorkService {
    public Student[] createStudentsArray() {
        return new Student[]{new Student(Role.STUDENT, 1L, "Андрій", "Мартинюк", "«+38(044)555-55-55»", "«anick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Олександр", "Гавриленко", "«+38(044)555-55-55»", "«bnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Ірина", "Степанюк", "«+38(044)555-55-55»", "«cnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Олег", "Мисливчук", "«+38(044)555-55-55»", "«dnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Володимир", "Зеленський", "«+38(044)555-55-55»", "«inick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Володимир", "Гройсман", "«+38(044)555-55-55»", "«fnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Андрій", "Парубій", "«+38(044)555-55-55»", "«gnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Петро", "Порошенко", "«+38(044)555-55-55»", "«onick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Валерій", "Залужний", "«+38(044)555-55-55»", "«pnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Юлія", "Тимошенко", "«+38(044)555-55-55»", "«qnick@mail.com»")};
    }

    public void creatTaskForStudent(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            byte result = (byte) (1 + Math.random() * 10);
            for (Student student : students) {
                if (student.getTaskNumber() == 0 && student.getTaskNumber() != result) {
                    student.setTaskNumber(result);
                    break;
                } else if (student.getTaskNumber() == result) {
                    i--;
                    break;
                }
            }
        }
    }

    public void controlWorkStart(List<Student> listStudents, Student[] studentsArray) throws InterruptedException {
        Thread thread;
        for (int i = 0; i < studentsArray.length; i++) {
            thread = new Thread(listStudents.get(i));
            thread.start();
        }
        Thread.sleep(1000);
        sortedStudents(listStudents);
        for (byte i = 12; i > 0; i--) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        for (int i = 0; i < listStudents.size(); i++) {
            if (listStudents.get(i).getTime() <= 12) {
                listStudents.get(i).setStudentNumber(i + 1);
                System.out.printf("Студент: %d %s %s // час -> %d сек.\n", listStudents.get(i).getStudentNumber(),
                        listStudents.get(i).getFirstPersonName(), listStudents.get(i).getLastPersonName(), listStudents.get(i).getTime());
            } else {
                System.out.printf("Студент: %s %s // НЕ ВСТИГ(ЛА)!!! час -> %d сек.\n",
                        listStudents.get(i).getFirstPersonName(), listStudents.get(i).getLastPersonName(), listStudents.get(i).getTime());
            }
        }
    }

    private void sortedStudents(List<Student> listStudents) {
        listStudents.sort((o1, o2) -> {
            int result = 1;
            if (o1.hashCode() == o2.hashCode() && o1.equals(o2)) {
                result = 0;
            } else if (o1.getTime() < o2.getTime()) {
                result = -1;
            }
            return result;
        });
    }
}
