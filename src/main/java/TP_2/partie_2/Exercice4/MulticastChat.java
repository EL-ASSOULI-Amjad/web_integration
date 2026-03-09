package TP_2.partie_2.Exercice4;

import java.net.*;
import java.util.*;

public class MulticastChat {
    private static final String IP = "224.0.0.1";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Username: ");
            String name = sc.nextLine();

            InetAddress group = InetAddress.getByName(IP);
            MulticastSocket socket = new MulticastSocket(PORT);

            NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            if (netIf == null || !netIf.supportsMulticast() || !netIf.isUp()) {
                netIf = NetworkInterface.getByName("lo"); // Try standard loopback name
            }

            socket.joinGroup(new InetSocketAddress(group, PORT), netIf);

            Thread t = new Thread(new ChatReceiver(socket));
            t.setDaemon(true);
            t.start();

            System.out.println("--- Group Joined via " + netIf.getDisplayName() + " ---");

            while (true) {
                String msg = sc.nextLine();
                if (msg.equalsIgnoreCase("/quit")) break;

                byte[] data = (name + ": " + msg).getBytes();
                socket.send(new DatagramPacket(data, data.length, group, PORT));
            }

            socket.leaveGroup(new InetSocketAddress(group, PORT), netIf);
            socket.close();
        } catch (Exception e) {
            System.err.println("Fatal Error: " + e.getMessage());
        }
    }
}