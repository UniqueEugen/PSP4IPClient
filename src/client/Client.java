package client;


import myLibrary.console.Console;
import myLibrary.input.Scan;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String serverMessage;
    private final String END_CMD = "DSCNNCTD";
    private final String CLOSE_CMD = "CLOSED_SERVER";
    private final String MATRIX_CMD = "MATRIX";
    public void runClient() {
        boolean endFlag;
        try {
            Console.log("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1", 2525);
            Console.log("connection established....");
            ObjectOutputStream coos =
                    new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream cois =
                    new ObjectInputStream(clientSocket.getInputStream());
            endFlag=false;
            while (!endFlag) {
                Console.log("Enter any string to continue \n\t('1' − programme terminate)");
                String clientMessage = Scan.stringScan();
                Console.log(clientMessage);
                if (clientMessage.equals("1")){
                    clientMessage=END_CMD+",";
                    endFlag=true;
                }
                else{
                    PrinterScanner printerScanner = new PrinterScanner();
                    clientMessage = MATRIX_CMD + ","+ printerScanner.getMatrix();
                }
                coos.writeObject(clientMessage);
                serverMessage =cois.readObject().toString();
                Console.log("Отношение главной диагонали к побочной = " + serverMessage);//выводится на //экран со-держимое потока ввода (переданное сервером)
                Console.log("---------------------------");

            }
            coos.close();//закрытие потока вывода
            cois.close();//закрытие потока ввода
            clientSocket.close();//закрытие сокета
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}
