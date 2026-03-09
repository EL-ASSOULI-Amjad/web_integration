package TP_2.partie_2.partie_11.Exercice2;

import java.io.*;
import java.net.*;

public class ServeurWeb {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8000);
        System.out.println("Web server started on port 8000...");
        while(true) {
            Socket client = server.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String corps =
                    "<HTML>" +
                            "<TITLE>Mon serveur</TITLE>" +
                            "<BODY>Cette page a été envoyée par mon <B>Serveur</B></BODY>" +
                            "</HTML>";

            out.println("HTTP/1.0 200 OK");
            out.println();
            out.println(corps);

            client.close();
        }
    }
}