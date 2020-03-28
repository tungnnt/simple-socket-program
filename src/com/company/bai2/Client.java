package com.company.bai2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        /**
         * Xác định máy chủ kết nối
         */

        try {
            IAccount iAccount = (IAccount) Naming.lookup("rmi://127.0.0.1:6789/StudentQuery");

            /**
             * Client nhập mã sinh viên
             */
            Scanner in  = new Scanner(System.in);
            System.out.println("Client enter students id: ");
            String sId = in.nextLine();

            System.out.println(iAccount.getStudents(sId));

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
