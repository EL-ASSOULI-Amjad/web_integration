package TP_2.partie_1.Exercice1;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class Serveur {
    public static void main(String[] args) throws Exception {
        System.setProperty("javax.net.ssl.keyStore", "src/main/java/TP_2/partie_1/Exercice1/serverkey.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "stpass123");

        SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket server = (SSLServerSocket) ssf.createServerSocket(5000);

        System.out.println("Server started (SSL)...");

        while(true) {
            SSLSocket client = (SSLSocket) server.accept();
            System.out.println("Client connected");
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello world");
            client.close();
        }
    }
}