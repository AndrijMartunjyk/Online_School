package online_school.domain.control_work;

import online_school.domain.model.Person;
import online_school.domain.model.Role;
import online_school.log.Log;

import java.io.Serial;
import java.io.Serializable;

public class Student extends Person implements Runnable, Serializable {
    @Serial
    private static final long serialVersionUID = 5L;
    private int studentNumber;
    private byte time;
    private byte taskNumber;

    public Student(Role role, Long personId, String firstPersonName, String lastPersonName, String phone, String email) {
        super(role, personId, firstPersonName, lastPersonName, phone, email);
    }

    @Override
    public void run() {
        time = (byte) (Math.random() * (15 - 8) + 8);
        Log.debug(Student.class.getName(), "method->\"run\"");
    }

    @Override
    public String getFirstPersonName() {
        Log.debug(Student.class.getName(), "method->\"getFirstPersonName\"");
        return super.getFirstPersonName();
    }

    public byte getTaskNumber() {
        Log.debug(Student.class.getName(), "method->\"getTaskNumber\"");
        return taskNumber;
    }

    public byte getTime() {
        Log.debug(Student.class.getName(), "method->\"getTime\"");
        return time;
    }

    public int getStudentNumber() {
        Log.debug(Student.class.getName(), "method->\"getStudentNumber\"");
        return studentNumber;
    }

    public void setTaskNumber(byte taskNumber) {
        Log.debug(Student.class.getName(), "method->\"setTaskNumber\"");
        this.taskNumber = taskNumber;
    }

    public void setStudentNumber(int studentNumber) {
        Log.debug(Student.class.getName(), "method->\"setStudentNumber\"");
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        Log.debug(Student.class.getName(), "method->\"toString\"");
        return "Студент-> "
                + "\" "
                + studentNumber
                + " \""
                + " отримав завдання № "
                + taskNumber
                + "  //  "
                + super.toString();
    }
}
