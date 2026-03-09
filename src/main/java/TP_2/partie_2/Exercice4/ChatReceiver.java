package TP_2.partie_2.Exercice4;

import java.net.*;

public class ChatReceiver implements Runnable {
    private MulticastSocket socket;

    public ChatReceiver(MulticastSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[2048];
            while (!socket.isClosed()) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("\n" + msg);
                System.out.print("> ");
            }
        } catch (Exception e) {
            if (!socket.isClosed()) System.err.println("Receiver Error: " + e.getMessage());
        }
    }
}