package TP_2.partie_2.partie_11.Exercice3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connecté au serveur !");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez votre nom : ");

            String pseudo = scanner.nextLine();
            out.println(pseudo);
            Thread ecouteur = new Thread(new Runnable() {
                public void run() {
                    try {
                        String msgServeur;
                        while ((msgServeur = in.readLine()) != null) {
                            System.out.println("\n" + msgServeur);
                            System.out.print("> ");
                        }
                    } catch (Exception e) {
                        System.out.println("Déconnecté du serveur.");
                    }
                }
            });
            ecouteur.start();
            while (true) {
                String monMessage = scanner.nextLine();
                out.println(monMessage);
            }
        } catch (Exception e) {
            System.out.println("Erreur : Impossible de contacter le serveur.");
        }
    }
}