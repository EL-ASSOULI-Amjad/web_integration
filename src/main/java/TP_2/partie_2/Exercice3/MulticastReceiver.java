package TP_2.partie_2.Exercice3;

import java.net.*;

public class MulticastReceiver {
    public static void main(String[] args) {
        int port = 8686;
        String groupAddr = "224.0.0.1";
        byte[] buffer = new byte[1024];

        try {
            MulticastSocket socket = new MulticastSocket(port);
            InetAddress group = InetAddress.getByName(groupAddr);

            InetSocketAddress groupAddress = new InetSocketAddress(group, port);

            NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());

            socket.joinGroup(groupAddress, netIf);

            System.out.println("Receiver prêt sur l'interface : " + netIf.getDisplayName());

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Reçu : " + message);
            }
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}