package TP_2.partie_2.partie_11.Exercice1;

import java.io.*;
import java.net.*;
import java.util.*;

public class Serveur {

    static String[] proverbes = {
            "Patience is a virtue.",
            "Better late than never.",
            "Actions speak louder than words.",
            "Where there is a will, there is a way."
    };

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started...");

        Random rand = new Random();

        while(true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String proverbe = proverbes[rand.nextInt(proverbes.length)];

            out.println(proverbe);

            client.close();
        }
    }
}