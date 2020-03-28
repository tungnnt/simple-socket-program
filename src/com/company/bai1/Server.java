package com.company.bai1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// class Student dai dien cho doi tuong sinh vien bao gom ten, mssv, lop, sdt, email, dia chi
class Student {
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

// class mo ta Server
public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Server start...");
        // tao socket cua server va cho ket noi tu client
        ServerSocket listener = new ServerSocket(3009);

        System.out.println("Server accepts connection from client...");
        // chap nhan ket noi tu client
        Socket socketOfServer = listener.accept();;

        // doc du lieu tu client, gui du lieu den client
        BufferedReader serverReceiver = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
        BufferedWriter serverSender = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));

        // mang chua cac doi tuong student
        ArrayList<Student> students = new ArrayList<Student>();
        Student aStudent = new Student("17021353", "Nguyen Ngoc Thanh Tung", "K62CACLC1", "0392479119", "cloneoftung@gmail.com", "Hai Duong");
        students.add(aStudent);
        aStudent = new Student("17021252", "Nguyen Huu Hoa", "K62CACLC1", "0392479118", "hoann@gmail.com", "Ha noi");
        students.add(aStudent);
        aStudent = new Student("17021050", "Nguyen Hop Quang", "K62CACLC1", "0392479118", "hoann@gmail.com", "Ha noi");
        students.add(aStudent);

        // doc du lieu tu client gui den
        String line;
        while (true) {
            line = serverReceiver.readLine();
            System.out.println("Server received: " + line);

            // kiem tra xem clien co muon dong ket noi khong
            if (line.equals("End connection")) {
                serverSender.write("Accept end connection");
                serverSender.newLine();
                serverSender.flush();

                // tat server
                serverReceiver.close();
                serverSender.close();
                socketOfServer.close();
                break;
            }

            // kiem tra xem co sinh vien co mssv can tim khong
            boolean hasStudent = false;
            for (Student student : students) {
                if (student.getStudentId().equals(line)) {
                    serverSender.write(student.toString());
                    serverSender.newLine();
                    serverSender.flush();
                    hasStudent = true;
                    break;
                }
            }

            if (hasStudent == false){
                serverSender.write("Student not available");
                serverSender.newLine();
                serverSender.flush();
            }
        }
        System.out.println("Status: Sever stopped");
    }
}