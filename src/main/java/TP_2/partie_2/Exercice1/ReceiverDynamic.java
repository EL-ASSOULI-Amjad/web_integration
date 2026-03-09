package TP_2.partie_2.Exercice1;

import java.net.*;

public class ReceiverDynamic {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Receiver <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Receiver actif sur le port " + port);
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Reçu de " + packet.getAddress() + " : " + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}