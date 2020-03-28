package com.company.bai2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAccount extends Remote {
    String getStudents(String studentId) throws RemoteException;
}
