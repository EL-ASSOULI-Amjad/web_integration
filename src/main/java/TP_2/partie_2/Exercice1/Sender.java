package TP_2.partie_2.Exercice1;

import java.net.*;

public class Sender {
    public static void main(String[] args) {
        String message = "bonjour tout le monde";
        int port = 7676;
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("localhost");
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);

            System.out.println("Message envoyé");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}