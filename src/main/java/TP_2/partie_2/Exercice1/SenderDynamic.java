package TP_2.partie_2.Exercice1;

import java.net.*;
import java.util.Scanner;
import java.util.Random;

public class SenderDynamic {
    public static void main(String[] args) {
        String[] proverbes = {
                "Rira bien qui rira le dernier",
                "Petit à petit, l'oiseau fait son nid.",
                "Qui cherche trouve",
                "L'union fait la force"
        };
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le port du destinataire : ");
        int port = sc.nextInt();
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress dest = InetAddress.getByName("localhost");
            String message = proverbes[new Random().nextInt(proverbes.length)];
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, dest, port);
            socket.send(packet);
            System.out.println("Proverbe envoyé : " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}