package TP_2.partie_2.partie_11.Exercice3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Thread class to handle each client
class ThreadClient extends Thread {
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    String pseudo;

    public ThreadClient(Socket s) {
        this.socket = s;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            pseudo = in.readLine();
            ServeurChat.clients.add(out);

            diffuser(pseudo + " a rejoint le chat !");
            String message;
            while ((message = in.readLine()) != null) {
                diffuser(pseudo + " : " + message);
            }
        } catch (Exception e) {
            System.out.println(pseudo + " s'est déconnecté.");
        }
    }
    public void diffuser(String msg) {
        for (PrintWriter client : ServeurChat.clients) {
            client.println(msg);
        }
    }
}