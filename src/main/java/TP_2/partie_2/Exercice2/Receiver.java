package TP_2.partie_2.Exercice2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
    public static void main(String[] args) {
        int port = 7676;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Receiver : En attente de proverbes sur le port " + port + "...");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);

                String proverbe = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Proverbe reçu : " + proverbe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}