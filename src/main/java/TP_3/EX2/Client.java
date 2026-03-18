package TP_3.EX2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            BanqueService service = (BanqueService) registry.lookup("BanqueService");

            System.out.println("Solde: " + service.consulterSolde(1));
            service.retirer(1, 100);

            System.out.println("Nouveau solde: " + service.consulterSolde(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}