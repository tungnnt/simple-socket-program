package com.company.bai2;

public class Student {
    // cac thuoc tinh cua sinh vien
    private String studentId;
    private String name;
    private String classroom;
    private String phone;
    private String email;
    private String address;

    // ham khoi tao 1 doi tuong sinh vien
    public Student(String studentId, String name, String classroom, String phone, String email, String address) {
        this.studentId = studentId;
        this.name = name;
        this.classroom = classroom;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // getter
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // ham in thong tin sinh vien
    @Override
    public String toString() {
        return "Student info: [Name: " + this.getName() + ", " +
                "studentID: " + this.getStudentId() + "," +
                "class: " + this.getClassroom() + "," +
                "phone: " + this.getPhone() + ", " +
                "email: " + this.getEmail() + ", " +
                "address: " + this.getAddress() + "]";
    }
}
