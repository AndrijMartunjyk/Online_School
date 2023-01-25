package online_school.domain.model;

public class Student extends Person implements Runnable {
    private int studentNumber;
    private byte time;
    private byte taskNumber;

    public Student(Role role, Long personId, String firstPersonName, String lastPersonName, String phone, String email) {
        super(role, personId, firstPersonName, lastPersonName, phone, email);
    }

    @Override
    public void run() {
        time = (byte) (Math.random() * (15 - 8) + 8);
    }

    @Override
    public String getFirstPersonName() {
        return super.getFirstPersonName();
    }

    public byte getTaskNumber() {
        return taskNumber;
    }

    public byte getTime() {
        return time;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setTaskNumber(byte taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
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
