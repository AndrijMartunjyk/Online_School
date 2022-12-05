package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.course.model.Person;
import online_school.generic.SchoolArray;
import online_school.my_interface.InterfaceRepository;
import online_school.service.StudentService;

public class StudentRepository implements InterfaceRepository {
    private final SchoolArray<Person> studentsArray = new SchoolArray<>(new Person[1]);


    @Override
    public int counter() {
        int result = 0;
        for (Person student : studentsArray.getArray()) {
            if (student == null) {
                break;
            } else {
                result = StudentService.getStudentCounter();
            }
        }
        return result;
    }

    @Override
    public void deleteObject(long studentId) {
        boolean isPresent = true;
        for (int i = 0; i < studentsArray.getArray().length; i++) {
            if (studentsArray.getArray()[i] == null) {
                break;
            } else if (studentsArray.getArray()[i].getPersonId() == studentId) {
                studentsArray.getArray()[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", studentId);
                for (int j = 0; j < studentsArray.getArray().length - 1; j++) {
                    if (studentsArray.getArray()[j] == null) {
                        studentsArray.getArray()[j] = studentsArray.getArray()[j + 1];
                        studentsArray.getArray()[j + 1] = null;
                    }
                }
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.out.println("Не має об'єкта з таким ID, спробуйте ще раз!!!");
        }
    }

    @Override
    public void showInformPerson(long courseOrLectureId, Lecture[] lectures, Person[] student) {
        InterfaceRepository.super.showInformPerson(courseOrLectureId, lectures, student);
    }

    @Override
    public <E> void add(E student) {
        studentsArray.add((Person) student);
    }

    public SchoolArray<Person> getStudentsArrayObject() {
        return studentsArray;
    }

    public Person[] getStudentArray() {
        return studentsArray.getArray();
    }

    public long getStudentId() {
        return this.studentsArray.getArray()[counter() - 1].getPersonId();
    }


}
