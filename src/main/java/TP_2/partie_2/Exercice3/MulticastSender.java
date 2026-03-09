package TP_2.partie_2.Exercice3;

import java.net.*;
import java.util.Random;

public class MulticastSender {
    public static void main(String[] args) {
        String[] proverbes = {
                "L'union fait la force.",
                "Pierre qui roule n'amasse pas mousse.",
                "Aide-toi, le ciel t'aidera.",
                "On ne change pas une équipe qui gagne."
        };

        int port = 8686;
        String groupAddr = "224.0.0.1";

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(groupAddr);


            NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            socket.setNetworkInterface(netIf);

            String message = proverbes[new Random().nextInt(proverbes.length)];
            byte[] data = message.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, group, port);

            socket.send(packet);
            System.out.println("Sender : Message envoyé sur " + groupAddr + " via " + netIf.getDisplayName());

        } catch (Exception e) {
            System.err.println("Erreur lors de l'envoi : " + e.getMessage());
            e.printStackTrace();
        }
    }
}