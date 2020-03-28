package com.company.bai1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

// class mo ta client
public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("Client start...");

        // ket noi den server localhost:3009
        String serverHost = "localhost";
        Socket socketOfClient = new Socket(serverHost, 3009);;
        BufferedWriter clientSender = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
        BufferedReader clientReceiver = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));

        try {
            // nhan mssv tu nguoi dung nhap
            Scanner in = new Scanner(System.in);
            System.out.print("Client says enter studentId: ");
            String stdID = in.nextLine();

            // gui du lieu ma nguoi dung nhap den server
            clientSender.write(stdID);
            clientSender.newLine();
            clientSender.flush();
            System.out.println("Client -> Server: " +stdID);

            // lay du lieu tu server gui ve
            String responseOfServer;
            if ((responseOfServer = clientReceiver.readLine()) != null)
                System.out.println("Server -> Client: " + responseOfServer);

            // client gui yeu cau dong ket noi
            clientSender.write("End connection");
            clientSender.newLine();
            clientSender.flush();
            if (!stdID.equals("End connection"))
                System.out.println("Client -> Server: End connection");
            System.out.println("Status: Disconnect to server");
            clientSender.close();
            clientReceiver.close();
            socketOfClient.close();

        } catch (UnknownHostException e) {
            System.err.println("Host:port not found" + e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}