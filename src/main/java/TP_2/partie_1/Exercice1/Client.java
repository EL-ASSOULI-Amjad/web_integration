package TP_2.partie_1.Exercice1;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String proverbe = in.readLine();
        System.out.println("Proverbe reçu : " + proverbe);
        socket.close();
    }
}