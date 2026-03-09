package TP_2.partie_2.Exercice2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Sender {
    public static void main(String[] args) {
        String[] proverbes = {
                "Petit à petit, l'oiseau fait son nid.",
                "Rien ne sert de courir, il faut partir à point.",
                "L'habit ne fait pas le moine.",
                "Mieux vaut tard que jamais."
        };

        try (DatagramSocket socket = new DatagramSocket()) {
            String message = proverbes[new Random().nextInt(proverbes.length)];
            byte[] data = message.getBytes();

            InetAddress address = InetAddress.getByName("localhost");
            int port = 7676;

            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            socket.send(packet);

            System.out.println("Sender : Proverbe envoyé avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}