package com.company.bai2;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class Server {
    public static void main(String[] args) {
        try {
            IAccount iAccount = new AccountServiceImpl();
            LocateRegistry.createRegistry(6789);

            /**
             * Đăng ký đối tượng vs rmiregistry
             * với tên là ahihidongoc
             */
            Naming.bind("rmi://127.0.0.1:6789/StudentQuery", iAccount);

            System.out.println("RMI Server Started");
        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
