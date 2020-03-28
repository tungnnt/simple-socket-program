package com.company.bai2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AccountServiceImpl extends UnicastRemoteObject implements IAccount {
    private static final long serialVersionUID = 1L;

    public AccountServiceImpl() throws RemoteException {
    }

    @Override
    public String getStudents(String studentId) throws RemoteException {
        /**
         * Tạo 1 mảng chứa các đối tượng student
         * @return thông tin sinh viên nếu tìm thấy
         */
        ArrayList<Student> students = new ArrayList<>();
        Student tmpStudent = new Student("17021353", "Nguyen Ngoc Thanh Tung", "K62CACLC1", "0392479119", "cloneoftung@gmail.com", "Hai Duong");
        students.add(tmpStudent);
        tmpStudent = new Student("17021252", "Nguyen Huu Hoa", "K62CACLC1", "0392479118", "hoann@gmail.com", "Ha noi");
        students.add(tmpStudent);
        tmpStudent = new Student("17021050", "Nguyen Hop Quang", "K62CACLC1", "0392479118", "hoann@gmail.com", "Ha noi");
        students.add(tmpStudent);

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student.toString();
            }
        }

        return "Student id not available";
    }
}
