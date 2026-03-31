package TP_2.partie_1.Exercice1;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class Client {

    public static void main(String[] args) throws Exception {
        System.setProperty("javax.net.ssl.trustStore", "src/main/java/TP_2/partie_1/Exercice1/clientTruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "stpass123");

        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) ssf.createSocket("localhost", 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String messageRecu = in.readLine();
        System.out.println("Message reçu du serveur : " + messageRecu);
        socket.close();
    }
}