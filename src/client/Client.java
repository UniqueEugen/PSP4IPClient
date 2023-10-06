package client;

import scan.Scan;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String serverMessage;
    private final String END_CMD = "CLOSE";
    private final String CLOSE_CMD = "CLOSED_SERVER";
    public void runClient() {
        boolean endFlag;
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1", 2525);
            System.out.println("connection established....");
            ObjectOutputStream coos =
                    new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream cois =
                    new ObjectInputStream(clientSocket.getInputStream());
            endFlag=false;
            while (!endFlag) {
                System.out.println("Enter any string to send to server \n\t('1' − programme terminate)");
                String clientMessage = Scan.stringScan();
                if (clientMessage.equals("1")) clientMessage=END_CMD;
                coos.writeObject(clientMessage);
                serverMessage =cois.readObject().toString();
                System.out.println("~server~: " + serverMessage);//выводится на //экран со-держимое потока ввода (переданное сервером)
                System.out.println("---------------------------");
                if (serverMessage.equals(CLOSE_CMD)){
                    endFlag=true;
                }
            }
            coos.close();//закрытие потока вывода
            cois.close();//закрытие потока ввода
            clientSocket.close();//закрытие сокета
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
