package TP_2.partie_1.Exercice3;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServeurChat {
    static ArrayList<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serveur = new ServerSocket(1234);
            System.out.println("Serveur démarré sur le port 1234...");
            while (true) {
                Socket socket = serveur.accept();
                System.out.println("Nouveau client connecté !");

                new ThreadClient(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Erreur serveur : " + e.getMessage());
        }
    }
}