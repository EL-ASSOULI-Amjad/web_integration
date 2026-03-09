package TP_2.partie_2.Exercice1;

import java.net.*;

public class Receiver {
    public static void main(String[] args) {
        int port = 7676;
        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Receiver sur le port " + port + "...");
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message reçu : " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}