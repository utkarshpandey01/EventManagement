package model;

public class Student extends User {

    private String studentId;

    public Student(String name, String email, String studentId) {
        super(name, email);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n===== STUDENT INFORMATION =====");
        System.out.println("Name       : " + name);
        System.out.println("Email      : " + email);
        System.out.println("Student ID : " + studentId);
    }
}